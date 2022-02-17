package com.quentinrouet.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.quentinrouet.androkado.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {


    public static final String KEY_ARTICLE = "keyArticle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDetailBinding activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());


        Article articleTest = getIntent().getParcelableExtra(ArticleAdapter.KEY_ARTICLE);
        activityDetailBinding.imageButtonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, articleTest.getUrl(), Toast.LENGTH_SHORT).show();
                Intent intentToInfoUrl = new Intent(DetailActivity.this, InfoUrlActivity.class);
                intentToInfoUrl.putExtra(KEY_ARTICLE, articleTest);
                startActivity(intentToInfoUrl);
            }
        });
        activityDetailBinding.setArticle(articleTest);
    }
}