package com.dreamguard.a3dqiyi;

import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.dreamguard.a3dqiyi.utils.BottomNavigationViewHelper;
import com.dreamguard.a3dqiyi.view.GameFragment;
import com.dreamguard.a3dqiyi.view.MyFragment;
import com.dreamguard.a3dqiyi.view.SearchFragment;
import com.dreamguard.a3dqiyi.view.VideoFragment;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView bottomVideo;
    private ImageView bottomGame;
    private ImageView bottomSearch;
    private ImageView bottomMy;
    private ImageView bottomVR;

    private AnimationDrawable videoAnimationDrawable;
    private AnimationDrawable gameAnimationDrawable;
    private AnimationDrawable searchAnimationDrawable;
    private AnimationDrawable myAnimationDrawable;

    private VideoFragment videoFragment;
    private GameFragment gameFragment;
    private SearchFragment searchFragment;
    private MyFragment myFragment;
    private int currentFragmentIndex = -1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){

        bottomVideo = (ImageView) findViewById(R.id.bottom_video);
        bottomGame = (ImageView) findViewById(R.id.bottom_game);
        bottomSearch = (ImageView) findViewById(R.id.bottom_search);
        bottomMy = (ImageView) findViewById(R.id.bottom_my);
        bottomVR = (ImageView) findViewById(R.id.bottom_vr);

        bottomVideo.setOnClickListener(this);
        bottomGame.setOnClickListener(this);
        bottomSearch.setOnClickListener(this);
        bottomMy.setOnClickListener(this);
        bottomVR.setOnClickListener(this);

        videoAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                R.drawable.frame_anim_video);
        gameAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                R.drawable.frame_anim_game);
        searchAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                R.drawable.frame_anim_search);
        myAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                R.drawable.frame_anim_my);

        bottomVR = (ImageView) findViewById(R.id.bottom_vr);
        bottomVR.setOnClickListener(this);

        videoFragment = new VideoFragment();
        gameFragment = new GameFragment();
        searchFragment = new SearchFragment();
        myFragment = new MyFragment();

        switchItem(0);
    }

    public void SwitchFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .show(fragment)
                .commit();
    }

    public void switchItem(int index) {
        switch (index) {
            case 0:
                if (currentFragmentIndex != 0) {
                    SwitchFragment(videoFragment);
                    currentFragmentIndex = 0;
                }
                bottomVideo.setImageDrawable(videoAnimationDrawable);
                videoAnimationDrawable.start();
                bottomGame.setImageDrawable(gameAnimationDrawable.getFrame(0));
                bottomSearch.setImageDrawable(searchAnimationDrawable.getFrame(0));
                bottomMy.setImageDrawable(myAnimationDrawable.getFrame(0));
                break;
            case 1:
                if (currentFragmentIndex != 1) {
                    SwitchFragment(gameFragment);
                    currentFragmentIndex = 1;
                }
                bottomGame.setImageDrawable(gameAnimationDrawable);
                gameAnimationDrawable.start();
                bottomVideo.setImageDrawable(videoAnimationDrawable.getFrame(0));
                bottomSearch.setImageDrawable(searchAnimationDrawable.getFrame(0));
                bottomMy.setImageDrawable(myAnimationDrawable.getFrame(0));

                break;
            case 2:
                if (currentFragmentIndex != 2) {
                    SwitchFragment(searchFragment);
                    currentFragmentIndex = 2;
                }
                bottomSearch.setImageDrawable(searchAnimationDrawable);
                searchAnimationDrawable.start();
                bottomVideo.setImageDrawable(videoAnimationDrawable.getFrame(0));
                bottomGame.setImageDrawable(gameAnimationDrawable.getFrame(0));
                bottomMy.setImageDrawable(myAnimationDrawable.getFrame(0));

                break;
            case 3:
                if (currentFragmentIndex != 3) {
                    SwitchFragment(myFragment);
                    currentFragmentIndex = 3;
                }
                bottomMy.setImageDrawable(myAnimationDrawable);
                myAnimationDrawable.start();
                bottomVideo.setImageDrawable(videoAnimationDrawable.getFrame(0));
                bottomGame.setImageDrawable(gameAnimationDrawable.getFrame(0));
                bottomSearch.setImageDrawable(searchAnimationDrawable.getFrame(0));

                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_video:
                switchItem(0);
                break;
            case R.id.bottom_game:
                switchItem(1);
                break;
            case R.id.bottom_search:
                switchItem(2);
                break;
            case R.id.bottom_my:
                switchItem(3);
                break;
            case R.id.bottom_vr:
                break;
        }
    }

    private long exitTime = 0;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - exitTime < 2000){
            super.onBackPressed();
        }else {
            Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        }
    }

}
