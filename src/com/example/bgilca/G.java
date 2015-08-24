package com.example.bgilca;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class G extends Application {

		
	protected static int count;
	protected static int ok = 0;
	protected static String title;
	protected static int tempsetup = 5;
	protected static boolean ispng = false;
	protected static boolean trd = false;
	public static int max;
	private Context main;
	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	 final String seat_l = "dn389q0";
	 final String seat_r = "f4j8dg3";
	 final String head = "52rtfnkjv93df";
	 final String body = "ad3wrefhnccs9";
	 final String legs = "dner3w89ryhff";
	 final String headlight = "gnv589ej";
	 final String fog = "cfwr9f8wjh9rfh";
	 final String defog = "dfqaidfnecsf";
	 final String wing = "8urfjgviosrhn";
	 final String playic = "fgvsnifnasdff";
	 final String fanspeedpref = "afjauad33";
	 final String temp = "asfasbfiafnae";
	 final String shuffle = "alabalaportocala";
	 final static String TAG = "PL-LG-24";
	public G(Context context){
		this.main = context;
		init();
	}
	private void init(){
		 preferences = main.getSharedPreferences("preferences", 1);
	     editor = preferences.edit();
	     editor.commit();
	}
	public boolean getShuffle(){
		return preferences.getBoolean(shuffle, false);
	}
	public void setShuffle(boolean shufflech){
		editor.putBoolean(shuffle, shufflech);
		editor.commit();
	}
	
	public boolean getScaunstg() {
		return preferences.getBoolean(seat_l, false);
	}

	public void setScaunstg(boolean scaunstg) {

		editor.putBoolean(seat_l, scaunstg);
		editor.commit();
	}

	public  boolean getScaundr() {
		return  preferences.getBoolean(seat_r, false);
	}

	public void setScaundr(boolean scaundr) {

		editor.putBoolean(seat_r, scaundr);
		editor.commit();
	}

	public  boolean getFaruri() {
		// TODO Auto-generated method stub
		return preferences.getBoolean(headlight, false);
	}

	public void setFaruri(boolean faruri) {
	
		editor.putBoolean(headlight, faruri);
		editor.commit();
	}

	public  boolean getDezab() {
		return preferences.getBoolean(defog, false);
	}

	public void setDezab(boolean dezab) {
		

		editor.putBoolean(defog, dezab);
		editor.commit();
		
	}

	public  boolean getCeata() {
		// TODO Auto-generated method stub
		return preferences.getBoolean(fog, false);
	}

	public void setCeata(boolean ceata) {
		// TODO Auto-generated method stub
	editor.putBoolean(fog, ceata);
	editor.commit();
	}

	public  boolean getSpoiler() {
		return preferences.getBoolean(wing, false);
	}

	public void setSpoiler(boolean spoiler) {
		
		editor.putBoolean(wing, spoiler);
		editor.commit();
	}

	public  boolean getPicioare() {
		return 	preferences.getBoolean(legs, false);
	}

	public void setPicioare(boolean picioare) {

		editor.putBoolean(legs, picioare);
		editor.commit();
	}

	public  boolean getCorp() {
		return preferences.getBoolean(body,false);

	}

	public void setCorp(boolean corp) {

		editor.putBoolean(body, corp);
		editor.commit();
	}

	public  boolean getCap() {
		return preferences.getBoolean(head, false);
	}

	public void setCap(boolean cap) {

		editor.putBoolean(head, cap);
		editor.commit();
	}

	public  int getFanspeed() {
		return preferences.getInt(fanspeedpref, 0);
	}

	public void setFanspeed(int fanspeed) {

		editor.putInt(fanspeedpref, fanspeed);
		
		editor.commit();
	}
	public boolean getPlay(){
		return preferences.getBoolean(playic, false);
	}
	public void setPlay(Boolean play){
		editor.putBoolean(playic, play);
		editor.commit();
	}
	public int getTemp(){
		return preferences.getInt(temp, 21);
	}
	public void setTemp(int tempdes){
		editor.putInt(temp, tempdes);
		editor.commit();
	}
}
