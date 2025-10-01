package com.example.ecommerceapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;

import java.util.List;

public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.ViewHolder> {

    private List<String> historyList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemRemove(String item);
        void onItemClick(String item);
    }

    public SearchHistoryAdapter(List<String> list, OnItemClickListener listener) {
        this.historyList = list;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = historyList.get(position);
        holder.tvHistory.setText(item);

        holder.btnRemove.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemRemove(item);
            }
        });

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHistory;
        ImageView btnRemove;

        public ViewHolder(View itemView) {
            super(itemView);
            tvHistory = itemView.findViewById(R.id.tvHistoryItem);
            btnRemove = itemView.findViewById(R.id.btnRemoveHistory);
        }
    }
}
