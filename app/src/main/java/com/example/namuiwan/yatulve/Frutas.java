package com.example.namuiwan.yatulve;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.namuiwan.R;

public class Frutas extends AppCompatActivity implements View.OnClickListener {
    ImageView imgUchuvas, imgMora, imgMortino, imgFresas;
    MediaPlayer uchuvas, mora, mortino, fresas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutasve);
        referenciar();
    }
    private void referenciar(){
        imgUchuvas= findViewById(R.id.imgUchuvas);
        imgUchuvas.setOnClickListener(this);
        imgMora=findViewById(R.id.imgMora);
        imgMora.setOnClickListener(this);
        imgMortino=findViewById(R.id.imgMortino);
        imgMortino.setOnClickListener(this);
        imgFresas=findViewById(R.id.imgFresas);
        imgFresas.setOnClickListener(this);

        uchuvas = MediaPlayer.create(this,R.raw.gallinaaa);
        mora = MediaPlayer.create(this,R.raw.venado);
        mortino = MediaPlayer.create(this,R.raw.gatoaa);
        fresas = MediaPlayer.create(this,R.raw.perroaa);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgUchuvas:
                uchuvas.start();
                break;
            case R.id.imgMora:
                mora.start();
                break;
            case R.id.imgMortino:
                mortino.start();
                break;
            case R.id.imgFresas:
                fresas.start();
                break;
        }
    }
}