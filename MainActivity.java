package com.example.checkboxandtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="ListViewExample";

    public ListView listView;
    public Button selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.listView=(ListView) findViewById(R.id.listView);
        this.selected=(Button) findViewById(R.id.selected);
        this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i(TAG,"onItemClick:"+position);
                CheckedTextView v=(CheckedTextView) view;
                boolean currentCheck=v.isChecked();
                ItemsDetail items=(ItemsDetail) listView.getItemAtPosition(position);
                items.setActive(!currentCheck);
            }
        });
        //
        this.selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printSelectedItems();
            }
        });
        this.intiListViewData();
    }
    private void intiListViewData(){
        ItemsDetail apple=new ItemsDetail("Apple","Fruit");
        ItemsDetail milk=new ItemsDetail("Milk","Dairy product");
        ItemsDetail pizza=new ItemsDetail("pizza","fast food");

        ItemsDetail[] items = new ItemsDetail[]{apple,milk,pizza};

        ArrayAdapter<ItemsDetail>arrayAdapter=new ArrayAdapter<ItemsDetail>(this, android.R.layout.simple_list_item_checked,items);

        this.listView.setAdapter(arrayAdapter);

        for (int i=0;i< items.length;i++) {
            this.listView.setItemChecked(i,items[i].isActive());
        }
    }
    public void printSelectedItems(){

        SparseBooleanArray sp =listView.getCheckedItemPositions();
        StringBuilder sb =new StringBuilder();

        for (int i=0;i<sp.size();i++)
        {
            if (sp.valueAt(i)==true) {
                ItemsDetail items = (ItemsDetail) listView.getItemAtPosition(i);

                String s= items.getItemName();
                sb =sb.append(""+s);
            }
    }
        Toast.makeText(this,"Selected Items are::"+sb.toString(),Toast.LENGTH_LONG).show();
    }
}