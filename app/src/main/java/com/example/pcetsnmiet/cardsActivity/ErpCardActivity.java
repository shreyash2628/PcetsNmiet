package com.example.pcetsnmiet.cardsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.pcetsnmiet.R;

public class ErpCardActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erp_card);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        webView = findViewById(R.id.erp_web);

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://pceterp.com/oraerp/nmiet/student2020.html");
//        webView.setWebViewClient(new WebViewClient());


    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
        {
            webView.goBack();
        }else{
            super.onBackPressed();

        }
    }
}