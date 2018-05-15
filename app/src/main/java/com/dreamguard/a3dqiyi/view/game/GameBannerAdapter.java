package com.dreamguard.a3dqiyi.view.game;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dreamguard.a3dqiyi.R;
import com.dreamguard.a3dqiyi.utils.GlideRoundTransform;

/**
 * <pre>
 *     author : daihailin
 *     e-mail : daihl@kdxfilm.com
 *     time   : 2018/05/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class GameBannerAdapter extends PagerAdapter{

    private Context mContext;
    public GameBannerAdapter(Context context) {
        mContext = context;
    }

    private String[] imgRes = {
            "http://pic3.qiyipic.com/common/lego/20180510/a090c0b50deb42c8952a35ebf8895ec2.jpg",
            "http://pic34.nipic.com/20131014/9483785_151836168001_2.jpg",
            "http://pic.58pic.com/58pic/13/17/92/22P58PICYyR_1024.jpg",
            "http://scimg.jb51.net/allimg/150430/14-1504300U01J49.jpg",
            "http://pic51.nipic.com/file/20141031/8098773_215235317000_2.jpg"
    };

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_game_banner_item, null);
        ImageView image = (ImageView) view.findViewById(R.id.game_banner_image);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        final int realPosition = getRealPosition(position);
        image.setImageURI(Uri.parse(imgRes[realPosition]));
        Glide.with(mContext)
                .load(imgRes[realPosition])
                .transform( new GlideRoundTransform(mContext))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(image);
        container.addView(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return view;
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public void startUpdate(ViewGroup container) {
        super.startUpdate(container);
        ViewPager viewPager = (ViewPager) container;
        int position = viewPager.getCurrentItem();
        if (position == 0) {
            position = getFirstItemPosition();
        } else if (position == getCount() - 1) {
            position = getLastItemPosition();
        }
        viewPager.setCurrentItem(position, false);

    }

    private int getRealCount() {
        return imgRes.length;
    }

    private int getRealPosition(int position) {
        return position % getRealCount();
    }

    private int getFirstItemPosition() {
        return Integer.MAX_VALUE / 2;
    }

    private int getLastItemPosition() {
        return Integer.MAX_VALUE / 2 - 1;
    }

}
