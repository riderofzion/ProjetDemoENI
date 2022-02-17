package com.quentinrouet.androkado;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quentinrouet.androkado.databinding.RowLayoutArticleBinding;

/**
 * Created by quentin for Constraint Layout on 17/02/2022.
 */
class ArticleViewHolder  extends RecyclerView.ViewHolder {
    RowLayoutArticleBinding binding;

    public ArticleViewHolder(RowLayoutArticleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
