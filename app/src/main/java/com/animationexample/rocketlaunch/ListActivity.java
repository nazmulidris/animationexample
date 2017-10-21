/*
 * Copyright 2017 Nazmul Idris.
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

package com.animationexample.rocketlaunch;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.view.View;

import com.animationexample.rocketlaunch.animationactivities.AnimationListener;
import com.animationexample.rocketlaunch.animationactivities.AnimationOptions;
import com.animationexample.rocketlaunch.animationactivities.ChangeBackgroundColor;
import com.animationexample.rocketlaunch.animationactivities.FlyDoge;
import com.animationexample.rocketlaunch.animationactivities.LaunchAndSpin;
import com.animationexample.rocketlaunch.animationactivities.LaunchAndSpinViewPropertyAnimator;
import com.animationexample.rocketlaunch.animationactivities.LaunchRocket1;
import com.animationexample.rocketlaunch.animationactivities.LaunchRocket2;
import com.animationexample.rocketlaunch.animationactivities.LaunchRocket3;
import com.animationexample.rocketlaunch.animationactivities.NoAnimation;
import com.animationexample.rocketlaunch.animationactivities.RotateRocket;
import com.animationexample.rocketlaunch.animationactivities.XmlAnimationActivity;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets custom font on ActionBar title.
        setupAppBar();

        // Hides the status bar.
        hideStatusBar();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));

        List<RocketAnimationItem> items = new ArrayList<>();

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_no_animation),
                        new Intent(this, NoAnimation.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_launch_rocket_1),
                        new Intent(this, LaunchRocket1.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_spin_rocket),
                        new Intent(this, RotateRocket.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_launch_rocket_2),
                        new Intent(this, LaunchRocket2.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_launch_rocket_3),
                        new Intent(this, LaunchRocket3.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_color_animation),
                        new Intent(this, ChangeBackgroundColor.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.launch_spin_1), new Intent(this, LaunchAndSpin.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.launch_spin_2),
                        new Intent(this, LaunchAndSpinViewPropertyAnimator.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_with_doge), new Intent(this, FlyDoge.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_animation_listeners),
                        new Intent(this, AnimationListener.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_animation_options),
                        new Intent(this, AnimationOptions.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_jump_and_blink),
                        new Intent(this, XmlAnimationActivity.class)));

        recyclerView.setAdapter(new RocketAdapter(this, items));
    }

    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void setupAppBar() {
        Toolbar appBar = findViewById(R.id.appbar);
        setSupportActionBar(appBar);
        SpannableString spannableString = new SpannableString(getString(R.string.app_name));
        spannableString.setSpan(
                new TypefaceSpan(this, "Saira-Regular.ttf"),
                0,
                spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(spannableString);
    }
}

class TypefaceSpan extends MetricAffectingSpan {
    /** An <code>LruCache</code> for previously loaded typefaces. */
    private static LruCache<String, Typeface> sTypefaceCache = new LruCache<String, Typeface>(12);

    private Typeface mTypeface;

    /** Load the {@link Typeface} and apply to a {@link Spannable}. */
    public TypefaceSpan(Context context, String typefaceName) {
        mTypeface = sTypefaceCache.get(typefaceName);

        if (mTypeface == null) {
            mTypeface =
                    Typeface.createFromAsset(
                            context.getApplicationContext().getAssets(),
                            String.format("fonts/%s", typefaceName));

            // Cache the loaded Typeface
            sTypefaceCache.put(typefaceName, mTypeface);
        }
    }

    @Override
    public void updateMeasureState(TextPaint p) {
        p.setTypeface(mTypeface);

        // Note: This flag is required for proper typeface rendering
        p.setFlags(p.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.setTypeface(mTypeface);

        // Note: This flag is required for proper typeface rendering
        tp.setFlags(tp.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }
}
