package com.example.bulbulhossen.dse_project.Fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.bulbulhossen.dse_project.R;

/**
 * Created by Md.Bulbul Hossen on 11/12/15.
 */
public class Home_Web_update_Fragment extends Fragment {


    private WebView mWebView;
    ProgressBar progressBar;

    public Home_Web_update_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.web_update_fragment, container, false);


        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar1);
        mWebView = (WebView) rootView.findViewById(R.id.webView);
        mWebView.setWebViewClient(new myWebClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://www.stockbangladesh.mobi/index-normal.php");
        return rootView;

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

    // To handle "Back" key press event for WebView to go back to previous screen
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}