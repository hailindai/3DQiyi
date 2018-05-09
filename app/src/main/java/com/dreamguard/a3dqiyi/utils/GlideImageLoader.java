package com.dreamguard.a3dqiyi.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dreamguard.a3dqiyi.enity.VideoBannerItem;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        VideoBannerItem item = (VideoBannerItem)path;
        Glide.with(context).load(item.getImageUrl()).into(imageView);
    }
}
