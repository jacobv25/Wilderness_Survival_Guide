package edu.miracosta.finalprojecttest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import edu.miracosta.finalprojecttest.view_learn_more.LearnMoreActivity;
import edu.miracosta.finalprojecttest.model.board_game.BoardPiece;
import edu.miracosta.finalprojecttest.view_play.PlayActivity;

import static edu.miracosta.finalprojecttest.model.board_game.BoardGame.LEVEL_1;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues.CABN_5_2;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues.FNSH_1_4;

public class MainActivity extends AppCompatActivity {

    /**
     * HOW TO: Change the RUNNING_GAME_BOARD and RUNNING_GAME_START to change the game board
     */
    public static final BoardPiece[][] RUNNING_GAME_BOARD = LEVEL_1;
    public static final BoardPiece RUNNING_GAME_START = CABN_5_2;
    public static final BoardPiece RUNNING_GAME_FINISH = FNSH_1_4;

    private Button playButton;
    private Button learnMoreButton;

    private MediaPlayer riverFluteMediaPlayer;

    /**
     * Runs method when the activity boots up, and links any views with specific ids
     * @param savedInstanceState - Allows the activity to revert to a previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playGameButton);
        learnMoreButton = findViewById(R.id.learnMoreButton);
        riverFluteMediaPlayer = MediaPlayer.create(this, R.raw.river_flute);
    }

    /**
     * When the program starts up, the riverFlute will start playing
     */
    @Override
    protected void onStart() {
        super.onStart();

        riverFluteMediaPlayer.start();
    }

    /**
     * If the audio of the river flute was ever paused, this method will resume it
     */
    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (!riverFluteMediaPlayer.isPlaying()) {
            riverFluteMediaPlayer.start();
        }
    }

    /**
     * When the user presses the play button, it switches to the play activity
     * @param V - The button that was pressed
     */
    public void switchToPlayActivity(View V) {

        Intent startGameIntent = new Intent(this, PlayActivity.class);
        riverFluteMediaPlayer.stop();
        startActivity(startGameIntent);

    }

    /**
     * When the user presses the learn more button, it switches to the learn activity
     * @param V - The button that was pressed
     */
    public void switchToLearnMoreActivity(View V) {

        Intent learnMoreIntent = new Intent(this, LearnMoreActivity.class);

        startActivity(learnMoreIntent);
    }
}
