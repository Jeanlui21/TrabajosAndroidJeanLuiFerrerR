package com.corps.jeanlui21.projectocalificado3;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{
    DatabaseHelper db;
    EditText e1,e2,e3,d1,d2;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this,SignUpActivity.class);

        db = new DatabaseHelper(this);

         e1 = (EditText) findViewById(R.id.email);
         e2 = (EditText) findViewById(R.id.pass);
         e3 = (EditText) findViewById(R.id.cpass);

         d1 = (EditText) findViewById(R.id.editTextUser);
         d2 = (EditText) findViewById(R.id.NamesandLastnames);

        Button b1 = (Button) findViewById(R.id.register);
        TextView b2 = (TextView) findViewById(R.id.textViewLogin);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();

                String c1 = d1.getText().toString();
                String c2 = d2.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals("")||c1.equals("")||c2.equals("")){
                    Toast.makeText(MainActivity.this, "Campos vacios", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (s2.equals(s3)){
                        Boolean chkemail = db.chkemail(s1);
                        if(chkemail==true){
                             boolean insert = db.insert(s1,s2,c1,c2);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MainActivity.this, "Problemas de Registro", Toast.LENGTH_SHORT).show();
                            }
                            }else{
                            Toast.makeText(MainActivity.this, "Correo ya registrado", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

                startActivity(intent);

            }
        });

    }



}
