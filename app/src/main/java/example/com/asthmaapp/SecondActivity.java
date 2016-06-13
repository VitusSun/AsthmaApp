package example.com.asthmaapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    Database db;
    Button Sign_in;
    TextView T1;
    TextView T2;
    CheckBox c;
    String S1, S2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Sign_in = (Button) findViewById(R.id.button2);
        T1= (TextView) findViewById(R.id.editText) ;
        T2=(TextView) findViewById(R.id.editText2) ;
        db= new Database(this);
        T1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1.setText("");
            }
        });

        T2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T2.setText("");
            }
        });
        c = (CheckBox)findViewById( R.id.check_Box1 );
        c.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked)
                {
                    T2.setTransformationMethod ( PasswordTransformationMethod.getInstance());
                }else{
                    T2.setTransformationMethod( HideReturnsTransformationMethod.getInstance());

                }

            }
        } );
        button_click();



    }
    public void button_click(){
        Sign_in.setOnClickListener( new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            Cursor res=db.get_values(T1.getText().toString(),T2.getText().toString());
                                            if(res.getCount()==0)
                                            {
                                                Toast.makeText( SecondActivity.this, "No Entry Found", Toast.LENGTH_LONG ).show();
                                                return;
                                            }
                                            else
                                            {
                                                Intent i = new Intent( getApplicationContext(), Main2.class );
                                                startActivity( i );
                                                onPause();

                                            }

                                        }
                                    }
        );
    }
    protected void onPause(){
        super.onPause();
        finish();
    }


}


