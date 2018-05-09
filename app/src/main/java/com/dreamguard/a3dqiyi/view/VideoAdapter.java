package com.dreamguard.a3dqiyi.view;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dreamguard.a3dqiyi.view.video.VideoA3DFragment;
import com.dreamguard.a3dqiyi.view.video.VideoHipTopFragment;
import com.dreamguard.a3dqiyi.view.video.VideoRecommendFragment;
import com.dreamguard.a3dqiyi.view.video.VideoVRFragment;
import com.dreamguard.a3dqiyi.view.video.VideoWelfareFragment;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */

public class VideoAdapter extends FragmentStatePagerAdapter {
    public VideoAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new VideoRecommendFragment();
            case 1:
                return new VideoHipTopFragment();
            case 2:
                return new VideoA3DFragment();
            case 3:
                return new VideoVRFragment();
            case 4:
                return new VideoWelfareFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

    /**
     * java.lang.IllegalStateException: Fragement no longer exists for key f0: index 0
     * @return
     */
    @Override
    public Parcelable saveState() {
        return null;
    }

}
