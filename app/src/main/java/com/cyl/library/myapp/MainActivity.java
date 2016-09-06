package com.cyl.library.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cyl.cyllibrary.widgets.EndlessRecyclerOnScrollListener;
import com.cyl.cyllibrary.widgets.HeaderViewRecyclerAdapter;
import com.cyl.cyllibrary.widgets.LoadMoreView;
import com.cyl.cyllibrary.widgets.LoadRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EndlessRecyclerOnScrollListener.RvLoadMoreListener{
    private LoadRecyclerView loadRecyclerView;
    private LoadMoreView moreView;
    private List<String> icons = new ArrayList<>();
    private HeaderViewRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        for (int i=0;i<10;i++){
            icons.add("http://img2.imgtn.bdimg.com/it/u=4206774177,4196230443&fm=21&gp=0.jpg");
        }
        loadRecyclerView = (LoadRecyclerView) findViewById(R.id.loadmore_recylerview);
        loadRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        moreView = new LoadMoreView(getApplicationContext(),loadRecyclerView);
        adapter = new HeaderViewRecyclerAdapter(new MyAdapter());
        adapter.addFooterView(moreView.getFooterView());


        loadRecyclerView.setAdapter(adapter);
        loadRecyclerView.setRvLoadMoreListener(this);
        loadRecyclerView.resetMore();
//        loadRecyclerView.setAdapter();
    }


    private final class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(getLayoutInflater().inflate(R.layout.listview_item,parent,false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Picasso.with(getBaseContext()).load(icons.get(position)).into(holder.icon);
        }

        @Override
        public int getItemCount() {
            return icons.size();
        }

        public final class MyViewHolder extends RecyclerView.ViewHolder{
            private ImageView icon;
            public MyViewHolder(View itemView) {
                super(itemView);
                icon = (ImageView) itemView.findViewById(R.id.icon);
            }

        }
    }

    @Override
    public void onLoadMore(int currentPage) {
        for (int i=0;i<10;i++){
            icons.add("http://img2.imgtn.bdimg.com/it/u=4206774177,4196230443&fm=21&gp=0.jpg");
        }
    }
}
