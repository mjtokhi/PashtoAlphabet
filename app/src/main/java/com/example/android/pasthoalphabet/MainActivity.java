package com.example.android.pasthoalphabet;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.pasthoalphabet.R.raw.closed_hat_1;
import static com.example.android.pasthoalphabet.R.raw.kik1;
import static com.example.android.pasthoalphabet.R.raw.snare;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mpSnare;
    private MediaPlayer mpBase;
    private MediaPlayer mpHat;

    private TextView mTextMessage;

/*    private Button.OnClickListener drums_listener = new View.OnClickListener() {
        @Override
        public void onClick (View v) {
            String bass = "bass";
            String snare = "snare_drum";
            String hat = "hat";
            if (snare.equals(v.getId())) {
                Snare(v);
            }
            /*
            else if ()
                    mpSnare.start();
                    return true;
                case R.id.hat:
                    mpHat.start();
                    return true;

        }
    };
*/
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    PlaySound(item);

                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    PlaySound(item);
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    PlaySound(item);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /*Button bass = findViewById(R.id.bass);
        Button snare_drum = findViewById(R.id.snare_drum);
        Button hat = findViewById(R.id.hat);
        */

        mpSnare = MediaPlayer.create(MainActivity.this, snare);
        mpBase = MediaPlayer.create(MainActivity.this, kik1);
        mpHat = MediaPlayer.create(MainActivity.this, closed_hat_1);
    }

    public void PlaySound(MenuItem item) {
        mpBase.start();
    }

    public void Snare(View v){
        mpSnare.start();
    }

    public void Base (View v) {
        mpBase.start();
    }

    public void Hat (View v) {
        mpHat.start();
    }
}
