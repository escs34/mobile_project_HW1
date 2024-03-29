package com.example.hw1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    boolean is_Logined = false;

    private boolean is_valid(String login_id, String login_pass){

        DbOpenHelper mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        Cursor iCursor = mDbOpenHelper.selectColumns();
        while(iCursor.moveToNext()){
            String tempID = iCursor.getString(iCursor.getColumnIndex("userid"));
            String tempPass = iCursor.getString(iCursor.getColumnIndex("pass"));

            if(tempID.equals(login_id)){
                if(tempPass.equals(login_pass)){
                    is_Logined = true;
                    break;
                }
            }
        }
        return is_Logined;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText inputted_id = (EditText)findViewById(R.id.input_id);
                EditText inputted_pass = (EditText)findViewById(R.id.input_pass);

                String id_string = inputted_id.getText().toString();
                String pass_string = inputted_pass.getText().toString();
                if (is_valid(id_string, pass_string)){
                    Intent intent = new Intent(getApplicationContext(),
                            ThirdActivity.class);
                    startActivity(intent);
                }
                else{
                    System.out.printf("Wrong ID or Passs");
                }
            }
        });


        Button btnSignin = (Button) findViewById(R.id.btnSignin);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });
    }

}

