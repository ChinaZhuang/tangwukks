package com.esunward.inspectSystem;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.TabActivity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.itheima.mobilesafe.R;

public class DetailActivity extends BaseActivity   {
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tangwu_detail);

        TabHost tabHost = (TabHost) findViewById(R.id.myTabHost);

        // ������Ǽ̳�TabActivity��������ڵõ�tabHost֮����ӱ�ǩ֮ǰ����tabHost.setup()
        tabHost.setup();

        // ����content�����ò����˲����ļ��е�view
        tabHost.addTab(tabHost.newTabSpec("view1")
                .setIndicator("�豸��־").setContent(R.id.myinclude1));
        tabHost.addTab(tabHost.newTabSpec("view2")
        		.setIndicator("�豸��Ϣ").setContent(R.id.myinclude2));
        
    }


}
