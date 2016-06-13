package example.com.asthmaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FourthActivity extends AppCompatActivity {
    Button B1,B3,B5;
    CheckBox C1;
    ListView L1;
    //ArrayList<Medicine> adapter;
    //MedicineAdapter madatapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fourth );
        B1=(Button)findViewById(R.id.button4);
        B3 = (Button)findViewById(R.id.button6);
        B5 = (Button)findViewById(R.id.button5);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Main2.class);
                startActivity(i);
            }
        });
        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FifthActivity.class);
                startActivity(i);
            }
        });
   //   displayMedicineList();
       populateListView();

    }

   /*private void displayMedicineList() {
        adapter = new ArrayList<Medicine>();
        adapter.add(new Medicine("Accolate"));
        adapter.add(new Medicine("Advair Diskus"));
        adapter.add(new Medicine("Advair HFA"));
        adapter.add(new Medicine("Aerospan HFA®"));
        adapter.add(new Medicine("Alupent®"));
        adapter.add(new Medicine("Alvesco®"));
        adapter.add(new Medicine("Asmanex®"));

        madatapter = new MedicineAdapter(adapter,this);
        L1.setAdapter(madatapter);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int pos = L1.getPositionForView(buttonView);
        if(pos!= ListView.INVALID_POSITION)
        {
            Medicine m = adapter.get(pos);
            m.setSelected(isChecked);
            Toast.makeText(
                    this,
                    "Clicked on Medicine: " + m.getName(), Toast.LENGTH_SHORT).show();
        }

    }*/

   private void populateListView() {
        String[] medicine = {"Accolate","Advair Diskus", "Advair HFA","Aerospan HFA®","Alupent®","Alvesco®","Asmanex®"};
        ArrayAdapter adapter= new ArrayAdapter<String>(this,R.layout.custom_layout,R.id.text_custom,medicine);
        ListView L1 = (ListView)findViewById(R.id.listView_fourth);
        L1.setAdapter(adapter);
    }

}
