package com.quentinrouet.androkado.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.quentinrouet.androkado.bo.Article;
import com.quentinrouet.androkado.adapter.ArticleAdapter;
import com.quentinrouet.androkado.R;
import com.quentinrouet.androkado.dao.ArticleDao;

import java.util.ArrayList;

public class ListArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_article);

        //TODO Je récupère mon RecyclerView
        RecyclerView rvArticles = findViewById(R.id.recyclerViewArticles);
        //TODO Je donne l'instruction d'affichage à mon RecyclerView (comment j'affiche)
        //TODO (LinearLayout Vertical)
        rvArticles.setLayoutManager(new LinearLayoutManager(this));
        //TODO Je créé mon adapter

        ArticleAdapter adapter = new ArticleAdapter((ArrayList<Article>) new ArticleDao(this).get(this));
        //TODO J'affecte mon adapter à ma RecyclerView
        rvArticles.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itemConfiguration)
            startActivity(new Intent(this,ConfigurationActivity.class));
        return super.onOptionsItemSelected(item);
    }
}