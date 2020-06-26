package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Luis Liranzo 19-0734
    private EditText Name;
    private EditText Password;
    private Button Ok;
    private Button  Clean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.etuser);
        Password = (EditText) findViewById(R.id.etPassword);
        Ok  = (Button) findViewById(R.id.bttok);
        Clean = (Button) findViewById(R.id.bttclean);

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar(Name.getText().toString(), Password.getText().toString());
            }
        });
        Clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name.setText("");
                Password.setText("");
            }
        });
    }
    private void validar(String username, String pass)
    {
        if((username.isEmpty())|| pass.isEmpty())
        {
            Toast toast = Toast.makeText(getApplicationContext(),"Debe completar todos los campos",Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            if ((username.equals("unibe")) && (pass.equals("12345"))) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Usuario o Password incorrecto", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
