package edu.miracosta.finalprojecttest.view_learn_more;
/**
 * Displays information about an item within the learn more activity, being plants, animals, and
 * tips.
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 5/22/19
 */
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.enviroment.Animal;
import edu.miracosta.finalprojecttest.model.JSONLoader;
/**
 * Displays a list of animals that are loaded from a JSON file
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 5/22/19
 */
public class AnimalsListActivity extends ListActivity {

    //TODO: Create a custom list adapter.
    //TODO: This one should be easier than the inventory list adapter.
    //TODO: See Pet Protector for help.

    private List<Animal> allAnimals;
    private ListView animalsListView;

    private LearnMoreListAdapter learnMoreListAdapter;
    private ListView learnMoreListView;
    /**
     * Runs method when the activity boots up
     * @param savedInstanceState - Allows the activity to revert to a previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //loading animal objects from json file
        try {
            allAnimals = JSONLoader.loadJSONFromAsset(this);
        } catch (IOException e) {
            Log.e("Final Project", "Error loading JSON" + e.getMessage());
        }

        animalsListView = findViewById(R.id.animalsLearnMoreListView);

        //setting adapter to be viewed with the list
        setListAdapter(new LearnMoreListAdapter(this, R.layout.learn_more_list_item, allAnimals));
    }

    /**
     * This method runs when an Animal object is selected from the list, and sends information
     * of the animal object within that specific position into the details activity.
     * @param l - ListView object that the user pressed on
     * @param v - The button the user pressed
     * @param position - Position within the list
     * @param id - Id associated with the button
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent detailsIntent = new Intent(this, ActivityDetails.class);
        // ListItems correspond to the List entries by position

        Animal selectedAnimal = allAnimals.get(position);

        detailsIntent.putExtra("Name", selectedAnimal.getAnimalName());
        detailsIntent.putExtra("Description", selectedAnimal.getAnimalDescription());
        detailsIntent.putExtra("ImageName", selectedAnimal.getAnimalImage());

        startActivity(detailsIntent);

    }
}
