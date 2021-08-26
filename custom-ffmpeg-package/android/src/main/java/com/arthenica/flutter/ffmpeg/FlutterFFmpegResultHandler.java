package com.arthenica.flutter.ffmpeg;

import android.os.Handler;
import android.os.Looper;

import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;

/**
 * <h3>Flutter FFmpeg Result Handler</h3>
 *
 * @author Ramanand Sirvi
 */
class FlutterFFmpegResultHandler {
    private final Handler handler;

    FlutterFFmpegResultHandler() {
        handler = new Handler(Looper.getMainLooper());
    }

    void notImplemented(final MethodChannel.Result result) {
        handler.post(new Runnable() {

            @Override
            public void run() {
                if (result != null) {
                    result.notImplemented();
                }
            }
        });
    }

    void success(final MethodChannel.Result result, final Object object) {
        handler.post(new Runnable() {

            @Override
            public void run() {
                if (result != null) {
                    result.success(object);
                }
            }
        });
    }

    void success(final EventChannel.EventSink eventSink, final Object object) {
        handler.post(new Runnable() {

            @Override
            public void run() {
                if (eventSink != null) {
                    eventSink.success(object);
                }
            }
        });
    }

}
