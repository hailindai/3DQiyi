package com.dreamguard.a3dqiyi.view;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dreamguard.a3dqiyi.R;
import com.dreamguard.a3dqiyi.utils.GlideCircleTransform;
import com.dreamguard.a3dqiyi.utils.GlideRoundTransform;
import com.dreamguard.a3dqiyi.view.video.GameBannerAdapter;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */
public class GameFragment extends Fragment {


    private ViewPager gameBannerViewPager;
    private PagerAdapter gameBannerAdapter;



    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        gameBannerViewPager = (ViewPager) view.findViewById(R.id.game_banner);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gameBannerAdapter = new GameBannerAdapter(getActivity());
        gameBannerViewPager.setPageMargin(10);
        gameBannerViewPager.setAdapter(gameBannerAdapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("dai","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("dai","onResume");
        startScrollBanner();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("dai","onPause");
        stopScrollBanner();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("dai","onStop");
    }

    private boolean isLooper;

    public void startScrollBanner(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                isLooper = true;
                while (isLooper){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //这里是设置当前页的下一页
                            gameBannerViewPager.setCurrentItem(gameBannerViewPager.getCurrentItem() + 1);
                        }
                    });
                }
            }
        }).start();
    }

    public void stopScrollBanner(){
        isLooper = false;
    }
}
