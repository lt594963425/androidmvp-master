package com.antonioleiva.mvpexample.app.utils;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class HttpTask extends AsyncTask<String, Void, String> {

	private HttpUtils.OnHttpResultListener onHttpResultListener;

	public HttpTask(HttpUtils.OnHttpResultListener onHttpResultListener) {
		this.onHttpResultListener = onHttpResultListener;
	}

	@Override
	protected String doInBackground(String... params) {
		try {
			return HttpUtils.post(params[0], params[1], params[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		if (this.onHttpResultListener != null) {
			this.onHttpResultListener.onResult(result);
		}
	}

}
