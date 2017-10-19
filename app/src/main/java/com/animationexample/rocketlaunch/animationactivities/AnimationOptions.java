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

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateInterpolator;

public class AnimationOptions extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        ValueAnimator verticalMovementAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);
        verticalMovementAnimator.addUpdateListener(animator -> {
            float value = (float) animator.getAnimatedValue();
            mRocket.setTranslationY(value);
            mDoge.setTranslationY(value);
        });

        ValueAnimator rotationAnimator = ValueAnimator.ofFloat(0, 360);
        rotationAnimator.addUpdateListener(animator -> {
            float value = (float) animator.getAnimatedValue();
            mDoge.setRotation(value);
        });

        setupAnimationOptions(rotationAnimator);
        setupAnimationOptions(verticalMovementAnimator);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(verticalMovementAnimator).with(rotationAnimator);
        animatorSet.start();
    }

    private void setupAnimationOptions(ValueAnimator animator){
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(3); // this repeat count is a zero index value
        animator.setDuration(DEFAULT_ANIMATION_DURATION);
        animator.setInterpolator(new AccelerateInterpolator(2f));
    }

    @Override
    protected String getDisplayMessage() {
        return "Animation Options, AnimatorSet";
    }
}
