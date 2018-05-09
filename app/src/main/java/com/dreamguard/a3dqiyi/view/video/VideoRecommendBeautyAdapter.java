package com.dreamguard.a3dqiyi.view.video;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dreamguard.a3dqiyi.R;
import com.dreamguard.a3dqiyi.enity.VideoBeautyItem;
import com.dreamguard.a3dqiyi.enity.VideoSelectionItem;

import java.util.List;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */

public class VideoRecommendBeautyAdapter extends BaseQuickAdapter<VideoBeautyItem, BaseViewHolder> {
    public VideoRecommendBeautyAdapter(@LayoutRes int layoutResId, @Nullable List<VideoBeautyItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoBeautyItem item) {
        helper.setText(R.id.video_recommend_beauty_item_name,item.getName());
        Glide.with(mContext).load(item.getImageUrl()).crossFade().into((ImageView) helper.getView(R.id.video_recommend_beauty_item_image));
    }
}
