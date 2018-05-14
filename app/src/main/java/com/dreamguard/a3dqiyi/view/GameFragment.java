package com.dreamguard.a3dqiyi.view;


import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dreamguard.a3dqiyi.R;
import com.dreamguard.a3dqiyi.enity.ScaleInTransformer;
import com.dreamguard.a3dqiyi.utils.GlideCircleTransform;
import com.dreamguard.a3dqiyi.utils.GlideRoundTransform;
import com.dreamguard.a3dqiyi.view.video.GameBannerAdapter;

import java.util.Timer;
import java.util.TimerTask;

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
        gameBannerViewPager.setPageTransformer(true,new ScaleInTransformer());
        initTimer();
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

    @Override
    public void onDestroy ( ) {
        if (timer != null) {
            timer.cancel( );
            timer = null;
        }
        super.onDestroy( );

    }


    public void startScrollBanner(){
        isLooper = true;
    }

    public void stopScrollBanner(){
        isLooper = false;
    }


    private void initTimer() {
        bannerTask = new TimerTask() {
            @Override
            public void run() {
                if (isLooper) {
                    autoHandler.sendEmptyMessage(0);
                }
            }
        };
        timer = new Timer();
        timer.schedule(bannerTask, 100, 3000);
    }

    private boolean isLooper;
    private Timer timer;
    private TimerTask bannerTask;
    private Handler autoHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    gameBannerViewPager.setCurrentItem(gameBannerViewPager.getCurrentItem() + 1);
                    break;
                default:
                    break;
            }
        }
    };
}
