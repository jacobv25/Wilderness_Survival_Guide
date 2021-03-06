package edu.miracosta.finalprojecttest;

/**
 * SplashActivity.java: Creates a splash screen when booting up the program
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 4/23/19
 */

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    /**
     * Runs method when the activity boots up, and links any views with specific ids
     * @param savedInstanceState - Allows the activity to revert to a previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        //Delay activity with TimerTask
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent musicIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(musicIntent);
                //Finish the current activity (finish SplashActivity)
                finish();
            }
        };


        Timer timer = new Timer();
        timer.schedule(task, 3000);

        //Any loading code goes her(DBHelper gets instantiated, loading JSON)


    }
}
