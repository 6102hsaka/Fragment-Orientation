package com.example.fragmentorientation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentorientation.api.data.AvengersList;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemCommunicator {

    private ListFragment listFragment;
    private DescFragment descFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.list_fragment_main);
        listFragment.setItemCommunicator(this);

        descFragment = (DescFragment) getSupportFragmentManager().findFragmentById(R.id.desc_fragment_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_item_1:
                Toast.makeText(this, R.string.menu_item_1+" selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_2:
                Toast.makeText(this, R.string.menu_item_2+" selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_3:
                Toast.makeText(this, R.string.menu_item_3+" selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void send(int pos) {
        if(descFragment!=null) {
            descFragment.setDescription(AvengersList.getAvengers().get(pos));
        } else {
            Intent intent = new Intent(this, DescriptionActivity.class);
            intent.putExtra("pos", pos);
            startActivity(intent);
        }
    }
}