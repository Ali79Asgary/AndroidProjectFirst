package com.example.myapplication.ui.videos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ShowVideoActivity;
import com.example.myapplication.Video;
import com.example.myapplication.VideoListAdapter;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class VideosFragment extends Fragment {

    private VideosViewModel videosViewModel;
    File dir;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        videosViewModel = ViewModelProviders.of(this).get(VideosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_videos, container, false);
//        final TextView textView = root.findViewById(R.id.text_videos);
//        videosViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        final ListView videoListView = (ListView) root.findViewById(R.id.videosListView);

//        dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        ArrayList<Video> videosList = genVideos();
//        for (int j = 0 ; j < files.length ; j++){
//            videosList.add(filesName[j]);
//        }
        VideoListAdapter adapter = new VideoListAdapter(this.getActivity(), R.layout.videos_view_layout, videosList);
        videoListView.setAdapter(adapter);
        videoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(videoListView.getContext(), ShowVideoActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }



    private ArrayList<Video> genVideos() {
        ArrayList<Video> videos = new ArrayList<Video>();

        Video v1 = new Video("http://dl.pop-music.ir/music/1399/Ordibehesht/Puzzle%20Band%20-%20Dametam%20Garm%20(Live%20Version).mp3","Dametam Garm");
//        File[] files = dir.listFiles();
//        String[] filesName = new String[files.length];
//        for (int i = 0 ; i < files.length ; i++){
//            filesName[i] = files[i].getName();
//        }

        videos.add(v1);
        


        return videos;
    }

}