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

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.provider.FontRequest;
import android.support.v4.provider.FontsContractCompat;

/** More info https://developers.google.com/fonts/docs/android */
public class FontDownloader {

    private final DownloadTarget mTarget;
    private final Context mContext;
    private Handler mHandler;

    public FontDownloader(Context context, DownloadTarget target) {
        mTarget = target;
        mContext = context;
        initializeFonts();
    }

    private void initializeFonts() {
        // https://developers.google.com/fonts/docs/android
        String query = "name=Open Sans&weight=800&italic=0";

        FontRequest request =
                new FontRequest(
                        "com.google.android.gms.fonts",
                        "com.google.android.gms",
                        query,
                        R.array.com_google_android_gms_fonts_certs);

        FontsContractCompat.FontRequestCallback callback =
                new FontsContractCompat.FontRequestCallback() {
                    @Override
                    public void onTypefaceRetrieved(Typeface typeface) {
                        mTarget.applyFont(typeface);
                    }
                };

        FontsContractCompat.requestFont(mContext, request, callback, getHandlerThreadHandler());
    }

    private Handler getHandlerThreadHandler() {
        if (mHandler == null) {
            HandlerThread handlerThread = new HandlerThread("fonts");
            handlerThread.start();
            mHandler = new Handler(handlerThread.getLooper());
        }
        return mHandler;
    }

    public interface DownloadTarget {
        public void applyFont(Typeface typeface);
    }
}
