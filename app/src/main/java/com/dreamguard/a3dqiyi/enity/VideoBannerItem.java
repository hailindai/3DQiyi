package com.dreamguard.a3dqiyi.enity;

/**
 * Created by hailin.dai on 2018/5/6.
 * Email: 605345320@qq.com
 */

public class VideoBannerItem {
    private String imageUrl;
    private String name;
    private String time;
    private String url;

    public VideoBannerItem(String imageUrl, String name, String time, String url) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.time = time;
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
