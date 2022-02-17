package com.quentinrouet.androkado;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.quentinrouet.androkado.databinding.RowLayoutArticleBinding;

import java.util.ArrayList;

/**
 * Created by quentin for Constraint Layout on 17/02/2022.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
   public static final String KEY_ARTICLE = "KEY_ARTICLE";
   ArrayList<Article> dataSetArticles;

   public ArticleAdapter(ArrayList<Article> dataSetArticles) {
      this.dataSetArticles = dataSetArticles;
   }

   @NonNull
   @Override
   public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      RowLayoutArticleBinding binding = DataBindingUtil.inflate(
              LayoutInflater.from(parent.getContext()),
              R.layout.row_layout_article,
              parent,
              false
      );
      return new ArticleViewHolder(binding);
   }

   @Override
   public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
      Article article = dataSetArticles.get(position);
      holder.binding.setArticle(article);
      //Je passe l'article clické à mon DetailActivity
      holder.itemView.setOnClickListener((View view) -> {
            Intent intentToDetail = new Intent(view.getContext(),DetailActivity.class);
            intentToDetail.putExtra(KEY_ARTICLE,article);
            view.getContext().startActivity(intentToDetail);
      });
   }

   @Override
   public int getItemCount() {
      return dataSetArticles.size();
   }
}
