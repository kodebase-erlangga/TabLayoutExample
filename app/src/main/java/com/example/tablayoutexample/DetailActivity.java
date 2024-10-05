package com.example.tablayoutexample;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Ambil data yang dikirim melalui Intent
        String judul = getIntent().getStringExtra("judul");
        int jumlahKlik = getIntent().getIntExtra("jumlahKlik", 0);

        // Tampilkan data di TextView
        TextView textViewJudul = findViewById(R.id.textViewJudul);
        TextView textViewJumlahKlik = findViewById(R.id.textViewJumlahKlik);

        textViewJudul.setText(judul);
        textViewJumlahKlik.setText("Jumlah klik: " + jumlahKlik);

        // Inisialisasi WebView dan ProgressBar
        webView = findViewById(R.id.webview);  // Perbaiki di sini: ganti view dengan this
        progressBar = findViewById(R.id.progressBar);

        // Mengatur pengaturan WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Mengaktifkan JavaScript

        // Mengatur listener untuk memuat URL dan menampilkan progress
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE); // Sembunyikan progress bar
            }
        });

        // Memuat halaman
        webView.loadUrl("https://www.erlanggaonline.com/");
    }
}