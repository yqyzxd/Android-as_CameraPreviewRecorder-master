package com.phuket.tour.camera;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity {

	static {
		System.loadLibrary("native_encoder-lib");
	}
	
	private Button start_preview_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start_preview_btn = (Button) findViewById(R.id.start_preview);
		start_preview_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
				== PackageManager.PERMISSION_GRANTED) {
					Intent intent = new Intent(MainActivity.this, CameraPreviewActivity.class);
					startActivity(intent);
				}else {
					ActivityCompat.requestPermissions(MainActivity.this,new String[]{ Manifest.permission.CAMERA},1024);
				}
			}
		});
	}


	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode==1024 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
			Intent intent = new Intent(MainActivity.this, CameraPreviewActivity.class);
			startActivity(intent);
		}
	}
}
