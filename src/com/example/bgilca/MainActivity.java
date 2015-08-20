package com.example.bgilca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.bgilca.MusicService.MusicBinder;

import android.widget.MediaController.MediaPlayerControl;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.ServiceConnection;

public class MainActivity extends Activity implements MediaPlayerControl {
	Button blade;
	Button navi;
	Button headlight;
	static Button scaunstg;
	public static boolean player = false;
	Button scaundr;
	static Button play;
	Button next;
	Button prev;
	boolean x = false;
	private ArrayList<Song> songList;
	private ListView songView;
	MusicService musicSrv;
	private Intent playIntent;
	private boolean musicBound = false;
	TextView Title, CurrentPos, TotalDur;
	ProgressBar prog;
	Counter progress;
	Button shuffle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);
		// if (savedInstanceState == null) {
		// getFragmentManager().beginTransaction()
		// .add(R.id.container, new PlaceholderFragment()).commit();
		prog = (ProgressBar) findViewById(R.id.progressBar);
		// Counter progress = new Counter(prog, musicSrv);
		// progress.start();

		songView = (ListView) findViewById(R.id.song_list);
		songList = new ArrayList<Song>();
		getSongList();

		Collections.sort(songList, new Comparator<Song>() {
			public int compare(Song a, Song b) {
				return a.getTitle().compareTo(b.getTitle());
			}
		});

		SongAdapter songAdt = new SongAdapter(this, songList);
		songView.setAdapter(songAdt);
		Title = (TextView) findViewById(R.id.titlemain);
		CurrentPos = (TextView) findViewById(R.id.currentposition);
		TotalDur = (TextView) findViewById(R.id.totalduration);
		Typeface digital = Typeface.createFromAsset(this.getAssets(),
				"DS_DIGI.TTF");
		CurrentPos.setTypeface(digital);
		TotalDur.setTypeface(digital);

		// if(playIntent==null){
		// playIntent = new Intent(this, MusicService.class);
		// bindService(playIntent, musicConnection, Context.BIND_AUTO_CREATE);
		// startService(playIntent);
		// }

		blade = (Button) findViewById(R.id.fantab);
		blade.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent vent = new Intent(MainActivity.this, Ventscreen.class);
				startActivity(vent);
				if (progress.isAlive())
					progress.interrupt();
				finish();
			}
		});

		navi = (Button) findViewById(R.id.navi);
		navi.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent nav = new Intent(MainActivity.this, Navi.class);
				startActivity(nav);
				if (progress.isAlive())
					progress.interrupt();
				finish();
			}
		});

		headlight = (Button) findViewById(R.id.head);
		headlight.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent head = new Intent(MainActivity.this, Headlight.class);
				startActivity(head);
				if (progress.isAlive())
					progress.interrupt();
				finish();
			}
		});

		scaunstg = (Button) findViewById(R.id.scaunstg);
		if (Storage.getScaunstg() == true) {
			scaunstg.setPressed(true);
		}
		scaunstg.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				// doSomething();

				scaunstg.setPressed(!scaunstg.isPressed());
				if (scaunstg.isPressed()) {
					Storage.setScaunstg(true);
					MyService.mConnectedThread.write("1");
				} else {
					Storage.setScaunstg(false);
					MyService.mConnectedThread.write("2");
				}
				return true;
			}
		});
		scaundr = (Button) findViewById(R.id.scaundr);
		if (Storage.getScaundr() == true) {
			scaundr.setPressed(true);
		}
		scaundr.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				// doSomething();
				scaundr.setPressed(!scaundr.isPressed());
				if (scaundr.isPressed()) {
					Storage.setScaundr(true);
					MyService.mConnectedThread.write("3");
				} else {
					Storage.setScaundr(false);
					MyService.mConnectedThread.write("4");
				}
				return true;
			}
		});

		shuffle = (Button) findViewById(R.id.shuffle);
		if (Storage.shuffle == true) {
			shuffle.setPressed(true);
		}
		shuffle.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				// doSomething();
				shuffle.setPressed(!shuffle.isPressed());
				if (scaundr.isPressed()) {
					Storage.shuffle = true;
				} else {
					Storage.shuffle = false;
				}
				return true;
			}
		});

		next = (Button) findViewById(R.id.next);
		next.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				if (shuffle.isPressed() == true) {
					musicSrv.playNextsh();
				} else {
					musicSrv.playNext();
				}// Title.setText(Storage.title);
			}
		});
		prev = (Button) findViewById(R.id.prev);
		prev.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				musicSrv.playPrev();

			}
		});

		play = (Button) findViewById(R.id.play);

		play.setPressed(Storage.play);

		play.setOnTouchListener(new OnTouchListener() {

			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				// doSomething();

				play.setPressed(!play.isPressed());

				if (play.isPressed()) {
					start();

					final Counter progress = new Counter(prog, musicSrv, Title,
							CurrentPos, TotalDur);

					progress.start();

					System.out.println(musicSrv.songPosn);

				} else {
					pause();
					Storage.play = false;
				}
				return true;
			}
		});

		// if(Counter.isAlive()){

		// }
	}

	// ONCREATE ENDS HERE

	private ServiceConnection musicConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			MusicBinder binder = (MusicBinder) service;
			// get service
			musicSrv = binder.getService();
			// pass list
			musicSrv.setList(songList);
			progress = new Counter(prog, musicSrv, Title, CurrentPos, TotalDur);
			progress.start();
			musicBound = true;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			musicBound = false;
		}
	};

	public void songPicked(View view) {
		musicSrv.setSong(Integer.parseInt(view.getTag().toString()));
		musicSrv.playSong();
		play.setPressed(true);

	}

	@Override
	protected void onStart() {
		super.onStart();
		if (playIntent == null) {
			playIntent = new Intent(this, MusicService.class);
			bindService(playIntent, musicConnection, Context.BIND_AUTO_CREATE);
			startService(playIntent);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;

		}
		return super.onOptionsItemSelected(item);
	}

	public void getSongList() {
		ContentResolver musicResolver = getContentResolver();
		Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
		Cursor musicCursor = musicResolver.query(musicUri, null, null, null,
				null);
		if (musicCursor != null && musicCursor.moveToFirst()) {
			// get column
			int titleColumn = musicCursor
					.getColumnIndex(android.provider.MediaStore.Audio.Media.TITLE);
			int idColumn = musicCursor
					.getColumnIndex(android.provider.MediaStore.Audio.Media._ID);
			int artistColumn = musicCursor
					.getColumnIndex(android.provider.MediaStore.Audio.Media.ARTIST);
			// add songs to list
			do {
				long thisId = musicCursor.getLong(idColumn);
				String thisTitle = musicCursor.getString(titleColumn);
				String thisArtist = musicCursor.getString(artistColumn);
				songList.add(new Song(thisId, thisTitle, thisArtist));
			} while (musicCursor.moveToNext());
		}
	}

	public void onDestroy() {
		stopService(new Intent(this, MyService.class));
		stopService(playIntent);
		musicSrv = null;

		super.onDestroy();

	}

	@Override
	public boolean canPause() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSeekBackward() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSeekForward() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getAudioSessionId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBufferPercentage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentPosition() {
		// TODO Auto-generated method stub
		if (musicSrv != null && musicBound && musicSrv.isPng())
			return musicSrv.getPosn();
		else
			return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.MediaController.MediaPlayerControl#getDuration()
	 */
	@Override
	public int getDuration() {
		if (musicSrv != null && musicBound && musicSrv.isPng())

			return musicSrv.getDur() / 1000;
		else
			return 0;
	}

	@Override
	public boolean isPlaying() {
		int i = 1;
		boolean j = false;
		switch (i) {
		case 1:
			if (musicSrv != null && musicBound)
				j = true;
		case 2:
			if (musicSrv == null && musicBound)
				j = false;

		}
		return j;
	}

	@Override
	public void pause() {
		musicSrv.pausePlayer();// TODO Auto-generated method stub

	}

	@Override
	public void seekTo(int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start() {
		if (musicSrv != null && musicBound)
			musicSrv.go();// TODO Auto-generated method stub
		// Title.setText(Storage.title);

	}

	@Override
	public void onResume() {
		super.onResume();
	}
}

/**
 * A placeholder fragment containing a simple view.
 */
/*
 * public static class PlaceholderFragment extends ListFragment {
 * 
 * private static final String[] FROM = { MediaStore.Audio.Media.TITLE };
 * private static final int[] TO = { android.R.id.text1 }; private CursorAdapter
 * mAdapter; private MediaPlayer mp = new MediaPlayer(); Button blade; Button
 * navi; Button headlight; Button scaunstg; Button scaundr;
 * 
 * @Override public View onCreateView(LayoutInflater inflater, ViewGroup
 * container, Bundle savedInstanceState) { View view =
 * inflater.inflate(R.layout.fragment_main, container, false); blade = (Button)
 * view.findViewById(R.id.fantab); blade.setOnClickListener(new
 * OnClickListener(){
 * 
 * @Override //On click function public void onClick(View view) { //Create the
 * intent to start another activity Intent vent = new Intent(getActivity(),
 * Ventscreen.class); getActivity().startActivity(vent); getActivity().finish();
 * } });
 * 
 * headlight = (Button) view.findViewById(R.id.head);
 * headlight.setOnClickListener(new OnClickListener(){
 * 
 * @Override //On click function public void onClick(View view) { //Create the
 * intent to start another activity Intent head = new Intent(getActivity(),
 * Headlight.class); getActivity().startActivity(head); getActivity().finish();
 * } });
 * 
 * 
 * navi = (Button) view.findViewById(R.id.navi); navi.setOnClickListener(new
 * OnClickListener(){
 * 
 * @Override //On click function public void onClick(View view) { //Create the
 * intent to start another activity Intent navi = new Intent(getActivity(),
 * Navi.class); getActivity().startActivity(navi); getActivity().finish(); } });
 * return view; }
 * 
 * @Override public void onCreate(Bundle savedInstanceState) {
 * super.onCreate(savedInstanceState); Context context = getActivity(); int
 * layout = android.R.layout.simple_list_item_1; Cursor cursor =
 * context.getContentResolver().query(
 * MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
 * MediaStore.Audio.Media.TITLE + " ASC"); int flags = 0; mAdapter = new
 * SimpleCursorAdapter(context, layout, cursor, FROM, TO, flags);
 * 
 * } Uri mus= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
 * 
 * 
 * 
 * 
 * 
 * @Override public void onActivityCreated(Bundle savedInstanceState) {
 * super.onActivityCreated(savedInstanceState);
 * 
 * setListAdapter(mAdapter);
 * getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
 * mAdapter.notifyDataSetChanged(); } } }
 */

