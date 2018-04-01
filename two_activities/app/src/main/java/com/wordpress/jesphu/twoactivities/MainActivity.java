package com.wordpress.jesphu.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText message_edit_text; // Object to hold EditText object.

    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"; // Define key for intent extra.
    public static final int TEXT_REQUEST = 1;

    // Temp holders for reply header and reply TextViews.
    private TextView reply_head_text_view;
    private TextView reply_text_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message_edit_text = (EditText) findViewById(R.id.editText_main);

        reply_head_text_view = (TextView) findViewById(R.id.text_header_reply);
        reply_text_view = (TextView) findViewById(R.id.text_message_reply);
    }

    public void launch_second_activity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class); // Switching activities (from main to second).

        String message = message_edit_text.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message); // Sending additional info (with the intent defined above).

        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int request_code, int result_code, Intent data) {
        super.onActivityResult(request_code, result_code, data); // Super refers to immediate parent class object.

        // Test that correct intent result is processed.
        if (request_code == TEXT_REQUEST) {
            if (result_code == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                // Set invisible variables visible and display reply string.
                reply_head_text_view.setVisibility(View.VISIBLE);
                reply_text_view.setText(reply);
                reply_text_view.setVisibility(View.VISIBLE);
            }
        }

    }
}
