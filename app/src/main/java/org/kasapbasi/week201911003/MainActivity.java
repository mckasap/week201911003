package org.kasapbasi.week201911003;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    public void SendSms(View v){



    }
}
