package com.example.tp_3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DeuxiemeActivity extends AppCompatActivity {
    EditText messageSend;
    Button send;
    TextView messageRecived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deuxieme);

        ActionBar bar = getSupportActionBar();
        bar.setTitle("Tow Activities");

        messageSend = findViewById(R.id.message_send);
        send = findViewById(R.id.send);
        messageRecived = findViewById(R.id.message_show);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeuxiemeActivity.this, MainActivity.class);
                intent.putExtra("message", messageSend.getText().toString());
                startActivity(intent);
            }
        });


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("message");
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            messageRecived.setText(formattedDate+" : "+value);
        }
    }
}