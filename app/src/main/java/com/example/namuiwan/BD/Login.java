package com.example.namuiwan.BD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.namuiwan.BD.DBHELPER.DBhelper;
import com.example.namuiwan.Menued;
import com.example.namuiwan.R;

public class Login extends AppCompatActivity {
    EditText Username;
    Button NuevoUsuario,Volver;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        referenciar();

        NuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Username.getText().toString();
                if(TextUtils.isEmpty(user)){
                    Toast.makeText(Login.this,"Todos los campos tienen que ser requerido",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(DB.checkusername(user) == false){
                        Boolean insert = DB.insertDats(user);
                        if(insert == true){
                            Toast.makeText(Login.this, "Registro existoso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Menued.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(Login.this, "REGISTRO NO ENCONTRADO", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Login.this, "El usuario ya existe ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginIn.class);
                startActivity(intent);
            }
        });
    }
    public void referenciar(){
        Username = findViewById(R.id.Username);
        NuevoUsuario = findViewById(R.id.NuevoUsuario);
        Volver = findViewById(R.id.Volver);
        DB = new DBhelper(this);
    }
}