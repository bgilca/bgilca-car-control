package com.example.bgilca;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

//in fact this is the splash screen

public class Splash extends Activity {
	MediaPlayer launchMusic;

	@Override
	public void onCreate(Bundle Bgilca) {

		super.onCreate(Bgilca);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_splash);
		// Launch music
		

		Thread launchTime = new Thread() {
			public void run() {
				try {

					sleep(5000);
					startService(new Intent(getBaseContext(), MyService.class));
					Intent splashIntent = new Intent(
							"com.example.bgilca.MainActivity");
					startActivity(splashIntent);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

					finish();

				}
			}
		};
		launchTime.start();

		// end of launch music.

	}

	protected void onPause() {


		super.onPause();
		finish();

	}
};
