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

package com.animationexample.rocketlaunch;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;

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
import com.animationexample.rocketlaunch.downloadablefonts.FontDownloader;
import com.animationexample.rocketlaunch.downloadablefonts.MyTypefaceSpan;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets custom font on ActionBar title.
        setupAppBar();

        RecyclerView recyclerView = findViewById(R.id.list);
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

    private void setupAppBar() {
        Toolbar appBar = findViewById(R.id.appbar);
        setSupportActionBar(appBar);

        final String titleString = getString(R.string.app_name);

        // WITHOUT FONT
        getSupportActionBar().setTitle(titleString);

        // WITH FONT
        new FontDownloader(
                this,
                typeface -> {
                    setFormattedTitle(titleString, typeface);
                });

        // following line does not work (can't find font)
        // setFormattedTitle(titleString, ResourcesCompat.getFont(this, R.font.poppins));
    }

    private void setFormattedTitle(String titleString, Typeface typeface) {
        SpannableString spannableString = new SpannableString(titleString);
        spannableString.setSpan(
                new MyTypefaceSpan(this, typeface),
                0,
                spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(spannableString);
    }
}
