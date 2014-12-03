package com.sanda.videoCompressor;

//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
import android.util.Log;
import android.view.Gravity;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class VideoCompressor extends CordovaPlugin  {
	
  private static final String ACTION_START_EVENT = "start";
  private static final String ACTION_SHOW_EVENT = "show";


public static CallbackContext callback;

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if (ACTION_START_EVENT.equals(action)) {
	
	cordova.getActivity().runOnUiThread(new Runnable() {
		public void run(){
		//Context context = cordova.getActivity().getApplicationContext();
		//Intent i = new Intent(context,DemoClient.class);
		String[] commandComplex = {"ffmpeg","-y" ,"-i", "/storage/sdcard0/videos/Other/VID-20130625-WA0002.3gp","-strict","experimental","-s", "160x120","-r","25", "-vcodec", "mpeg4", "-b", "150k", "-ab","48000", "-ac", "2", "-ar", "22050", "/storage/sdcard0/Ngage/Video/outgp.3gp"};
					Log.e("Complex command", commandComplex.toString());
					
					setCommandComplex(commandComplex);
					setOutputFilePath("/storage/sdcard0/Ngage/Video/outgp.3gp");
					setProgressDialogTitle("Compressing " + "Video"
							+ ", Please wait...");
					setProgressDialogMessage("Depends on your " + "Video"
							+ " size, it can take a few minutes");

							setProgressDialogTitle("Exporting As MP4 Video");
					setProgressDialogMessage("Depends on your video size, it can take a few minutes");
					setNotificationIcon(R.drawable.icon2);
					setNotificationMessage("Demo is running...");
					setNotificationTitle("Demo Client");
					setNotificationfinishedMessageTitle("Demo Transcoding finished");
					setNotificationfinishedMessageDesc("Click to play demo");
					setNotificationStoppedMessage("Demo Transcoding stopped");
					///////////////

					Log.i(Prefs.TAG, "ffmpeg4android library version: " + Prefs.getLibraryVersionName());
					runTranscoing();

		}
	});
  }else   if (ACTION_SHOW_EVENT.equals(action)) {
	  startAct(com.netcompss.ffmpeg4android_client.ShowFileAct.class);		
    }
  else {
      callbackContext.error("Recording." + action + " is not a supported function. Did you mean '" + ACTION_SHOW_EVENT + "'?");
      return false;
    }


}
