package com.saifytech.student_crud_operation;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


    //This is listview adapte for students with custom layout for each item in the list view  student_list_item.xml is used as a layout for each item in the list view  textViewName,textViewAge are the textview id in the student_list_item.xml

public class StudentAdapter extends android.widget.BaseAdapter {
    private Context context;
    private List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.student_list_row, parent, false);
        }
        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        TextView textViewAge = (TextView) convertView.findViewById(R.id.textViewAge);
        Student student = studentList.get(position);
        textViewName.setText(student.getName());
        textViewAge.setText(String.valueOf(student.getAge()));
        return convertView;
    }
}










