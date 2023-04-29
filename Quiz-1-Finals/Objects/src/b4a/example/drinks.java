package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class drinks extends Activity implements B4AActivity{
	public static drinks mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.drinks");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (drinks).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.drinks");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.drinks", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (drinks) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (drinks) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return drinks.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (drinks) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (drinks) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            drinks mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (drinks) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtprice1 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chkcoffee = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chksoda = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chktea = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.pizza _pizza = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="drinks";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="Activity.LoadLayout(\"laydrinks\")";
mostCurrent._activity.LoadLayout("laydrinks",mostCurrent.activityBA);
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="drinks";
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="drinks";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="End Sub";
return "";
}
public static String  _btnaccept1_click() throws Exception{
RDebugUtils.currentModule="drinks";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnaccept1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnaccept1_click", null));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Private Sub btnaccept1_Click";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="Main.pricefordrinks = txtprice1.Text";
mostCurrent._main._pricefordrinks /*String*/  = mostCurrent._txtprice1.getText();
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="Msgbox(\"Transaction Confirmed\",\"Successful\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Transaction Confirmed"),BA.ObjectToCharSequence("Successful"),mostCurrent.activityBA);
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="End Sub";
return "";
}
public static String  _btnclear1_click() throws Exception{
RDebugUtils.currentModule="drinks";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnclear1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnclear1_click", null));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Private Sub btnclear1_Click";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="chkcoffee.Checked = False";
mostCurrent._chkcoffee.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="chktea.Checked = False";
mostCurrent._chktea.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="chksoda.Checked = False";
mostCurrent._chksoda.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="txtprice1.Text = 0";
mostCurrent._txtprice1.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="End Sub";
return "";
}
public static String  _btnhome1_click() throws Exception{
RDebugUtils.currentModule="drinks";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnhome1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnhome1_click", null));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Private Sub btnhome1_Click";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="End Sub";
return "";
}
public static String  _chkcoffee_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="drinks";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chkcoffee_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chkcoffee_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Private Sub chkcoffee_CheckedChange(Checked As Boo";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="If chkcoffee.Checked = True Then";
if (mostCurrent._chkcoffee.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="txtprice1.Text = txtprice1.Text + 50";
mostCurrent._txtprice1.setText(BA.ObjectToCharSequence((double)(Double.parseDouble(mostCurrent._txtprice1.getText()))+50));
 }else {
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="txtprice1.Text = txtprice1.Text - 50";
mostCurrent._txtprice1.setText(BA.ObjectToCharSequence((double)(Double.parseDouble(mostCurrent._txtprice1.getText()))-50));
 };
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="End Sub";
return "";
}
public static String  _chksoda_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="drinks";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chksoda_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chksoda_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Private Sub chksoda_CheckedChange(Checked As Boole";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="If chksoda.Checked = True Then";
if (mostCurrent._chksoda.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="txtprice1.Text = txtprice1.Text + 30";
mostCurrent._txtprice1.setText(BA.ObjectToCharSequence((double)(Double.parseDouble(mostCurrent._txtprice1.getText()))+30));
 }else {
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="txtprice1.Text = txtprice1.Text - 30";
mostCurrent._txtprice1.setText(BA.ObjectToCharSequence((double)(Double.parseDouble(mostCurrent._txtprice1.getText()))-30));
 };
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="End Sub";
return "";
}
public static String  _chktea_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="drinks";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chktea_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chktea_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Private Sub chktea_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="If chktea.Checked = True Then";
if (mostCurrent._chktea.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="txtprice1.Text = txtprice1.Text + 40";
mostCurrent._txtprice1.setText(BA.ObjectToCharSequence((double)(Double.parseDouble(mostCurrent._txtprice1.getText()))+40));
 }else {
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="txtprice1.Text = txtprice1.Text - 40";
mostCurrent._txtprice1.setText(BA.ObjectToCharSequence((double)(Double.parseDouble(mostCurrent._txtprice1.getText()))-40));
 };
RDebugUtils.currentLine=2818055;
 //BA.debugLineNum = 2818055;BA.debugLine="End Sub";
return "";
}
}