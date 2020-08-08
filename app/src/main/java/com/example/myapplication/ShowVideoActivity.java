package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class ShowVideoActivity extends AppCompatActivity {

    VideoView videoViewShow;
    String videoPath = "";
    File dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);

        videoViewShow = findViewById(R.id.videoViewShow);
        videoPath = getIntent().getStringExtra("VideoPath");
        videoViewShow.setVideoPath(videoPath);
        MediaController controller = new MediaController(this);
        controller.setAnchorView(videoViewShow);
        videoViewShow.setMediaController(controller);
//        videoViewShow.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.pogba);
//        MediaController videoController = new MediaController(this);
//        videoController.setAnchorView(videoViewShow);
//        videoViewShow.setMediaController(videoController);

    }

//    public void showVideos(VideoView videoView, String videoPath){
//        dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        File[] filesArray = dir.listFiles();
//
////        videoView.setVideoPath(videoPath+videoID);
////        MediaController videoController = new MediaController(this);
////        videoController.setAnchorView(videoView);
////        videoView.setMediaController(videoController);
//    }
}