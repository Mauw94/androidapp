package com.example.maurits.universo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.maurits.universo.R;

public class TweetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);

        String url = "https://twitter.com/intent/tweet?text=I+learned+so+much+about+the+univers+with+Universo+check+out+the+app+right+now+!!!";
        WebView view =(WebView) this.findViewById(R.id.twitter_webview);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
    }
}
