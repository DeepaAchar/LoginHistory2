package com.example.deepa.loginhistory;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editTextUName,editTextpwd,editTextconfirmPwd;
    private Button buttonReg;

    private String userName,userPwd,userConPwd;
    private Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        register();
    }

    public void register(){
        editTextUName=(EditText)findViewById(R.id.editTextUNameLog);
        editTextpwd=(EditText)findViewById(R.id.editTextPwdLog);
        editTextconfirmPwd=(EditText)findViewById(R.id.editTextConPwdReg);
        buttonReg=(Button)findViewById(R.id.buttonRegNow);

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=editTextUName.getText().toString();
                userPwd=editTextpwd.getText().toString();
                userConPwd=editTextconfirmPwd.getText().toString();

                if(!userPwd.equals(userConPwd)) {

                    Toast.makeText(getBaseContext(), "password does not match with the confirm password", Toast.LENGTH_LONG).show();
                    editTextUName.setText("");
                    editTextpwd.setText("");
                    editTextconfirmPwd.setText("");
                }
                else{
                    DatabaseOperations regDb=new DatabaseOperations(context);
                    regDb.insertOperation(regDb,userName,userPwd);
                    Toast.makeText(getBaseContext(),"You are registered successfully!", Toast.LENGTH_LONG).show();
                    finish();

                }
            }
        });
    }
}
