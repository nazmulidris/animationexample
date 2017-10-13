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

public class RocketAnimationItem {
  private final String mTitle;
  private final Intent mIntent;

  public RocketAnimationItem(String title, android.content.Intent intent) {
    mTitle = title;
    mIntent = intent;
  }

  public android.content.Intent getIntent() {
    return mIntent;
  }

  public String getTitle() {
    return mTitle;
  }
}
