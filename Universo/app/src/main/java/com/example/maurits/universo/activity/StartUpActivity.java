package com.example.maurits.universo.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maurits.universo.R;
import com.example.maurits.universo.data.HttpGetRequest;
import com.example.maurits.universo.model.UserSessionManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import org.json.JSONException;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class StartUpActivity extends AppCompatActivity implements LocationListener {

    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        session = new UserSessionManager(getApplicationContext());

        Button startButton = (Button) findViewById(R.id.button_start);

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
        Button imageButton = (Button) findViewById(R.id.tweetButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tweetIntent = new Intent(Intent.ACTION_SEND);
                tweetIntent.putExtra(Intent.EXTRA_TEXT, "I learned so much about the univers with Universo check out the app right now !!!");
                tweetIntent.setType("text/plain");

                PackageManager packManager = getPackageManager();
                List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY);

                boolean resolved = false;
                for (ResolveInfo resolveInfo : resolvedInfoList) {
                    if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                        tweetIntent.setClassName(
                                resolveInfo.activityInfo.packageName,
                                resolveInfo.activityInfo.name);
                        resolved = true;
                        break;
                    }
                }
                if (resolved) {
                    startActivity(tweetIntent);
                } else {
                    Intent intent = new Intent(StartUpActivity.this, TweetActivity.class);
                    startActivity(intent);
                }
            }
        });

//        try {
//            getNighttime(50.9189, 5.455);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//
//        }
        getLocation();

    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void getNighttime(double lat, double longt) throws ExecutionException, InterruptedException, JSONException {
        //Some url endpoint that you may have
        String latitude = String.valueOf(lat);
        String logitude = String.valueOf(longt);
        //Toast.makeText(MainActivity.this, "lat = " + latitude + "   long = " + logitude, Toast.LENGTH_SHORT).show();
        String myUrl = "https://api.sunrise-sunset.org/json?lat=" + latitude + "&lng=" + logitude;
        //String to place our result in
        String sunset;
        //Instantiate new instance of our class
        HttpGetRequest getRequest = new HttpGetRequest();
        //Perform the doInBackground method, passing in our url
        sunset = getRequest.execute(myUrl).get();
        TextView sunsetview = (TextView) findViewById(R.id.sunsetview);
        if (sunset != null) {
            sunsetview.setText("Stars will be visible at " + sunset);
        } else {
            sunsetview.setText("there was a problem determining when you can watch to the stars please try again later");
        }
    }

    void getLocation() {
        try {
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
            //Location l = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        } catch (SecurityException e) {
            e.printStackTrace();
            TextView sunsetview = (TextView) findViewById(R.id.sunsetview);
            sunsetview.setText("Problem with getting your current location");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        session.mGoogleApiClient.connect();
    }

    @Override
    public void onBackPressed() {
    }

    private void googleLogout() {

        Auth.GoogleSignInApi.signOut(session.mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {

                session.mGoogleApiClient.disconnect();
            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {
        TextView sunsetview = (TextView) findViewById(R.id.sunsetview);
        try {
            double lat = location.getLatitude();
            double lon = location.getLongitude();
            getNighttime(lat, lon);
        } catch (ExecutionException e) {
            sunsetview.setText("Problem location1");
            e.printStackTrace();
        } catch (InterruptedException e) {
            sunsetview.setText("Problem location2");
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
            sunsetview.setText("Problem location3");
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {
        Toast.makeText(StartUpActivity.this, "Please enable GPS know when you can watch to the stars.", Toast.LENGTH_SHORT).show();
    }
}
