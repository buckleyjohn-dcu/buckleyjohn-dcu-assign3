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

public class RugbyCounter extends AppCompatActivity {
    int homeTeamScore = 0;
    int awayTeamScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rugby_counter);
    }
    public String getHome()
    {
        EditText editHomeTeam = (EditText) findViewById(R.id.teamhome);
        String home = editHomeTeam.getText().toString();
        return home+ ": ";
    }
    public String getAway()
    {
        EditText editAwayTeam = (EditText) findViewById(R.id.teamaway);
        String away = editAwayTeam.getText().toString();
        return away+ ": ";
    }


    private void homeTeam(int htscore)
    {
        TextView homeTeamScoreDisplay = (TextView) findViewById(R.id.hometeamscore);
        homeTeamScoreDisplay.setText("" + htscore);
    }
    public void hometry(View view)
    {

        homeTeamScore = homeTeamScore + 5;
        homeTeam(homeTeamScore);
    }

    public void homeconv(View view)
    {

        homeTeamScore = homeTeamScore + 2;
        homeTeam(homeTeamScore);
    }

    public void homepen(View view)
    {

        homeTeamScore = homeTeamScore + 5;
        homeTeam(homeTeamScore);
    }

    private void awayTeam(int atscore)
    {
        TextView awayTeamScoreDisplay = (TextView) findViewById(R.id.awayteamscore);
        awayTeamScoreDisplay.setText("" + atscore);
    }
    public void awaytry(View view)
    {

        awayTeamScore = awayTeamScore + 5;
        awayTeam(awayTeamScore);
    }

    public void awaycon(View view)
    {

        awayTeamScore = awayTeamScore + 2;
        awayTeam(awayTeamScore);
    }

    public void awaypen(View view)
    {

        awayTeamScore = awayTeamScore + 3;
        awayTeam(awayTeamScore);
    }

    public void resetButton(View view)
    {
        homeTeamScore = 0;
        awayTeamScore = 0;
        homeTeam(0);
        awayTeam(0);

    }

    public void emailresult (View view)
    {
        Intent intent = new Intent(this, Email.class);
        startActivity(intent);
    }


    public void showsummary (View view)
    {

        Toast.makeText(getApplicationContext(), "SCORE\n" + getHome() + homeTeamScore + "\n" + getAway() + awayTeamScore, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"****Statistics:*****",Toast.LENGTH_SHORT);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rugby_counter, menu);
        return true;
    }

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
