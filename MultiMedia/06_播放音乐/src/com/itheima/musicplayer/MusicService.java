package com.itheima.musicplayer;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;

public class MusicService extends Service {

	MediaPlayer player;
	private Timer timer;

	@Override
	public IBinder onBind(Intent intent) {
		return new MusicController();
	}

	class MusicController extends Binder implements MusicInterface {

		@Override
		public void play() {
			MusicService.this.play();
		}

		@Override
		public void pause() {
			MusicService.this.pause();
		}

		@Override
		public void continuePlay() {
			MusicService.this.continuePlay();
		}

		@Override
		public void seekTo(int progress) {
			MusicService.this.seekTo(progress);
		}
	}

	@Override
	public void onCreate() {
		super.onCreate();
		player = new MediaPlayer();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		player.stop();
		player.release();
		player = null;
		if (timer != null) {
			timer.cancel();
			timer = null;
		}
	}

	public void play() {
		player.reset();
		try {
			player.setDataSource("sdcard/zxmzf.mp3");
			// player.setDataSource("http://192.168.13.119:8080/bzj.mp3");
			// player.prepare();
			player.prepareAsync();
			// player.start();
			player.setOnPreparedListener(new OnPreparedListener() {
				@Override
				public void onPrepared(MediaPlayer mp) {
					player.start();
					addTimer();
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void continuePlay() {
		player.start();
	}

	public void pause() {
		player.pause();
	}

	public void seekTo(int progress) {
		player.seekTo(progress);
	}

	public void addTimer() {
		if (timer == null) {
			timer = new Timer();
			timer.schedule(new TimerTask() {

				@Override
				public void run() {
					int duration = player.getDuration();
					int currentPosition = player.getCurrentPosition();
					Message msg = MainActivity.handler.obtainMessage();
					Bundle bundle = new Bundle();
					bundle.putInt("duration", duration);
					bundle.putInt("currentPosition", currentPosition);
					msg.setData(bundle);
					MainActivity.handler.sendMessage(msg);
				}
			}, 5, 500);
		}
	}
}
