package com.example.fragmentorientation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragmentorientation.api.data.AvengersList;

public class DescriptionActivity extends AppCompatActivity {

    private DescFragment descFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        descFragment = (DescFragment) getSupportFragmentManager().findFragmentById(R.id.desc_fragment_main);
        int pos = getIntent().getIntExtra("pos", 0);
        descFragment.setDescription(AvengersList.getAvengers().get(pos));
    }
}