
package com.example.john.assign22016johnbuckley;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

/**
 * It is the activity for launching the app
 * This is the screen that the user will see when the app is launched
 * @author  JOhn Buckley
 */
public class MainActivity extends AppCompatActivity
{
    final int GET_TEXT_REQUEST_CODE =1;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(TAG, "The activity is visible and about to be started.");
    }

    /**
     * the oncreate method of the activity lifecylce
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState)
        {
            if (savedInstanceState != null)
            {
                Log.d(TAG, "onCreate() Restoring previous state");
            /* restore state */
            } else
            {
                Log.d(TAG, "onCreate() No saved state available");
            /* initialize app */
            }
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);
            final Button button = (Button) findViewById(R.id.showDCU);
            // Will be called when the user clicks on the Implicit:Find DCU button

            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                //Create an implicit Intent for starting the Find DCU activity
                public void onClick(View v)
                {
                    if (v != null)
                    {
                        Log.i(TAG, "Show DCU Button will start intent");
                        /* starts intent */
                    } else
                    {
                        Log.i(TAG, "Show DCU Button will not start intent");
                        /* will not start intent */
                    }
                    String address = "DCU,Dublin, Ireland";
                    Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + address));
                    startActivity(geoIntent);
                }
            });
            final Button button1 = (Button) findViewById(R.id.showTimer);
            // Will be called when the user clicks on the Implicit:Set 10 seconds Timer
             button1.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    if (v != null)
                    {
                     Log.i(TAG, "Show Timer Button will start intent");
                        /* starts intent */
                    }   else
                    {
                    Log.i(TAG, "Show Timer Button will not start intent");
                        /* will not start intent */
                    }
                //Create an implicit Intent for starting the Set 10 seconds Timer activity
                    String message = "SDA Timer";
                    int seconds = 10;
                    Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                    .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
                    if (intent.resolveActivity(getPackageManager()) != null)
                    {
                       Log.i(TAG, "Set Timer Intent will start");
                        /* starts intent */
                    } else
                    {
                        Log.i(TAG, "Set Timer intent will not start");
                        /* will not start intent */
                    }
                    if (intent.resolveActivity(getPackageManager()) != null)
                    {
                        startActivity(intent);
                    }
                }
            });
            final Button linearWeights = (Button) findViewById(R.id.weights);
            // Will be called when the user clicks on the Explicit:Linear and Weights button
            linearWeights.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    if (v != null)
                    {
                        Log.i(TAG, "Linear and Weights Button will start intent");
                        /* starts intent */
                    } else
                    {
                        Log.i(TAG, "Linear and Weights Button will not start intent");
                        /* will not start intent */
                    }
                    // Create an explicit Intent for starting the Explicit:Linear and Weights Activity
                    Intent linearWeightsIntent = new Intent(MainActivity.this, Explicit1.class);
                    // Use the Intent to start the Explicit:Linear and Weights Activity
                    startActivity(linearWeightsIntent);
                    if (linearWeightsIntent != null)
                    {
                        Log.i(TAG, "Linear and Weights Intent will work");
                        /* starts intent */
                    } else
                    {
                        Log.i(TAG, "Linear and Weights Intent will not work");
                        /* will not start intent */
                    }
                }
            });
            final Button emailbutton = (Button) findViewById(R.id.email);
            // Will be called when the user clicks on the Explicit:Send and Return button
            emailbutton.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    if (v != null)
                    {
                        Log.i(TAG, "Send and Return button will start intent");
                        /* starts intent */
                    } else
                    {
                        Log.i(TAG, "Send and Return Button will not start intent");
                        /* will not start intent */
                    }
                    // Create an explicit Intent for starting the Explicit:Send and Return
                    Intent emailintent = new Intent(MainActivity.this, Explicit2.class);
                    // Use the Intent to start the Explicit:Send and Return Activity

                    startActivityForResult(emailintent,GET_TEXT_REQUEST_CODE);
                    if (emailintent != null)
                    {
                        Log.i(TAG, "Send and Return Intent will work");
                        /* starts intent */
                    } else
                    {
                        Log.i(TAG, "Send and Return Intent will not work");
                        /* will not start intent */
                    }
                }
                protected void onActivityResult(int requestCode, int resultCode, Intent data)
                {
                    Log.i(TAG, "Entered onActivityResult()");
                    // Make sure the request was successful
                    if (requestCode == GET_TEXT_REQUEST_CODE)
                        if (resultCode == RESULT_OK)
                        {
                            StringBuilder SendandReturn = new StringBuilder(60);
                            SendandReturn.append("Name: ").append(data.getStringExtra("AddressValue"))
                                    .append("\n").append("Subject: ").append(data.getStringExtra("SubjectValue"));

                        }
                }
            });

        }

}
