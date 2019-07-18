package com.chaacho.courseramenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.chaacho.courseramenu.menu.ActivityAbout;
import com.chaacho.courseramenu.menu.ActivitySettings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvDaniel = findViewById(R.id.tvDaniel);
        registerForContextMenu(tvDaniel);
        ImageView imageView = (ImageView)findViewById(R.id.ivMenuPop);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Debemos ver que es lo que ha pulsado.
        switch (item.getItemId()){
            //Devolverá el id del buton pulsado
            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;
            case R.id.mSettings:
                Intent intent1 = new Intent(this, ActivitySettings.class);
                startActivity(intent1);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mEliminar:
                Toast.makeText(this,getResources().getString(R.string.eliminar),Toast.LENGTH_LONG).show();

                break;
            case R.id.mEditar:
                Toast.makeText(this,getResources().getString(R.string.editar),Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    public void menuPopUp(View v){
        ImageView imageView = findViewById(R.id.ivMenuPop);
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.getMenuInflater().inflate(R.menu.men_popup,popupMenu.getMenu());
        popupMenu.show();

    }
}
