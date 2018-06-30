package com.example.saintilien.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    String  newItem;
    EditText etItemToEdit;
    boolean focus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        newItem = getIntent().getStringExtra("view");
        focus = getIntent().getBooleanExtra("focus", focus);


        etItemToEdit = (EditText)findViewById(R.id.etItemToEdit);
        etItemToEdit.setText(newItem);


        etItemToEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if (b){
                    ((EditText) etItemToEdit).setSelection(((EditText) etItemToEdit).getText().length());
                }
            }
        });

    }



    public void onSubmit (View v){


        etItemToEdit = (EditText)findViewById(R.id.etItemToEdit);

        Intent data = new Intent();


        data.putExtra("etItemToEdit", etItemToEdit.getText().toString());


        setResult(RESULT_OK, data);
        finish();




    }





}





