package com.example.anne.interactivestory.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.anne.interactivestory.R;


public class MainActivity extends AppCompatActivity {

    private EditText nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameEditText);
        Button startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameField.getText().toString();
                startStory(name);
            }
        });
    }

    protected void onResume(){
        super.onResume();
        nameField.setText("");
    }

    private void startStory(String name) {
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);

        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra(key, name);
        startActivity(intent);
    }
}
