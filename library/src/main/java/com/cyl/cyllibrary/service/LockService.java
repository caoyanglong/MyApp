package com.cyl.cyllibrary.service;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.text.TextUtils;

import com.cyl.cyllibrary.ui.LockActivity;


/**
 * Created by CYL on 16-7-20.
 * email:670654904@qq.com
 * 用做锁屏的服务
 *
 * 使用的时候  配置activity 使用
 */
public class LockService extends Service {

    private Intent mFxLockIntent = null;
    private KeyguardManager mKeyguardManager = null;
    public static KeyguardManager.KeyguardLock mKeyguardLock = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mFxLockIntent = new Intent(LockService.this, LockActivity.class);
        mFxLockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mKeyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        mKeyguardLock = mKeyguardManager.newKeyguardLock("FxLock");
        registerComponent();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterComponent();
        //被销毁时启动自身，保持自身在后台存活
        startService(new Intent(LockService.this, LockService.class));
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }

    //监听来自用户按Power键点亮点暗屏幕的广播
    private BroadcastReceiver mScreenOnOrOffReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //android.intent.action.SCREEN_ON  /SCREEN_OFF屏幕点亮 /屏幕关闭
            if (TextUtils.equals("android.intent.action.SCREEN_ON", intent.getAction())) {
                //屏蔽手机内置的锁屏
                mKeyguardLock.disableKeyguard();
                //启动该第三方锁屏
                startActivity(mFxLockIntent);
            }
        }
    };

    //注册广播监听
    public void registerComponent() {
        IntentFilter mScreenOnOrOffFilter = new IntentFilter();
        mScreenOnOrOffFilter.addAction("android.intent.action.SCREEN_ON");
//        mScreenOnOrOffFilter.addAction("android.intent.action.SCREEN_OFF");
        LockService.this.registerReceiver(mScreenOnOrOffReceiver, mScreenOnOrOffFilter);
    }

    //解除广播监听
    public void unregisterComponent() {
        if (mScreenOnOrOffReceiver != null) {
            LockService.this.unregisterReceiver(mScreenOnOrOffReceiver);
        }
    }

}
