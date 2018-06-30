package com.example.saintilien.simpletodo;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {
   ArrayList<String> items;
   ArrayAdapter<String> itemsAdapter;
   ListView lvItems;
   private final int CODE_REQUEST = 20;
   boolean hasFocus = false;
   int pos ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //the behavior of the application
       lvItems =(ListView)findViewById(R.id.lvItems);
       items = new ArrayList<>();
       readitems();
       itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,items);
       lvItems.setAdapter(itemsAdapter);

       setupListViewListener();

    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener(){

                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {


                        final int posi = pos;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if (!isFinishing()){
                                    new AlertDialog.Builder(MainActivity.this)
                                            .setTitle("Delete this item")
                                            .setMessage("Do you really want to delete this item?")
                                            .setCancelable(false)
                                            .setNegativeButton("Yes", new DialogInterface.OnClickListener(){
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                    items.remove(posi);
                                                    itemsAdapter.notifyDataSetChanged();
                                                    writeItems();

                                                }


                                            })
                                            .setPositiveButton("No", null).show();


                                }

                            }

                        });

                        return true;
                    }
                });

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
                intent.putExtra("view", items.get(position));
                pos = position;
                hasFocus = true;
                intent.putExtra("focus", hasFocus);
                startActivityForResult(intent, CODE_REQUEST);
                }
        });

    }

    public void onAddItem(View v){
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems();
        Toast.makeText(this, itemText, Toast.LENGTH_SHORT).show();
    }

    public void readitems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir,"todofile.txt");
         // creation du fichier s'il n'en existe pas
        if(!todoFile.exists()){
            try{
                todoFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

     try{
        items =new ArrayList<String>(FileUtils.readLines(todoFile));
      }catch (IOException e){
        items = new ArrayList<String>();
      }
    }

    private void writeItems(){
        File filesDir = getFilesDir();
      File todoFile = new File(filesDir,"todofile.txt");
        // creation du fichier s'il n'en existe pasx+
      if(!todoFile.exists()){
          try{
              todoFile.createNewFile();
          }catch (IOException e){
              e.printStackTrace();
          }
      }
       try{
           FileUtils.writeLines(todoFile,items);
      }catch (IOException e){
           e.printStackTrace();
      }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == CODE_REQUEST){

            String etItemToEdit = data.getExtras().getString("etItemToEdit");
            items.remove(pos);

            itemsAdapter.insert(etItemToEdit,pos);
            writeItems();

            Toast.makeText(this, etItemToEdit, Toast.LENGTH_SHORT).show();


        }
    }
}
