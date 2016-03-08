package com.example.deepa.loginhistory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public int status=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userRegistration();
        userLogin();
    }

    public void userRegistration(){

        Button reg=(Button)findViewById(R.id.buttonRegister);
        reg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startActivity(new Intent("com.example.deepa.loginhistory.RegistrationActivity"));
            }
        });
    }

    public void userLogin(){

        Button log=(Button)findViewById(R.id.buttonLoginNow);
        log.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                status=1;
                Bundle b=new Bundle();
                b.putInt("status",status);
                startActivity(new Intent("com.example.deepa.loginhistory.LoginActivity").putExtras(b));
            }
        });
    }

}
