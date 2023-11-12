package com.example.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {
    private ImageView imageViewSonuc;
    private TextView textViewSonuc;
    private Button tekrarOyna;

    private Boolean sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        tekrarOyna=findViewById(R.id.tekrarOyna);
        imageViewSonuc=findViewById(R.id.imageViewSonuc);
        textViewSonuc=findViewById(R.id.textViewSonuc);

        sonuc=getIntent().getBooleanExtra("sonuc",false);
        if (sonuc){

            textViewSonuc.setText("Tebrikler kazandınız...");
            imageViewSonuc.setImageResource(R.drawable.winner);
        }else {
            textViewSonuc.setText("Üzgünüm kaybettiniz...");
            imageViewSonuc.setImageResource(R.drawable.lose);
        }

        tekrarOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yeniIntent = new Intent(SonucActivity.this,GameActivity.class);
                startActivity(yeniIntent);
                finish();
            }
        });

    }
}