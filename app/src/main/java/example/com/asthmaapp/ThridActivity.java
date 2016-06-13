package example.com.asthmaapp;

import android.content.Intent;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThridActivity extends AppCompatActivity {
    TextView T1, T2, T3, T4;
    Button B1;
    CheckBox c;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_thrid2 );
        T1 = (TextView) findViewById( R.id.editText3 );
        T2 = (TextView) findViewById( R.id.editText4 );
        T3 = (TextView) findViewById( R.id.editText5 );
        T4 = (TextView) findViewById( R.id.editText6 );
        T1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1.setText( "" );
            }
        } );
        T2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T2.setText( "" );
            }
        } );
        T3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T3.setText( "" );
            }
        } );
        T4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T4.setText( "" );
            }
        } );
        B1 = (Button) findViewById( R.id.button3 );
        c = (CheckBox)findViewById( R.id.check_Box );
        c.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked)
                {
                    T3.setTransformationMethod ( PasswordTransformationMethod.getInstance());
                    T4.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    T3.setTransformationMethod( HideReturnsTransformationMethod.getInstance());
                    T4.setTransformationMethod( HideReturnsTransformationMethod.getInstance());
                }

            }
        } );
        db = new Database( this );
        add_data();

    }

    public void add_data() {
        B1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateName(T1.getText().toString()))
                {
                    T1.setError("Invalid Name");
                    T1.requestFocus();
                }
                else if(!validateEmail(T2.getText().toString())){
                    T2.setError( "Invalid Email" );
                    T2.requestFocus();
                }else if(!validatePassword(T3.getText().toString()))
                {
                    T3.setError("Invalid Password");
                    T3.requestFocus();

                }
                    else{

                if(T3.getText().toString().equals( T4.getText().toString())) {
                    System.out.println(T1.getText().toString());
                    boolean is_inserted = db.insertData( T1.getText().toString(), T2.getText().toString(), T3.getText().toString(), T4.getText().toString() );
                    if (is_inserted == true)
                        Toast.makeText( ThridActivity.this, "Data is Inserted", Toast.LENGTH_LONG ).show();
                    else
                        Toast.makeText( ThridActivity.this, "Data is Not Inserted", Toast.LENGTH_LONG ).show();

                    Intent i = new Intent( getApplicationContext(), SecondActivity.class );
                    startActivity( i );
                }else
                {
                    Toast.makeText( ThridActivity.this,"Password Doesn't Match", Toast.LENGTH_LONG).show();
                }
            }}

        } );
    }

    private boolean validateName(String Name) {
        String name = "Name";
        Pattern pattern = Pattern.compile( name );
        Matcher matcher = pattern.matcher( Name );
        return matcher.matches();
    }

    private boolean validatePassword(String Password) {
        return Password != null && Password.length() > 5;
    }

    private boolean validateEmail(String email) {
        String Email_Pattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern pattern = Pattern.compile( Email_Pattern );
        Matcher matcher = pattern.matcher( email );
        return matcher.matches();
    }

    protected void onPause(){
        super.onPause();
        finish();
    }
}

