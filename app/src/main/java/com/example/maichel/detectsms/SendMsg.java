package com.example.maichel.detectsms;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by MAICHEL on 17/10/2017.
 */

public class SendMsg extends BroadcastReceiver {

    ContentResolver contentResolver;
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "broadcast receiver top", Toast.LENGTH_LONG).show();
        contentResolver = context.getContentResolver();
        contentResolver.registerContentObserver(Uri.parse("content://sms/out"), true, new YourObserver(new Handler()));
        Toast.makeText(context, "broadcast receiver bottom", Toast.LENGTH_LONG).show();
    }

   /* public ContentResolver getContentResolver() {
        return contentResolver;
    }
    */
}
