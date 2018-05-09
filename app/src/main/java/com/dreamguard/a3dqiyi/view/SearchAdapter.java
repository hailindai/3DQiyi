package com.dreamguard.a3dqiyi.view;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dreamguard.a3dqiyi.R;
import com.dreamguard.a3dqiyi.enity.SearchTopItem;

import java.util.List;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */

public class SearchAdapter extends BaseQuickAdapter<SearchTopItem, BaseViewHolder> {
    public SearchAdapter(@LayoutRes int layoutResId, @Nullable List<SearchTopItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchTopItem item) {
        //使用本地资源模拟
        helper.setImageResource(R.id.search_top_item_image,Integer.parseInt(item.getImageUrl()));
        helper.setText(R.id.search_top_item_name,item.getName());
    }
}
