/*
 * Copyright 2017 Nazmul Idris. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.animationexample.rocketlaunch.animationactivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import com.animationexample.rocketlaunch.R;

public abstract class BaseAnimationActivity extends AppCompatActivity {

    public static final long DEFAULT_ANIMATION_DURATION = 2500L;
    protected View mRocket;
    protected View mDoge;
    protected View mFrameLayout;
    protected float mScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base_animation);

        mRocket = findViewById(R.id.rocket);
        mDoge = findViewById(R.id.doge);

        mFrameLayout = findViewById(R.id.container);
        mFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseAnimationActivity.this,
                               getDisplayMessage(),
                               Toast.LENGTH_SHORT).show();
                onStartAnimation();
            }
        });
    }

    protected String getDisplayMessage(){
        return "user click";
    }

    @Override
    protected void onResume() {
        super.onResume();

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenHeight = displaymetrics.heightPixels;
    }

    protected abstract void onStartAnimation();
}
