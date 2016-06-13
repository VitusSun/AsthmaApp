package example.com.asthmaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

public class FifthActivity extends AppCompatActivity {
    Button B1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fifth );
        B1 =(Button)findViewById(R.id.f_back2);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FourthActivity.class);
                startActivity(i);
            }
        });
        populateListView1();

    }

    private void populateListView1() {
        String[] medicine = {"Accolate","Advair Diskus", "Advair HFA","Aerospan HFA®","Alupent®","Alvesco®","Asmanex®", "Asmanex® HFA","Breo Ellipta®","Deltasone®", "Sterapred®" ,"Medrol®" ,"Cotolone®", "Millipred DP®", "Millipred®", "Prelone®", "Prednisone Intensol®", "Rayos®", "Orapred®", "Pediapred®","Dulera®","Epinephrine Mist®", "Adrenaclick®", "Adrenalin®", "Adrenalin Chloride®", "S2®", "EpiPen Jr® 2-Pak", "Twinject®", "Epipen® 2-Pak", "Auvi-Q"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_layout2,R.id.text_custom1,medicine);
        ListView L1 = (ListView)findViewById(R.id.listView1);
        L1.setAdapter(adapter);


    }
}
