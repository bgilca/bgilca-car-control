package com.example.bgilca;

import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

class Counter extends Thread {
	public static int count = 0;
	private ProgressBar progres;
	int duration;
	int song, Total, Current, Totalmin, Totalsec, Currentmin, Currentsec;
	private MusicService musicSrv;
	TextView TotalDur, CurrentPos;
	TextView title;
	Handler handler = new Handler();
	G g;
	public Counter(ProgressBar progres, MusicService musicSrv, TextView Title,
			TextView CurrentPos, TextView TotalDur) {
		this.progres = progres;
		this.title = Title;
		this.musicSrv = musicSrv;
		this.CurrentPos = CurrentPos;
		this.TotalDur = TotalDur;
	}

	public void run() {

		while (!Counter.interrupted()) {
			try {
				System.out.println(musicSrv.songPosn);

				if (musicSrv != null) {

					Thread.sleep(100);
					if (musicSrv.isPng()) {

						progres.setMax(musicSrv.getDur() / 100);
						Total = musicSrv.getDur() / 1000;
						Totalmin = Total / 60;
						Totalsec = Total % 60;
						Current = musicSrv.getPosn() / 1000;
						Currentmin = Current / 60;
						Currentsec = Current % 60;
						handler.post(new Runnable() {
							public void run() {
								title.setText(G.title);
								if (Currentsec < 10)
									CurrentPos.setText(Currentmin + " : 0"
											+ Currentsec);
								else
									CurrentPos.setText(Currentmin + " : "
											+ Currentsec);
								if (Totalsec < 10)
									TotalDur.setText(Totalmin + " : 0"
											+ Totalsec);
								else
									TotalDur.setText(Totalmin + " : "
											+ Totalsec);
							}
						});
						musicSrv.getTit();
						if (musicSrv.getPosn() > musicSrv.getDur() - 100)
							if (g.getShuffle() == true)
								musicSrv.playNextsh();
							else {
								musicSrv.playNext();
							}

						// title.setText(Storage.title);
						progres.setProgress(musicSrv.getPosn() / 100);
						// System.out.println(Storage.count);
					}
					if (musicSrv.getDur() == musicSrv.getPosn()) {
					}
					// musicSrv.playNext();
					// title.setText(Storage.title);
					// System.out.println("thread running");

				}
			} catch (Exception e) {

			}

		}
	}
}