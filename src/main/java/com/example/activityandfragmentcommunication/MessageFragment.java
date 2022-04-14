package com.example.activityandfragmentcommunication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MessageFragment extends Fragment {

    KinzaMessageInterface kinzaMessageInterface;

   public interface KinzaMessageInterface{

        void onMessage(String message);
    }


    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        EditText editTextKinza = view.findViewById(R.id.editTextKinza);

        Button buttonKinza = view.findViewById(R.id.buttonKinza);

        buttonKinza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String kinza = editTextKinza.getText().toString();

                kinzaMessageInterface.onMessage(kinza);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Activity activity = getActivity();

        try {

            kinzaMessageInterface = (KinzaMessageInterface) activity;

        }

        catch (ClassCastException e) {
           throw new ClassCastException(activity.toString() + "must impliment onMessage");
        }
        }
}