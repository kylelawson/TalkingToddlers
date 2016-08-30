package com.kylelawson.talkingtoddlers;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BottomBarActivity extends Fragment {

    Button mom_button;
    Button dad_button;

    SharedPreferences momDadState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_bottom_bar, container, false);

        momDadState = getActivity().getSharedPreferences("MDSTATE", Context.MODE_PRIVATE);


        mom_button = (Button) view.findViewById(R.id.mom_button);
        dad_button = (Button) view.findViewById(R.id.dad_button);

        if(momDadState.getInt("STATE", 0) != 0){
            if(momDadState.getInt("STATE", 1) == 1){

                mom_button.setBackgroundColor(Color.BLUE);
                mom_button.setClickable(false);

                dad_button.setBackgroundColor(Color.LTGRAY);
                dad_button.setClickable(true);

            }else if(momDadState.getInt("STATE", 2) == 2){

                mom_button.setBackgroundColor(Color.LTGRAY);
                mom_button.setClickable(true);

                dad_button.setBackgroundColor(Color.BLUE);
                dad_button.setClickable(false);

            }
        }

        mom_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = momDadState.edit();
                editor.putInt("STATE", 1).apply();

                dad_button.setClickable(true);
                dad_button.setBackgroundColor(Color.LTGRAY);

                mom_button.setClickable(false);
                mom_button.setBackgroundColor(Color.BLUE);
            }
        });

        dad_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = momDadState.edit();
                editor.putInt("STATE", 2).apply();

                dad_button.setClickable(false);
                dad_button.setBackgroundColor(Color.BLUE);

                mom_button.setClickable(true);
                mom_button.setBackgroundColor(Color.LTGRAY);
            }
        });

        return view;
    }
}
