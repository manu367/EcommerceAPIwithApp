package com.example.ecommerceapp.fragement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.adapter.VideoAdapter;
import com.example.ecommerceapp.model.VideoModel;

import java.util.ArrayList;
import java.util.List;


public class ReelFragment extends Fragment {

    private View view;
    private ViewPager2 viewPager;
    private VideoAdapter adapter;
    private List<VideoModel> videoList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_reel, container, false);
        viewPager = view.findViewById(R.id.viewPagerVideos);
        viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        videoList = getSampleVideos();
        adapter = new VideoAdapter(videoList, requireContext());
        viewPager.setAdapter(adapter);
        // autoplay logic: when page selected, play it; pause previous
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            int prevPosition = -1;
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (prevPosition != -1) adapter.pauseAt(prevPosition);
                adapter.playAt(position);
                prevPosition = position;
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // play current page
        int pos = viewPager.getCurrentItem();
        adapter.playAt(pos);
    }

    @Override
    public void onPause() {
        super.onPause();
        adapter.pauseAll();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter.releaseAll();
    }

    // sample video list (replace with your URLs)
    @NonNull
    private List<VideoModel> getSampleVideos() {
        List<VideoModel> list = new ArrayList<>();
        // public sample videos for testing
        list.add(new VideoModel(
                "https://manu367.github.io/video/Video-282.mp4",
                "@bigbunny",
                "Big Buck Bunny - sample video",
                ""
        ));
        list.add(new VideoModel(
                "https://manu367.github.io/video/Video-462.mp4",
                "@joyrides",
                "For Bigger Joyrides",
                ""
        ));
        list.add(new VideoModel(
                "https://manu367.github.io/video/Video-583.mp4",
                "@elephant",
                "Elephants Dream - sample",
                ""
        ));

        list.add(new VideoModel(
                "https://manu367.github.io/video/Video-936.mp4",
                "@elephant",
                "Elephants Dream - sample",
                ""
        ));
        return list;
    }
}