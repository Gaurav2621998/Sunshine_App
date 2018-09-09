package com.example.android.sunshine;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class IntentActivity extends Activity {

    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        t1=(TextView)findViewById(R.id.t1);

        t2=(TextView)findViewById(R.id.t2);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage=Uri.parse("https://www.udacity.com");

                Intent i=new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(i);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addressquary="1600 Amphitheatre Parkway,CA";

                Uri.Builder builder=new Uri.Builder();
                builder.scheme("geo")
                        .path("0,0")
                        .query(addressquary);
                Uri addressUri=builder.build();
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(addressUri);

                if(i.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(i);
                }
                else {
                    Toast.makeText(IntentActivity.this, "No tool to handle address", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
