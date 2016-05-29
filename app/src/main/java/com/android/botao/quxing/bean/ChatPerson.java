package com.android.botao.quxing.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016/5/28.
 */
public class ChatPerson {
    private Drawable drawable;
    private int ResourceId;
    private String name;
    private String content;
    private String state;

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public int getResourceId() {
        return ResourceId;
    }

    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ChatPerson() {
    }
}
