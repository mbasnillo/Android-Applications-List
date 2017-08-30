package com.milestrong.applist;

import android.graphics.drawable.Drawable;

/**
 * Created by Miles Lawrence on 30/08/2017.
 */

public class Application {
    private String title;
    private Drawable icon;

    public Application(String title, Drawable icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return this.title;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
