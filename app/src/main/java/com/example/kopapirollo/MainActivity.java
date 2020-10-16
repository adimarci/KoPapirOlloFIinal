package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button ko,papir,ollo;
    private  ImageView user_selection,cpu_selection;
    private int gyozelemSzamlalo=0;
    private int dontetlenSzamlalo=0;
    private int veresegSzamlalo=0;
    private int cpuSzam=0;
    private int userSzam=0;
    private TextView gyozelem;
    private TextView dontetlen;
    private TextView vereseg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();

        ko.setOnClickListener(this);
        papir.setOnClickListener(this);
        ollo.setOnClickListener(this);


        }
        private void init(){

    ko = findViewById(R.id.button_rock);
    papir = findViewById(R.id.button_paper);
    ollo = findViewById(R.id.button_scissor);
    user_selection=findViewById(R.id.imageView);
    cpu_selection=findViewById(R.id.imageView2);
    gyozelem=findViewById(R.id.textView3);
    dontetlen=findViewById(R.id.textView4);
    vereseg=findViewById(R.id.textView5);

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.button_rock:
                user_selection.setImageResource(R.drawable.rock);
                userSzam=1;
                break;

            case R.id.button_paper:
                user_selection.setImageResource(R.drawable.paper);
                userSzam=2;
                break;

            case R.id.button_scissor:
                user_selection.setImageResource(R.drawable.scissors);
                userSzam=3;
                break;
        }

        randomcpu();

        checkWinner();
        eredmenyKiir();
    }


   private void randomcpu(){
       int random = new Random().nextInt(3);

       switch (random){
           case 0:  cpu_selection.setImageResource(R.drawable.rock);
           cpuSzam=1;
           break;
           case 1:  cpu_selection.setImageResource(R.drawable.paper);
           cpuSzam=2;
           break;
           case 2:  cpu_selection.setImageResource(R.drawable.scissors);
           cpuSzam=3;
           break;
       }


   }




    private void checkWinner() {
        if (gyozelemSzamlalo==3 || veresegSzamlalo==3){
            new AlertDialog.Builder(this)
                    .setTitle("Játék vége")
                    .setMessage("Szeretne új játékot kezdeni?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                             gyozelemSzamlalo=0;
                             dontetlenSzamlalo=0;
                             veresegSzamlalo=0;
                        }
                    })


                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.this.finish();
                            System.exit(0);
                        }
                    })

                    .show();
        }
        if (userSzam == cpuSzam) {
            dontetlenSzamlalo++;
            Toast.makeText(this, "Döntetlen", Toast.LENGTH_SHORT).show();
            return;
        }



        if(userSzam == 1){
            if(cpuSzam == 2){
                veresegSzamlalo++;
                Toast.makeText(this, "Vereség", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(cpuSzam == 3){
                gyozelemSzamlalo++;
                Toast.makeText(this, "Győzelem", Toast.LENGTH_SHORT).show();
                return;
            }
        }


        if(userSzam == 2){
            if(cpuSzam == 3){
                veresegSzamlalo++;
                Toast.makeText(this, "Vereség", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(cpuSzam == 1){
                gyozelemSzamlalo++;
                Toast.makeText(this, "Győzelem", Toast.LENGTH_SHORT).show();
                return;
            }
        }


        if(userSzam == 3){
            if(cpuSzam == 1){
                veresegSzamlalo++;
                Toast.makeText(this, "Vereség", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(cpuSzam == 2){
                gyozelemSzamlalo++;
                Toast.makeText(this, "Győzelem", Toast.LENGTH_SHORT).show();
                return;
            }
        }


    }



    private void eredmenyKiir(){
    gyozelem.setText("Győzelem:"+gyozelemSzamlalo);
    dontetlen.setText("Döntetlen:"+dontetlenSzamlalo);
    vereseg.setText("Vereség:"+veresegSzamlalo);
    }

}