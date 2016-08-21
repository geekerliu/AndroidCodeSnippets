package com.itheima.musicplayer;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

	static Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			Bundle bundle = msg.getData();
			int duration = bundle.getInt("duration");
			int currentPostition = bundle.getInt("currentPosition");
			sb.setMax(duration);
			sb.setProgress(currentPostition);
		}
	};
	MusicInterface mi;
	private MyserviceConn conn;
	private Intent intent;
	private static SeekBar sb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sb = (SeekBar) findViewById(R.id.sb);
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				int progress = seekBar.getProgress();
				mi.seekTo(progress);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
			}
		});

		intent = new Intent(this, MusicService.class);
		startService(intent);
		conn = new MyserviceConn();
		bindService(intent, conn, BIND_AUTO_CREATE);
	}

	class MyserviceConn implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mi = (MusicInterface) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
		}
	}

	public void play(View v) {
		mi.play();
	}

	public void continuePlay(View v) {
		mi.continuePlay();
	}

	public void pause(View v) {
		mi.pause();
	}

	public void exit(View v) {
		unbindService(conn);
		stopService(intent);
	}

}
