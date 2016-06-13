package example.com.asthmaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button SignIn;
    Button Create_New;
    TextView display;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Database(this);

        SignIn =(Button) findViewById(R.id.button);
        Create_New =(Button) findViewById(R.id.button1);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(i);


            }
        });
        Create_New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ThridActivity.class);
                startActivity(i);
            }
        });


    }
    protected void onPause(){
       super.onPause();
       finish();
    }
}
