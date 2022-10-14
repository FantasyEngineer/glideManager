package com.example.glidemanager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class G {

    private final ColorDrawable placeHolderDrawable;
    private final ColorDrawable redDrawable;

    private G() {
        placeHolderDrawable = new ColorDrawable(Color.parseColor("#5087EC"));
        redDrawable = new ColorDrawable(Color.parseColor("#E83B30"));
    }

    public static G getInstance() {
        return SingletonHolder.glide;
    }

    private static class SingletonHolder {
        private static final G glide = new G();
    }

    /**
     * 加载url
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void load(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).placeholder(placeHolderDrawable).error(redDrawable).into(imageView);
    }
}
