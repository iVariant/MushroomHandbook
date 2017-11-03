package com.example.ixvar.mushroomhandbook.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ixvar.mushroomhandbook.R;

public class MainActivity extends AppCompatActivity {

    public static String productType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonSeasonsClick(View v){
        startActivity(new Intent(this,SeasonsActivity.class));
    }

    public void buttonFavoritesClick(View v){
        startActivity(new Intent(this,FavoritesActivity.class));
    }

    public void buttonMushroomsClick(View v){
        productType = "Mushrooms";
        startActivity(new Intent(this,ProductActivity.class));
    }

    public void buttonBerriesClick(View v){
        productType = "Berries";
        startActivity(new Intent(this,ProductActivity.class));
    }

    public void buttonPlantsClick(View v){
        productType = "Plants";
        startActivity(new Intent(this,ProductActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.action_about :
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.menu_about)
                        .setMessage(R.string.menu_text)
                        .setIcon(R.drawable.ic_spider_menu)
                        .setCancelable(false)
                        .setNegativeButton(R.string.menu_close,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
