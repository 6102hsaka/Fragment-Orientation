package com.example.fragmentorientation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fragmentorientation.api.model.Avenger;

public class DescFragment extends Fragment {

    TextView name, realname, team, firstappearance, createdby, publisher, bio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_desc, container, false);
        name = (TextView) view.findViewById(R.id.desc_frag_name);
        realname = (TextView) view.findViewById(R.id.desc_frag_real_name);
        team = (TextView) view.findViewById(R.id.desc_frag_team);
        firstappearance = (TextView) view.findViewById(R.id.desc_frag_first_appearance);
        createdby = (TextView) view.findViewById(R.id.desc_frag_created_by);
        publisher = (TextView) view.findViewById(R.id.desc_frag_publisher);
        bio = (TextView) view.findViewById(R.id.desc_frag_bio);
        return view;
    }

    public void setDescription(Avenger avenger) {
        if (avenger != null) {
            name.setText("Name: " + avenger.getName());
            realname.setText("RealName: " + avenger.getRealname());
            team.setText("Team: " + avenger.getTeam());
            firstappearance.setText("First Appearance in: " + avenger.getFirstappearance());
            createdby.setText("Created By: " + avenger.getCreatedby());
            publisher.setText("Publisher: " + avenger.getPublisher());
            bio.setText(avenger.getBio());
        }
    }
}