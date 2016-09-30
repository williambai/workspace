package com.pdbang.glasses;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ImageActivity extends Activity{

	private LayoutInflater layoutInflater;
	private RelativeLayout layoutView;
	private ImageView imageView;
//	private int displayWidth;
//	private int displayHeight;
	private Boolean scaleToggle = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		setContentView(R.layout.image_scale);
		layoutView = (RelativeLayout) this.findViewById(R.id.layout1);

		/* 取得屏幕分辨率的大小 */  
//        DisplayMetrics dm = new DisplayMetrics();  
//        getWindowManager().getDefaultDisplay().getMetrics(dm);  
//		displayWidth = dm.widthPixels;
//		displayHeight =  dm.heightPixels;
//		Log.v("debug","displayWidth=" + displayWidth + "; displayHeight=" + displayHeight);

		/* 加载图片 */
		imageView = (ImageView)this.findViewById(R.id.imageView1);
		Bitmap bm = getImageFromAssetsFile("1.jpg");
		imageView.setImageBitmap(bm);
		layoutView.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Log.v("debug","Image is clicked.");
				if(!scaleToggle){
//					Bitmap bm = getImageFromAssetsFile("1.jpg");
//					imageView.setImageBitmap(bm);
					int width = layoutView.getWidth();
					int height = layoutView.getHeight();
					imageView.layout(width/2, 0,width, height/2);
				}else{
//					Bitmap bm = getImageFromAssetsFile("2.jpg");
//					imageView.setImageBitmap(bm);
					int width = layoutView.getWidth();
					int height = layoutView.getHeight();
					imageView.layout(0, 0,width,height);
				}
				scaleToggle = !scaleToggle;
			}
			
		});
		Log.v("debug","ImageActivity to front.");
	}
	
	private Bitmap getImageFromAssetsFile(String fileName)  
	  {  
	      Bitmap image = null;  
	      AssetManager am = getResources().getAssets();  
	      try  
	      {  
	          InputStream is = am.open(fileName);  
	          image = BitmapFactory.decodeStream(is);  
	          is.close();  
	      }  
	      catch (IOException e)  
	      {  
	          e.printStackTrace();  
	      }  
	  
	      return image;  
	  
	  } 
}
