package com.esunward.inspectSystem;

import com.itheima.mobilesafe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * ɨ���豸��Ϣ�����Ľ���
 * @author Administrator
 *
 */
public class ScanEquipInfoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tangwu_scaninfo);
		
	}
	
	//�豸����
	public void equipmentNormal(View view){
		//Intent intent = new Intent(LoginActivity.this,CenterActivity.class);
		//startActivity(intent);
		//HttpUtil.androidHttpPostRequest();
		/*Toast.makeText(LoginActivity.this, "����Ҫ��¼ϵͳ", 0).show();
		Intent intent = new Intent(LoginActivity.this,CenterActivity.class);
		startActivity(intent);
		*/
	}
	
	
	//�豸�쳣
	public void equipmentAbnormal(View view){
		Intent intent = new Intent(ScanEquipInfoActivity.this,AbnormalFormActivity.class);
		startActivity(intent);
	}
}
