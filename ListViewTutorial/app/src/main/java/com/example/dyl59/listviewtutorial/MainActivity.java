package com.example.dyl59.listviewtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected List<HashMap<String, String>> UnitListArray;
    protected SimpleAdapter MyListAdapter;

    protected Button addButton;
    protected EditText addEditText;
    //protected ListView unitList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        UnitListArray = new ArrayList<HashMap<String, String>>();
        String[] colHEAD = new String[] {"CODE","UNITS","SEMESTER"};
        int[] dataCell = new int[] {R.id.UnitCode,R.id.UnitName,R.id.Semester};
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("CODE", "FIT5183");
        map.put("UNITS", "Mobile and Distributed Computing");
        map.put("SEMESTER","Sem 2A 2017");
        UnitListArray.add(map);
        HashMap<String,String> map1 = new HashMap<String,String>();
        map1.put("CODE", "FIT5184");
        map1.put("UNITS", "System");
        map1.put("SEMESTER","Sem 2A 2017");
        UnitListArray.add(map1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView unitList = (ListView)this.findViewById(R.id.listView);
        MyListAdapter = new SimpleAdapter(this,UnitListArray,R.layout.list_view,colHEAD,dataCell);
        unitList.setAdapter(MyListAdapter);

        initAddUnitListeners();
    }

    protected void addMap(HashMap<String, String> ma){
        if(!ma.isEmpty()){
            //UnitListArray = new ArrayList<HashMap<String, String>>();
            String[] colHEAD = new String[] {"CODE","UNITS","SEMESTER"};
            int[] dataCell = new int[] {R.id.UnitCode,R.id.UnitName,R.id.Semester};
            //UnitListArray.add(UnitListArray.size(), ma);
            UnitListArray.add(ma);
            setContentView(R.layout.activity_main);

            ListView unitList = (ListView)this.findViewById(R.id.listView);
            MyListAdapter = new SimpleAdapter(this,UnitListArray,R.layout.list_view,colHEAD,dataCell);
            unitList.setAdapter(MyListAdapter);
        }
    }

    protected void sendToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    protected void initAddUnitListeners() {
        addButton = (Button) this.findViewById(R.id.button);
        addEditText = (EditText) this.findViewById(R.id.editText);
        this.addButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String newUnit = addEditText.getText().toString();
                if(newUnit.length() > 0) {
                    String[] unitsArray = newUnit.split(",");
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("CODE", unitsArray[0]);
                    map.put("UNITS", unitsArray[1]);
                    map.put("SEMESTER", unitsArray[2]);
                    addMap(map);
                }
                else{
                    sendToast("input data");
                }
            }
        });
    }

}
