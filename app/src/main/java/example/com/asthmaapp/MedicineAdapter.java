package example.com.asthmaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Thekiller on 04-Jun-16.
 */
class Medicine{
    String name;
    boolean selected=false;

    public Medicine(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
public class MedicineAdapter extends ArrayAdapter<Medicine>{
    private List<Medicine> MedicineList;
    private Context context;
    public MedicineAdapter(List<Medicine> MedicineList, Context context) {
        super(context, R.layout.custom_layout,MedicineList);
        this.MedicineList=MedicineList;
        this.context=context;
    }
    private static class MedicineHolder{
        public TextView T1;

    }
    private static class MedicineHolder2{
        public CheckBox C1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        MedicineHolder holder = new MedicineHolder();
        MedicineHolder2 holder2 = new MedicineHolder2();
        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.custom_layout,null);
            holder.T1 = (TextView) v.findViewById(R.id.text_custom) ;
            holder2.C1=(CheckBox)v.findViewById(R.id.check_boc_custom);

          //  holder.C1.setOnCheckedChangeListener((FourthActivity) context);
        }
        else{
            holder =(MedicineHolder) v.getTag();
        }
        Medicine m = MedicineList.get(position);
        holder.T1.setText(m.getName());
        holder2.C1.setChecked(m.isSelected());
        holder2.C1.setTag(m);
        return v;
    }
}
