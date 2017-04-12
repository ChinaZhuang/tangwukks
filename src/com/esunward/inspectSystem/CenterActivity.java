package com.esunward.inspectSystem;

import com.esunward.javabean.User;
import com.itheima.mobilesafe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;

public class CenterActivity extends Activity {
private ImageView personface;  //��ͷ���ͼƬ
	
	private TextView loginUser_name_tv;
	private TextView loginUser_no;
	private TextView loginUser_phone;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tangwu_ceter);
		personface = (ImageView)findViewById(R.id.personface);
		
		loginUser_name_tv = (TextView) findViewById(R.id.loginUser_name);
		loginUser_no = (TextView) findViewById(R.id.loginUser_no);
		loginUser_phone = (TextView) findViewById(R.id.loginUser_phone);
		
		User user = (User) getIntent().getExtras().get("loginUser");
		loginUser_name_tv.setText(user.getName());
		loginUser_no.setText(user.getNo());
		loginUser_phone.setText(user.getPhone());
	}
	
	/**
	 * �޸��û���Ϣ�Ľ���
	 * @param view
	 */
	public void editInfo(View view){
		Intent intent = new Intent(CenterActivity.this,EditInfoActivity.class);
		startActivity(intent);
	}
	
	/**
	 * �޸��û�����Ľ���
	 * @param view
	 */
	public void modifyPassword(View view){
		Intent intent = new Intent(CenterActivity.this,ModifyPasswordActivity.class);
		startActivity(intent);
	}
	
	/**
	 * �˳��ʺŵ��õķ���
	 * @param view
	 */
	public void logout(View view){
		Intent intent = new Intent(CenterActivity.this,ModifyPasswordActivity.class);
		startActivity(intent);
	}
	
	
	/**
	 * Ѳ���¼���õķ���
	 * @param view
	 */
	public void showInspectRecord(View view){
		Intent intent = new Intent(CenterActivity.this,InspectRecordActivity.class);
		startActivity(intent);
	}
	
	/**
	 * ����Ѳ��,����ɨ���ά��
	 */
	public void scanQrCode(View view){
		/*Intent intent = new Intent(CenterActivity.this,InspectRecordActivity.class);
		startActivity(intent);*/
	}
	
	/**
	 * Ѳ������
	 * @param view
	 */
	public void inspectTask(View view){
		Intent intent = new Intent(CenterActivity.this,InspectTaskActivity.class);
		startActivity(intent);
	}
	
	/**
	 * ��������
	 * @param view
	 */
	public void centerInfo(View view){
		Intent intent = new Intent(CenterActivity.this,CenterActivity.class);
		startActivity(intent);
	}
	
}
