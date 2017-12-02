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

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AnticipateInterpolator;

public class FlyDoge extends BaseAnimationActivity {

    @Override
    protected void onStartAnimation() {

        ValueAnimator positionAnimation = ValueAnimator.ofFloat(0, -mScreenHeight);
        positionAnimation.addUpdateListener(
                animator -> {
                    float value = (float) animator.getAnimatedValue();
                    mRocket.setTranslationY(value);
                    mDoge.setTranslationY(value);
                });
        positionAnimation.setRepeatCount(1);
        positionAnimation.setRepeatMode(ValueAnimator.REVERSE);

        ValueAnimator rotationAnimation = ValueAnimator.ofFloat(0, 360);
        rotationAnimation.addUpdateListener(
                valueAnimator -> {
                    float value = (float) valueAnimator.getAnimatedValue();
                    mDoge.setRotation(value);
                });
        rotationAnimation.setRepeatCount(1);
        rotationAnimation.setRepeatMode(ValueAnimator.REVERSE);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(positionAnimation).with(rotationAnimation);
        animatorSet.setDuration(DEFAULT_ANIMATION_DURATION);
        animatorSet.setInterpolator(new AnticipateInterpolator());
        animatorSet.start();
    }

    @Override
    protected String getDisplayMessage() {
        return "AnimatorSet, multiple objects, AnticipateInterpolator";
    }

}
