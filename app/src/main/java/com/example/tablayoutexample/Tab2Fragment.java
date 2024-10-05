package com.example.tablayoutexample;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab2Fragment extends Fragment {

    RecyclerView recyclerView;
    int[] images = {R.drawable.cover5, R.drawable.cover6, R.drawable.cover7, R.drawable.cover8};

    // Array judul buku
    String[] judulBuku = {
            "Biologi Molekuler",
            "Manajemen Obesitas",
            "Asuhan Keperawatan Keluarga Dengan Pendekatan Studi Kasus",
            "Bioteknologi Kesehatan"
    };

    public Tab2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2fragment, container, false); // pastikan ini sesuai

        // Setup RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView); // Pastikan ID ini sesuai
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4)); // Set grid layout dengan 2 kolom

        // Buat instance ImageAdapter
        ImageAdapter imageAdapter = new ImageAdapter(getContext(), images, judulBuku);
        recyclerView.setAdapter(imageAdapter);

        return view;
    }
}
