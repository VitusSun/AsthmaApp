package example.com.asthmaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2 extends AppCompatActivity {
    Button B1,B2,B3,B4,B5,B6;
    TextView T1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        B1 = (Button) findViewById( R.id.b1 );
        B2 = (Button) findViewById( R.id.b2 );
        B3 = (Button) findViewById( R.id.b3 );
        B4 = (Button) findViewById( R.id.b4 );
        B5 = (Button) findViewById( R.id.b5 );
        B6 = (Button) findViewById( R.id.b6 );
        T1= (TextView) findViewById( R.id.textView );
        B1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext(),MainActivity.class );
                startActivity( i );
            }
        } );
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FourthActivity.class);
                startActivity(i);
            }
        });
    }

}
