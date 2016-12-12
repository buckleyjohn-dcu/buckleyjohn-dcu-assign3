package com.example.john.assign32016johnbuckley;
/**
 * The activity is launched when selects the Pizza Menu List button.
 * A toast is displayed when user selects a pizza
 * @author Colette Kirwan
 * @date 12/12/2016
 *
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PizzaMenuActivity extends AppCompatActivity
{
    @Override
    /**
     *@param savedInstanceState Bundle containing state information (key-value
     pairs
     */
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_menu);// the layout format determined
        //intialise the Array Pizza
        final ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

        //Images, Pizza names and pizza descriptions to be included in the array
        pizzas.add(new Pizza(R.mipmap.bbq, R.string.pizza1,R.string.pizza1Desc));
        pizzas.add(new Pizza(R.mipmap.ic_calzone, R.string.pizza2,R.string.pizza2Desc));
        pizzas.add(new Pizza(R.mipmap.Hawaiian, R.string.pizza3,R.string.pizza3Desc));
        pizzas.add(new Pizza(R.mipmap.Pepperoni, R.string.pizza4,R.string.pizza4Desc));
        pizzas.add(new Pizza(R.mipmap.Margherita, R.string.pizza5,R.string.pizza5Desc));
        pizzas.add(new Pizza(R.mipmap.Chicken, R.string.pizza6,R.string.pizza6Desc));

        /**
         * The pizza adapater
         * @param - context
         * @param  pizzas the source of the data set, the Array pizzas
         * @param R.layout.listview_layout. Setting the layout of one element of the data set
         */
        PizzaAdapter adapter = new PizzaAdapter(this, pizzas, R.layout.listview_layout);
        ListView listView = (ListView) findViewById(R.id.pizzamenulist);

        listView.setAdapter(adapter);
        // Set a click listener to show the toast message
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            /**
             *
             */
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {


                Pizza word = pizzas.get(position);//get the position of the itme in the adapter selected
                String colourWord = getBaseContext().getResources().getString(word.getPizzaDescId() );
                Toast.makeText(getApplicationContext(), colourWord, Toast.LENGTH_LONG).show(); //make the toast when use selects a pizza
            }

        });
    }
}
