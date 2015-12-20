package com.example.bulbulhossen.dse_project.Fragment;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.bulbulhossen.dse_project.R;

public class Market_Statistics extends AppCompatActivity {

    private WebView mWebView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market__statistics);


        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.setWebViewClient(new myWebClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://m.dsemonitor.com/index.php");
        return;

    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }



    }

    }

