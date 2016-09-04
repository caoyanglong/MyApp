package com.cyl.cyllibrary.ui;

import android.graphics.Color;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.cyl.cyllibrary.base.BaseActivity;
import com.cyl.cyllibrary.service.LockService;


/**
 * Created by CYL on 16-7-20.
 * email:670654904@qq.com
 * 请将此actiivty 启动模式设置为 singleInstance 保证系统中只有一个锁屏页面
 */
public class LockActivity extends BaseActivity{
    private static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;
    @Override
    public int setContent() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void beforeSetContent() {
        super.beforeSetContent();
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);//关键代码
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        setContent(linearLayout);
    }

    @Override
    public void initListener() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return disableKeycode(keyCode, event);
    }

    private boolean disableKeycode(int keyCode, KeyEvent event) {
        int key = event.getKeyCode();
        switch (key) {
            case KeyEvent.KEYCODE_BACK:
            case KeyEvent.KEYCODE_VOLUME_DOWN:
            case KeyEvent.KEYCODE_VOLUME_UP:
            case KeyEvent.KEYCODE_HOME:
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        keyGuardReenable();
    }

    /**
     * 使用的用的keyguard 的可用
     */
    private void keyGuardReenable() {
        if(LockService.mKeyguardLock != null){
            LockService.mKeyguardLock.reenableKeyguard();
        }
    }
}
