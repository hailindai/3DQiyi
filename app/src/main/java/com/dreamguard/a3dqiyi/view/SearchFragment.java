package com.dreamguard.a3dqiyi.view;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dreamguard.a3dqiyi.R;
import com.dreamguard.a3dqiyi.enity.SearchTopItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */
public class SearchFragment extends Fragment {

    private RecyclerView searchHot;
    private SearchAdapter searchAdapter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchHot = (RecyclerView) view.findViewById(R.id.search_hot);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchHot.setLayoutManager(new GridLayoutManager(getContext(), 2));
        List<SearchTopItem> searchTopItems = new ArrayList<>();
        searchTopItems.add(new SearchTopItem(R.drawable.search_hot_1 + "", "偶像练习生 VR"));
        searchTopItems.add(new SearchTopItem(R.drawable.search_hot_2 + "", "热血街舞团 VR"));
        searchTopItems.add(new SearchTopItem(R.drawable.search_hot_3 + "", "VR旅行"));
        searchTopItems.add(new SearchTopItem(R.drawable.search_hot_4 + "", "VR过山车"));
        searchTopItems.add(new SearchTopItem(R.drawable.search_hot_5 + "", "3D电影"));
        searchTopItems.add(new SearchTopItem(R.drawable.search_hot_6 + "", "VR游戏"));
        searchTopItems.add(new SearchTopItem(R.drawable.search_hot_7 + "", "VR演唱会"));
        searchTopItems.add(new SearchTopItem(R.drawable.search_hot_8 + "", "太空"));
        searchTopItems.add(new SearchTopItem(R.drawable.search_hot_9 + "", "奔跑吧兄弟第6季"));
        searchTopItems.add(new SearchTopItem(R.drawable.search_hot_10 + "", "向往的生活第2季"));
        searchAdapter = new SearchAdapter(R.layout.item_search_top, searchTopItems);

        TextView searchHotHeader = new TextView(getContext());
        searchHotHeader.setText("热门搜索");
        searchHotHeader.setTextSize(16);
        searchHotHeader.setTextColor(Color.BLACK);
        searchHotHeader.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        searchAdapter.addHeaderView(searchHotHeader);
        searchHot.setAdapter(searchAdapter);
    }
}
