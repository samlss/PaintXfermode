package com.iigo.paintxfermode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author SamLeung
 * @Emial 729717222@qq.com
 * @date 2018/6/22 0022 18:06
 */
public class AllModeSampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new XFerModesSampleView(this));
    }
}
