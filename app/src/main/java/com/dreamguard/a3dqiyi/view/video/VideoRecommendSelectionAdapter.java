package com.dreamguard.a3dqiyi.view.video;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dreamguard.a3dqiyi.R;
import com.dreamguard.a3dqiyi.enity.VideoClassificationItem;
import com.dreamguard.a3dqiyi.enity.VideoSelectionItem;

import java.util.List;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */

public class VideoRecommendSelectionAdapter extends BaseQuickAdapter<VideoSelectionItem, BaseViewHolder> {
    public VideoRecommendSelectionAdapter(@LayoutRes int layoutResId, @Nullable List<VideoSelectionItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoSelectionItem item) {
        helper.setText(R.id.video_recommend_selection_item_name,item.getName());
        helper.setText(R.id.video_recommend_selection_item_time,item.getTime());
        Glide.with(mContext).load(item.getImageUrl()).crossFade().into((ImageView) helper.getView(R.id.video_recommend_selection_item_image));
    }
}
