package edu.miracosta.finalprojecttest.view_learn_more;

/**
 * Displays information about an item within the learn more activity, being plants, animals, and
 * tips.
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 5/22/19
 */

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;
import edu.miracosta.finalprojecttest.R;

public class ActivityDetails extends AppCompatActivity {

    private TextView detailsNameTextView;
    private TextView detailsDescriptionTextView;
    private ImageView detailsImageView;

    /**
     * Runs method when the activity boots up
     * @param savedInstanceState - Allows the activity to revert to a previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent detailsIntent = getIntent();

        //Retrieving information from the intent
        String name = detailsIntent.getStringExtra("Name");
        String description = detailsIntent.getStringExtra("Description");
        String imageName = detailsIntent.getStringExtra("ImageName");

        //Linking id's with the view objects in the activity
        detailsNameTextView = findViewById(R.id.detailsNameTextView);
        detailsImageView = findViewById(R.id.detailsImageView);
        detailsDescriptionTextView = findViewById(R.id.detailsDescriptionTextView);

        //loading the image associated with the item
        AssetManager am = getAssets();
        try {
            InputStream stream = am.open(imageName);
            Drawable image = Drawable.createFromStream(stream, name);
            detailsImageView.setImageDrawable(image);
        }
        catch (IOException ex)
        {
            Log.e("ActivityDetails", "Error loading: " + imageName);
        }

        //setting text
        detailsNameTextView.setText(name);
        detailsDescriptionTextView.setText(description);
    }


}
