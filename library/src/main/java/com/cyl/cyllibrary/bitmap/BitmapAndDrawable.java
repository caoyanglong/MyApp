package com.cyl.cyllibrary.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.InputStream;

/**
 * bitmap 与drawable 之间的转换   以及 资源文件转化为 bitmap  drawable 等
 *
 * @author 曹阳龙
 *         <p/>
 *         2015-9-10
 */
public class BitmapAndDrawable {
    /**
     * 通过 资源文件获取bitmap 对象
     *
     * @param context 上下文环境
     * @param bid     bitmap 的资源id  drawableid
     * @return
     */
    public static Bitmap bitmapFromInputStream(Context context, int bid) {
        InputStream is = context.getResources().openRawResource(bid);
        Bitmap mBitmap = BitmapFactory.decodeStream(is);
        return mBitmap;
    }

    /**
     * 通过bitmap 直接搞定
     *
     * @param context
     * @param bid
     * @return
     */
    public static Bitmap bitmapFromResource(Context context, int bid) {
        return BitmapFactory.decodeResource(context.getResources(), bid);
    }

    /**
     * 通过文件创建bitmap对象
     *
     * @param filepath
     * @return
     */
    public static Bitmap bitmapFromFile(String filepath) {
        return BitmapFactory.decodeFile(filepath);
    }

    /**
     * 通过bitmap获取drawable
     *
     * @param context
     * @param bitmap
     * @return
     */
    public static Drawable drawableFromBitmap(Context context, Bitmap bitmap) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    /**
     * 从bitmap中获取drawable 对象
     *
     * @param drawable
     * @return
     */
    public static Bitmap bitmapFromDrawable(Drawable drawable) {
        BitmapDrawable bd = (BitmapDrawable) drawable;
        return bd.getBitmap();
    }
}
