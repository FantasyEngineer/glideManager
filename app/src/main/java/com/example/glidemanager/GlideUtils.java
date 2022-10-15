package com.example.glidemanager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Glide的工具类
 * <p>
 * implementation 'com.github.bumptech.glide:glide:4.14.2'
 * annotationProcessor 'com.github.bumptech.glide:compiler:4.14.2'
 * implementation 'jp.wasabeef:glide-transformations:4.3.0'
 * <p>
 * https://github.com/wasabeef/glide-transformations
 */
public class GlideUtils {

    private static String TAG = "glide";
    private final ColorDrawable placeHolderDrawable;
    private final ColorDrawable redDrawable;

    private GlideUtils() {
        //加载中
        placeHolderDrawable = new ColorDrawable(Color.parseColor("#5087EC"));
        //加载失败 根据自己的需求替换
        redDrawable = new ColorDrawable(Color.parseColor("#E83B30"));
    }

    public static GlideUtils getInstance() {
        return SingletonHolder.GLIDE;
    }

    private static class SingletonHolder {
        private static final GlideUtils GLIDE = new GlideUtils();
    }

    /**
     * 加载普通的图,原图展示,可能上下有空白
     *
     * @param context
     * @param ob        file ,bitmap, drawable, url,Uri,byte[],resourceId
     * @param imageView
     */
    public void load(Context context, Object ob, ImageView imageView) {
        load(context, ob, imageView, false, false);
    }

    /**
     * 加载居中无圆角
     *
     * @param context
     * @param ob
     * @param imageView
     */
    public void loadCenterCrop(Context context, Object ob, ImageView imageView) {
        load(context, ob, imageView, true, false);
    }

    /**
     * 加载圆形头像
     *
     * @param context
     * @param ob
     * @param imageView
     */
    public void loadAvatar(Context context, Object ob, ImageView imageView) {
        load(context, ob, imageView, true, true);
    }


    private void load(Context context, Object ob, ImageView imageView, Boolean isCenterCrop, Boolean isCircle) {
        RequestBuilder<Drawable> builder = Glide.with(context).load(ob);
        if (isCenterCrop) builder.transform(new CenterCrop());
        if (isCircle) builder.transform(new CircleCrop());//设置了这个,默认就是centerCrop
        builder.placeholder(placeHolderDrawable).error(redDrawable).into(imageView);
    }

    /**
     * 加载带角的图片
     *
     * @param context
     * @param ob
     * @param imageView
     * @param roundingRadius
     */
    public void loadCorner(Context context, Object ob, ImageView imageView, int roundingRadius) {
        RequestBuilder<Drawable> builder = Glide.with(context).load(ob);
        builder.transform(new CenterCrop(), new RoundedCorners(roundingRadius));
        builder.placeholder(placeHolderDrawable).error(redDrawable).into(imageView);
    }

    public void loadBlur(Context context, Object ob, ImageView imageView) {
        Glide.with(context).load(ob).transform(new CenterCrop(), new BlurTransformation(1, 5))
                .placeholder(placeHolderDrawable).error(redDrawable).into(imageView);
    }


    /**
     * 加载不同角度的图片
     *
     * @param context
     * @param ob
     * @param imageView
     */
    public void loadCornerAround(Context context, Object ob, ImageView imageView, float topLeft, float topRight, float bottomRight, float bottomLeft) {
        RequestBuilder<Drawable> builder = Glide.with(context).load(ob);
        builder.transform(new CenterCrop(), new GranularRoundedCorners(topLeft, topRight, bottomRight, bottomLeft));
        builder.placeholder(placeHolderDrawable).error(redDrawable).into(imageView);
    }

    public void loadListener(Context mContext, String path, ImageView mImageView, RequestListener<Drawable> requestListener) {
        Glide.with(mContext).load(path).listener(requestListener).placeholder(placeHolderDrawable).error(redDrawable).into(mImageView);
    }

    public void loadToContent(Context mContext, String path, SimpleTarget<Drawable> simpleTarget) {
        Glide.with(mContext).load(path).centerCrop().placeholder(placeHolderDrawable).error(redDrawable).into(simpleTarget);
    }

    //理磁盘缓存 需要在子线程中执行
    public static void clearDiskCache(Context mContext) {
        Glide.get(mContext).clearDiskCache();
    }

    //清理内存缓存  可以在UI主线程中进行
    public static void clearMemory(Context mContext) {
        Glide.get(mContext).clearMemory();
    }

}
