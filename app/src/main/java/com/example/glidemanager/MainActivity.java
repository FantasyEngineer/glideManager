package com.example.glidemanager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.example.glidemanager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        GlideUtils.getInstance().load(this, "https://img0.baidu.com/it/u=1472391233,99561733&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", binding.iv1);
        GlideUtils.getInstance().loadAvatar(this, "https://img0.baidu.com/it/u=1472391233,99561733&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", binding.iv2);
        GlideUtils.getInstance().loadCenterCrop(this, "https://img0.baidu.com/it/u=1472391233,99561733&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", binding.iv3);

        GlideUtils.getInstance().loadCorner(this, "https://img0.baidu.com/it/u=1472391233,99561733&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", binding.iv4, 30);
        GlideUtils.getInstance().loadCornerAround(this, "https://img0.baidu.com/it/u=1472391233,99561733&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", binding.iv5, 5, 20, 30, 60);
        GlideUtils.getInstance().loadBlur(this, "https://img0.baidu.com/it/u=1472391233,99561733&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", binding.iv6);


        GlideUtils.getInstance().loadListener(this, "https://img2.woyaogexing.com/2022/10/13/e244310e1729830a!400x400.jpg", binding.iv6, new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                Log.d("TAG", "onResourceReady: " + resource);
                Log.d("TAG", "onResourceReady: " + model);
                Log.d("TAG", "onResourceReady: " + target);
                Log.d("TAG", "onResourceReady: " + dataSource);
                Log.d("TAG", "onResourceReady: " + isFirstResource);

                return false;
            }
        });




    }

}