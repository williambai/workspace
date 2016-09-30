package com.pdbang.glasses;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class VideoActivity extends Activity{

	private RelativeLayout layoutView;
	private SurfaceView surfaceView = null;
	private SurfaceHolder surfaceHolder = null;
	private Camera camera = null;
	private Boolean scaleToggle = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_scale);
		layoutView = (RelativeLayout) this.findViewById(R.id.layout2);

		/* 加载摄像头 */
		surfaceView = (SurfaceView)this.findViewById(R.id.surfaceView1);
		surfaceHolder = surfaceView.getHolder();
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		surfaceHolder.addCallback(new SurfaceHolder.Callback(){

			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				// TODO Auto-generated method stub
				Log.d("debug","surface changed.");
			}

			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				Log.d("debug","surface created.");
				camera = Camera.open();
				try {
					camera.setPreviewDisplay(holder);
					camera.startPreview();//开始预览
					} catch (IOException e) {
					// TODO Auto-generated catch block
					if(null != camera){
						camera.release();
						camera = null;
					}
				}
			}

			@Override
			public void surfaceDestroyed(SurfaceHolder arg0) {
				// TODO Auto-generated method stub
				Log.d("debug","surface destoryed.");
				if(null != camera){
					camera.setPreviewCallback(null);
					camera.stopPreview();
					camera.release();
					camera = null;
				}
			}
			
		});
		
		layoutView.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Log.v("debug","surfaceView is clicked.");
				if(!scaleToggle){
					int width = layoutView.getWidth();
					int height = layoutView.getHeight();
					surfaceView.layout(width/2, 0,width, height/2);
				}else{
					int width = layoutView.getWidth();
					int height = layoutView.getHeight();
					surfaceView.layout(0, 0,width,height);
				}
				scaleToggle = !scaleToggle;
			}
			
		});
		Log.v("debug","VideoActivity to front.");
	}
	
}
