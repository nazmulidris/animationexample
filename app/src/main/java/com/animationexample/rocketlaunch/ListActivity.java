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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.animationexample.rocketlaunch.animationactivities.ChangeBackgroundColor;
import com.animationexample.rocketlaunch.animationactivities.FlyThereAndBackAnimationActivity;
import com.animationexample.rocketlaunch.animationactivities.FlyWithDogeAnimationActivity;
import com.animationexample.rocketlaunch.animationactivities.LaunchAndSpin;
import com.animationexample.rocketlaunch.animationactivities.LaunchAndSpinViewPropertyAnimator;
import com.animationexample.rocketlaunch.animationactivities.LaunchRocket1;
import com.animationexample.rocketlaunch.animationactivities.LaunchRocket2;
import com.animationexample.rocketlaunch.animationactivities.LaunchRocket3;
import com.animationexample.rocketlaunch.animationactivities.NoAnimation;
import com.animationexample.rocketlaunch.animationactivities.RotateRocket;
import com.animationexample.rocketlaunch.animationactivities.WithListenerAnimationActivity;
import com.animationexample.rocketlaunch.animationactivities.XmlAnimationActivity;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        getString(R.string.launch_spin_1),
                        new Intent(this, LaunchAndSpin.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.launch_spin_2),
                        new Intent(
                                this, LaunchAndSpinViewPropertyAnimator.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_with_doge),
                        new Intent(this, FlyWithDogeAnimationActivity.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_animation_events),
                        new Intent(this, WithListenerAnimationActivity.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_there_and_back),
                        new Intent(this, FlyThereAndBackAnimationActivity.class)));

        items.add(
                new RocketAnimationItem(
                        getString(R.string.title_jump_and_blink),
                        new Intent(this, XmlAnimationActivity.class)));

        recyclerView.setAdapter(new RocketAdapter(this, items));
    }
}
