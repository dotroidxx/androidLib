package net.dotroid.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

/**************************************************
 * プログレスダイアログを表示して初期化処理を行うActivity
 * @author dotroid
 **************************************************/
public class InitBehindProgressActivity extends Activity {
	
	// ProgressDialogｿｿ
	private ProgressDialog mProgressDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/********************************************
	 * プログレスダイアログを表示して、初期化処理を実行する
	 * 継承先ActivityのonCreateにて実行する
	 * @param message プログレスダイアログに表示するメッセージ
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
	 * 初期化処理
	 * Override先で実装する
	 *******************************************/
	protected void Init() throws Exception{
		
		// Do Anything behind a ProgressDialog
		return;
		
	}
	
	/********************************************
	 * 非同期実行用Runnable処理
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
