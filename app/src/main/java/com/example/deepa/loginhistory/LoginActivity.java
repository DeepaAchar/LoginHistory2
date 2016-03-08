package com.example.deepa.loginhistory;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUName,editTextpwd;
    private Button buttonReg;

    private String userName,userPwd;
    private Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();

    }
    public void login(){
        editTextUName=(EditText)findViewById(R.id.editTextUNameLog);
        editTextpwd=(EditText)findViewById(R.id.editTextPwdLog);

        Button log=(Button)findViewById(R.id.buttonLoginNow);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=getIntent().getExtras();
                int status=b.getInt("status");
                userName=editTextUName.getText().toString();
                userPwd=editTextpwd.getText().toString();
                Boolean search=false;
                String name;

                if(status==1){
                    Toast.makeText(getBaseContext(),"Loading",Toast.LENGTH_LONG).show();
                    DatabaseOperations dop=new DatabaseOperations(context);
                    Cursor cur=dop.selectOperation(dop);
                    cur.moveToFirst();
                    do{
                        if(userName.equals(cur.getString(0)) && userPwd.equals(cur.getString(1))){
                            search=true;
                            name=userName;
                        }
                    }while(cur.moveToNext());
                    
                    if(search==true){
                        Toast.makeText(getBaseContext(), "You have logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent("com.example.deepa.loginhistory.ListUsersActivity"));

                    }

                    else{
                        Toast.makeText(getBaseContext(), "We do not find you registered, please register", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                }
            }
        });
    }


}
