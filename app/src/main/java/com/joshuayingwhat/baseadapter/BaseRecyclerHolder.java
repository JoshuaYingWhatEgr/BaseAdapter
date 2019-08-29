package com.joshuayingwhat.baseadapter;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author joshuayingwhat
 */
public class BaseRecyclerHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private TextView textView;

    public BaseRecyclerHolder(@NonNull View itemView) {
        super(itemView);
        this.mViews = new SparseArray<>(8);
    }

    /**
     * 根据布局id获取 view
     */
    private <T> T getView(int resourceId) {
        View view = mViews.get(resourceId);
        if (view == null) {
            //如果当前view没有找到就findviewbyid,同时将此view和id存入sparsearray
            view = itemView.findViewById(resourceId);
            mViews.put(resourceId, view);
        }
        return (T) view;
    }

    /**
     * 根据id设置textview
     */
    public void setText(int resourceId, String content) {
        textView = getView(resourceId);
        textView.setText(content);
    }

    /**
     * 通过getText设置当前控件的点击事件
     */
    public TextView getText() {
        if (textView != null) {
            return textView;
        }
        return null;
    }

    /**
     * 根据id设置images
     */
    public void setImages(int resourceId, Drawable drawables) {
        ImageView view = getView(resourceId);
        view.setImageDrawable(drawables);
    }
}
