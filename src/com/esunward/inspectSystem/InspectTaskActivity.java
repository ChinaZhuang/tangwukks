package com.esunward.inspectSystem;

import com.itheima.mobilesafe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InspectTaskActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tangwu_task);
		
	}
	
	/**
	 * Ѳ���¼���õķ���
	 * @param view
	 */
	public void showInspectRecord(View view){
		Intent intent = new Intent(this,InspectRecordActivity.class);
		startActivity(intent);
	}
	
	/**
	 * ����Ѳ��,����ɨ���ά��
	 */
	public void scanQrCode(View view){
		/*Intent intent = new Intent(this,InspectRecordActivity.class);
		startActivity(intent);*/
	}
	
	/**
	 * Ѳ������
	 * @param view
	 */
	public void inspectTask(View view){
		Intent intent = new Intent(this,InspectTaskActivity.class);
		startActivity(intent);
	}
	
	/**
	 * ��������
	 * @param view
	 */
	public void centerInfo(View view){
		Intent intent = new Intent(this,CenterActivity.class);
		startActivity(intent);
	}
}
