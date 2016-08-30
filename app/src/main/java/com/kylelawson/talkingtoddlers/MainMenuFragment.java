package com.kylelawson.talkingtoddlers;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Kyle Lawson on 8/30/2016. All work is self-coded unless otherwise noted.
 */
public class MainMenuFragment extends Fragment {

    Button categories;
    Button actions;
    Button emotions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.main_fragment_menu, container, false);

        categories = (Button) view.findViewById(R.id.categories);
        categories.setBackgroundColor(Color.parseColor("#F62A37"));

        actions = (Button) view.findViewById(R.id.actions);
        actions.setBackgroundColor(Color.parseColor("#24A4D5"));

        emotions = (Button) view.findViewById(R.id.emotions);
        emotions.setBackgroundColor(Color.parseColor("#FB8D2D"));

        return view;
    }


}
