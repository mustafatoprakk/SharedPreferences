package com.mustafatoprak.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

        TextView name_tv, profession_tv;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);

            name_tv = findViewById(R.id.nameTv);
            profession_tv = findViewById(R.id.professionTv);
        }

        public void verigetir(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".myFile.xml",MODE_PRIVATE);
        String name = sharedPreferences.getString(Sabitler.KEY_NAME, "N/A");
        String profession = sharedPreferences.getString(Sabitler.KEY_PROFESSION, "N/A");
        int id = sharedPreferences.getInt(Sabitler.KEY_ID, 0);

        name_tv.setText(name);
        profession_tv.setText(profession + " - " + id);
    }

    public void temizle(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".myFile.xml",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.clear();

        editor.apply();
    }

    public void sil(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".myFile.xml",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.remove(Sabitler.KEY_ID);
        editor.apply();
    }
}
