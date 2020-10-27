package com.example.fragmentorientation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentorientation.recyclerview.utils.MyAdapter;
import com.example.fragmentorientation.recyclerview.utils.RecyclerViewClickListener;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list_view);

        // Custom Adapter for Recycler View
        myAdapter = new MyAdapter(getContext(), getResources().getStringArray(R.array.list_item),
                getResources().getStringArray(R.array.list_description));
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Adding onClickListener to Recycler view
        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), recyclerView,
                (v, position) -> {
                    if (position >= 0 && position < myAdapter.getItemCount()) {
                        Log.d("List-Item", getResources().getStringArray(R.array.list_description)[position]);
                        this.itemCommunicator.send(position);
                    }
                }));
        return view;
    }

    public interface ItemCommunicator {
        public void send(int pos);
    }
}