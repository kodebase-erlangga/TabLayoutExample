package com.example.tablayoutexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;
    private int[] images;
    private String[] judulBuku;
    private int[] clickCount;

    // Constructor
    public ImageAdapter(Context context, int[] images, String[] judulBuku) {
        this.context = context;
        this.images = images;
        this.judulBuku = judulBuku;
        this.clickCount = new int[judulBuku.length]; // Array untuk menghitung klik setiap item
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]); // Set image resource

        holder.itemView.setOnClickListener(v -> {
            clickCount[position]++;
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("judul", judulBuku[position]);
            intent.putExtra("jumlahKlik", clickCount[position]);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
