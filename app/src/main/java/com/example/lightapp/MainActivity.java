package com.example.lightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private CameraManager cameraManager;
    private String cameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraManager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    public void onButton(View view){
        try {
            cameraManager.setTorchMode(cameraId,true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }
    public  void offButton (View view){
        try {
            cameraManager.setTorchMode(cameraId,false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

}