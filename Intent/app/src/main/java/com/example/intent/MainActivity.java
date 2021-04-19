package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editImplisit , editExplisit;
    Button btnImplisit,btnExplisit;
    private String KEY_NAME = "NAMA" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editImplisit = findViewById(R.id.linkImplisit);
        btnImplisit = findViewById(R.id.BtnintenImplisit);

        editExplisit = findViewById(R.id.linkExplisit);
        btnExplisit = findViewById(R.id.BtnintentExplisit);


        btnImplisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editImplisit.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });


        btnExplisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nama = editExplisit.getText().toString();
                    if( nama != "" ){
                        Intent  i = new Intent(MainActivity.this, ExplicitActivity.class);
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplication(), "Masukkan Nama Dulu " , Toast.LENGTH_SHORT);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplication(),"ERROR, Coba Lagi !",Toast.LENGTH_SHORT);
                }


            }
        });


    }
}