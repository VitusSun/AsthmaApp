package example.com.asthmaapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Thekiller on 18-May-16.
 */
public class Database extends SQLiteOpenHelper {
    public static final String Database_Name="user.db";
    public static final String Table_Name="user_table";
    public static final String Col_1="Name";
    public static final String Col_2="Email";
    public static final String Col_3="Password";
    public static final String Col_4="ConfirmPassword";
    public static final String command ="Create Table "+ Table_Name + "(" +
            Col_1+ " TEXT, "+Col_2+" TEXT, "+Col_3+" TEXT, "+Col_4+" TEXT);";



    public Database(Context context) {
        super( context, Database_Name, null, 1 );

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( command );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL( "DROP TABLE IF EXISTS"+Table_Name );
    }
    public boolean insertData(String name, String Email, String Password, String RPassword){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues(  );
        values.put(Col_1,name);
        values.put(Col_2,Email);
        values.put(Col_3,Password);
        values.put(Col_4,RPassword);
        long result=db.insert( Table_Name,null, values );
        return result != -1;
    }
    public Cursor get_values(String name, String Password){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery( "Select Name, Password from "+Table_Name+" WHERE Name = '"+name+"' AND Password = '"+Password+"';",null );
        return res;

    }
}
