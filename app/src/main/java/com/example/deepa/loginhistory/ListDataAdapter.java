package com.example.deepa.loginhistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deepa on 3/5/2016.
 */
public class ListDataAdapter extends ArrayAdapter {
    List userList=new ArrayList();

    //Inner class
    static class LayoutHandler{
        TextView UNAME,PWD;
    }

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Object object){
        super.add(object);
        userList.add(object);
    }

    public int getCount(){
        return userList.size();
    }

    public Object getItem(int position){
        return userList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutHandler handler=new LayoutHandler();
        if(row==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            handler=new LayoutHandler();
            handler.UNAME=(TextView)row.findViewById(R.id.textViewName);
            handler.PWD=(TextView)row.findViewById(R.id.textViewPasscode);
            row.setTag(handler);
        }
        else{
            handler=(LayoutHandler)row.getTag();
        }

        DataProvider dataProvider=(DataProvider)this.getItem(position);
        handler.UNAME.setText(dataProvider.getName());
        handler.PWD.setText(dataProvider.getPwd());

        return row;
    }
}
