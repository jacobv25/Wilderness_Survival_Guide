package edu.miracosta.finalprojecttest.view_play;
/**
 * This activity occurs when either your life has depleted in some way,
 * or you have successfully found the exit in the game.
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 5/22/19
 */

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import edu.miracosta.finalprojecttest.MainActivity;
import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.enviroment.GameTime;
import edu.miracosta.finalprojecttest.model.player.Player;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;
import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_FINISH;

public class EndGameActivity extends AppCompatActivity {

    /**
     * Runs method when the activity boots up, and links any views with specific ids
     * @param savedInstanceState - Allows the activity to revert to a previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView deathTextView = findViewById(R.id.deathTextView);

        final Intent intent = getIntent();
        final Intent intentMain = new Intent(this, MainActivity.class);
        final Handler handler = new Handler();

        Player player = intent.getParcelableExtra("Player");
        GameTime gameTime = intent.getParcelableExtra("GameTime");

        //if the player had successfully escaped
        if (RUNNING_GAME_BOARD[player.getY()][player.getX()] == RUNNING_GAME_FINISH) {
            //set color
            deathTextView.setTextColor(getResources().getColor(R.color.colorBlue));
            deathTextView.setText("You made it safely to the town.\n\nYou survived:\n\n" + gameTime.getTotalTimeFormatted());
            //delay before going back to main activity
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    startActivity(intentMain);
                }
            }, 5000);
        }
        //if the player's life had been depleted
        else if (player.getCondition() == 0) {
            //set color
            deathTextView.setTextColor(getResources().getColor(R.color.colorRed));
            deathTextView.setText("You are dead.\n\nYou survived:\n\n" + gameTime.getTotalTimeFormatted());
            //delay before going back to main activity
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    startActivity(intentMain);
                }
            }, 5000);
        }
    }

    /**
     * If the user presses the back button on their phone or tablet, it goes back to the beginning
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
