package com.pdbang.glasses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button imageButton = (Button) findViewById(R.id.button1);
		Button vedioButton = (Button) findViewById(R.id.button2);
		
		imageButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, ImageActivity.class);
				startActivity(intent);
			}
			
		});

		vedioButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, VideoActivity.class);
				startActivity(intent);
				
			}
			
		});

	}
}
