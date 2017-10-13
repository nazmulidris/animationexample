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

package com.animationexample.rocketlaunch.animationactivities;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;

import com.animationexample.rocketlaunch.R;

public class ChangeBackgroundColor extends BaseAnimationActivity {

    @Override
    protected void onStartAnimation() {

        ValueAnimator animator =
                ValueAnimator.ofObject(
                        new ArgbEvaluator(),
                        ContextCompat.getColor(this, R.color.background_from),
                        ContextCompat.getColor(this, R.color.background_to));

        animator.addUpdateListener(
                valueAnimator -> {
                    int color = (int) animator.getAnimatedValue();
                    mFrameLayout.setBackgroundColor(color);
                });

        animator.setDuration(DEFAULT_ANIMATION_DURATION);

        animator.setInterpolator(new FastOutSlowInInterpolator());

        animator.start();
    }

    @Override
    protected String getDisplayMessage() {
        return "ObjectAnimator, backgroundColor";
    }

}
