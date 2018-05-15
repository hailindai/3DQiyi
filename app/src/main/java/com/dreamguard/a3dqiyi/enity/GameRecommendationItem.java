package com.dreamguard.a3dqiyi.enity;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */

public class GameRecommendationItem {
    private String imageUrl;
    private String name;

    public GameRecommendationItem(String imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
