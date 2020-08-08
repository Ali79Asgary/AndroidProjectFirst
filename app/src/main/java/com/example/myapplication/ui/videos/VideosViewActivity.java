package com.example.myapplication.ui.videos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.ShowVideoActivity;

import java.io.File;

public class VideosViewActivity extends AppCompatActivity {

    private static final int PERMISSION_STORAGE_CODE = 1000;
    String videoUrl = "http://dl.pop-music.ir/music/1399/Ordibehesht/Puzzle%20Band%20-%20Dametam%20Garm%20(Live%20Version).mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_view_layout);
    }

    public void showVideoButton(View view) {
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File[] files = dir.listFiles();
        Intent intent = new Intent(VideosViewActivity.this, ShowVideoActivity.class);
        intent.putExtra("VideoPath",files[0].getAbsolutePath());
        startActivity(intent);
    }

    public void downloadVideoButton(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                String[] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permission,PERMISSION_STORAGE_CODE);
            } else {
                startDownloading(videoUrl);
            }
        } else {
            startDownloading(videoUrl);
        }
    }

    public void startDownloading(String url){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Video");
        request.setDescription("Video Downloading!");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS , ""+System.currentTimeMillis());
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_STORAGE_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startDownloading(videoUrl);
                } else {
                    Toast.makeText(this, "Permission Denied...!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}