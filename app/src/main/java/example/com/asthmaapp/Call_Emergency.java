package example.com.asthmaapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Call_Emergency extends AppCompatActivity {
Button B1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call__emergency);
    B1= (Button) findViewById(R.id.emer_button);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent= new Intent();
                callIntent.setData(Uri.parse("tel:123456789"));
                startActivity(callIntent);
            }
        });
    }
}
