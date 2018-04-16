package xyz.sumeshmajhi.www.sakam.Cate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import xyz.sumeshmajhi.www.sakam.Cate.RowData;
import xyz.sumeshmajhi.www.sakam.R;

import java.util.List;
/**
 * Created by saGen on 14-03-2018.
 */

public class MyAdapter extends BaseAdapter
{

    Context applicationContext;
    List<RowData> rowDatas;

    public MyAdapter(Context applicationContext, List<RowData> rowDatas) {
        this.applicationContext=applicationContext;
        this.rowDatas=rowDatas;
    }

    @Override
    public int getCount() {
        return rowDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return rowDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class MyViewHolder
    {
        TextView textView1;


    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder myViewHolder=null;
        if(view==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.row_data,null);
            myViewHolder=new MyViewHolder();
            myViewHolder.textView1=(TextView) view.findViewById(R.id.title);
            RowData rowData=rowDatas.get(i);

            myViewHolder.textView1.setText(rowData.getMain_title());

            view.setTag(myViewHolder);

        }
        else
        {
            myViewHolder=(MyViewHolder)view.getTag();
        }

        return view;
    }
}
