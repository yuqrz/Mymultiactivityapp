package com.example.mymultiactivityapp;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button newActivityButton = findViewById(R.id.ButtonActivity);
        newActivityButton.setOnClickListener(v->{
            Intent newIntent = new Intent(MainActivity.this, SecondActivity.class);
            newIntent.putExtra("message", "Witaj na drugim ekranie");
            startActivity(newIntent);
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("surname");
        String email = intent.getStringExtra("email");
        TextView data = findViewById(R.id.Info);
        if (name != null && surname != null && email != null) {
            String displayText = "Imię: " + name + "\nNazwisko: " + surname + "\nEmail: " + email;
            data.setText(displayText);
        }
    }
}