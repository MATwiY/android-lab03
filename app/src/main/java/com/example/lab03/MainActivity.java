package com.example.lab03;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.example.lab03.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk FAB", Toast.LENGTH_SHORT).show();
                Intent intencja = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intencja, REQUEST_IMAGE_CAPTURE);
            }
        });
    }

    public void kliknij(View obj){
        Toast.makeText(getApplicationContext(), "kliknięto przycisk Button", Toast.LENGTH_SHORT).show();
        Intent intencja = new Intent(this, LoginActivity.class);
        startActivity(intencja);
    }

    public void randKlik(View obj){
        Random random = new Random();
        int r = random.nextInt(10) + 1;

        Toast.makeText(getApplicationContext(), "Wylosowana wartość to : " + r, Toast.LENGTH_SHORT).show();
        ImageView btn = findViewById(R.id.randBtn);

        if(r < 3) {
            btn.setImageResource(R.drawable.draw1_foreground);
        }
        else if(r < 6){
            btn.setImageResource(R.drawable.draw3_foreground);
        }
        else if(r > 6){
            btn.setImageResource(R.drawable.draw2_foreground);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE){
            if(resultCode == RESULT_OK){
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                ConstraintLayout lay = (ConstraintLayout) findViewById(R.id.cont);
                lay.setBackground(new BitmapDrawable(getResources(), imageBitmap));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case(R.id.action_settings):
                Toast.makeText(getApplicationContext(), "kliknięto przycisk " + R.id.action_settings, Toast.LENGTH_SHORT).show();
                break;
            case(R.id.action_volume):
                Toast.makeText(getApplicationContext(), "kliknięto przycisk " + R.id.action_volume, Toast.LENGTH_SHORT).show();
                break;
            case(R.id.action_profile):
                Toast.makeText(getApplicationContext(), "kliknięto przycisk " + R.id.action_profile, Toast.LENGTH_SHORT).show();
                break;
            case(R.id.action_logout):
                Toast.makeText(getApplicationContext(), "kliknięto przycisk " + R.id.action_logout, Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
