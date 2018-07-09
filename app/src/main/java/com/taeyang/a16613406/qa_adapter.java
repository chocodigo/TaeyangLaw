package com.taeyang.a16613406;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.taeyang.a16613406.R;

import java.util.ArrayList;

/**
 * Created by lee on 2018-05-21.
 */

public class qa_adapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> itemArrayList;

    public qa_adapter(Context context, ArrayList<String> itemArrayList){
        super(context, R.layout.lv_row,itemArrayList);
        this.context=context;
        this.itemArrayList=itemArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView=inflater.inflate(R.layout.lv_row,parent,false);

        TextView TitleView=(TextView)rowView.findViewById(R.id.label);

        TitleView.setText(itemArrayList.get(position));

        return rowView;
    }
}
