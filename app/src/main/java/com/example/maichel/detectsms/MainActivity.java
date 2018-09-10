package com.example.maichel.detectsms;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    YourObserver yourObserver;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //detectOutgoingSms(this);



    }

    private void detectOutgoingSms (Context context) {

        ContentResolver contentResolver = context.getContentResolver();
        contentResolver.registerContentObserver(Uri.parse("content://sms/out"),true, new YourObserver(new Handler()));
        Toast.makeText(this, "you've sent a message successfully", Toast.LENGTH_LONG).show();
    }

    public void msgBody () {

        // save the message to the SD card here
        Uri uriSMSURI = Uri.parse("content://sms/out");
        Cursor cur = this.getContentResolver().query(uriSMSURI, null, null, null, null);
        // this will make it point to the first record, which is the last SMS sent
        if (cur != null)
            cur.moveToFirst();
        String content = cur.getString(cur.getColumnIndex("body"));
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(content);
    }
}
