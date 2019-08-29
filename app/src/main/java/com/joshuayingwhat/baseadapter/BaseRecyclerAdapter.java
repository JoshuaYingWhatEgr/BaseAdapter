package com.joshuayingwhat.baseadapter;

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

    private int resourceLayout;
    private List<T> resDatas;

    public BaseRecyclerAdapter(Collection<T> resDatas, RecyclerView recyclerView, int resourceLayout) {
        if (resDatas == null) {
            this.resDatas = new ArrayList<>();
        } else if (resDatas instanceof List) {
            this.resDatas = (List<T>) resDatas;
        } else {
            this.resDatas = new ArrayList<>(resDatas);
        }

        this.resourceLayout = resourceLayout;


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @NonNull
    @Override
    public BaseRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerHolder holder, int position) {

    }
}
