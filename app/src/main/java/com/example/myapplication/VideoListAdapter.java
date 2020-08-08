package com.example.myapplication;

import android.content.Context;
import android.os.Environment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.ui.videos.VideosFragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoListAdapter extends ArrayAdapter<Video> {

    private static final String TAG = "VideoListAdapter";
    private Context mContext;
    int mResource;
    public VideoListAdapter(Context context, int resource, ArrayList<Video> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String link = getItem(position).getVideoLink();
        String name = getItem(position).getVideoName();

//        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        File[] files = dir.listFiles();
//        String[] filesName = new String[files.length];
//        for (int i = 0 ; i < files.length ; i++){
//            filesName[i] = files[i].getName();
//        }

        Video video = new Video(link, name);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.lblVideoName);
//        TextView tvCreature = (TextView) convertView.findViewById(R.id.lblCreatureName);
//        TextView tvLength = (TextView) convertView.findViewById(R.id.lblVideoLength);

        tvName.setText(name);
//        tvLength.setText(length);
//        tvNumber.setText(number);
//        tvCreature.setText(creatureName);

        return convertView;
    }
}
