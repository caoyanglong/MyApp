package com.cyl.cyllibrary.io;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by CYL on 2016/2/2.
 * email:670654904@qq.com
 * 类似于java web中读取配置文件
 */
public class AppProperties {
    private Context context;
    //asset目录下的文件名字
    private String fileName;
    private Properties properties;

    public AppProperties(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
        //初始化变量
        init();
    }

    /**
     * 初始化  配置文件
     */
    private void init() {
        properties = new Properties();
        try {
            InputStream in = context.getAssets().open(fileName);
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 如果添加的key 存在的话  返回对应值  否则返回null
     *
     * @param key 通过键名获取对应的值
     * @return
     */
    public String getValueByKey(String key) {
        return properties.getProperty(key);
    }


}
