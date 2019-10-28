package com.example.hw1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SecondActivity extends Activity {


    private boolean addToDB(String my_id, String my_pass, String my_name, String my_phone, String my_address){
        DbOpenHelper mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        long result_num = mDbOpenHelper.insertColumn(my_id, my_pass, my_name, my_phone, my_address);

        RadioButton Accept = findViewById(R.id.Accept);

        //if (Accept.getva)
        if (result_num == -1){
            System.out.printf("Something Wrong in add to DB");
            return false;
        }

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Button btnSign_to_DB = (Button) findViewById(R.id.sign_in);
        btnSign_to_DB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText inputted_new_id = (EditText)findViewById(R.id.input_new_id);
                EditText inputted_new_pass  = (EditText)findViewById(R.id.input_new_pass);
                EditText inputted_new_name  = (EditText)findViewById(R.id.input_new_name);
                EditText inputted_new_phone  = (EditText)findViewById(R.id.input_new_phone);
                EditText inputted_new_address  = (EditText)findViewById(R.id.input_new_address);

                String new_id_str = inputted_new_id.getText().toString();
                String new_pass_str = inputted_new_pass.getText().toString();
                String new_name_str = inputted_new_name.getText().toString();
                String new_phone_str = inputted_new_phone.getText().toString();
                String new_address_str = inputted_new_address.getText().toString();

                boolean test_result = addToDB(new_id_str, new_pass_str, new_name_str, new_phone_str, new_address_str);

                AlertDialog.Builder alert = new AlertDialog.Builder(SecondActivity.this);
                alert.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                if (test_result == true){
                    alert.setMessage("가입 결과: id_"+new_id_str + ", pass_" + new_pass_str +" is SUCCESS");
                    alert.show();
                }
                else{
                    alert.setMessage("가입 결과: id_"+new_id_str + ", pass_" + new_pass_str +" is FAILED\n MAYBE invalid ID is inserted.");
                    alert.show();
                }

                System.out.printf("Sign in succeed.");


            }
        });

        Button btnReturn = (Button) findViewById(R.id.go_back);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.printf("Return pushed. Back to main page.");
                finish();
            }
        });

    }

}