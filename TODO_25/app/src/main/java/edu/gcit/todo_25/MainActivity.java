package edu.gcit.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editSurName, editTextId, mMarks;
    Button btnAdd, btnUpdate, btnDelete, btnView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb= new DatabaseHelper(this);
        editName = findViewById(R.id.Name);
        editSurName = findViewById(R.id.SName);
        editTextId = findViewById(R.id.Id_no);
        mMarks=findViewById(R.id.Marks);
        btnAdd=findViewById(R.id.button_add);
        btnView = findViewById(R.id.button_view);
        btnDelete = findViewById(R.id.button_delete);
        btnUpdate = findViewById(R.id.button_update);
        viewAll();
        UpdateData();
        DeleteData();
    }
    public void DeleteData(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not deleted", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }
    public void UpdateData(){
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editName.getText().toString(),
                                editSurName.getText().toString(),mMarks.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(MainActivity.this,"Data is updated",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not updated", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }

    public void AddData(View view) {
        boolean isInserted = myDb.insertData(editTextId.getText().toString(),
                editName.getText().toString(),
                editSurName.getText().toString(),
                mMarks.getText().toString());
        if(isInserted==true)
            Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this,"Data not inserted", Toast.LENGTH_SHORT).show();
    }
    public void viewAll(){
        btnView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Cursor res= myDb.getAllData();
                       if(res.getCount()== 0){
                           showMessage("Error","Nothing found");
                           return;
                       }
                       StringBuffer buffer = new StringBuffer();
                       while(res.moveToNext()){
                           buffer.append("Studets Id:"+ res.getString(0)+ "\n");
                           buffer.append("First name:"+ res.getString(1)+ "\n");
                           buffer.append("Last name:"+ res.getString(2)+ "\n");
                           buffer.append("ITW202 marks:"+ res.getString(3)+ "\n\n");
                       }
                       //Show all data
                       showMessage("lists of Students",buffer.toString());
                    }
                }
        );

    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}