package com.dehoo.softdownload;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author dehoo-ZhongHeliang 2013-3-21下午21:10:39
 * @version jdk 1.6; sdk 4.2.0
 */
public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button updateBtn = (Button) findViewById(R.id.btnUpdate);
		updateBtn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				UpdateManager manager = new UpdateManager(MainActivity.this);
				// 检查软件更新
				manager.checkUpdate();
			}
		});
	}
}