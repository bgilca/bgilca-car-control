package com.example.bgilca;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class Headlight extends MainActivity {
	static Button scaunstg;
	static Button scaundr;
	Button navi;
	Button blade;
	Button home;
	Button faruri, tails, defog, spoiler, ceata;

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_headlight);

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
		if (Storage.getFaruri() == true) {
			faruri.setPressed(true);
			tails.setPressed(true);
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
					Storage.setFaruri(true);
					MyService.mConnectedThread.write("5");
				} else {
					Storage.setFaruri(false);
					MyService.mConnectedThread.write("6");
				}
				return true;
			}
		});
		defog = (Button) findViewById(R.id.defog);
		if (Storage.getDezab() == true) {
			defog.setPressed(true);
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
					Storage.setDezab(true);
					MyService.mConnectedThread.write("b");
				} else {
					Storage.setDezab(false);
					MyService.mConnectedThread.write("c");
				}
				return true;
			}
		});

		ceata = (Button) findViewById(R.id.ceata);
		if (Storage.getCeata() == true) {
			ceata.setPressed(true);
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
					Storage.setCeata(true);
					MyService.mConnectedThread.write("9");
				} else {
					Storage.setCeata(false);
					MyService.mConnectedThread.write("a");
				}
				return true;
			}
		});

		spoiler = (Button) findViewById(R.id.spoiler);
		spoiler.setPressed(Storage.spoiler);
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
					Storage.spoiler = true;
					MyService.mConnectedThread.write("7");
				} else {
					MyService.mConnectedThread.write("8");
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
