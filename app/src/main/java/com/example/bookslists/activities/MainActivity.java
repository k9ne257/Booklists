package com.example.bookslists.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.bookslists.R;

public class MainActivity extends AppCompatActivity {

    Button btn;
    String searchTerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.search_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText searchView = (EditText) findViewById(R.id.search_key);
                searchTerm = searchView.getText().toString();
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("key", searchTerm);
                startActivity(i);
            }
        });

    }
}