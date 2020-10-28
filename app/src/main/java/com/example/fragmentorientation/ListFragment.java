package com.example.fragmentorientation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentorientation.api.GetAvengersApi;
import com.example.fragmentorientation.api.data.AvengersList;
import com.example.fragmentorientation.api.model.Avenger;
import com.example.fragmentorientation.recyclerview.utils.MyAdapter;
import com.example.fragmentorientation.recyclerview.utils.RecyclerViewClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private ItemCommunicator itemCommunicator;

    public void setItemCommunicator(ItemCommunicator itemCommunicator) {
        this.itemCommunicator = itemCommunicator;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // loading dataset from url
        loadData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list_view);

        // Custom Adapter for Recycler View
        myAdapter = new MyAdapter(getContext());
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Adding onClickListener to Recycler view
        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), recyclerView,
                (v, position) -> {
                    if (position >= 0 && position < myAdapter.getItemCount()) {
                        this.itemCommunicator.send(position);
                    }
                }));
        return view;
    }

    //method to get data from rest Api
    public void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GetAvengersApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetAvengersApi getAvengersApi = retrofit.create(GetAvengersApi.class);
        Call<List<Avenger>> avengersCall = getAvengersApi.getAvengersList();
        avengersCall.enqueue(new Callback<List<Avenger>>() {
            @Override
            public void onResponse(Call<List<Avenger>> call, Response<List<Avenger>> response) {
                AvengersList.setAvengers(response.body());
                myAdapter.update();
            }

            @Override
            public void onFailure(Call<List<Avenger>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public interface ItemCommunicator {
        void send(int pos);
    }
}