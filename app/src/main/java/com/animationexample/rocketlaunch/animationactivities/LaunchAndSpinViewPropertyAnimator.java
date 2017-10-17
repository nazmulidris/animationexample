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

import android.view.animation.AccelerateInterpolator;

public class LaunchAndSpinViewPropertyAnimator extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        mRocket.animate()
                .translationY(-mScreenHeight)
                .rotationBy(360f)
                .setDuration(DEFAULT_ANIMATION_DURATION)
                .setInterpolator(new AccelerateInterpolator(5f))
                .withEndAction(() -> {mRocket.setTranslationY(0);})
                .start();
    }

    @Override
    protected String getDisplayMessage() {
        return "View.animate() ... ViewPropertyAnimator";
    }
}