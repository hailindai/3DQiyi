package com.dreamguard.a3dqiyi.view.video;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dreamguard.a3dqiyi.R;
import com.dreamguard.a3dqiyi.enity.VideoSelectionItem;
import com.dreamguard.a3dqiyi.enity.VideoStereo3DItem;

import java.util.List;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */

public class VideoRecommendStereo3DAdapter extends BaseQuickAdapter<VideoStereo3DItem, BaseViewHolder> {
    public VideoRecommendStereo3DAdapter(@LayoutRes int layoutResId, @Nullable List<VideoStereo3DItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoStereo3DItem item) {
        helper.setText(R.id.video_recommend_stereo_3d_item_name,item.getName());
        helper.setText(R.id.video_recommend_stereo_3d_item_time,item.getTime());
        Glide.with(mContext).load(item.getImageUrl()).crossFade().into((ImageView) helper.getView(R.id.video_recommend_stereo_3d_item_image));
    }
}
