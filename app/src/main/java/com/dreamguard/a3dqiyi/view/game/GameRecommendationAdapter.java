package com.dreamguard.a3dqiyi.view.game;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dreamguard.a3dqiyi.R;
import com.dreamguard.a3dqiyi.enity.GameRecommendationItem;
import com.dreamguard.a3dqiyi.enity.VideoClassificationItem;

import java.util.List;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */

public class GameRecommendationAdapter extends BaseQuickAdapter<GameRecommendationItem, BaseViewHolder> {
    public GameRecommendationAdapter(@LayoutRes int layoutResId, @Nullable List<GameRecommendationItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GameRecommendationItem item) {
        Glide.with(mContext).load(item.getImageUrl()).crossFade().into((ImageView) helper.getView(R.id.game_recommendation_item_image));
        helper.setText(R.id.game_recommendation_item_name,item.getName());
    }
}
