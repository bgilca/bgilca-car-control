package com.example.bgilca;

import java.util.ArrayList;
import java.util.Random;

import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service implements
		MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,
		MediaPlayer.OnCompletionListener {
	public int dur;
	protected boolean stopper = true;
	private MediaPlayer player;
	private ArrayList<Song> songs;
	int songPosn = 0;
	private final IBinder musicBind = new MusicBinder();
	int dr = 0;
	int ok = 0;
	int drt = 0;

	public void onCreate() {

		super.onCreate();
		// initialize position

		// create player
		player = new MediaPlayer();
		// create the service
		initMusicPlayer();
		songPosn = 0;

	}

	public void initMusicPlayer() {
		player.setAudioStreamType(AudioManager.STREAM_MUSIC); // set player
																// properties
		player.setOnPreparedListener(this);
		player.setOnCompletionListener(this);
		player.setOnErrorListener(this);

	}

	public void getTit() {
		Song titlu = songs.get(songPosn);
		Storage.title = titlu.getTitle();
	}

	public void setList(ArrayList<Song> theSongs) {
		songs = theSongs;
	}

	public class MusicBinder extends Binder {
		MusicService getService() {
			return MusicService.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return musicBind;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		player.stop();
		player.release();
		return false;
	}

	public void onCompletionListener(MediaPlayer mp) {
		playNext();
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		mp.start();
		dr = getDur();
		ok = 1;

	}

	public void setSong(int songIndex) {
		songPosn = songIndex;
	}

	public int getPosn() {
		return player.getCurrentPosition();
	}

	public int getDur() {

		return player.getDuration();
	}

	public boolean isPng() {

		return player.isPlaying();
	}

	public void pausePlayer() {
		player.pause();
		stopper = true;
	}

	public void seek(int posn) {
		player.seekTo(posn);
	}

	public void go() {
		player.start();

	}

	public void playPrev() {

		Random randomGenerator = new Random();
		songPosn = randomGenerator.nextInt(songs.size());
		playSong();

	}

	// skip to next
	public void playNext() {

		if (songPosn < songs.size()) {
			songPosn++;
		} else
			songPosn = 0;
		playSong();

	}

	public void playSong() {
		// Storage.title = null;
		player.reset();// play a song

		Song playSongs = songs.get(songPosn);
		// get id
		long currSong = playSongs.getID();
		// Storage.title = playSongs.getTitle();
		// set uri
		Uri trackUri = ContentUris.withAppendedId(
				android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
				currSong);
		// Storage.title = playSongs.getTitle();
		try {
			player.setDataSource(getApplicationContext(), trackUri);
			// Storage.title=playSongs.getTitle();
		} catch (Exception e) {
			Log.e("MUSIC SERVICE", "Error setting data source", e);
		}
		// Storage.title = playSongs.getTitle();
		player.prepareAsync();
		// Storage.title = playSongs.getTitle();

	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		// songPosn= songPosn+1;
		// playSong();
	}

	public void playNextsh() {
		Random randomGenerator = new Random();
		songPosn = randomGenerator.nextInt(songs.size());
		playSong(); // TODO Auto-generated method stub

	}

}
