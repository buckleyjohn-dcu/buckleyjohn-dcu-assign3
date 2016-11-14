package com.example.john.assign22016johnbuckley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Explicit2 extends AppCompatActivity {

    @Override
    // oncreate method of the activity lifecycle
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit2);
        TtoAddress = (TextView) findViewById(R.id.mailto);
        subject = (TextView) findViewById(R.id.mailSubject);

    public void onIntentReturn(View v) {

        Intent backtoMainIntent = new Intent(Explicit2.this, MainActivity.class);
        backtoMainIntent.putExtra("NameValue", toAdress.getText().toString());
        backtoMainIntent.putExtra("EmailValue", subject.getText().toString());

        setResult(RESULT_OK, backtoMainIntent);
        finish();
    }
}
