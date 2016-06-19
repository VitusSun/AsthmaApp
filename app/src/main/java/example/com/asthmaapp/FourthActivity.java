package example.com.asthmaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FourthActivity extends AppCompatActivity {
    Button B3;
    CheckBox C1;
    ListView L1;
    TextView t1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        t1 = (TextView) findViewById(R.id.text_custom);
        B3 = (Button) findViewById(R.id.button5);
        L1 = (ListView) findViewById(R.id.listView);
        populateListView();
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FifthActivity.class);
                startActivity(i);
            }
        });
        // OnCheckedboxClicked();
    }

    private void populateListView() {
        String[] medicine = {"Accolate", "Advair Diskus", "Advair HFA", "Aerospan HFA®", "Alupent®", "Alvesco®", "Asmanex®"};
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.custom_layout, R.id.text_custom, medicine);
        L1.setAdapter(adapter);
    }
}
