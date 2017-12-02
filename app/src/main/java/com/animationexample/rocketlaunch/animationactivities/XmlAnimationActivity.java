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
import android.animation.AnimatorSet;
import android.support.graphics.drawable.AnimatorInflaterCompat;

import com.animationexample.rocketlaunch.R;

public class XmlAnimationActivity extends BaseAnimationActivity {
    @Override
    protected void onStartAnimation() {
        Animator rocketAnimatorSet =
                AnimatorInflaterCompat.loadAnimator(this, R.animator.jump_and_blink);
        rocketAnimatorSet.setTarget(mRocket);

        Animator dogeAnimatorSet =
                AnimatorInflaterCompat.loadAnimator(this, R.animator.jump_and_blink);
        dogeAnimatorSet.setTarget(mDoge);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rocketAnimatorSet, dogeAnimatorSet);
        animatorSet.setDuration(DEFAULT_ANIMATION_DURATION);
        animatorSet.start();
    }

    @Override
    protected String getDisplayMessage() {
        return "Using XML animations";
    }
}
