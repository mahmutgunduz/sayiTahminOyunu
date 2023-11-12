package com.example.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private EditText sayiGir;
    private TextView kalanHak, artirAzalt;
    private Button buttonTahminEt;
    private int sayac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        buttonTahminEt = findViewById(R.id.buttonTahminEt);
        sayiGir = findViewById(R.id.sayiGir);
        kalanHak = findViewById(R.id.kalanHak);
        artirAzalt = findViewById(R.id.artirAzalt);


        int ssss = getIntent().getIntExtra("difficult", 0);

        sayac = sayacNumber(ssss);
        int randomNumber = createRandomNumber(ssss);
        buttonTahminEt.setOnClickListener(view -> {




            int tahmin = Integer.parseInt(sayiGir.getText().toString());
            if (tahmin>33){

                Toast.makeText(getApplicationContext(),"hatali tusladiniz lutfen 0-33 arasinda bir sayi girin",Toast.LENGTH_SHORT).show();
            }
            sayac = sayac - 1;




            if (tahmin == randomNumber) {
                Intent yeniIntent = new Intent(GameActivity.this, SonucActivity.class);
                yeniIntent.putExtra("sonuc",true);
                startActivity(yeniIntent);
                finish();
            }
            if (tahmin < randomNumber) {
                artirAzalt.setText("arttir");
                kalanHak.setText("kalan hak :" + sayac);
            }
            if (tahmin > randomNumber) {
                artirAzalt.setText("azalt");
                kalanHak.setText("kalan hak :" + sayac);
            }
            if (sayac == 0) {
                Intent yeniIntent = new Intent(GameActivity.this, SonucActivity.class);
                yeniIntent.putExtra("sonuc",false);
                startActivity(yeniIntent);
                finish();
            }

            sayiGir.setText("");



        });


    }

    private int createRandomNumber(int ssss) {
        Random random = new Random();
        int randomNumber = 0;

        if (ssss == 1) {
            // KOLAY BLOGUUUU
            randomNumber = random.nextInt(33);

        } else if (ssss == 2) {
            randomNumber = random.nextInt(50);

        } else if (ssss == 3) {
            randomNumber = random.nextInt(100);
        }

        return randomNumber;

    }

    private int sayacNumber(int ssss) {
        int sayac = 0;


        if (ssss == 1) {
            sayac = 7;

        } else if (ssss == 2) {
            sayac = 5;

        } else if (ssss == 3) {
            sayac = 3;

        }

        return sayac;
    }



}