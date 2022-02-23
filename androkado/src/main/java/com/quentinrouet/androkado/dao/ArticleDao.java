package com.quentinrouet.androkado.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.quentinrouet.androkado.activity.ConfigurationActivity;
import com.quentinrouet.androkado.bo.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin for Constraint Layout on 21/02/2022.
 */
public class ArticleDao {
   private SQLiteDatabase db;

   public ArticleDao(Context context) {
      db = new BddHelper(context).getWritableDatabase();
   }
   public long insert(Article article) {
      ContentValues values = new ContentValues();
      values.put(ArticleContract.COL_NOM,article.getNom());
      values.put(ArticleContract.COL_DESCRIPTION,article.getDescription());
      values.put(ArticleContract.COL_URL,article.getUrl());
      values.put(ArticleContract.COL_DEGRE_ENVIE,article.getDegreEnvie());
      values.put(ArticleContract.COL_PRIX,article.getPrix());
      values.put(ArticleContract.COL_IS_ACHETE,article.isAchete());
      return db.insert(ArticleContract.TABLE_NAME,null,values);
   }


   public Article get(long id) {
      Article article = null;
      Cursor cursor = db.query( ArticleContract.TABLE_NAME,
              new String[]{
                      ArticleContract.COL_ID,
                      ArticleContract.COL_NOM,
                      ArticleContract.COL_IS_ACHETE,
                      ArticleContract.COL_PRIX,
                      ArticleContract.COL_DESCRIPTION,
                      ArticleContract.COL_DEGRE_ENVIE,
                      ArticleContract.COL_URL,
              }, ArticleContract.COL_ID + " =?",
              idToStringA(id), null,
              null,
              null);
      if(cursor.moveToNext()) {
         article = new Article();
         article.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ArticleContract.COL_ID.trim())));
         article.setNom(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_NOM.trim())));
         article.setAchete(cursor.getInt(cursor.getColumnIndexOrThrow(ArticleContract.COL_IS_ACHETE.trim()))>0);
         article.setPrix(cursor.getFloat(cursor.getColumnIndexOrThrow(ArticleContract.COL_PRIX.trim())));
         article.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_DESCRIPTION.trim())));
         article.setDegreEnvie(cursor.getDouble(cursor.getColumnIndexOrThrow(ArticleContract.COL_DEGRE_ENVIE.trim())));
         article.setUrl(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_URL.trim())));
      }
      return article;
   }
   public List<Article> get(Context context) {
      boolean isSortPrice =
              context.getSharedPreferences(ConfigurationActivity.CONFIG_ARTICLES, Context.MODE_PRIVATE)
                      .getBoolean(ConfigurationActivity.SORT_PRICE,false);
      List<Article> resultat = new ArrayList<>();
      Cursor cursor = db.query( ArticleContract.TABLE_NAME,
              new String[]{
                      ArticleContract.COL_ID,
                      ArticleContract.COL_NOM,
                      ArticleContract.COL_IS_ACHETE,
                      ArticleContract.COL_PRIX,
                      ArticleContract.COL_DESCRIPTION,
                      ArticleContract.COL_DEGRE_ENVIE,
                      ArticleContract.COL_URL,
              }, null,
              null, null, null,
              isSortPrice ? ArticleContract.COL_PRIX : null);
      while(cursor.moveToNext()) {
         Article article = new Article();
         article.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ArticleContract.COL_ID)));
         article.setNom(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_NOM)));
         article.setAchete(cursor.getInt(cursor.getColumnIndexOrThrow(ArticleContract.COL_IS_ACHETE))>0);
         article.setPrix(cursor.getFloat(cursor.getColumnIndexOrThrow(ArticleContract.COL_PRIX)));
         article.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_DESCRIPTION)));
         article.setDegreEnvie(cursor.getDouble(cursor.getColumnIndexOrThrow(ArticleContract.COL_DEGRE_ENVIE)));
         article.setUrl(cursor.getString(cursor.getColumnIndexOrThrow(ArticleContract.COL_URL)));
         resultat.add(article);
      }
      return resultat;
   }

   public boolean update(Article Article) {
      Log.i("ACOS","Entrée dans update avec " + Article.toString());
      ContentValues cv = new ContentValues();
      cv.put(ArticleContract.COL_NOM, Article.getNom());
      cv.put(ArticleContract.COL_IS_ACHETE, Article.isAchete());
      cv.put(ArticleContract.COL_PRIX, Article.getPrix());
      cv.put(ArticleContract.COL_DESCRIPTION, Article.getDescription());
      cv.put(ArticleContract.COL_DEGRE_ENVIE, Article.getDegreEnvie());
      cv.put(ArticleContract.COL_URL, Article.getUrl());

      return db.update(ArticleContract.TABLE_NAME,cv,ArticleContract.COL_ID + "=?",idToStringA(Article.getId()))>0;
   }
   public boolean delete(Article Article) {
      return db.delete(ArticleContract.TABLE_NAME,ArticleContract.COL_ID + " =?",idToStringA(Article.getId()))>0;
   }

   private String[] idToStringA(long id){
      return new String[]{String.valueOf(id)};
   }
      
}
