package com.joshuayingwhat.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author joshuayingwhat
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerHolder> {

    /**
     * recyclerview的布局
     */
    private int resourceLayout;

    /**
     * 初始化数据
     */
    private List<T> resDatas;

    /**
     * 是否在滑动中
     * true 不在滑动
     * false 滑动
     */
    private boolean isScrolling;

    private final Context viewContext;

    public BaseRecyclerAdapter(Collection<T> resDatas, RecyclerView recyclerView, int resourceLayout) {
        if (resDatas == null) {
            this.resDatas = new ArrayList<>();
        } else if (resDatas instanceof List) {
            this.resDatas = (List<T>) resDatas;
        } else {
            this.resDatas = new ArrayList<>(resDatas);
        }

        this.resourceLayout = resourceLayout;

        viewContext = recyclerView.getContext();

        /**
         * 这里是设置recyclerview滚动的时候不加载图片
         */
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //recyclerview不在滑动
                int scrollStateIdle = RecyclerView.SCROLL_STATE_IDLE;
                isScrolling = (newState == scrollStateIdle);
                if (isScrolling) {
                    //更新recyclerview所有数据
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resDatas == null ? 0 : resDatas.size();
    }

    @NonNull
    @Override
    public BaseRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseRecyclerHolder(LayoutInflater.from(viewContext)
                .inflate(resourceLayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerHolder holder, int position) {

    }
}
