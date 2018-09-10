package com.example.maichel.detectsms;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MAICHEL on 17/10/2017.
 */

public class YourObserver extends ContentObserver {

    MainActivity mainActivity;

    public YourObserver(Handler handler) {
        super(handler);
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        // save the message to the SD card here
        mainActivity.msgBody();


    }
}
