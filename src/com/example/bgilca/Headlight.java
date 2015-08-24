package com.example.bgilca;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class Headlight extends Activity {
	static Button scaunstg;
	static Button scaundr;
	Button navi;
	Button blade;
	Button home;
	Button faruri, tails, defog, spoiler, ceata;
	G g;
	@SuppressLint("ClickableViewAccessibility")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_headlight);
		g = new G(this);
		
		scaunstg = (Button) findViewById(R.id.scaunstg);
		scaunstg.setPressed(g.getScaunstg());
		if (g.getScaunstg() == true) {
			g.setScaunstg(true);
			MyService.mConnectedThread.write("1");
			Log.i(G.TAG, "left seat active");
		} else {
			g.setScaunstg(false);
			MyService.mConnectedThread.write("2");
			Log.i(G.TAG, "left seat inactive");
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
					g.setScaunstg(true);
					MyService.mConnectedThread.write("1");
					Log.i(G.TAG, "left seat active");
				} else {
					g.setScaunstg(false);
					MyService.mConnectedThread.write("2");
					Log.i(G.TAG, "left seat inactive");
				}
				return true;
			}
		});
		scaundr = (Button) findViewById(R.id.scaundr);
		scaundr.setPressed(g.getScaundr());
		if (g.getScaundr() == true) {
			g.setScaundr(true);
			MyService.mConnectedThread.write("3");
			Log.i(G.TAG, "right seat active");
		} else {
			g.setScaundr(false);
			MyService.mConnectedThread.write("4");
			Log.i(G.TAG, "right seat inactive");
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
					g.setScaundr(true);
					MyService.mConnectedThread.write("3");
					Log.i(G.TAG, "right seat active");
				} else {
					g.setScaundr(false);
					MyService.mConnectedThread.write("4");
					Log.i(G.TAG, "right seat inactive");
				}
				return true;
			}
		});

		navi = (Button) findViewById(R.id.navi);
		navi.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent nav = new Intent(Headlight.this, Navi.class);
				startActivity(nav);
				finish();
			}
		});

		blade = (Button) findViewById(R.id.fantab);
		blade.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent fan = new Intent(Headlight.this, Ventscreen.class);
				startActivity(fan);
				finish();
			}
		});

		home = (Button) findViewById(R.id.home);
		home.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent home = new Intent(Headlight.this, MainActivity.class);
				startActivity(home);
				finish();
			}
		});

		faruri = (Button) findViewById(R.id.faruri);
		tails = (Button) findViewById(R.id.tails);
		faruri.setPressed(g.getFaruri());
		tails.setPressed(g.getFaruri());
		if (g.getFaruri() == true) {
			g.setFaruri(true);
			tails.setPressed(true);
			MyService.mConnectedThread.write("5");
			Log.i(G.TAG, "headlights on");
		} else {
			g.setFaruri(false);
			MyService.mConnectedThread.write("6");
			Log.i(G.TAG, "headlights off");
			tails.setPressed(false);
		}
		faruri.setOnTouchListener(new OnTouchListener() {
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
				faruri.setPressed(!faruri.isPressed());
				tails.setPressed(!tails.isPressed());
				if (faruri.isPressed()) {
					g.setFaruri(true);
					MyService.mConnectedThread.write("5");
					Log.i(G.TAG, "headlights on");
				} else {
					g.setFaruri(false);
					MyService.mConnectedThread.write("6");
					Log.i(G.TAG, "headlights off");
				}
				return true;
			}
		});
		defog = (Button) findViewById(R.id.defog);
		defog.setPressed(g.getDezab());
		if (g.getDezab() == true) {
			g.setDezab(true);
			MyService.mConnectedThread.write("b");
			Log.i(G.TAG, "defogger on");
		} else {
			g.setDezab(false);
			MyService.mConnectedThread.write("c");
			Log.i(G.TAG, "defogger off");
		}
		defog.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;

				defog.setPressed(!defog.isPressed());

				if (defog.isPressed()) {
					g.setDezab(true);
					MyService.mConnectedThread.write("b");
					Log.i(G.TAG, "defogger on");
				} else {
					g.setDezab(false);
					MyService.mConnectedThread.write("c");
					Log.i(G.TAG, "defogger off");
				}
				return true;
			}
		});

		ceata = (Button) findViewById(R.id.ceata);
		ceata.setPressed(g.getCeata());
		if (g.getCeata() == true) {
			g.setCeata(true);
			MyService.mConnectedThread.write("9");
			Log.i(G.TAG, "fog lights on");
		} else {
			g.setCeata(false);
			MyService.mConnectedThread.write("a");
			Log.i(G.TAG, "fog lights off");
		
		}
		ceata.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;

				ceata.setPressed(!ceata.isPressed());

				if (ceata.isPressed()) {
					g.setCeata(true);
					MyService.mConnectedThread.write("9");
					Log.i(G.TAG, "fog lights on");
				} else {
					g.setCeata(false);
					MyService.mConnectedThread.write("a");
					Log.i(G.TAG, "fog lights off");
				}
				return true;
			}
		});

		spoiler = (Button) findViewById(R.id.spoiler);
		spoiler.setPressed(g.getSpoiler());
		if(spoiler.isPressed()){
			MyService.mConnectedThread.write("7");
			Log.i(G.TAG, "rear wing raised");
			g.setSpoiler(true);
		} else {
			MyService.mConnectedThread.write("8");
			Log.i(G.TAG, "rear wing lowered");
			g.setSpoiler(false);
		}
		spoiler.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				spoiler.setPressed(!spoiler.isPressed());

				if (spoiler.isPressed()) {
					g.setSpoiler(true);
					MyService.mConnectedThread.write("7");
					Log.i(G.TAG, "rear wing raised");
				} else {
					g.setSpoiler(false);
					MyService.mConnectedThread.write("8");
					Log.i(G.TAG, "rear wing lowered");
				}

				return true;
			}
		});

	}

	@Override
	public void onResume() {
		super.onResume();

	}

	public void onPause() {
		super.onPause();
		finish();

	}
}
