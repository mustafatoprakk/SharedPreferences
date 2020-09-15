package com.mustafatoprak.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name_text, profession_text;
    TextView name_tv, profession_tv, id_tv;
    Switch switchCompat;
    LinearLayout pageLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_text = findViewById(R.id.etName);
        profession_text = findViewById(R.id.etProfession);
        name_tv = findViewById(R.id.tvName);
        profession_tv = findViewById(R.id.tvProfession);
        id_tv = findViewById(R.id.tvId);
        switchCompat=findViewById(R.id.pageColorSwitch);
        pageLayout=findViewById(R.id.paheLayout);



        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                SharedPreferences sharedPreferences=getSharedPreferences(getPackageName() + ".myFile.xml", MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                editor.putBoolean(Sabitler.KEY_SWITCH,b);
                pageLayout.setBackgroundColor(b ? Color.GREEN:Color.WHITE);   // ? eğer(if) demek   : da eğer değilse(else) demek
                editor.apply();
            }
        });
        SharedPreferences sharedPreferences=getSharedPreferences(getPackageName() + ".myFile.xml", MODE_PRIVATE);
        boolean isChecked=sharedPreferences.getBoolean(Sabitler.KEY_SWITCH,false);
        switchCompat.setChecked(isChecked);

    }

    public void saveAccountData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + ".myFile.xml", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Sabitler.KEY_NAME, name_text.getText().toString());
        editor.putString(Sabitler.KEY_PROFESSION, profession_text.getText().toString());
        editor.putInt(Sabitler.KEY_ID, 150);

        editor.apply();
        //editor.commit();
        Toast.makeText(this, "asdas", Toast.LENGTH_SHORT).show();
    }

    public void loadAccoundData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + ".myFile.xml", MODE_PRIVATE);
        String name = sharedPreferences.getString(Sabitler.KEY_NAME, "N/A");
        String profession = sharedPreferences.getString(Sabitler.KEY_PROFESSION, "N/A");
        int id = sharedPreferences.getInt(Sabitler.KEY_ID, 0);

        name_tv.setText(name);
        profession_tv.setText(profession);
        id_tv.setText("" + id);


    }

    public void newActivity(View view) {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}