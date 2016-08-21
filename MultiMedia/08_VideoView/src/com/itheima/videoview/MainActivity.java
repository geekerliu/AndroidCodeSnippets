package com.itheima.videoview;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (!LibsChecker.checkVitamioLibs(this)) {return;}
		
		VideoView vv = (VideoView) findViewById(R.id.vv);
		
		vv.setVideoPath("sdcard/4.rmvb");
		vv.start();
		
		vv.setMediaController(new MediaController(this));
	}
}
