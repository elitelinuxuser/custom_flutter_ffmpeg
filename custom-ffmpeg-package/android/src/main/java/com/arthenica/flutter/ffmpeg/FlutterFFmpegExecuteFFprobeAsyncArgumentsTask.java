package com.arthenica.flutter.ffmpeg;

import android.os.AsyncTask;
import android.util.Log;

import com.arthenica.mobileffmpeg.FFprobe;

import java.util.Arrays;
import java.util.List;

import io.flutter.plugin.common.MethodChannel;

/**
 * Asynchronous task which performs {@link FFprobe#execute(String[])} method invocations.
 *
 * @author Ramanand Sirvi
 */
public class FlutterFFmpegExecuteFFprobeAsyncArgumentsTask extends AsyncTask<String, Integer, Integer> {

    private final MethodChannel.Result result;
    private final List<String> arguments;
    private final FlutterFFmpegResultHandler flutterFFmpegResultHandler;

    FlutterFFmpegExecuteFFprobeAsyncArgumentsTask(final List<String> arguments, final FlutterFFmpegResultHandler flutterFFmpegResultHandler, final MethodChannel.Result result) {
        this.arguments = arguments;
        this.result = result;
        this.flutterFFmpegResultHandler = flutterFFmpegResultHandler;
    }

    @Override
    protected Integer doInBackground(final String... unusedArgs) {
        final String[] argumentsArray = arguments.toArray(new String[0]);

        Log.d(FlutterFFmpegPlugin.LIBRARY_NAME, String.format("Running FFprobe with arguments: %s.", Arrays.toString(argumentsArray)));

        int rc = FFprobe.execute(argumentsArray);

        Log.d(FlutterFFmpegPlugin.LIBRARY_NAME, String.format("FFprobe exited with rc: %d", rc));

        return rc;
    }

    @Override
    protected void onPostExecute(final Integer rc) {
        flutterFFmpegResultHandler.success(result, FlutterFFmpegPlugin.toIntMap(FlutterFFmpegPlugin.KEY_RC, rc));
    }

}
