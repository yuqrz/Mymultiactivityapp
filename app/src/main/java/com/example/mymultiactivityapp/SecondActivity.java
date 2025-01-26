package com.example.mymultiactivityapp;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Button backButton = findViewById(R.id.BackActivity);
        TextView notificationText = findViewById(R.id.Info);
        EditText nameEditText = findViewById(R.id.editTextName);
        EditText surnameEditText = findViewById(R.id.editTextSurname);
        EditText emailEditText = findViewById(R.id.editTextEmail);

        String message = getIntent().getStringExtra("message");
        if (message != null) {
            notificationText.setText(message);
        }

        backButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            String surname = surnameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();

            Intent backIntent = new Intent(SecondActivity.this, MainActivity.class);
            backIntent.putExtra("name", name);
            backIntent.putExtra("surname", surname);
            backIntent.putExtra("email", email);
            startActivity(backIntent);
        });
    }
}