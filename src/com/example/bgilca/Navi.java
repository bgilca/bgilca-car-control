package com.example.bgilca;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class Navi extends MainActivity {
	static Button scaunstg;
	static Button scaundr;
	Button blade;
	Button headlight;
	Button home;

	@Override
	@SuppressLint("ClickableViewAccessibility")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navi);
		scaunstg = (Button) findViewById(R.id.scaunstg);
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
					MyService.mConnectedThread.write("1");
				} else {
					MyService.mConnectedThread.write("2");
				}
				return true;
			}
		});
		scaundr = (Button) findViewById(R.id.scaundr);
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
				return true;
			}
		});

		blade = (Button) findViewById(R.id.fantab);
		blade.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent nav = new Intent(Navi.this, Ventscreen.class);
				startActivity(nav);
				finish();
			}
		});

		headlight = (Button) findViewById(R.id.head);
		headlight.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent head = new Intent(Navi.this, Headlight.class);
				startActivity(head);
				finish();
			}
		});

		home = (Button) findViewById(R.id.home);
		home.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent home = new Intent(Navi.this, MainActivity.class);
				startActivity(home);
				finish();
			}
		});

	}

	public void onPause() {
		finish();

		super.onPause();

	}

}
