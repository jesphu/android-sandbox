package com.wordpress.jesphu.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"; // Define key for intent extra.

    private EditText message_edit_text; // Object to hold EditText object.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message_edit_text = (EditText) findViewById(R.id.editText_main);
    }

    public void launch_second_activity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class); // Switching activities (from main to second).

        String message = message_edit_text.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message); // Sending additional info (with the intent defined above).
        startActivity(intent);
    }
}
