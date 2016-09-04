package com.cyl.cyllibrary.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

/**
 * 将activity 中经常写的代码 进行格式化
 *
 * @author 曹阳龙
 *         <p>
 *         2015-9-13
 *
 */
public abstract class BaseActivity extends Activity {
    //资源管理
    protected Resources resources;
    //上下环境
    protected Context context;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        resources = getResources();
        beforeSetContent();
        if(view != null){
            setContentView(view);
        }
        else if(setContent() != 0){
            setContentView(setContent());
        }
        else {
            throw new RuntimeException("请先设置布局文件");
        }
        onCreate();
    }

    /**
     * 用于设置布局文件
     *
     * @return
     */
    public abstract int setContent();

    /**
     * oncreat 改为内部执行
     */
    private void onCreate() {
        initView();
        initData();
        initListener();
    }

    /**
     * 通过view的方式来设置activity 的布局
     * @param view
     */
    public void setContent(View view){
        this.view = view;
    }

    /**
     * 提供这个方法原因 ， 主要 有一些代码需要在 setcontent 之前调用 如 ： window窗口的设置
     */
    public void beforeSetContent() {
    }

    /**
     * 首次 必先初始化 view
     */
    public abstract void initView();

    /**
     * 初始化数据 从网络 获取数据 数据添加到 view 等逻辑 工作
     */
    public abstract void initData();

    /**
     * 初始化 view listener 的工作
     */
    public abstract void initListener();
} 