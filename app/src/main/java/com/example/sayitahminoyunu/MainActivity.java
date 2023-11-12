package com.example.sayitahminoyunu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    private Button buttonEasy, buttonHard, buttonNormal;

    private ImageButton infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEasy = findViewById(R.id.buttonEasy);
        buttonNormal = findViewById(R.id.buttonNormal);
        buttonHard = findViewById(R.id.buttonHard);


        Intent yeniIntent = new Intent(MainActivity.this, GameActivity.class);

        buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yeniIntent.putExtra("difficult",1);
                startActivity(yeniIntent);
            }
        });


        buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yeniIntent.putExtra("difficult",2);
                startActivity(yeniIntent);

            }
        });


        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yeniIntent.putExtra("difficult",3);
                startActivity(yeniIntent);

            }
        });



        infoButton = findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHowToPlayDialog();
            }
        });
    }

    private void showHowToPlayDialog() {
        // AlertDialog oluştur
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Başlık ve mesaj ayarla
        builder.setTitle("Nasıl Oynanır?");
        builder.setMessage("Oyunda rastgele bir sayı tutulur ve sizden bu sayıyı tahmin etmeniz istenir. "
                + "Tahmin hakkınız kadar sayı girebilirsiniz. "
                + "Her tahmininizde, tutulan sayı ile girdiğiniz sayı karşılaştırılır ve size ipucu verilir. "
                + "İpucular arasında 'Arttır', 'Azalt' veya 'Doğru' bulunabilir. "
                + "Oyunun amacı, tutulan sayıyı en az tahmin hakkınızla doğru bir şekilde bulmaktır."
                        + "\"Kolay\" modda, rastgele bir sayı 0 ile 33 arasında tutulur.\n" +
                "Toplam 7 tahmin hakkınız vardır.\n" +
                "Her tahmininizde, tutulan sayı ile girdiğiniz sayı karşılaştırılır ve size ipucu verilir. İpucular arasında \"Arttır\", \"Azalt\" veya \"Doğru\" bulunabilir.\n" +

                "\"Orta\" modda, rastgele bir sayı 0 ile 55 arasında tutulur.\n" +
                "Toplam 5 tahmin hakkınız vardır.\n" +
                "Her tahmininizde, tutulan sayı ile girdiğiniz sayı karşılaştırılır ve size ipucu verilir. İpucular arasında \"Arttır\", \"Azalt\" veya \"Doğru\" bulunabilir.\n" +

                "\"Zor\" modda, rastgele bir sayı 0 ile 100 arasında tutulur.\n" +
                "Toplam 3 tahmin hakkınız vardır.\n" +
                "Her tahmininizde, tutulan sayı ile girdiğiniz sayı karşılaştırılır ve size ipucu verilir. İpucular arasında \"Arttır\", \"Azalt\" veya \"Doğru\" bulunabilir.\n" +
                "Oyunun amacı, tutulan sayıyı en az tahmin hakkınızla doğru bir şekilde bulmaktır.");


        // Tamam butonu ekleyerek dialog penceresini göster
        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Tamam butonuna tıklandığında yapılacak işlemleri buraya ekleyebilirsiniz.
            }
        });

        // AlertDialog'u göster
        AlertDialog dialog = builder.create();
        dialog.show();


    }
}