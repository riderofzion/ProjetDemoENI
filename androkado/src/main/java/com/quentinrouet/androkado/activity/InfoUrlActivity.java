package com.quentinrouet.androkado.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.quentinrouet.androkado.bo.Article;
import com.quentinrouet.androkado.R;

public class InfoUrlActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);
        //ONVIEWCREATED

        //TODO Récupérer l'article
        Article articleClicked = getIntent().getParcelableExtra(DetailActivity.KEY_ARTICLE);
        //TODO afficher l'url dans une textview
        //TextView tv = findViewById(R.id.textViewUrl);
        webView = findViewById(R.id.webViewUrl);
        //tv.setText(articleClicked.getUrl());
        webView.loadUrl(articleClicked.getUrl());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}