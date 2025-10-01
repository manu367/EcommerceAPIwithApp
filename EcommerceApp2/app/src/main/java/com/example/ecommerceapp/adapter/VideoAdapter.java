package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.model.VideoModel;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<VideoModel> videos;
    private Context context;
    // track attached holders by adapter position
    private SparseArrayCompat<VideoViewHolder> attachedHolders = new SparseArrayCompat<>();

    public VideoAdapter(List<VideoModel> videos, Context context) {
        this.videos = videos;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.bind(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull VideoViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        int pos = holder.getAdapterPosition();
        if (pos != RecyclerView.NO_POSITION) attachedHolders.put(pos, holder);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull VideoViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        int pos = holder.getAdapterPosition();
        if (pos != RecyclerView.NO_POSITION) {
            holder.pausePlayer();
            attachedHolders.remove(pos);
            // release to free resources if you want; we release in onViewRecycled too
            holder.releasePlayer();
        }
    }

    @Override
    public void onViewRecycled(@NonNull VideoViewHolder holder) {
        super.onViewRecycled(holder);
        holder.releasePlayer();
    }

    // control players
    public void playAt(int position) {
        VideoViewHolder holder = attachedHolders.get(position);
        if (holder != null) holder.playPlayer();
    }

    public void pauseAt(int position) {
        VideoViewHolder holder = attachedHolders.get(position);
        if (holder != null) holder.pausePlayer();
    }

    public void pauseAll() {
        for (int i = 0; i < attachedHolders.size(); i++) {
            attachedHolders.valueAt(i).pausePlayer();
        }
    }

    public void releaseAll() {
        for (int i = 0; i < attachedHolders.size(); i++) {
            attachedHolders.valueAt(i).releasePlayer();
        }
        attachedHolders.clear();
    }

    // ViewHolder
    public class VideoViewHolder extends RecyclerView.ViewHolder {
        PlayerView playerView;
        ExoPlayer exoPlayer;
        ImageView btnLike, btnComment, btnShare;
        TextView tvUsername, tvDescription;
        String videoUrl;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            playerView = itemView.findViewById(R.id.videoPlayerView);
            btnLike = itemView.findViewById(R.id.btnLike);
            btnComment = itemView.findViewById(R.id.btnComment);
            btnShare = itemView.findViewById(R.id.btnShare);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        public void bind(VideoModel model) {
            videoUrl = model.getVideoUrl();
            tvUsername.setText(model.getUsername());
            tvDescription.setText(model.getDescription());

            // prepare player but do not autoplay automatically here
            preparePlayer();
        }

        private void preparePlayer() {
            if (exoPlayer == null) {
                exoPlayer = new ExoPlayer.Builder(context).build();
                playerView.setPlayer(exoPlayer);
                exoPlayer.setRepeatMode(com.google.android.exoplayer2.Player.REPEAT_MODE_ONE);
            }
            MediaItem item = MediaItem.fromUri(videoUrl);
            exoPlayer.setMediaItem(item);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(false);
        }

        public void playPlayer() {
            if (exoPlayer == null) preparePlayer();
            exoPlayer.setPlayWhenReady(true);
        }

        public void pausePlayer() {
            if (exoPlayer != null) exoPlayer.setPlayWhenReady(false);
        }

        public void releasePlayer() {
            if (exoPlayer != null) {
                exoPlayer.release();
                exoPlayer = null;
                playerView.setPlayer(null);
            }
        }
    }
}

