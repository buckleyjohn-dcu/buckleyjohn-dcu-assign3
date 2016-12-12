package com.example.john.assign32016johnbuckley;

/**
 * The bridge between the adapterview and the underlying data. It makes a view for a data set i.e. the pizza menu
 * @author Colette Kirwan
 * Created by John on 10/12/2016.
 */
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 */
public class PizzaAdapter extends ArrayAdapter<Pizza>
{

    /**
     * Resource ID for the background color for this list of colours
     */
    private int mColorResourceId;

    /**
     *
     * @param context
     * @param pizzas the data set of pizzas, the images and descriptions
     * @param colorResourceId the underlying view
     */
    public PizzaAdapter(Context context, ArrayList<Pizza> pizzas, int colorResourceId)
    {
        super(context, 0, pizzas);
        mColorResourceId = colorResourceId;
    }

    @Override
    /**
     * Returns the view of at the requested position in the data set.
     * @return listItemView  the pizza name, description and image of the pizza selected.
     */

    public View getView(int position, View convertView, ViewGroup parent)
    {

        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listview_layout, parent, false);
        }


        Pizza currentWord = getItem(position);


        TextView cTextView = (TextView) listItemView.findViewById(R.id.pizzaName_text_view);//the TextView Pizza Name from the format one what one view looks like

        cTextView.setText(currentWord.getPizzaNameId());//set the pizza name to that selected in the above getView method

        TextView dTextView = (TextView) listItemView.findViewById(R.id.pizzaDesc_text_view);//the TextView Pizza Description from the format one what one view looks like

        dTextView.setText(currentWord.getPizzaDescId());//set the pizza description to that selected above


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.pizzaimage);//the ImageView Pizza picture from the format one what one view looks like

        if (currentWord.hasImage())
        {

            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else
        {

            imageView.setVisibility(View.GONE);
        }


        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);


        return listItemView;
    }
}
