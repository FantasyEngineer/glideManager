package com.example.glidemanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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
        GlideUtils.getInstance().loadCornerAround(this, "https://img0.baidu.com/it/u=1472391233,99561733&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", binding.iv5, 5,20,30,60);
        GlideUtils.getInstance().loadBlur(this, "https://img0.baidu.com/it/u=1472391233,99561733&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", binding.iv6);

    }

}