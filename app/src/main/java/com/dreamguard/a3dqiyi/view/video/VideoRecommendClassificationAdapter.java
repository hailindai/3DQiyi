package com.dreamguard.a3dqiyi.view.video;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dreamguard.a3dqiyi.R;
import com.dreamguard.a3dqiyi.enity.SearchTopItem;
import com.dreamguard.a3dqiyi.enity.VideoClassificationItem;

import java.util.List;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */

public class VideoRecommendClassificationAdapter extends BaseQuickAdapter<VideoClassificationItem, BaseViewHolder> {
    public VideoRecommendClassificationAdapter(@LayoutRes int layoutResId, @Nullable List<VideoClassificationItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoClassificationItem item) {
        Glide.with(mContext).load(item.getImageUrl()).crossFade().into((ImageView) helper.getView(R.id.video_recommend_classification_item_image));
        helper.setText(R.id.video_recommend_classification_item_name,item.getName());
    }
}
