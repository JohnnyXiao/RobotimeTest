package com.example.androidthreadtest.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;

import com.example.androidthreadtest.MainActivity;
import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RobotiumTestCase extends ActivityInstrumentationTestCase2 {
	//private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.example.androidthreadtest.MainActivity";
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.togic.livevideo.MainActivity";
	private static Class<?> launcherAcivityClass;
	static{
		try {
			launcherAcivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
//构造方法
	public  RobotiumTestCase() throws ClassNotFoundException {
		super(launcherAcivityClass);
	}
	
	private Solo solo;
	@Before
	public void setUp() throws Exception {                   //开始测试之前初始化solo对象
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@After
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	@Test
	public void testcase001() {
		//assertTrue("无法启动启动类", solo.waitForActivity("MainActivity",30000));
		assertTrue("无法启动启动类", solo.waitForActivity("com.togic.livetv.TvUiActivity",30000));
		solo.sleep(3000);
		
/*		solo.clickOnButton("^重新设置文本内容$");
		solo.sleep(3000);*/
		

		solo.sendKey(KeyEvent.KEYCODE_ENTER);
		solo.clickInList(10);
	}

}
