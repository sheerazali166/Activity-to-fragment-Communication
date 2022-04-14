package com.example.activityandfragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MessageFragment.KinzaMessageInterface {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.kinzaContainer) != null){

            if (savedInstanceState != null){

                return;
            }

            fragmentManager = getSupportFragmentManager();

            MessageFragment messageFragment = new MessageFragment();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                    .add(R.id.kinzaContainer, messageFragment, null);

            fragmentTransaction.commit();
        }
    }

    @Override
    public void onMessage(String message) {

       TextView textViewMessage = findViewById(R.id.textViewMessage);

       textViewMessage.setText(message);
    }
}