package edu.miracosta.finalprojecttest.view_learn_more;
/**
 * AnimationPicture.java: Where the user is allowed to select an animation to happen for a picture.
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 5/22/19
 */

import android.graphics.drawable.AnimationDrawable;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import edu.miracosta.finalprojecttest.R;

public class AnimationPicture extends AppCompatActivity {

    private ImageView pictureView;

    //Animation used for Tween Animations
    private Animation rotateAnim;
    private Animation shakeAnim;

    /**
     * Runs method when the activity boots up, and links any views with specific ids
     * @param savedInstanceState - Allows the activity to revert to a previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        pictureView = findViewById(R.id.pictureView);
        pictureView.setBackgroundResource(R.drawable.flyingmountainbird);
    }

    /**
     * This method triggers the rotate animation when a button is pressed
     * @param v - The button that was pressed
     */
    public void toggleRotateAnim(View v)
    {
        rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        pictureView.startAnimation(rotateAnim);
    }

    /**
     * This method triggers the shake animation when a button is pressed
     * @param v - The button that was pressed
     */
    public void toggleShakeAnim(View v)
    {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        pictureView.startAnimation(shakeAnim);
    }

}
