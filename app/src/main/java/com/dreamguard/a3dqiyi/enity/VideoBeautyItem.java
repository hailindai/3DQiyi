package com.dreamguard.a3dqiyi.enity;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */

public class VideoBeautyItem {
    private String imageUrl;
    private String name;
    private String url;

    public VideoBeautyItem(String imageUrl, String name, String url) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
