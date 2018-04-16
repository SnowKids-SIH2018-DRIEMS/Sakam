package xyz.sumeshmajhi.www.sakam;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import xyz.sumeshmajhi.www.sakam.R;

/**
 * Created by saGen on 12-03-2018.
 */

public class Listview  extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;

    public Listview(Activity context, String[] web) {
        super(context, R.layout.list_item, web);
        this.context = context;
        this.web = web;


    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(web[position]);
        return rowView;



    }
}