package xyz.sumeshmajhi.www.sakam.Cate;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xyz.sumeshmajhi.www.sakam.Assam.Assam_schools_details;
import xyz.sumeshmajhi.www.sakam.CurrentLocation;
import xyz.sumeshmajhi.www.sakam.Jharkhand.Jharkhand_schools_details;
import xyz.sumeshmajhi.www.sakam.Odisha.Odisha_State_deatils;
import xyz.sumeshmajhi.www.sakam.R;
import xyz.sumeshmajhi.www.sakam.fragment.State_schools_details;
import xyz.sumeshmajhi.www.sakam.jharkhand_map;

public class CategoryActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener
{

    ListView listView;
    List<RowData> rowDatas;
    FloatingActionButton fab;

    String main_tile[]/*,sub_title[]*/;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_category);


        /*---floating----*/



        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CategoryActivity.this,CurrentLocation.class);
                startActivity(intent);
            }
        });



        listView=(ListView)findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        rowDatas=new ArrayList<RowData>();

        main_tile=getResources().getStringArray(R.array.india_states);
        //sub_title=getResources().getStringArray(R.array.sub_title);

        for(int i=0;i<main_tile.length;i++)
        {
            RowData rowData=new RowData(main_tile[i]);/*sub_title[i]*/
            rowDatas.add(rowData);
        }

        MyAdapter myAdapter=new MyAdapter(getApplicationContext(),rowDatas);
        myAdapter.notifyDataSetChanged();
        listView.setAdapter(myAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


        if (position == 0) {
            Intent intent = new Intent(this, Assam_schools_details.class);
            intent.putExtra("data",rowDatas.get(position));
            startActivity(intent);
        }
        else if (position == 1) {
            Intent intent = new Intent(this, Odisha_State_deatils.class);
            intent.putExtra("data",rowDatas.get(position));
            startActivity(intent);
        }
        else if (position == 2) {
            Intent intent = new Intent(this, Jharkhand_schools_details.class);
            intent.putExtra("data",rowDatas.get(position));
            startActivity(intent);
        }
        else if(position==3) {
            Intent intent = new Intent( CategoryActivity.this, State_schools_details.class );
            intent.putExtra( "data", rowDatas.get( position ) );
            startActivity( intent );
        }else if (position==4) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==5) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==6) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==7) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==8) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==9) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==10) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==11) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==12) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==13) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==14) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==15) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==16) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==17) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }else if (position==18) {
            Toast.makeText( getApplicationContext(),"No data ",Toast.LENGTH_SHORT ).show();
        }

    }
/*
        Intent intent=new Intent(CategoryActivity.this,State_schools_details.class);
        intent.putExtra("data",rowDatas.get(i));
        startActivity(intent);*/

}

