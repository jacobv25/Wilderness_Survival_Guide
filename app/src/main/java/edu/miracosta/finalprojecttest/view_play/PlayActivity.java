package edu.miracosta.finalprojecttest.view_play;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.StoryElements;
import edu.miracosta.finalprojecttest.model.board_game.BoardGame;
import edu.miracosta.finalprojecttest.model.player.Action;
import edu.miracosta.finalprojecttest.model.player.Damage;
import edu.miracosta.finalprojecttest.model.enviroment.GameTime;
import edu.miracosta.finalprojecttest.model.player.Player;
import edu.miracosta.finalprojecttest.model.player.Regeneration;
import edu.miracosta.finalprojecttest.model.enviroment.Weather;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;
import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_FINISH;

public class PlayActivity extends AppCompatActivity {

    private final static int REQUEST_CODE_1 = 1;

    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String PASS_TIME = "WAIT";

    //public static String DISPLAY_TEXT;

    private Button northButton;
    private Button southButton;
    private Button eastButton;
    private Button westButton;
    private Button actionButton;
    private Button inventoryButton;
    private Button passTimeButton;
    private List<Button> allButtons;
    private ConstraintLayout playActivityLayout;

    private TextView currentAreaTextView;
    private TextView playerConditionTextView;
    private TextView timeTextView;
    private TextView afflictionTempTextView;
    private TextView afflictionHungerTextView;
    private TextView afflictionThirstTextView;
    private TextView tempTextView;
    private TextView hungerTextView;
    private TextView thirstTextView;

    private Player player;
    private GameTime gameTime;
    private Weather weather;

    private MediaPlayer cabinAmbientMediaPlayer;
    private MediaPlayer forestDayAmbientMediaPlayer;
    private MediaPlayer forestNightAmbientMediaPlayer;
    private ExoPlayer cabinAmbientExoPlayer;
    private MediaPlayer walkSnowSFXMediaPlayer;

    private ProgressBar playerTempProgressBar;
    private ProgressBar playerHungerProgressBar;
    private ProgressBar playerThirstProgressBar;
    private ProgressBar playerConditionProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        northButton = findViewById(R.id.northButton);
        southButton = findViewById(R.id.southButton);
        eastButton = findViewById(R.id.eastButton);
        westButton = findViewById(R.id.westButton);
        actionButton = findViewById(R.id.actionButton);
        inventoryButton = findViewById(R.id.inventoryButton);
        passTimeButton = findViewById(R.id.waitButton);
        tempTextView = findViewById(R.id.tempTextView);
        hungerTextView = findViewById(R.id.hungerTextView);
        thirstTextView = findViewById(R.id.thirstTextView);
        playActivityLayout = findViewById(R.id.playActivityLayout);
        allButtons = new ArrayList<>();
        allButtons.add(northButton);
        allButtons.add(southButton);
        allButtons.add(eastButton);
        allButtons.add(westButton);
        allButtons.add(actionButton);
        allButtons.add(inventoryButton);
        allButtons.add(passTimeButton);

        playerTempProgressBar = findViewById(R.id.playerTempProgressBar);
        playerHungerProgressBar = findViewById(R.id.playerHungerProgressBar);
        playerThirstProgressBar = findViewById(R.id.playerThirstProgressBar);
        playerConditionProgressBar = findViewById(R.id.playerConditionProgressBar);

        currentAreaTextView = findViewById(R.id.currentAreaTextView);
        playerConditionTextView = findViewById(R.id.playerConditionTextView);
        timeTextView = findViewById(R.id.timeTextView);
        afflictionTempTextView = findViewById(R.id.afflictionTempTextView);
        afflictionHungerTextView = findViewById(R.id.afflictionHungerTextView);
        afflictionThirstTextView = findViewById(R.id.afflictionThirstTextView);
        //playView = findViewById(R.id.constraintLayout);

        cabinAmbientMediaPlayer = MediaPlayer.create(this, R.raw.cabin_fire);
        forestDayAmbientMediaPlayer = MediaPlayer.create(this, R.raw.forest_ambient_day);
        forestNightAmbientMediaPlayer = MediaPlayer.create(this, R.raw.forest_ambient_night);
        //cabinAmbientExoPlayer = setUpCabinAmbientExoPlayer();

        walkSnowSFXMediaPlayer = MediaPlayer.create(this, R.raw.walk_snow2);

        player = new Player();
        gameTime = new GameTime();
        weather = new Weather();
        playerConditionTextView.setText("HP= " + player.getCondition() +
                " | Temp= " + player.getTemperature() +
                " | Hunger= " + player.getHunger() +
                " | Thirst= " + player.getThirst());
        timeTextView.setText(gameTime.getDayTimeFormatted());
        currentAreaTextView.setText(StoryElements.HOW_TO_PLAY);
        //forestDayAmbientMediaPlayer.start();
        //cabinAmbientExoPlayer.setPlayWhenReady(true);
        //forestNightAmbientMediaPlayer.start();
    }

    @Override
    protected void onStart() {
        super.onStart();

        TrackSelector trackSelector = new DefaultTrackSelector();
        //DefaultRenderersFactory renderersFactory = new DefaultRenderersFactory(this);
        String application_name = getApplicationInfo().loadLabel(getPackageManager()).toString();
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, application_name));
        MediaSource audioSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(getCabinMp3Uri());
        cabinAmbientExoPlayer = ExoPlayerFactory.newSimpleInstance(this,
                                                                    trackSelector);
        cabinAmbientExoPlayer.prepare(audioSource);
        cabinAmbientExoPlayer.setPlayWhenReady(true);

//        //Use ExoPlayer Factory to initialize
//        cabinAmbientExoPlayer = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());
//        //Get application name (label)
//
//        // Produces DataSource instances through which media data is loaded.
//        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(this,
//                Util.getUserAgent(this, application_name));
//        // This is the MediaSource representing the media to be played.
//        ExtractorMediaSource cabinAmbientMediaSource = new ExtractorMediaSource.Factory(dataSourceFactory)
//                .createMediaSource(getCabinMp3Uri());
//        // Prepare the player with the source.
//        cabinAmbientExoPlayer.prepare(cabinAmbientMediaSource);
//
//        cabinAmbientExoPlayer.setPlayWhenReady(true);
//        //forestNightAmbientMediaPlayer.start();

    }

    private Uri getCabinMp3Uri() {

        //Get the URI
        Resources res = this.getResources();
        String uri = ContentResolver.SCHEME_ANDROID_RESOURCE
                + "://" + res.getResourcePackageName(R.raw.forest_ambient_night)
                + "/" + res.getResourceTypeName(R.raw.forest_ambient_night)
                + "/" + res.getResourceEntryName(R.raw.forest_ambient_night);

        return Uri.parse(uri);


    }

    public void movePlayer(View v) {
        String buttonText = ((Button)v).getText().toString();

        if (buttonText.equals(EAST) || buttonText.equals(PASS_TIME) ||
                buttonText.equals(NORTH) || buttonText.equals(SOUTH) || buttonText.equals(WEST)) {
            //move player
            player.movePlayerBoardPiece(buttonText, player, RUNNING_GAME_BOARD, walkSnowSFXMediaPlayer, allButtons, gameTime);
            currentAreaTextView.setText(player.getDisplayText());
        }

        //Check if fire is burning in current area
        if( Action.isFireBurning(player, RUNNING_GAME_BOARD) ) {
            Regeneration.regenFromFire(player);
        }

        Damage.damagePlayer(player, weather, gameTime);
        Regeneration.regeneratePlayer(player);
        //check for sunlight
        changeBackground(gameTime);
        //gameTime.passTime();
        BoardGame.update();
        //set the affliction text view
        setAfflictionText();
        //update the player condition text view
        playerConditionTextView.setText("HP= " + player.getCondition() +
                " | Temp= " + player.getTemperature() +
                " | Hunger= " + player.getHunger() +
                " | Thirst= " + player.getThirst());
        //TODO: Set the player progress bar (Temp)
        setPlayerProgressBars(player);


        //check if player is dead
        isPlayerDead(player);
        //check if player made it to finish
        didPlayerWin(player);
        //update the day time
        timeTextView.setText(gameTime.getDayTimeFormatted());
        //update the music
        playMedia();
    }

    private void setPlayerProgressBars(Player player) {

        playerTempProgressBar.setProgress((int)player.getTemperature());
        playerHungerProgressBar.setProgress((int)player.getHunger());
        playerThirstProgressBar.setProgress((int)player.getThirst());
        playerConditionProgressBar.setProgress((int)player.getCondition());
    }


    public void inventoryButtonPressed(View v) {
        Intent intent = new Intent(this, InventoryListActivity.class);

        intent.putExtra("Player", player);

        startActivity(intent);
    }

    public void actionButtonPressed(View v) {

        Intent intent = new Intent(this, ActionActivity.class);

        intent.putExtra("Player", player);
        //intent.putExtra("Inventory", player.getInventory());
        intent.putExtra("DisplayText", player.getDisplayText());
        intent.putExtra("GameTime", gameTime);

        startActivityForResult(intent, REQUEST_CODE_1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // The returned result data is identified by requestCode.
        // The request code is specified in startActivityForResult(intent, REQUEST_CODE_1); method.
        switch (requestCode)
        {
            // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
            case REQUEST_CODE_1:
                if(resultCode == RESULT_OK)
                {
                    player = data.getParcelableExtra("Player");
                    //set the current area text view
                    currentAreaTextView.setText(player.getDisplayText());
                    //check player hp
                    Damage.damagePlayer(player, weather, gameTime);
                    Regeneration.regeneratePlayer(player);
                    //pass time
                    gameTime.passTime(GameTime.PASS_MED);
                    //check for sunlight
                    changeBackground(gameTime);
                    BoardGame.update();

                    //Check if fire is burning in current area
                    if( Action.isFireBurning(player, RUNNING_GAME_BOARD) ) {
                        Regeneration.regenFromFire(player);
                    }
                    //set affliction text view
                    setAfflictionText();
                    //update the player condition text view
                    playerConditionTextView.setText("HP= " + player.getCondition() +
                            " | Temp= " + player.getTemperature() +
                            " | Hunger= " + player.getHunger() +
                            " | Thirst= " + player.getThirst());
                    //update progress bars
                    setPlayerProgressBars(player);
                    //update the time
                    timeTextView.setText(gameTime.getDayTimeFormatted());
                    //check if player is dead
                    isPlayerDead(player);
                    //check if player reached finish
                    didPlayerWin(player);
                }
        }
    }

    private void changeBackground(GameTime time) {

        //TODO: FIND OUT HOW TO GET ID FOR LAYOUT
        if (time.getDayTime() >= 1260 || time.getDayTime() < 360 ) {
            Log.i("Jacob", "Changing screen to black");
            playActivityLayout.setBackgroundColor(Color.BLACK);
            currentAreaTextView.setTextColor(Color.WHITE);
            timeTextView.setTextColor(Color.WHITE);
            tempTextView.setTextColor(Color.WHITE);
            hungerTextView.setTextColor(Color.WHITE);
            thirstTextView.setTextColor(Color.WHITE);
            playerTempProgressBar.setProgressDrawable(getDrawable(R.drawable.circular_progress_bar_white));
            playerHungerProgressBar.setProgressDrawable(getDrawable(R.drawable.circular_progress_bar_white));
            playerThirstProgressBar.setProgressDrawable(getDrawable(R.drawable.circular_progress_bar_white));

        }
        else if (time.getDayTime() >=360 || time.getDayTime() < 720) {
            Log.i("Jacob", "Changing screen to white");
            playActivityLayout.setBackgroundColor(getResources().getColor(R.color.colorGrey));
            currentAreaTextView.setTextColor(Color.BLACK);
            timeTextView.setTextColor(Color.BLACK);
            tempTextView.setTextColor(Color.BLACK);
            hungerTextView.setTextColor(Color.BLACK);
            thirstTextView.setTextColor(Color.BLACK);
            playerTempProgressBar.setProgressDrawable(getDrawable(R.drawable.circular_progress_bar_black));
            playerHungerProgressBar.setProgressDrawable(getDrawable(R.drawable.circular_progress_bar_black));
            playerThirstProgressBar.setProgressDrawable(getDrawable(R.drawable.circular_progress_bar_black));
        }
//        if (time.getDayTime() >= 720 || time.getDayTime() < 1260) {
//            playActivityLayout.setBackgroundColor(getResources().getColor(R.color.colorBlueSky));
//            currentAreaTextView.setTextColor(Color.BLACK);
//            timeTextView.setTextColor(Color.BLACK);
//            tempTextView.setTextColor(Color.BLACK);
//            hungerTextView.setTextColor(Color.BLACK);
//            thirstTextView.setTextColor(Color.BLACK);
//            playerTempProgressBar.setProgressDrawable(getDrawable(R.drawable.circular_progress_bar_black));
//            playerHungerProgressBar.setProgressDrawable(getDrawable(R.drawable.circular_progress_bar_black));
//            playerThirstProgressBar.setProgressDrawable(getDrawable(R.drawable.circular_progress_bar_black));
//        }
    }

    private void playMedia() {

//        if (player.isPlayerInside(RUNNING_GAME_BOARD)) {
//            cabinAmbientExoPlayer.setPlayWhenReady(true);
//        }
//        else {
//            cabinAmbientExoPlayer.setPlayWhenReady(false);
//        }
//        System.out.println("ARE YOU PLAYING?= " + cabinAmbientExoPlayer.getPlayWhenReady());
        if (player.isPlayerInside(RUNNING_GAME_BOARD)) {
            if (forestNightAmbientMediaPlayer.isPlaying()) {
                forestNightAmbientMediaPlayer.pause();
            }
            if (forestDayAmbientMediaPlayer.isPlaying()) {
                forestDayAmbientMediaPlayer.pause();
            }
            cabinAmbientMediaPlayer.start();
        }
        else {

            if(cabinAmbientMediaPlayer.isPlaying()) {
                cabinAmbientMediaPlayer.pause();
            }
            //if the day time is between 7am and 7pm
            if (gameTime.getDayTime() > 420 &&
                    gameTime.getDayTime() < 1140) {
                System.out.println("PLAYING DAY AMBIENT");
                if (forestNightAmbientMediaPlayer.isPlaying()) {
                    forestNightAmbientMediaPlayer.stop();
                }
                forestDayAmbientMediaPlayer.start();
            }
            else {
                System.out.println("playing night music");
                if (forestDayAmbientMediaPlayer.isPlaying()) {
                    forestDayAmbientMediaPlayer.stop();
                }
                forestNightAmbientMediaPlayer.start();
            }

        }
    }

    private void isPlayerDead(Player player) {

        if (player.getCondition() == 0) {

            Intent intent = new Intent(this, EndGameActivity.class);
            intent.putExtra("Player", player);
            intent.putExtra("GameTime", gameTime);
            startActivity(intent);
        }
    }

    private void didPlayerWin(Player player) {

        if( player.getX() == RUNNING_GAME_FINISH.getX() && player.getY() == RUNNING_GAME_FINISH.getY()) {

            Intent intent = new Intent(this, EndGameActivity.class);
            intent.putExtra("Player", player);
            intent.putExtra("GameTime", gameTime);
            startActivity(intent);
        }
    }

    private void setAfflictionText() {
        Log.i("Jacob", "playerTemp=" + player.getTemperature());
        //Set the Temperature
        if (player.getTemperature() == 0) {
            Log.i("Jacob", "in the BLOCK");
            playerTempProgressBar.setVisibility(View.INVISIBLE);
            afflictionTempTextView.setVisibility(View.VISIBLE);
        }
        else {
            playerTempProgressBar.setVisibility(View.VISIBLE);
            afflictionTempTextView.setVisibility(View.INVISIBLE);
        }


        //Set the Hunger
        if (player.getHunger() == 0) {
            playerHungerProgressBar.setVisibility(View.INVISIBLE);
            //Log.i("JACOB", "changing hunger progress bar");
            afflictionHungerTextView.setVisibility(View.VISIBLE);
        }
        else {
            playerHungerProgressBar.setVisibility(View.VISIBLE);
            afflictionHungerTextView.setVisibility(View.INVISIBLE);
        }



        //Set the thirst
        if (player.getThirst() == 0) {
            playerThirstProgressBar.setVisibility(View.INVISIBLE);
            //Log.i("Jacob", "changing thirst progress bar");
            afflictionThirstTextView.setVisibility(View.VISIBLE);
        }
        else {
            playerThirstProgressBar.setVisibility(View.VISIBLE);
            afflictionThirstTextView.setVisibility(View.INVISIBLE);
        }
    }
}
