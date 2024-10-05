package com.example.tablayoutexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Tab1Fragment extends Fragment {

    RecyclerView recyclerView;
    WebView webView;
    ProgressBar progressBar;
    ImageAdapter imageAdapter;

    int[] images = {R.drawable.cover1, R.drawable.cover2, R.drawable.cover3, R.drawable.cover4, R.drawable.cover5, R.drawable.cover6, R.drawable.cover7, R.drawable.cover8};
    String[] judulBuku = {"Manajemen Risiko Bisnis", "50 Teknik Praktis Manajemen Perusahaan", "Analisis Sumber Daya Manusia dan Statistik", "Analisis Kapasitas, Persediaan dan Pemasok", "Biologi Molekuler", "Manajemen Obesitas", "Asuhan Keperawatan Keluarga Dengan Pendekatan Studi Kasus", "Bioteknologi Kesehatan"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        imageAdapter = new ImageAdapter(getContext(), images, judulBuku);
        recyclerView.setAdapter(imageAdapter);

        webView = view.findViewById(R.id.webview);
        progressBar = view.findViewById(R.id.progressBar);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }
        });

        webView.loadUrl("https://www.google.com");

        return view;
    }
}
