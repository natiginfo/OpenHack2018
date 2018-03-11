package com.koonat.hackforhumanity;

/**
 * Created by Natig on 3/10/18.
 */

import android.Manifest;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.koonat.hackforhumanity.audio.AudioPlayer;
import com.koonat.hackforhumanity.audio.AudioRecorder;
import com.koonat.hackforhumanity.audio.internal.AudioPlayerImpl;
import com.koonat.hackforhumanity.audio.internal.AudioRecorderImpl;
import com.koonat.hackforhumanity.common.base.BaseActivity;
import com.koonat.hackforhumanity.topics.Topic;
import com.koonat.hackforhumanity.topics.TopicsAdapter;

import org.jetbrains.annotations.NotNull;

public class RecordActivity extends BaseActivity {
    private static final String TAG = "RecordActivity";
    private static final String LOG_TAG = "AudioRecordTest";
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;

    private RecordButton mRecordButton = null;

    private PlayButton mPlayButton = null;

    private AudioPlayer audioPlayer;
    private AudioRecorder audioRecorder;

    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
    private String[] permissions = {Manifest.permission.RECORD_AUDIO};
    private String fileName;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted) finish();

    }

    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    private void startPlaying() {
        audioPlayer.startPlaying(fileName);
    }

    private void stopPlaying() {
        audioPlayer.stopPlaying();
    }

    private void startRecording() {
        String fileName = audioRecorder.startRecording();
        Log.d(TAG, "startRecording: " + fileName);
        this.fileName = fileName;
    }

    private void stopRecording() {
        audioRecorder.stopRecording();
    }

    class RecordButton extends Button {
        boolean mStartRecording = true;

        OnClickListener clicker = v -> {
            onRecord(mStartRecording);
            if (mStartRecording) {
                setText("Stop recording");
            } else {
                setText("Start recording");
            }
            mStartRecording = !mStartRecording;
        };

        public RecordButton(Context ctx) {
            super(ctx);
            setText("Start recording");
            setOnClickListener(clicker);
        }
    }

    class PlayButton extends Button {
        boolean mStartPlaying = true;

        OnClickListener clicker = v -> {
            onPlay(mStartPlaying);
            if (mStartPlaying) {
                setText("Stop playing");
            } else {
                setText("Start playing");
            }
            mStartPlaying = !mStartPlaying;
        };

        public PlayButton(Context ctx) {
            super(ctx);
            setText("Start playing");
            setOnClickListener(clicker);
        }
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        audioPlayer = new AudioPlayerImpl();
        audioRecorder = new AudioRecorderImpl(getApplicationContext());

        getLifecycle().addObserver((LifecycleObserver) audioPlayer);
        getLifecycle().addObserver((LifecycleObserver) audioRecorder);

        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);

        LinearLayout ll = new LinearLayout(this);
        mRecordButton = new RecordButton(this);
        ll.addView(mRecordButton,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        0));
        mPlayButton = new PlayButton(this);
        ll.addView(mPlayButton,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        0));
        setContentView(ll);
    }
}
