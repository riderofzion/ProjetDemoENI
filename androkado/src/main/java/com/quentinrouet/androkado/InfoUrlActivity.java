package com.quentinrouet.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);
        //ONVIEWCREATED

        //TODO Récupérer l'article
        Article articleClicked = getIntent().getParcelableExtra(DetailActivity.KEY_ARTICLE);
        //TODO afficher l'url dans une textview
        TextView tv = findViewById(R.id.textViewUrl);
        tv.setText(articleClicked.getUrl());
    }
}