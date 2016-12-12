package com.example.john.assign32016johnbuckley;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 *
 */
public class MakePizzaActivity extends AppCompatActivity
{
    CheckBox pepperoni;
    CheckBox extraCheese;
    CheckBox onions;
    CheckBox mushrooms;
    String toppingSummary;
    int numofPizzas;
    int toppingcost;
    int baseCost = 10;
    int pizzaCost;
    TextView name;
    String userName;
    TextView displayOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_pizza);
        name =(TextView)findViewById(R.id.UserName);
        userName = name.getText().toString();
        pepperoni = (CheckBox) findViewById(R.id.checkBox1);
        extraCheese = (CheckBox) findViewById(R.id.checkBox2);
        onions = (CheckBox) findViewById(R.id.checkBox3);
        mushrooms = (CheckBox) findViewById(R.id.checkBox4);
        if(pepperoni.isChecked())
        {
            toppingSummary = "Pepperoni";
            toppingcost = 1;
        }
        else if (extraCheese.isChecked())
        {
            toppingSummary = "Extra Cheese";
            toppingcost = 1;
        }
        else if (onions.isChecked())
        {
            toppingSummary = "Onions";
            toppingcost = 1;
        }
        else if (mushrooms.isChecked())
        {
            toppingSummary = "Mushrooms";
            toppingcost = 1;
        }
        else if (pepperoni.isChecked()&& extraCheese.isChecked())
        {
            toppingSummary = "Pepperoni, Extra Cheese";
            toppingcost = 2;
        }
        else if (pepperoni.isChecked()&& extraCheese.isChecked() && onions.isChecked())
        {
            toppingSummary = "Pepperoni, Extra Cheese, Onions";
            toppingcost = 3;
        }
        else if (pepperoni.isChecked()&& extraCheese.isChecked() && onions.isChecked() && mushrooms.isChecked())
        {
            toppingSummary = "Pepperoni, Extra Cheese, Onions, Mushrooms";
            toppingcost = 4;
        }
        else if (extraCheese.isChecked() && onions.isChecked() && mushrooms.isChecked())
        {
            toppingSummary = "Extra Cheese, Onions, Mushrooms";
            toppingcost = 3;
        }
        else if (onions.isChecked() && mushrooms.isChecked())
        {
            toppingSummary = "Onions, Mushrooms";
            toppingcost = 2;
        }
        else if (pepperoni.isChecked() && onions.isChecked())
        {
            toppingSummary = "Pepperoni, Onions";
            toppingcost = 2;
        }
        else if (pepperoni.isChecked() && onions.isChecked() && mushrooms.isChecked())
        {
            toppingSummary = "Pepperoni, Onions, Mushrooms";
            toppingcost = 3;
        }
        else if (pepperoni.isChecked()&& mushrooms.isChecked())
        {
            toppingSummary = "Pepperoni, Mushrooms";
            toppingcost = 2;
        }
        else if (extraCheese.isChecked() &&  pepperoni.isChecked() && mushrooms.isChecked())
        {
            toppingSummary = "Pepperoni, Extra Cheese, Mushrooms";
            toppingcost = 3;
        }
        else if (extraCheese.isChecked()&& mushrooms.isChecked())
        {
            toppingSummary = "Extra Cheese, Mushrooms";
            toppingcost = 2;
        }
        else if (extraCheese.isChecked()&& onions.isChecked())
        {
            toppingSummary = "Extra Cheese, Onions";
            toppingcost = 2;
        }
        else
        {
            toppingSummary = "";
            toppingcost = 0;
        }


        Spinner quantity = (Spinner) findViewById(R.id.pizzaquantity);
        final ArrayList<Integer> numberofPizzas = new ArrayList<Integer>();
        numberofPizzas.add(1);
        numberofPizzas.add(2);
        numberofPizzas.add(3);
        numberofPizzas.add(4);
        numberofPizzas.add(5);
        numberofPizzas.add(6);
        numberofPizzas.add(7);
        numberofPizzas.add(8);
        numberofPizzas.add(9);
        numberofPizzas.add(10);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<Integer> qtyAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, numberofPizzas);
        // Specify the layout to use when the list of choices appears
        qtyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        quantity.setAdapter(qtyAdapter);
        quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                numofPizzas = Integer.parseInt(parent.getItemAtPosition(pos).toString());
                pizzaCost = (toppingcost+baseCost)* numofPizzas;
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    public void onclickSummary(View view)
    {
        StringBuilder output = new StringBuilder(60);
        output.append("Name:").append(userName).append("\n").append("Standard Margherita Pizza").append("\n").append("Extra Toppings:").append(toppingSummary)
        .append("\n").append("Quantity").append(numofPizzas).append("\n").append("Cost: €").append(pizzaCost).append("\n").append("Thank You!");
        Context context = getApplicationContext();
        CharSequence text = output.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void onclickSend(View view)
    {
        StringBuilder emailOutput = new StringBuilder(60);
        emailOutput.append("Name:").append(userName).append("\n").append("Standard Margherita Pizza").append("\n").append("Extra Toppings:").append(toppingSummary)
        .append("\n").append("Quantity").append(numofPizzas).append("\n").append("Cost: €").append(pizzaCost).append("\n").append("Thank You!");

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:")); // only email apps will handle this
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Order Confirmation");
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailOutput.toString());
    }
}




