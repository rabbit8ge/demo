package com.he.demo.android.testgradle.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class TestCase extends ActivityInstrumentationTestCase2 {
  	private Solo solo;
  	
  	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.he.demo.android.testgradle.MainActivity";

    private static Class<?> launcherActivityClass;
    static{
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }
  	
  	@SuppressWarnings("unchecked")
    public TestCase() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
		// Wait for activity: 'com.he.demo.android.testgradle.MainActivity'
		solo.waitForActivity("MainActivity", 2000);
		// Click on Empty Text View
		solo.clickOnView(solo.getView("editText1"));
		// Enter the text: 'I love you '
		solo.clearEditText((android.widget.EditText) solo.getView("editText1"));
		solo.enterText((android.widget.EditText) solo.getView("editText1"), "I love you ");
		// Click on Button
		solo.clickOnView(solo.getView("button1"));
		// Click on ImageView
		//solo.clickOnView(solo.getView(android.widget.ActionMenuPresenter$OverflowMenuButton.class, 0));
		// Click on action bar item
		solo.clickOnActionBarItem(0x7f080003);
		// Press menu back key
		solo.goBack();
	}
}
