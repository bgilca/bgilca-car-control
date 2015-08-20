package com.example.bgilca;

public class Storage {

	protected static boolean scaunstg = false;
	protected static boolean scaundr = false;
	protected static boolean cap = false;
	protected static boolean corp = false;
	protected static boolean picioare = false;
	protected static boolean faruri = false;
	protected static boolean ceata = false;
	protected static boolean dezab = false;
	protected static boolean spoiler = false;
	protected static boolean play = false;
	protected static int fanspeed = 0;
	protected static int count;
	protected static int ok = 0;
	protected static String title;
	protected static int tempsetup = 5;
	protected static boolean ispng = false;
	protected static boolean trd = false;
	public static int max;
	protected static boolean shuffle = true;

	public Storage() {

	}

	public static boolean getScaunstg() {
		return scaunstg;
	}

	public static void setScaunstg(boolean scaunstg) {
		Storage.scaunstg = scaunstg;
	}

	public static boolean getScaundr() {
		return scaundr;
	}

	public static void setScaundr(boolean scaundr) {
		Storage.scaundr = scaundr;
	}

	public static boolean getFaruri() {
		// TODO Auto-generated method stub
		return faruri;
	}

	public static void setFaruri(boolean faruri) {
		Storage.faruri = faruri;
	}

	public static boolean getDezab() {
		return dezab;
	}

	public static void setDezab(boolean dezab) {
		Storage.dezab = dezab;
	}

	public static boolean getCeata() {
		// TODO Auto-generated method stub
		return ceata;
	}

	public static void setCeata(boolean ceata) {
		// TODO Auto-generated method stub
		Storage.ceata = ceata;
	}

	public static boolean getSpoiler() {
		return spoiler;
	}

	public static void setSpoiler(boolean spoiler) {
		Storage.spoiler = spoiler;
	}

	public static boolean getPicioare() {
		return picioare;
	}

	public static void setPicioare(boolean picioare) {
		Storage.picioare = picioare;
	}

	public static boolean getCorp() {
		return corp;
	}

	public static void setCorp(boolean corp) {
		Storage.corp = corp;
	}

	public static boolean getCap() {
		return cap;
	}

	public static void setCap(boolean cap) {
		Storage.cap = cap;
	}

	public static int getFanspeed() {
		return fanspeed;
	}

	public static void setFanspeed(int fanspeed) {
		Storage.fanspeed = fanspeed;
	}

}
