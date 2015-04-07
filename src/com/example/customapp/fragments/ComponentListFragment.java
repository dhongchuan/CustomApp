package com.example.customapp.fragments;

import java.util.ArrayList;

import com.example.customapp.SlideMenuActivity;
import com.example.customapp.WinXinActivity;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ComponentListFragment extends ListFragment{
	private ArrayList<String> mComponents;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("�����б�");
        init();
    }	
	private void init(){
		mComponents = new ArrayList<String>();
		mComponents.add("�໬�˵�");
		mComponents.add("��΢��");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mComponents);
        setListAdapter(adapter);
    }
	
	@Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = null;
        switch (position){
            case 0:
                i = new Intent(getActivity(), SlideMenuActivity.class);
                break;
            case 1:
            	i = new Intent(getActivity(), WinXinActivity.class);
            
        }
        startActivity(i);
    }
	
}
