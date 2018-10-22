package com.corps.jeanlui21.projectocalificado3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        findViewById(R.id.buttonLogin).setOnClickListener(this);
        findViewById(R.id.textViewSignup).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.buttonLogin:
                startActivity(new Intent(this, Main2Activity.class));
                break;

            case R.id.textViewSignup:
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
