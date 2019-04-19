package org.kasapbasi.week201911003;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPhone;
    EditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPhone=(EditText)findViewById(R.id.etNumber);
        etMessage=(EditText)findViewById(R.id.etMessage);


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1461: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(etPhone.getText().toString(), null, etMessage.getText().toString(), null, null);

                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }

    public void SendSms(View v){

 if(ContextCompat.checkSelfPermission(this,
         Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
     if (ActivityCompat.shouldShowRequestPermissionRationale(this,
             Manifest.permission.SEND_SMS)) {
     } else {
         ActivityCompat.requestPermissions(this,
                 new String[]{Manifest.permission.SEND_SMS},
                 1461);
     }


    }else{

     SmsManager smsManager = SmsManager.getDefault();
     String[] phones =etPhone.getText().toString().split(",");

     for(String s:phones)
     smsManager.sendTextMessage(s, null, etMessage.getText().toString(), null, null);

 }


    }


}
