package com.example.maurits.universo.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.maurits.universo.R;
import com.example.maurits.universo.model.UserSessionManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class StartUpActivity extends AppCompatActivity {
    
    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        session =  new UserSessionManager(getApplicationContext());

        Button startButton = (Button) findViewById(R.id.button_start);

        Toast.makeText(getApplicationContext(), "Signed in.", Toast.LENGTH_SHORT).show();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(StartUpActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });

        Button signOutButton = (Button) findViewById(R.id.button_signout);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleLogout();
                Intent loginActivity = new Intent(StartUpActivity.this, SignInActivity.class);
                startActivity(loginActivity);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        session.mGoogleApiClient.connect();
    }

    @Override
    public void onBackPressed(){
    }

    private void googleLogout(){

        Auth.GoogleSignInApi.signOut(session.mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                Toast.makeText(getApplicationContext(), "Signed out.", Toast.LENGTH_SHORT).show();
                session.mGoogleApiClient.disconnect();
            }
        });
    }
}