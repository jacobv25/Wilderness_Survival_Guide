package edu.miracosta.finalprojecttest.view_learn_more;
/**
 * What is used to display a single tip object onto a list.
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
import edu.miracosta.finalprojecttest.model.JSONLoader;
import edu.miracosta.finalprojecttest.model.enviroment.Tip;

public class TipsListActivity extends ListActivity {

    //TODO: Create a custom list adapter.
    //TODO: This one should be easier than the inventory list adapter.
    //TODO: See Pet Protector for help.

    private List<Tip> allTips;
    private ListView tipsListView;

    /**
     * Runs method when the activity boots up, and links any views with specific ids
     * @param savedInstanceState - Allows the activity to revert to a previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            allTips = JSONLoader.loadJSONFromAssetTips(this);
        } catch (IOException e) {
            Log.e("Final Project", "Error loading JSON" + e.getMessage());
        }

        tipsListView = findViewById(R.id.tipsLearnMoreListView);

        setListAdapter(new TipListAdapter(this, R.layout.tip_list_item, allTips));
    }

    /**
     * This method runs when an Tip object is selected from the list, and sends information
     * of the plant object within that specific position into the details activity.
     * @param l - ListView object that the user pressed on
     * @param v - The button the user pressed
     * @param position - Position within the list
     * @param id - Id associated with the button
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent detailsIntent = new Intent(this, ActivityDetails.class);
        // ListItems correspond to the List entries by position

        Tip selectedTip = allTips.get(position);

        detailsIntent.putExtra("Name", selectedTip.getTipName());
        detailsIntent.putExtra("Description", selectedTip.getTipDescription());
        detailsIntent.putExtra("ImageName", selectedTip.getTipImage());

        startActivity(detailsIntent);

    }
}
