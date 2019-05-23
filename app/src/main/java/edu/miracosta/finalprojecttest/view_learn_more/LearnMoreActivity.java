package edu.miracosta.finalprojecttest.view_learn_more;
/**
 * Gives the user choices to learn more about plants, animals, tips in the wilderness, or
 * even learn about where the game was made.
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 5/22/19
 */
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.GoogleMaps;


public class LearnMoreActivity extends AppCompatActivity {

    //TODO: Each button (Animals, Plants, Survival Tips) take the user to its specific List View.
    /**
     * Runs method when the activity boots up, and links any views with specific ids
     * @param savedInstanceState - Allows the activity to revert to a previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);

        Button animalsButton = findViewById(R.id.learnMoreAnimalsButton);
        Button plantsButton = findViewById(R.id.learnMorePlantsButton);
        Button survivalTipsButton = findViewById(R.id.learnMoreSurvivalTipsButton);

    }

    /**
     * Leads to another activity that gives a list of animals and their information
     * @param v - The button that was pressed
     */
    public void animalsLearnMoreButtonPressed(View v) {

        Intent intent = new Intent(this, AnimalsListActivity.class);

        startActivity(intent);
    }

    /**
     * Leads to another activity that gives a list of plants and their information
     * @param v - The button that was pressed
     */
    public void plantsLearnMoreButtonPressed(View v) {

        Intent intent = new Intent(this, PlantsListActivity.class);

        startActivity(intent);
    }
    /**
     * Leads to another activity that gives a list of tips and their information
     * @param v - The button that was pressed
     */
    public void tipsLearnMoreButtonPressed(View v) {

        Intent intent = new Intent(this, TipsListActivity.class);

        startActivity(intent);
    }

    /**
     * Leads to another activity that gives a location of where the program was made
     * @param v - The button that was pressed
     */
    public void aboutLearnMoreButtonPressed(View v) {

        Intent intent = new Intent(this, GoogleMaps.class);

        startActivity(intent);
    }
    /**
     * Leads to another activity that gives a location of image animation
     * @param v - The button that was pressed
     */
    public void animationLearnMoreButtonPressed(View v) {

        Intent intent = new Intent(this, AnimationPicture.class);

        startActivity(intent);
    }
}
