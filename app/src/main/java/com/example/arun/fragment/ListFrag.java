package com.example.arun.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {

    ItemSelected activity;

    public interface ItemSelected{
        void onItemSelected(int index);
    }
    public ListFrag() {
        // Required empty public constructor
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //getting the list
        String[] data = getResources().getStringArray(R.array.pieces);

        //type of the list
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,data));

        //phone is in landscape mode
        if(this.getActivity().findViewById(R.id.layout_portrait) == null)
        {
            activity.onItemSelected(0);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        //postion of the item clicked
        activity.onItemSelected(position);


    }
}
