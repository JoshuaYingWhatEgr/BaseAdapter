package com.joshuayingwhat.baseadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * 此项目是 开发一款通用的adapter适配器
 *
 * @author joshuayingwhat
 */
public class MainActivity extends AppCompatActivity {

    private List<Widget> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));

        for (int i = 0; i < 100; i++) {
            Widget widget = new Widget(i + "", i + "");
            mList.add(widget);
        }

        WidgetAdapter widgetAdapter = new WidgetAdapter(mList, recyclerView, R.layout.item_widget_layout);
        recyclerView.setAdapter(widgetAdapter);
    }
}
