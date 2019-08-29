package com.joshuayingwhat.baseadapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;

/**
 * @author joshuayingwhat
 */
public class WidgetAdapter extends BaseRecyclerAdapter<Widget> {

    public WidgetAdapter(Collection<Widget> resDatas, RecyclerView recyclerView, int resourceLayout) {
        super(resDatas, recyclerView, resourceLayout);
    }

    @Override
    void convert(BaseRecyclerHolder holder, Widget datas, int position, boolean isScrolling) {
        holder.setTextView(R.id.name_tv, datas.getName());
        holder.setTextView(R.id.age_tv, datas.getAge());
    }


}
