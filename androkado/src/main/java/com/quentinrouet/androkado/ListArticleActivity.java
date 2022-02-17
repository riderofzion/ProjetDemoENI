package com.quentinrouet.androkado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        Article articleTest1 = new Article("Pain au chocolat",
                "Viennoiserie au chocolat",
                "https://wikipedia.org/wiki/Pain_au_chocolat",
                1.1f,
                4.0,
                true
        );
        Article articleTest2 = new Article("Croissant",
                "Viennoiserie sans chocolat",
                "https://wikipedia.org/wiki/Croissant",
                1.1f,
                5.0,
                true
        );
        Article articleTest3 = new Article("Baguette de pain",
                "Essentiel",
                "https://wikipedia.org/wiki/Pain",
                0.9f,
                3.0,
                false
        );
        ArrayList<Article> al = new ArrayList<Article>();
        al.add(articleTest1);
        al.add(articleTest2);
        al.add(articleTest3);
        ArticleAdapter adapter = new ArticleAdapter(al);
        //TODO J'affecte mon adapter à ma RecyclerView
        rvArticles.setAdapter(adapter);
    }
}