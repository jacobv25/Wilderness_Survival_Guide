package edu.miracosta.finalprojecttest.view_play;
/**
 * What is used to display a single item object onto a list.
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 5/22/19
 */
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.enviroment.Item;

public class InventoryListAdapter extends ArrayAdapter<Item> {

    //TODO: Extend ArrayAdapter and decide which constructor to implement.
    //TODO: See pet protector for help.
    //TODO: This may be different than PetProtector because we want to display
    //TODO: an array (inventory[]) within an object(Inventory.java) within another
    //TODO: object (Player). May get tricky.

    private Context mContext;
    private List<Item> mAllItems;
    private int mResourceId;

    /**
     * Creates a new <code>InventoryListAdapter</code> given a mContext, resource id and list of plants.
     *
     * @param context The mContext for which the adapter is being used (typically an activity)
     * @param resourceId The resource id (typically the layout file name)
     * @param allItems The list of all Items to display
     */
    public InventoryListAdapter(Context context, int resourceId, List<Item> allItems) {
        super(context, resourceId, allItems);
        mContext = context;
        mResourceId = resourceId;
        mAllItems = allItems;
    }

    /**
     * Gets the view associated with the layout.
     * @param pos The position of the inventory selected in the list.
     * @param convertView The converted view.
     * @param parent The parent - ArrayAdapter
     * @return The new view with all content set.
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        //Inflate our custom layout with data from the List<MusicEvent>
        Item focusedItem = mAllItems.get(pos);
        //Manually inflate the custom layout
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Tell the inflater to inflate inventory_list_item
        View customView = inflater.inflate(mResourceId, null);
        //Fill the parts of the custom view
        ImageView listItemImageView = customView.findViewById(R.id.inventoryImageView);
        TextView listItemNameTextView = customView.findViewById(R.id.inventoryNameTextView);
        TextView listItemCountTextView = customView.findViewById(R.id.inventoryCountTextView);
        //Put information into text views and image view
        listItemNameTextView.setText(focusedItem.getName());
        listItemCountTextView.setText(Integer.toString(focusedItem.getCount()));
        //Load the image dynamically
        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = ((AssetManager) am).open(focusedItem.getImageName());
            Drawable image = Drawable.createFromStream(stream, focusedItem.getName());
            //Put the image into the image view
            listItemImageView.setImageDrawable(image);
        } catch (IOException e) {
            Log.e("Final Project", e.getMessage());
        }
        return customView;
    }
}
