package com.wordpress.jesphu.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";

    private EditText m_reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE); // Get string containing message from intent extras.
        TextView textView = (TextView) findViewById(R.id.text_message);
        textView.setText(message);

        m_reply = (EditText) findViewById(R.id.editText_second);
    }

    public void return_reply(View view) {
        String reply = m_reply.getText().toString();

        Intent reply_intent = new Intent();
        reply_intent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, reply_intent);
        finish();
    }
}
