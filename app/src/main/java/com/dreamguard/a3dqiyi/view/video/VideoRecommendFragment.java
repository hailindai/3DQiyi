package com.dreamguard.a3dqiyi.view.video;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dreamguard.a3dqiyi.R;
import com.dreamguard.a3dqiyi.enity.SearchTopItem;
import com.dreamguard.a3dqiyi.enity.VideoBannerItem;
import com.dreamguard.a3dqiyi.enity.VideoBeautyItem;
import com.dreamguard.a3dqiyi.enity.VideoClassificationItem;
import com.dreamguard.a3dqiyi.enity.VideoSelectionItem;
import com.dreamguard.a3dqiyi.enity.VideoStereo3DItem;
import com.dreamguard.a3dqiyi.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoRecommendFragment extends Fragment {

    private Banner bannerView;
    private RecyclerView classificationView;
    private VideoRecommendClassificationAdapter classificationAdapter;
    private RecyclerView selectionView;
    private VideoRecommendSelectionAdapter selectionAdapter;
    private RecyclerView beautyView;
    private VideoRecommendBeautyAdapter beautyAdapter;
    private RecyclerView stereo3DView;
    private VideoRecommendStereo3DAdapter stereo3DAdapter;

    public VideoRecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video_recommend, container, false);
        bannerView = (Banner)view.findViewById(R.id.banner);
        classificationView = (RecyclerView)view.findViewById(R.id.classification);
        selectionView = (RecyclerView)view.findViewById(R.id.selection);
        beautyView = (RecyclerView)view.findViewById(R.id.beauty);
        stereo3DView = (RecyclerView)view.findViewById(R.id.stereo_3d);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //banner
        List<VideoBannerItem> bannerItems = new ArrayList<>();
        bannerItems.add(new VideoBannerItem("http://pic0.qiyipic.com/common/lego/20180423/a0def7d7222e4d7eb2e5c2b391291323.jpg","VR动画丨史前世界：侏罗纪","","http://www.iqiyi.com/v_19rrfaiy4w.html"));
        bannerItems.add(new VideoBannerItem("http://pic0.qiyipic.com/common/lego/20180503/8b3c3643084f4d5c8ae718f16443b7e3.jpg","VR旅行丨锦绣云南：红河","","http://www.iqiyi.com/v_19rrbpqa14.html"));
        bannerItems.add(new VideoBannerItem("http://pic1.qiyipic.com/common/lego/20180504/f384e79341f4460cbbec28b2250c3e28.jpg","VR佳片丨free whale","","http://www.iqiyi.com/v_19rre29k0g.html"));
        bannerItems.add(new VideoBannerItem("http://pic0.qiyipic.com/common/lego/20180423/2024f1b96410447d96fa617f06ad1906.jpg","VR佳片丨free whale","","http://www.iqiyi.com/v_19rre29k0g.html"));

        bannerView.setImageLoader(new GlideImageLoader());
        bannerView.setImages(bannerItems);
        bannerView.setDelayTime(5000);
        List<String> titleItems = new ArrayList<>();
        for(VideoBannerItem item:bannerItems){
            titleItems.add(item.getName());
        }
        bannerView.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        bannerView.setBannerTitles(titleItems);
        bannerView.start();

        //classification
        classificationView.setLayoutManager(new GridLayoutManager(getContext(),5));
        List<VideoClassificationItem> classificationItems = new ArrayList<>();
        classificationItems.add(new VideoClassificationItem("http://pic3-b.qiyipic.com/image/20180504/vr/vr_entrance26_1525398939717.png", "热血街舞团"));
        classificationItems.add(new VideoClassificationItem("http://pic3-b.qiyipic.com/image/20180504/vr/vr_entrance25_1525398599185.png", "全景看奇葩"));
        classificationItems.add(new VideoClassificationItem("http://pic3-b.qiyipic.com/image/20180428/vr/vr_entrance24_1524883480666.png", "偶像面对面"));
        classificationItems.add(new VideoClassificationItem("http://pic3-b.qiyipic.com/image/20180427/vr/vr_entrance16_1524832007730.png", "必看精品"));
        classificationItems.add(new VideoClassificationItem("http://pic3-b.qiyipic.com/image/20180427/vr/vr_entrance17_1524832019864.png", "本地视频"));
        classificationAdapter = new VideoRecommendClassificationAdapter(R.layout.item_video_recommend_classification,classificationItems);
        classificationView.setAdapter(classificationAdapter);

        //selection
        selectionView.setLayoutManager(new GridLayoutManager(getContext(),2));
        List<VideoSelectionItem> selectionItems = new ArrayList<>();
        selectionItems.add(new VideoSelectionItem("http://pic1.qiyipic.com/common/lego/20180428/f713a94a60564c3bb084ca77ecd9c0ae.jpg","VR动画丨史前世界：侏罗纪","10:00:00","http://www.iqiyi.com/v_19rrfaiy4w.html"));
        selectionItems.add(new VideoSelectionItem("http://pic1.qiyipic.com/common/lego/20180502/60299ac2838e4c8ab62ad4310e2e921e.jpg","VR旅行丨锦绣云南：红河","10:00:00","http://www.iqiyi.com/v_19rrbpqa14.html"));
        selectionItems.add(new VideoSelectionItem("http://pic0.qiyipic.com/common/lego/20180419/387c1ac317d84f13a432fce5915010a1.jpg","VR佳片丨free whale","10:00:00","http://www.iqiyi.com/v_19rre29k0g.html"));
        selectionItems.add(new VideoSelectionItem("http://pic2.qiyipic.com/common/lego/20180420/0f7f21b85206468abd1ac8c823720bf3.jpg","VR动画丨史前世界：侏罗纪","10:00:00","http://www.iqiyi.com/v_19rrfaiy4w.html"));

        selectionAdapter = new VideoRecommendSelectionAdapter(R.layout.item_video_recommend_selection,selectionItems);
        selectionAdapter.addHeaderView(LinearLayout.inflate(getContext(),R.layout.item_video_recommend_selection_header,null));
        selectionView.setAdapter(selectionAdapter);

        //beauty
        beautyView.setLayoutManager(new GridLayoutManager(getContext(),2));
        List<VideoBeautyItem> beautyItems = new ArrayList<>();
        beautyItems.add(new VideoBeautyItem("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525802046005&di=2aa70154b9f7dd7714b07c98123c3346&imgtype=0&src=http%3A%2F%2Fpic.yesky.com%2FuploadImages%2F2015%2F152%2F53%2FSH47MDG7BT13.jpg","VR动画丨史前世界：侏罗纪","http://www.iqiyi.com/v_19rrfaiy4w.html"));
        beautyItems.add(new VideoBeautyItem("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525802088886&di=f1a4f6ca63c6b50fbcd3885a9804b001&imgtype=0&src=http%3A%2F%2Fold.bz55.com%2Fuploads%2Fallimg%2F150604%2F139-1506041IG9.jpg","VR旅行丨锦绣云南：红河","http://www.iqiyi.com/v_19rrbpqa14.html"));
        beautyItems.add(new VideoBeautyItem("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525802173289&di=acdc7b57e630c6aae79335e5c784ba63&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3D8867b8119616fdfacc61ceaeddf7e938%2Fbd3eb13533fa828b8996ded9f61f4134970a5a56.jpg","VR佳片丨free whale","http://www.iqiyi.com/v_19rre29k0g.html"));
        beautyItems.add(new VideoBeautyItem("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525802191702&di=811d0af29a07915701440da1d67122ed&imgtype=0&src=http%3A%2F%2Fwww.fansimg.com%2Fuploads2012%2F05%2Fuserid174909time20120526160908.jpg","VR动画丨史前世界：侏罗纪","http://www.iqiyi.com/v_19rrfaiy4w.html"));
        beautyAdapter = new VideoRecommendBeautyAdapter(R.layout.item_video_recommend_beauty,beautyItems);
        beautyAdapter.addHeaderView(LinearLayout.inflate(getContext(),R.layout.item_video_recommend_beauty_header,null));
        beautyView.setAdapter(beautyAdapter);

        //stereo 3d
        stereo3DView.setLayoutManager(new GridLayoutManager(getContext(),3));
        List<VideoStereo3DItem> stereo3DItems = new ArrayList<>();
        stereo3DItems.add(new VideoStereo3DItem("http://pic3.qiyipic.com/image/20180328/65/0d/v_115301278_m_601_m1_260_360.jpg","VR动画丨史前世界：侏罗纪","10:00:00","http://www.iqiyi.com/v_19rrfaiy4w.html"));
        stereo3DItems.add(new VideoStereo3DItem("http://pic2.qiyipic.com/image/20180328/e9/cb/v_114789328_m_601_260_360.jpg","VR旅行丨锦绣云南：红河","10:00:00","http://www.iqiyi.com/v_19rrbpqa14.html"));
        stereo3DItems.add(new VideoStereo3DItem("http://pic8.qiyipic.com/image/20180217/86/b2/v_109505650_m_601_m3_260_360.jpg","VR佳片丨free whale","10:00:00","http://www.iqiyi.com/v_19rre29k0g.html"));
        stereo3DItems.add(new VideoStereo3DItem("http://pic9.qiyipic.com/image/20180218/f5/82/v_110119689_m_601_m2_260_360.jpg","VR动画丨史前世界：侏罗纪","10:00:00","http://www.iqiyi.com/v_19rrfaiy4w.html"));
        stereo3DItems.add(new VideoStereo3DItem("http://pic4.qiyipic.com/image/20180322/c9/ae/v_115293512_m_601_260_360.jpg","VR佳片丨free whale","10:00:00","http://www.iqiyi.com/v_19rre29k0g.html"));
        stereo3DItems.add(new VideoStereo3DItem("http://pic5.qiyipic.com/image/20180220/8d/2f/v_114693251_m_601_m1_260_360.jpg","VR动画丨史前世界：侏罗纪","10:00:00","http://www.iqiyi.com/v_19rrfaiy4w.html"));
        stereo3DAdapter = new VideoRecommendStereo3DAdapter(R.layout.item_video_recommend_stereo_3d,stereo3DItems);
        stereo3DAdapter.addHeaderView(LinearLayout.inflate(getContext(),R.layout.item_video_recommend_stereo_3d_header,null));
        stereo3DView.setAdapter(stereo3DAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        bannerView.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        bannerView.stopAutoPlay();
    }
}
