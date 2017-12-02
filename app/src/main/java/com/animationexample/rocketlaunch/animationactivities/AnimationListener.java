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

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

public class AnimationListener extends BaseAnimationActivity {

    @Override
    protected void onStartAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, -mScreenHeight);
        animator.addUpdateListener(
                valueAnimator -> {
                    float value = (float) valueAnimator.getAnimatedValue();
                    mRocket.setTranslationY(value);
                    mDoge.setTranslationY(value);
                });

        animator.addListener(
                new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Toast.makeText(
                                        AnimationListener.this,
                                        "Doge launched off earth",
                                        Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(
                                        AnimationListener.this,
                                        "Doge is on the moon",
                                        Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {}

                    @Override
                    public void onAnimationRepeat(Animator animation) {}
                });

        animator.setDuration(DEFAULT_ANIMATION_DURATION * 2);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }

    @Override
    protected String getDisplayMessage() {
        return "Animation Listeners";
    }
}
