package com.quentinrouet.androkado.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by quentin for Constraint Layout on 21/02/2022.
 */
public class BddHelper extends SQLiteOpenHelper {
   private final static int VERSION = 2;
   private final static String BDD_NAME = "androkado.db";
   private final static String TAG = "BddHelper";

   public BddHelper(Context context) {
      super(context, BDD_NAME, null, VERSION); }
   @Override
   public void onCreate(SQLiteDatabase sqLiteDatabase) {
      Log.i(TAG,"Passage dans le onCreate");
      sqLiteDatabase.execSQL(ArticleContract.CREATE_TABLE);
   }
   @Override
   public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      Log.i(TAG,"Passage dans le onUpgrade"); sqLiteDatabase.execSQL(ArticleContract.DROP_TABLE);
      onCreate(sqLiteDatabase);
   }
}
