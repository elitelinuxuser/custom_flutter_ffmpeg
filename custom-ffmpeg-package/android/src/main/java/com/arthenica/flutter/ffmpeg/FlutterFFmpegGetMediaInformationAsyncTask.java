package com.arthenica.flutter.ffmpeg;

import android.os.AsyncTask;
import android.util.Log;

import com.arthenica.mobileffmpeg.FFprobe;
import com.arthenica.mobileffmpeg.MediaInformation;

import io.flutter.plugin.common.MethodChannel;

/**
 * Asynchronous task which performs {@link FFprobe#getMediaInformation(String, Long)} method invocations.
 *
 * @author Ramanand Sirvi
 */
public class FlutterFFmpegGetMediaInformationAsyncTask extends AsyncTask<String, Integer, MediaInformation> {

    private final String path;
    private final MethodChannel.Result result;
    private final FlutterFFmpegResultHandler flutterFFmpegResultHandler;

    FlutterFFmpegGetMediaInformationAsyncTask(final String path, final FlutterFFmpegResultHandler flutterFFmpegResultHandler, final MethodChannel.Result result) {
        this.path = path;
        this.result = result;
        this.flutterFFmpegResultHandler = flutterFFmpegResultHandler;
    }

    @Override
    protected MediaInformation doInBackground(final String... unusedArgs) {
        Log.d(FlutterFFmpegPlugin.LIBRARY_NAME, String.format("Getting media information for %s.", path));
        return FFprobe.getMediaInformation(path);
    }

    @Override
    protected void onPostExecute(final MediaInformation mediaInformation) {
        flutterFFmpegResultHandler.success(result, FlutterFFmpegPlugin.toMediaInformationMap(mediaInformation));
    }

}
