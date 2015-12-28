
package ie.dcu.buckley7mail.john.jbassign3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author John Buckley < john.buckley7@mail.dcu.ie>
 * @version 1.0
 * @since  2015-12-27
 */
public class RugbyCounter extends AppCompatActivity {
    int homeTeamScore = 0;
    int awayTeamScore = 0;

    /**
     *The oncreate method calls when the app is run.
     * It will create the view and start the assignment activity
     * @see android.app.Activity#onCreate(android.os.Bundle)
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rugby_counter);
    }

    /**
     * method to get for the user to enter the home team name
     * findViewById finds the view by id teamhome, the id attribute from the xml
     * @see android.app.Activity#findViewById(android.os.Bundle)
     * @return the name entered + ;
     */
    public String getHome()
    {
        EditText editHomeTeam = (EditText) findViewById(R.id.teamhome);
        String home = editHomeTeam.getText().toString();
        return home+ ": ";
    }

    /**
     * method to get for the user to enter the away team name
     * findViewById finds the view by id teamaway, the id attribute from the xml
     * @see android.app.Activity#findViewById(android.os.Bundle)
     * @return
     */
    public String getAway()
    {
        EditText editAwayTeam = (EditText) findViewById(R.id.teamaway);
        String away = editAwayTeam.getText().toString();
        return away+ ": ";
    }

    /**
     *  the home team score display.
     *  will be increased by the score buttons
     * @param htscore the home team score
     */
    private void homeTeam(int htscore)
    {
        TextView homeTeamScoreDisplay = (TextView) findViewById(R.id.hometeamscore);
        homeTeamScoreDisplay.setText(htscore);
    }

    /**
     * The onClickListener uses the onclick method declared in the button in xml file
     * The method is called when the home try (button) is clicked.
     * Adds 5 to the home team score every time the home try button is clicked
     * @see android.view.View.OnClickListener
     * @param view The view that was clicked
     */
    public void hometry(View view)
    {

        homeTeamScore = homeTeamScore + 5;
        homeTeam(homeTeamScore);
    }
    /**
    The onClickListener uses the onclick method declared in the button in xml file
    * The method is called when the home conversion (button) is clicked.
     * Adds 2 to the home team score every time the home conversion button is clicked
    * @see android.view.View.OnClickListener
    * @param view The view that was clicked
    */
    public void homeconv(View view)
    {
        homeTeamScore = homeTeamScore + 2;
        homeTeam(homeTeamScore);
    }
    /**
     * The onClickListener uses the onclick method declared in the button in xml file
     * The method is called when the home pentaly (button) is clicked.
     * Adds 3 to the home team score every time the home penalty button is clicked
     * @see android.view.View.OnClickListener
     * @param view The view that was clicked
     */
    public void homepen(View view)
    {

        homeTeamScore = homeTeamScore + 5;
        homeTeam(homeTeamScore);
    }
    /**
     *the away team score display
     * will be increased by the score buttons when clicked
     * @param atscore the away team score
     */
    private void awayTeam(int atscore)
    {
        TextView awayTeamScoreDisplay = (TextView) findViewById(R.id.awayteamscore);
        awayTeamScoreDisplay.setText("" + atscore);
    }

    /**
     * The onClickListener uses the onclick method declared in the button in xml file
     * The method is called when the away try (button) is clicked.
     * Adds 5 to the away team score every time the away try button is clicked
     * @see android.view.View.OnClickListener
     * @param view The view that was clicked
     */
    public void awaytry(View view)
    {

        awayTeamScore = awayTeamScore + 5;
        awayTeam(awayTeamScore);
    }

    /**
     * The onClickListener uses the onclick method declared in the button in xml file
     * The method is called when the away conversion (button) is clicked.
     * Adds 2 to the away team score every time the away conversion button is clicked
     * @see android.view.View.OnClickListener
     * @param view The view that was clicked
     */
    public void awaycon(View view)
    {

        awayTeamScore = awayTeamScore + 2;
        awayTeam(awayTeamScore);
    }

    /**
     * The onClickListener uses the onclick method declared in the button in xml file
     * The method is called when the away penalty (button) is clicked.
     * Adds 3 to the home team score every time the away penalty button is clicked
     * @see android.view.View.OnClickListener
     * @param view The view that was clicked
     */
    public void awaypen(View view)
    {

        awayTeamScore = awayTeamScore + 3;
        awayTeam(awayTeamScore);
    }

    /**
     * resets the score down to zero
     * The onClickListener uses the onclick method declared in the button in xml file
     * assigns a value of 0 to both teams
     * @see android.view.View.OnClickListener
     * @param view The view that was clicked
     */
    public void resetButton(View view)
    {
        homeTeamScore = 0;
        awayTeamScore = 0;
        homeTeam(0);
        awayTeam(0);

    }

    /**
     * The onClickListener uses the onclick method declared in the button in xml file
     * sets up the intent to start the email activity
     * @see android.view.View.OnClickListener
     * @param view The view that was clicked
     */
    public void emailresult (View view)
    {
        Intent intent = new Intent(this, Email.class);
        startActivity(intent);
    }

    /**
     * The onClickListener uses the onclick method declared in the button in xml file
     * sets up the toast where when the summary button is clicked the summary of the scores will populate for a short period of time.
     * @param view the view that was clicked
     */
    public void showsummary (View view)
    {

        Toast.makeText(getApplicationContext(), "SCORE\n" + getHome() + homeTeamScore + "\n" + getAway() + awayTeamScore, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"****Statistics:*****",Toast.LENGTH_SHORT);

    }

    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rugby_counter, menu);
        return true;
    }

    /**
     *
     * @param item
     * @return
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
