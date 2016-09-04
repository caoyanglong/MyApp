package com.cyl.cyllibrary.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.List;

/**
 * Created by CYL on 2016/5/6.
 * email:670654904@qq.com
 * recyclerview 的适配器
 */
public abstract class BaseRecyclerAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    /**
     * 数据源
     */
    protected List<T> dataSource;
    protected LayoutInflater inflater;
    /**
     * 上下文 环境
     */
    protected Context context;

    public BaseRecyclerAdapter(Context context, List<T> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    /**
     * 通过item的位置移除 某个条目
     * @param postion
     */
    public void removeItem(int postion){
        dataSource.remove(postion);
        notifyDataSetChanged();
    }
}
