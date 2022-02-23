package com.quentinrouet.androkado.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.quentinrouet.androkado.R;

public class ConfigurationActivity extends AppCompatActivity {
    public static final String CONFIG_ARTICLES = "configArticles";
    public static final String SORT_PRICE = "sortPrice";
    public static final String DEF_PRICE = "defPrice";
    private SharedPreferences sp;
    SwitchCompat switchSortPrice;
    EditText editTextDefPrice;
    Button buttonSaveSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        switchSortPrice = findViewById(R.id.switchSortPrice);
        editTextDefPrice = findViewById(R.id.editTextDefPrice);
        buttonSaveSP = findViewById(R.id.buttonSavePref);

        setValuesFromSp();
        saveSP();
    }

    private void setValuesFromSp(){
        //TODO Set les valeurs des SharedPref
        sp = getSharedPreferences(CONFIG_ARTICLES,MODE_PRIVATE);
        boolean isSortedPrice = sp.getBoolean(SORT_PRICE,false);
        float defPrice = sp.getFloat(DEF_PRICE,42.0f);
        switchSortPrice.setChecked(isSortedPrice);
        editTextDefPrice.setText(String.valueOf(defPrice));
    }
    private void saveSP(){
        //TODO Sauvegarde SP
        buttonSaveSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.edit().putBoolean(SORT_PRICE,switchSortPrice.isChecked())
                        .putFloat(DEF_PRICE,Float.parseFloat(editTextDefPrice.getText().toString()))
                        .apply();
            }
        });
    }
}