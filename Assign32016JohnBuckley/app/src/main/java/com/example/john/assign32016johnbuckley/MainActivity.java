package com.example.john.assign32016johnbuckley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author John
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Will launch the intent to display the pizza menu
     * @param v view to handle the event when clicked on pizza menu
     */
    public void onPizzaMenuClicked(View v)
    {
        Intent intent = new Intent(MainActivity.this,
                PizzaMenuActivity.class);
        startActivity(intent);
    }

    /**
     * Will launch the intent to the display the make your own pizza screen
     * @param v
     */
    public void onMakeYourOwnPizzaClicked(View v)
    {
        Intent intent = new Intent(MainActivity.this,
                MakePizzaActivity.class);
        startActivity(intent);
    }
}
