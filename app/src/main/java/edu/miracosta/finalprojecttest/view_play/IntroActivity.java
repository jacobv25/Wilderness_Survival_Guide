package edu.miracosta.finalprojecttest.view_play;
/**
 * I don't understand why this class exists...
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 5/22/19
 */
import androidx.appcompat.app.AppCompatActivity;
import edu.miracosta.finalprojecttest.R;

import android.os.Bundle;

public class IntroActivity extends AppCompatActivity {
    /**
     * Runs method when the activity boots up
     * @param savedInstanceState - Allows the activity to revert to a previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }
}
