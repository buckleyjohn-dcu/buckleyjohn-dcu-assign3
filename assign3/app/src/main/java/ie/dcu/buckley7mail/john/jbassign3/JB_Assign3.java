package ie.dcu.buckley7mail.john.jbassign3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 ** @author John Buckley < john.buckley7@mail.dcu.ie>
 * @version 1.0
 * @since  2015-12-19
 *
 */
public class JB_Assign3 extends AppCompatActivity
{
    /**
     *The oncreate method calls when the app is run.
     * It will create the view and start the assignment activity
     * @see android.app.Activity#onCreate(android.os.Bundle)
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jb__assign3);

    }

    /**
     * The onClickListner which uses the onclick method declared in the button in xml file
     * The method is called when the view (button) is clicked.
     * Starts the intent to move into the PhotoGallery activity
     * @see android.view.View.OnClickListener
     * @param v The view that was clicked
     */
    public void showpics(View v)
    {
        Intent gallery = new Intent(this, PhotoGallery.class);
        startActivity(gallery);
    }

    /**
     * The onClickListener uses the onclick method declared in the button in xml file
     * The method is called when the view (button) is clicked.
     * Starts the intent to move into the RugbyCounter activity
     * @see android.view.View.OnClickListener
     * @param view The view that was clicked
     */
    public void rugbycounter(View view)
    {
        Intent rugby = new Intent(this, RugbyCounter.class);
        startActivity(rugby);
    }

    /**
     *Initialises the contents of Activity's standard options menu
     * @see android.app.Activity#onCreateOptionsMenu
     * @param menu The options menu in items are placed
     * @return true - Must be return a value of true for the menu to be displayed
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jb__assign3, menu);
        return true;
    }

    /**
     * Hook called whenever an item in the options menu is selected
     *@see android.app.Activity#onOptionsItemSelected
     * @param item The menu item that was selected.
     * @return false to allow normal menu processing to proceed, true to consume it here.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
