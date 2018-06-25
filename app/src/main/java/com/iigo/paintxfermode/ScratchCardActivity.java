package com.iigo.paintxfermode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author SamLeung
 * @Emial 729717222@qq.com
 * @date 2018/6/25 0025 14:40
 */
public class ScratchCardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ScratchCardView(this));
    }
}
