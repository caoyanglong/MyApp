package com.cyl.cyllibrary.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * listview 适配器的构造方法
 *
 * @param <T>
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {
    protected List<T> dataSource = new ArrayList<T>();
    //数据源
    protected LayoutInflater layoutInflater;
    protected Context context;

    public BaseListAdapter(List<T> dataSource, Context context) {
        super();
        this.dataSource = dataSource;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public BaseListAdapter() {

    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView);
    }

    /**
     * @param position item的位置   从零开始的
     * @param view     item的view通过viewholder 复用
     * @return
     */
    public abstract View getView(int position, View view);

    /**
     * t 给listview 添加数据
     *
     * @param list
     */
    public void addData(List<T> list) {
        dataSource.addAll(list);
        this.notifyDataSetChanged();

    }

}
