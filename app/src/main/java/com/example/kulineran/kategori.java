package com.example.kulineran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class kategori extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);


    }

    public void pecel(View view) {
        Intent intent = new Intent(kategori.this, Info_makanan.class);
        startActivity(intent);
    }
}