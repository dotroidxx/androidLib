package net.dotroid.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

/**************************************************
 * 真真真真真真真真真真真真真Activity
 * @author dotroid
 **************************************************/
public class InitBehindProgressActivity extends Activity {
	
	// ProgressDialog真
	private ProgressDialog mProgressDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/********************************************
	 * 真真真真真真真真真真�
	 * onCreate真真真 
	 * @param message 真真真真真真真真真真
	 ********************************************/
	protected void startInitProgress(String message){
	
		// Setting ProgressDialog
		mProgressDialog = new ProgressDialog(this);
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		mProgressDialog.setMessage(message);
		mProgressDialog.setCancelable(true);
		mProgressDialog.show();

		// Start init thread
		(new Thread(runnable)).start();
	}

	/********************************************
	 * 真真�
	 * Override真真真
	 *******************************************/
	protected void Init() throws Exception{
		
		// Do Anything behind a ProgressDialog
		return;
		
	}
	
	/********************************************
	 * 真真真Runnable真真真
	 *******************************************/
	private Runnable runnable = new Runnable(){
		public void run() {
			try {
				// invoke init progress
				Init();
			}catch (Exception e) {
				Log.e("InitBehindProgressActivity", e.getMessage());
			}
			// dismiss a ProgressDialog
			mProgressDialog.dismiss();
		}
	};
}
