package com.saifytech.student_crud_operation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    
// Register xml elements with java code
    private DatabaseHelper databaseHelper;
    private Student student;
    private List<Student> studentList;
    private StudentAdapter studentAdapter;
    private android.widget.ListView listView;
    private android.widget.Button buttonAdd;
    private android.widget.Button buttonView;
    private android.widget.Button buttonUpdate;
    private android.widget.Button buttonDelete;
    private android.widget.Button buttonDeleteAll;
    private android.widget.EditText editTextName;
    private android.widget.EditText editTextAge;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Initialize xml elements
        registerAllElements();

// Initialize database helper
        databaseHelper = new DatabaseHelper(this);

// Initialize student
        student = new Student();

// Initialize student adapter
        studentList = databaseHelper.getAllStudents();
        studentAdapter = new StudentAdapter(this, studentList);

// Set student adapter to list view
        listView.setAdapter(studentAdapter);

// Add student button click listener
        clickEventOnAllButtons();

    }

    // register all elements id in the mainactivity

    public void registerAllElements() {

        listView = (android.widget.ListView) findViewById(R.id.listViewStudent);
        buttonAdd = (android.widget.Button) findViewById(R.id.buttonAddStudent);
        buttonUpdate = (android.widget.Button) findViewById(R.id.buttonEditStudent);
        buttonDelete = (android.widget.Button) findViewById(R.id.buttonDeleteStudent);

    }


    public void clickEventOnAllButtons() {

            buttonAdd.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    Student student = new Student();
                    student.setName("Taher");
                    student.setAge(20);
                    student.setId(1);
                    databaseHelper.addStudent(student);
                    studentList.add(student);
                    studentAdapter.notifyDataSetChanged();

                }
            });

            buttonUpdate.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    Student student = new Student();
                    student.setName("Taher Updated");
                    student.setAge(20);
                    student.setId(1);
                    databaseHelper.updateStudent(student);

                    studentList.set(0, student);

                    studentAdapter.notifyDataSetChanged();



                }
            });

            buttonDelete.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {

                    databaseHelper.deleteStudent(0);
                    studentList.remove(0);
                    studentAdapter.notifyDataSetChanged();

                }
            });

    }
 


}