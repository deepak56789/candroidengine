package at.bartinger.candroid.sound;

import java.io.IOException;
import java.util.TreeMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

public class SFXManager {

	private Context context;
	private final int MAX_STREAMS = 10;
	
	private SoundPool soundpool;
	private float volume = 1;
	
	private TreeMap<String,Integer> nameToId = new TreeMap<String, Integer>();

	
	
	public SFXManager(Context context) {
		this.context = context;
		soundpool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 100);
	}
		
	public void addSound(String soundname, String assetPath){
		try {
			nameToId.put(soundname, soundpool.load(context.getResources().getAssets().openFd(assetPath), 100));
		} catch (IOException e) {
			Log.e("CanvasGame", "Could not open SoundFile" + assetPath);
		}
	}

	public void play(String soundname){
		soundpool.play(nameToId.get(soundname), volume, volume, 1, 0, 1f);
	}
	
	public void play(String soundname, float rate){
		soundpool.play(nameToId.get(soundname), volume, volume, 1, 0, rate);
	}
	
	public void stopSounds(){
		soundpool.pause(1);
	}
	
	public void release() {
		soundpool.release();
		soundpool = null;
	}
	
	public void setVolumeOf(float v){
		volume = v;
	}
	
	public float getVolume(){
		return volume;
	}

}
