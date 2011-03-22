package net.dotroid.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

/**************************************************
 * ¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿Activity
 * @author dotroid
 **************************************************/
public class InitBehindProgressActivity extends Activity {
	
	// ProgressDialog¿¿
	private ProgressDialog mProgressDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/********************************************
	 * ¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿
	 * onCreate¿¿¿¿¿¿ 
	 * @param message ¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿
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
	 * ¿¿¿¿¿
	 * Override¿¿¿¿¿¿
	 *******************************************/
	protected void Init() throws Exception{
		
		// Do Anything behind a ProgressDialog
		return;
		
	}
	
	/********************************************
	 * ¿¿¿¿¿¿Runnable¿¿¿¿¿¿
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
