package com.kylelawson.talkingtoddlers;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

public class TopBarActivity extends Fragment {

    Switch text_toggle;
    SharedPreferences textingState = getActivity().getSharedPreferences("TEXTING", Context.MODE_PRIVATE);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_top_bar, container, false);

        text_toggle = (Switch) getActivity().findViewById(R.id.texting_toggle);

        if(textingState != null){
            if(textingState.getInt("STATE", 0 ) != 0){

                text_toggle.setChecked(true);

            }else{

                text_toggle.setChecked(false);

            }
        }

        text_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textingState.getInt("STATE", 0) == 0){

                    SharedPreferences.Editor editor = textingState.edit();
                    editor.putInt("STATE", 1).apply();
                    text_toggle.setChecked(true);

                }else{

                    SharedPreferences.Editor editor = textingState.edit();
                    editor.putInt("STATE", 0).apply();
                    text_toggle.setChecked(false);
                }
            }
        });

        return view;

    }
}
