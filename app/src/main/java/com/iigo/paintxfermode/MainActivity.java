package com.iigo.paintxfermode;

import android.content.Intent;
import android.graphics.AvoidXfermode;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelXorXfermode;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartModeSample(View view) {
        startActivity(new Intent(this, AllModeSampleActivity.class));
    }

    public void onStartScratchCardSample(View view) {
        startActivity(new Intent(this, ScratchCardActivity.class));
    }
}
