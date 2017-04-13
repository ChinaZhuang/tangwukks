package com.esunward.inspectSystem;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

/**
 * ����Activity
 * @author Administrator
 *
 */
public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//����������һ�δ��룬��Ϊandroid4.0�Ժ���������
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
		    // ���StrictMode�ĵ�
		    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		            .detectDiskReads().detectDiskWrites().detectNetwork()
		            .penaltyLog().build());
		    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		            .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
		            .penaltyLog().penaltyDeath().build());
		}
	}
	
}
