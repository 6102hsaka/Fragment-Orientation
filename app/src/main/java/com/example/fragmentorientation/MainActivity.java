package com.example.fragmentorientation;

import android.content.Intent;
import android.os.Bundle;

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