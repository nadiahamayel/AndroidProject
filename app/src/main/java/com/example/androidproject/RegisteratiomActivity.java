package com.example.androidproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisteratiomActivity extends AppCompatActivity {
    EditText Name;
    EditText password;
    EditText phone;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);


        Name = findViewById(R.id.first);

        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        register = findViewById(R.id.registration);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }

            private void checkDataEntered() {
                if (isEmpty(Name)) {
                    Name.setError("first name is required!");
                }



            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", Name.getText().toString());
        outState.putString("password", password.getText().toString());
        outState.putString("phone", phone.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Name.setText(savedInstanceState.getString("name"));
        password.setText(savedInstanceState.getString("password"));
        phone.setText(savedInstanceState.getString("phone"));
    }


    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}
