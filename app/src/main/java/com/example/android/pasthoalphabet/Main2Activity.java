package com.example.android.pasthoalphabet;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private TextView displayText;
    public Button.OnClickListener button1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(intent1);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        displayText = (TextView) findViewById(R.id.tv_display_text);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(button1Listener);

    }

    public void wrongAnswer(View v){
        Toast.makeText(Main2Activity.this, "Wrong Answer.", Toast.LENGTH_SHORT).show();
    }
}
