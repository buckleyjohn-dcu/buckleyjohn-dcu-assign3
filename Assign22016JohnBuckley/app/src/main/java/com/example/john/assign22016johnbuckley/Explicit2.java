package com.example.john.assign22016johnbuckley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * The start of of the send and return activity
 * when the user hits the send button that data is passed back the main activity
 * This activity of the Send and Return Explicit
 * @author John Buckley
 */
public class Explicit2 extends MainActivity
{
    TextView toAddress;
    TextView subject;

    /**
     * the on create method of the activity lifecycle
     * is the method to initialize the activity and inflate the UI
     * @param savedInstanceState
     */
    @Override
    // oncreate method of the activity lifecycle
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit2);
        final Button button = (Button) findViewById(R.id.showDCU);
        // Will be called when the user clicks on the Implicit:Find DCU button
        button.setOnClickListener(new View.OnClickListener()
        {
            /**
             * @param v
             * @return toaddress the email address entered
             * @return subject  the subject entered by the user
             */
            public void onClick(View v)
            {
                toAddress = (TextView) findViewById(R.id.mailto);
                subject=(TextView) findViewById(R.id.mailSubject);
            }
        });
    }

    /**
     * the intent to return the results of the activty send and Return to the main activity
     * by using the
     * @param v
     */
    public void onIntentReturn(View v)
    {
        Intent backtoMainIntent = new Intent(Explicit2.this, MainActivity.class);
        backtoMainIntent.putExtra("AddressValue", toAddress.getText().toString());
        backtoMainIntent.putExtra("SubjectValue", subject.getText().toString());

        setResult(RESULT_OK, backtoMainIntent);
        finish();
    }
}
