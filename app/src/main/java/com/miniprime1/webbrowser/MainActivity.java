package com.miniprime1.webbrowser;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.view.*;

import com.miniprime1.webbrowser.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.webview.loadUrl("https://www.google.com");
        activityMainBinding.webview.getSettings().setJavaScriptEnabled(true);
        activityMainBinding.webview.setWebChromeClient(new WebChromeClient());
        activityMainBinding.webview.setWebViewClient(new WebViewClientClass());
    }

    class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void goButtonClick(View view) {
        String uri = activityMainBinding.uriTextEdit.getText().toString();
        activityMainBinding.webview.loadUrl(uri);

    }

    public void backButtonClick(View view) {
        if (activityMainBinding.webview.canGoBack()) {
            activityMainBinding.webview.goBack();
        }
    }

    public void fowardButtonClick(View view) {
        if (activityMainBinding.webview.canGoForward()) {
            activityMainBinding.webview.goForward();
        }
    }
}