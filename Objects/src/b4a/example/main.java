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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static int _monstertype = 0;
public static String[] _monster = null;
public static String _filename = "";
public static anywheresoftware.b4a.objects.MediaPlayerWrapper _mediaplayer = null;
public static anywheresoftware.b4a.keywords.constants.TypefaceWrapper _font = null;
public anywheresoftware.b4a.objects.LabelWrapper _num1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _num2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _operation = null;
public anywheresoftware.b4a.objects.LabelWrapper _hp = null;
public anywheresoftware.b4a.objects.LabelWrapper _mobhp = null;
public anywheresoftware.b4a.objects.LabelWrapper _answer = null;
public anywheresoftware.b4a.objects.LabelWrapper _equal = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _stran = null;
public static String _str = "";
public static int _bar = 0;
public static int _damage = 0;
public static int _hpval = 0;
public static int _mobval = 0;
public static String _tempstr = "";
public static boolean _check = false;
public static String[] _operator = null;
public static int _barsize = 0;
public static boolean _hpshake = false;
public static boolean _mobshake = false;
public anywheresoftware.b4a.objects.PanelWrapper _gamestate = null;
public anywheresoftware.b4a.objects.PanelWrapper _pausestate = null;
public anywheresoftware.b4a.objects.PanelWrapper _titlestate = null;
public anywheresoftware.b4a.objects.PanelWrapper _gameoverstate = null;
public anywheresoftware.b4a.objects.PanelWrapper _gamedefeated = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _mob = null;
public anywheresoftware.b4a.objects.PanelWrapper _mob2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _ply1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _ply2 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvsgraph = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvsgraph2 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvsgraph3 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvsgraph4 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _rect1 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _rect2 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _rect3 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _rect4 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button0 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button3 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button4 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button5 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button6 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button7 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button8 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button9 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonenter = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonclear = null;
public anywheresoftware.b4a.objects.AnimationWrapper _shake = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.starter _starter = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 85;BA.debugLine="InitializeState";
_initializestate();
 //BA.debugLineNum = 86;BA.debugLine="DrawState";
_drawstate();
 //BA.debugLineNum = 88;BA.debugLine="If(HPval <= 100 And HPval >=1)Then";
if ((_hpval<=100 && _hpval>=1)) { 
 //BA.debugLineNum = 90;BA.debugLine="DrawMonster";
_drawmonster();
 //BA.debugLineNum = 91;BA.debugLine="DrawHealth";
_drawhealth();
 //BA.debugLineNum = 92;BA.debugLine="DrawEquation";
_drawequation();
 };
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 108;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 109;BA.debugLine="If Msgbox2(\"Are you sure to exit?\", \"\", \"Yes\", \"";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Are you sure to exit?"),BA.ObjectToCharSequence(""),"Yes","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 110;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 111;BA.debugLine="ExitApplication '...or whatever other previous";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 }else {
 //BA.debugLineNum = 113;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
 //BA.debugLineNum = 116;BA.debugLine="Return False    ' Handle the other presses in th";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public static String  _button0_click() throws Exception{
 //BA.debugLineNum = 352;BA.debugLine="Private Sub Button0_Click";
 //BA.debugLineNum = 353;BA.debugLine="answer.Text = tempStr&\"0\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"0"));
 //BA.debugLineNum = 354;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
 //BA.debugLineNum = 356;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
 //BA.debugLineNum = 358;BA.debugLine="Private Sub Button1_Click";
 //BA.debugLineNum = 359;BA.debugLine="answer.Text = tempStr&\"1\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"1"));
 //BA.debugLineNum = 360;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
 //BA.debugLineNum = 361;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
 //BA.debugLineNum = 363;BA.debugLine="Private Sub Button2_Click";
 //BA.debugLineNum = 364;BA.debugLine="answer.Text = tempStr&\"2\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"2"));
 //BA.debugLineNum = 365;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
 //BA.debugLineNum = 366;BA.debugLine="End Sub";
return "";
}
public static String  _button3_click() throws Exception{
 //BA.debugLineNum = 368;BA.debugLine="Private Sub Button3_Click";
 //BA.debugLineNum = 369;BA.debugLine="answer.Text = tempStr&\"3\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"3"));
 //BA.debugLineNum = 370;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
 //BA.debugLineNum = 371;BA.debugLine="End Sub";
return "";
}
public static String  _button4_click() throws Exception{
 //BA.debugLineNum = 373;BA.debugLine="Private Sub Button4_Click";
 //BA.debugLineNum = 374;BA.debugLine="answer.Text = tempStr&\"4\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"4"));
 //BA.debugLineNum = 375;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
 //BA.debugLineNum = 376;BA.debugLine="End Sub";
return "";
}
public static String  _button5_click() throws Exception{
 //BA.debugLineNum = 378;BA.debugLine="Private Sub Button5_Click";
 //BA.debugLineNum = 379;BA.debugLine="answer.Text = tempStr&\"5\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"5"));
 //BA.debugLineNum = 380;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
 //BA.debugLineNum = 381;BA.debugLine="End Sub";
return "";
}
public static String  _button6_click() throws Exception{
 //BA.debugLineNum = 383;BA.debugLine="Private Sub Button6_Click";
 //BA.debugLineNum = 384;BA.debugLine="answer.Text = tempStr&\"6\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"6"));
 //BA.debugLineNum = 385;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
 //BA.debugLineNum = 386;BA.debugLine="End Sub";
return "";
}
public static String  _button7_click() throws Exception{
 //BA.debugLineNum = 388;BA.debugLine="Private Sub Button7_Click";
 //BA.debugLineNum = 389;BA.debugLine="answer.Text = tempStr&\"7\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"7"));
 //BA.debugLineNum = 390;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
 //BA.debugLineNum = 391;BA.debugLine="End Sub";
return "";
}
public static String  _button8_click() throws Exception{
 //BA.debugLineNum = 393;BA.debugLine="Private Sub Button8_Click";
 //BA.debugLineNum = 394;BA.debugLine="answer.Text = tempStr&\"8\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"8"));
 //BA.debugLineNum = 395;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
 //BA.debugLineNum = 396;BA.debugLine="End Sub";
return "";
}
public static String  _button9_click() throws Exception{
 //BA.debugLineNum = 398;BA.debugLine="Private Sub Button9_Click";
 //BA.debugLineNum = 399;BA.debugLine="answer.Text = tempStr&\"9\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"9"));
 //BA.debugLineNum = 400;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
 //BA.debugLineNum = 401;BA.debugLine="End Sub";
return "";
}
public static String  _buttonclear_click() throws Exception{
 //BA.debugLineNum = 346;BA.debugLine="Private Sub ButtonClear_Click";
 //BA.debugLineNum = 347;BA.debugLine="answer.Text=\"\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 348;BA.debugLine="tempStr=\"\"";
mostCurrent._tempstr = "";
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return "";
}
public static String  _buttonenter_click() throws Exception{
 //BA.debugLineNum = 314;BA.debugLine="Private Sub ButtonEnter_Click";
 //BA.debugLineNum = 315;BA.debugLine="tempStr=\"\"";
mostCurrent._tempstr = "";
 //BA.debugLineNum = 316;BA.debugLine="damage = str";
_damage = (int)(Double.parseDouble(mostCurrent._str));
 //BA.debugLineNum = 317;BA.debugLine="If answer.Text = str Then";
if ((mostCurrent._answer.getText()).equals(mostCurrent._str)) { 
 //BA.debugLineNum = 318;BA.debugLine="strAn.Text = \"Correct\"";
mostCurrent._stran.setText(BA.ObjectToCharSequence("Correct"));
 //BA.debugLineNum = 319;BA.debugLine="mobVal= mobVal-damage";
_mobval = (int) (_mobval-_damage);
 //BA.debugLineNum = 320;BA.debugLine="mobshake = True";
_mobshake = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 321;BA.debugLine="MediaPlayer.Load(File.DirAssets,\"dam.mp3\")";
_mediaplayer.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dam.mp3");
 }else {
 //BA.debugLineNum = 324;BA.debugLine="strAn.Text = \"InCorrect\"";
mostCurrent._stran.setText(BA.ObjectToCharSequence("InCorrect"));
 //BA.debugLineNum = 325;BA.debugLine="HPval = HPval-damage";
_hpval = (int) (_hpval-_damage);
 //BA.debugLineNum = 326;BA.debugLine="MediaPlayer.Play";
_mediaplayer.Play();
 //BA.debugLineNum = 327;BA.debugLine="hpshake = True";
_hpshake = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 328;BA.debugLine="MediaPlayer.Load(File.DirAssets,\"pdam.mp3\")";
_mediaplayer.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"pdam.mp3");
 };
 //BA.debugLineNum = 330;BA.debugLine="MediaPlayer.Play";
_mediaplayer.Play();
 //BA.debugLineNum = 332;BA.debugLine="GameState.Visible=False";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 333;BA.debugLine="ReDraw";
_redraw();
 //BA.debugLineNum = 334;BA.debugLine="Activity_Create(True)";
_activity_create(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 335;BA.debugLine="If MonsterType == 3 Then";
if (_monstertype==3) { 
 //BA.debugLineNum = 336;BA.debugLine="GameDefeated.Visible=True";
mostCurrent._gamedefeated.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 338;BA.debugLine="check = True";
_check = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 339;BA.debugLine="If HPval <= 100 And HPval >= 0 Then";
if (_hpval<=100 && _hpval>=0) { 
 //BA.debugLineNum = 340;BA.debugLine="GameState.Visible=True";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 };
 //BA.debugLineNum = 344;BA.debugLine="End Sub";
return "";
}
public static String  _drawequation() throws Exception{
int _rand1 = 0;
int _rand2 = 0;
 //BA.debugLineNum = 242;BA.debugLine="Sub DrawEquation";
 //BA.debugLineNum = 243;BA.debugLine="Dim rand1 As Int = Rnd(1,11)";
_rand1 = anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (11));
 //BA.debugLineNum = 244;BA.debugLine="Dim rand2 As Int = Rnd(1,11)";
_rand2 = anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (11));
 //BA.debugLineNum = 245;BA.debugLine="num1.Text=rand1";
mostCurrent._num1.setText(BA.ObjectToCharSequence(_rand1));
 //BA.debugLineNum = 246;BA.debugLine="num2.Text=rand2";
mostCurrent._num2.setText(BA.ObjectToCharSequence(_rand2));
 //BA.debugLineNum = 247;BA.debugLine="ShuffleArray(operator)";
_shufflearray(mostCurrent._operator);
 //BA.debugLineNum = 248;BA.debugLine="operation.text = operator(0)";
mostCurrent._operation.setText(BA.ObjectToCharSequence(mostCurrent._operator[(int) (0)]));
 //BA.debugLineNum = 249;BA.debugLine="Select operator(0)";
switch (BA.switchObjectToInt(mostCurrent._operator[(int) (0)],"+","-","*","/")) {
case 0: {
 //BA.debugLineNum = 251;BA.debugLine="str =rand1+rand2";
mostCurrent._str = BA.NumberToString(_rand1+_rand2);
 break; }
case 1: {
 //BA.debugLineNum = 253;BA.debugLine="str =rand1-rand2";
mostCurrent._str = BA.NumberToString(_rand1-_rand2);
 break; }
case 2: {
 //BA.debugLineNum = 255;BA.debugLine="str =rand1*rand2";
mostCurrent._str = BA.NumberToString(_rand1*_rand2);
 break; }
case 3: {
 //BA.debugLineNum = 257;BA.debugLine="str =rand1/rand2";
mostCurrent._str = BA.NumberToString(_rand1/(double)_rand2);
 break; }
}
;
 //BA.debugLineNum = 259;BA.debugLine="End Sub";
return "";
}
public static String  _drawhealth() throws Exception{
 //BA.debugLineNum = 197;BA.debugLine="Sub DrawHealth";
 //BA.debugLineNum = 198;BA.debugLine="HP.Text=HPval";
mostCurrent._hp.setText(BA.ObjectToCharSequence(_hpval));
 //BA.debugLineNum = 199;BA.debugLine="mobHP.Text=mobVal";
mostCurrent._mobhp.setText(BA.ObjectToCharSequence(_mobval));
 //BA.debugLineNum = 201;BA.debugLine="If MonsterType<3 Then";
if (_monstertype<3) { 
 //BA.debugLineNum = 202;BA.debugLine="Select MonsterType";
switch (_monstertype) {
case 0: {
 //BA.debugLineNum = 204;BA.debugLine="barsize = mobVal*4.68";
_barsize = (int) (_mobval*4.68);
 break; }
case 1: {
 //BA.debugLineNum = 206;BA.debugLine="barsize = mobVal*2.34";
_barsize = (int) (_mobval*2.34);
 break; }
case 2: {
 //BA.debugLineNum = 208;BA.debugLine="barsize = mobVal*1.56";
_barsize = (int) (_mobval*1.56);
 break; }
}
;
 };
 //BA.debugLineNum = 212;BA.debugLine="mob.Color = Colors.ARGB(0, 0, 0, 0)";
mostCurrent._mob.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 213;BA.debugLine="cvsGraph.Initialize(mob)";
mostCurrent._cvsgraph.Initialize((android.view.View)(mostCurrent._mob.getObject()));
 //BA.debugLineNum = 214;BA.debugLine="rect1.Initialize(10dip, 10dip, IntToDIP(bar*4.67)";
mostCurrent._rect1.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_inttodip((int) (_bar*4.67)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
 //BA.debugLineNum = 215;BA.debugLine="cvsGraph.DrawRect(rect1, xui.Color_Black, False,";
mostCurrent._cvsgraph.DrawRect((android.graphics.Rect)(mostCurrent._rect1.getObject()),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
 //BA.debugLineNum = 217;BA.debugLine="mob2.Color=Colors.ARGB(0, 0, 0, 0)";
mostCurrent._mob2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 218;BA.debugLine="cvsGraph2.Initialize(mob2)";
mostCurrent._cvsgraph2.Initialize((android.view.View)(mostCurrent._mob2.getObject()));
 //BA.debugLineNum = 219;BA.debugLine="rect2.Initialize(10dip, 10dip, IntToDIP(barsize),";
mostCurrent._rect2.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_inttodip(_barsize),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
 //BA.debugLineNum = 220;BA.debugLine="cvsGraph2.DrawRect(rect2, xui.Color_Red , True, 3";
mostCurrent._cvsgraph2.DrawRect((android.graphics.Rect)(mostCurrent._rect2.getObject()),_xui.Color_Red,anywheresoftware.b4a.keywords.Common.True,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3))));
 //BA.debugLineNum = 222;BA.debugLine="ply1.Color = Colors.ARGB(0, 0, 0, 0)";
mostCurrent._ply1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 223;BA.debugLine="cvsGraph3.Initialize(ply1)";
mostCurrent._cvsgraph3.Initialize((android.view.View)(mostCurrent._ply1.getObject()));
 //BA.debugLineNum = 224;BA.debugLine="rect3.Initialize(10dip, 10dip, IntToDIP(bar*4.67)";
mostCurrent._rect3.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_inttodip((int) (_bar*4.67)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
 //BA.debugLineNum = 225;BA.debugLine="cvsGraph3.DrawRect(rect3, xui.Color_Black, False,";
mostCurrent._cvsgraph3.DrawRect((android.graphics.Rect)(mostCurrent._rect3.getObject()),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
 //BA.debugLineNum = 227;BA.debugLine="ply2.Color=Colors.ARGB(0, 0, 0, 0)";
mostCurrent._ply2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 228;BA.debugLine="cvsGraph4.Initialize(ply2)";
mostCurrent._cvsgraph4.Initialize((android.view.View)(mostCurrent._ply2.getObject()));
 //BA.debugLineNum = 229;BA.debugLine="rect4.Initialize(10dip, 10dip, IntToDIP(HPval*4.6";
mostCurrent._rect4.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_inttodip((int) (_hpval*4.68)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
 //BA.debugLineNum = 230;BA.debugLine="cvsGraph4.DrawRect(rect4, xui.Color_Red , True, 2";
mostCurrent._cvsgraph4.DrawRect((android.graphics.Rect)(mostCurrent._rect4.getObject()),_xui.Color_Red,anywheresoftware.b4a.keywords.Common.True,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
 //BA.debugLineNum = 232;BA.debugLine="If hpshake == True Then";
if (_hpshake==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 233;BA.debugLine="hpshake = False";
_hpshake = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 234;BA.debugLine="shake.Start(ply2)";
mostCurrent._shake.Start((android.view.View)(mostCurrent._ply2.getObject()));
 }else if(_mobshake==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 236;BA.debugLine="mobshake = False";
_mobshake = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 237;BA.debugLine="shake.Start(mob2)";
mostCurrent._shake.Start((android.view.View)(mostCurrent._mob2.getObject()));
 //BA.debugLineNum = 238;BA.debugLine="shake.Start(ImageView1)";
mostCurrent._shake.Start((android.view.View)(mostCurrent._imageview1.getObject()));
 };
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public static String  _drawmonster() throws Exception{
 //BA.debugLineNum = 177;BA.debugLine="Sub DrawMonster";
 //BA.debugLineNum = 178;BA.debugLine="If mobVal <= 0 Then";
if (_mobval<=0) { 
 //BA.debugLineNum = 179;BA.debugLine="MonsterType = MonsterType+1";
_monstertype = (int) (_monstertype+1);
 //BA.debugLineNum = 180;BA.debugLine="Select MonsterType";
switch (_monstertype) {
case 1: {
 //BA.debugLineNum = 182;BA.debugLine="mobVal = 200";
_mobval = (int) (200);
 break; }
case 2: {
 //BA.debugLineNum = 184;BA.debugLine="mobVal = 300";
_mobval = (int) (300);
 break; }
}
;
 };
 //BA.debugLineNum = 189;BA.debugLine="If MonsterType<3 Then";
if (_monstertype<3) { 
 //BA.debugLineNum = 190;BA.debugLine="FileName = Monster(MonsterType)";
_filename = _monster[_monstertype];
 //BA.debugLineNum = 191;BA.debugLine="ImageView1.Bitmap = LoadBitmap(File.DirAssets, F";
mostCurrent._imageview1.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_filename).getObject()));
 };
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public static String  _drawstate() throws Exception{
 //BA.debugLineNum = 163;BA.debugLine="Sub DrawState";
 //BA.debugLineNum = 164;BA.debugLine="If check == False Then";
if (_check==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 165;BA.debugLine="TitleState.Visible = True";
mostCurrent._titlestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 168;BA.debugLine="If HPval <=0 Then";
if (_hpval<=0) { 
 //BA.debugLineNum = 169;BA.debugLine="GameState.Visible = False";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 170;BA.debugLine="GameOverState.Visible = True";
mostCurrent._gameoverstate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public static String  _fontstyle() throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Sub FontStyle";
 //BA.debugLineNum = 121;BA.debugLine="num1.Typeface = Font";
mostCurrent._num1.setTypeface((android.graphics.Typeface)(_font.getObject()));
 //BA.debugLineNum = 122;BA.debugLine="num2.Typeface = Font";
mostCurrent._num2.setTypeface((android.graphics.Typeface)(_font.getObject()));
 //BA.debugLineNum = 123;BA.debugLine="operation.Typeface = Font";
mostCurrent._operation.setTypeface((android.graphics.Typeface)(_font.getObject()));
 //BA.debugLineNum = 124;BA.debugLine="HP.Typeface = Font";
mostCurrent._hp.setTypeface((android.graphics.Typeface)(_font.getObject()));
 //BA.debugLineNum = 125;BA.debugLine="mobHP.Typeface = Font";
mostCurrent._mobhp.setTypeface((android.graphics.Typeface)(_font.getObject()));
 //BA.debugLineNum = 126;BA.debugLine="answer.Typeface = Font";
mostCurrent._answer.setTypeface((android.graphics.Typeface)(_font.getObject()));
 //BA.debugLineNum = 127;BA.debugLine="equal.Typeface = Font";
mostCurrent._equal.setTypeface((android.graphics.Typeface)(_font.getObject()));
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 29;BA.debugLine="Private num1, num2, operation As Label";
mostCurrent._num1 = new anywheresoftware.b4a.objects.LabelWrapper();
mostCurrent._num2 = new anywheresoftware.b4a.objects.LabelWrapper();
mostCurrent._operation = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private HP, mobHP As Label";
mostCurrent._hp = new anywheresoftware.b4a.objects.LabelWrapper();
mostCurrent._mobhp = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private answer, equal As Label";
mostCurrent._answer = new anywheresoftware.b4a.objects.LabelWrapper();
mostCurrent._equal = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private strAn As Label";
mostCurrent._stran = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private str As String";
mostCurrent._str = "";
 //BA.debugLineNum = 40;BA.debugLine="Private bar As Int = 100";
_bar = (int) (100);
 //BA.debugLineNum = 41;BA.debugLine="Private damage As Int = 0";
_damage = (int) (0);
 //BA.debugLineNum = 42;BA.debugLine="Private HPval As Int = 100";
_hpval = (int) (100);
 //BA.debugLineNum = 43;BA.debugLine="Private mobVal As Int = 100";
_mobval = (int) (100);
 //BA.debugLineNum = 44;BA.debugLine="Private tempStr As String =\"\"";
mostCurrent._tempstr = "";
 //BA.debugLineNum = 45;BA.debugLine="Private check As Boolean = False";
_check = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 46;BA.debugLine="Private operator() As String = Array As String(\"+";
mostCurrent._operator = new String[]{"+","*"};
 //BA.debugLineNum = 47;BA.debugLine="Private barsize As Int";
_barsize = 0;
 //BA.debugLineNum = 48;BA.debugLine="Private hpshake As Boolean = False";
_hpshake = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 49;BA.debugLine="Private mobshake As Boolean = False";
_mobshake = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 51;BA.debugLine="Private GameState, PauseState, TitleState, GameOv";
mostCurrent._gamestate = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._pausestate = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._titlestate = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._gameoverstate = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._gamedefeated = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private Button1 As Button";
mostCurrent._button1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private mob, mob2, ply1, ply2 As Panel";
mostCurrent._mob = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._mob2 = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._ply1 = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._ply2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private cvsGraph, cvsGraph2, cvsGraph3, cvsGraph4";
mostCurrent._cvsgraph = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
mostCurrent._cvsgraph2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
mostCurrent._cvsgraph3 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
mostCurrent._cvsgraph4 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private rect1, rect2, rect3, rect4 As Rect";
mostCurrent._rect1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
mostCurrent._rect2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
mostCurrent._rect3 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
mostCurrent._rect4 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private Button0 As Button";
mostCurrent._button0 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private Button1 As Button";
mostCurrent._button1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private Button2 As Button";
mostCurrent._button2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Private Button3 As Button";
mostCurrent._button3 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Private Button4 As Button";
mostCurrent._button4 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Private Button5 As Button";
mostCurrent._button5 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Private Button6 As Button";
mostCurrent._button6 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Private Button7 As Button";
mostCurrent._button7 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private Button8 As Button";
mostCurrent._button8 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Private Button9 As Button";
mostCurrent._button9 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Private ButtonEnter As Button";
mostCurrent._buttonenter = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Private ButtonClear As Button";
mostCurrent._buttonclear = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 74;BA.debugLine="Private shake As Animation";
mostCurrent._shake = new anywheresoftware.b4a.objects.AnimationWrapper();
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public static String  _initializestate() throws Exception{
 //BA.debugLineNum = 132;BA.debugLine="Sub InitializeState";
 //BA.debugLineNum = 134;BA.debugLine="MediaPlayer.Initialize()";
_mediaplayer.Initialize();
 //BA.debugLineNum = 135;BA.debugLine="shake.InitializeTranslate(\"\", -9dip, 0, 9dip, 0)";
mostCurrent._shake.InitializeTranslate(mostCurrent.activityBA,"",(float) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (9))),(float) (0),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (9))),(float) (0));
 //BA.debugLineNum = 136;BA.debugLine="shake.RepeatCount = 3";
mostCurrent._shake.setRepeatCount((int) (3));
 //BA.debugLineNum = 137;BA.debugLine="shake.RepeatMode = shake.REPEAT_REVERSE";
mostCurrent._shake.setRepeatMode(mostCurrent._shake.REPEAT_REVERSE);
 //BA.debugLineNum = 138;BA.debugLine="shake.Duration = 30";
mostCurrent._shake.setDuration((long) (30));
 //BA.debugLineNum = 140;BA.debugLine="strAn.Initialize(\"\")";
mostCurrent._stran.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 142;BA.debugLine="GameState.Initialize(\"\") : GameState.Visible = Fa";
mostCurrent._gamestate.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 142;BA.debugLine="GameState.Initialize(\"\") : GameState.Visible = Fa";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 143;BA.debugLine="GameOverState.Initialize(\"\") : GameOverState.Visi";
mostCurrent._gameoverstate.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 143;BA.debugLine="GameOverState.Initialize(\"\") : GameOverState.Visi";
mostCurrent._gameoverstate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 144;BA.debugLine="PauseState.Initialize(\"\"): PauseState.Visible = F";
mostCurrent._pausestate.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 144;BA.debugLine="PauseState.Initialize(\"\"): PauseState.Visible = F";
mostCurrent._pausestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 145;BA.debugLine="TitleState.Initialize(\"\"): TitleState.Visible = F";
mostCurrent._titlestate.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 145;BA.debugLine="TitleState.Initialize(\"\"): TitleState.Visible = F";
mostCurrent._titlestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 146;BA.debugLine="GameDefeated.Initialize(\"\"): GameDefeated.Visible";
mostCurrent._gamedefeated.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 146;BA.debugLine="GameDefeated.Initialize(\"\"): GameDefeated.Visible";
mostCurrent._gamedefeated.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 149;BA.debugLine="GameState.LoadLayout(\"GameState\")";
mostCurrent._gamestate.LoadLayout("GameState",mostCurrent.activityBA);
 //BA.debugLineNum = 150;BA.debugLine="TitleState.LoadLayout(\"TitleState\")";
mostCurrent._titlestate.LoadLayout("TitleState",mostCurrent.activityBA);
 //BA.debugLineNum = 151;BA.debugLine="GameOverState.LoadLayout(\"GameOverState\")";
mostCurrent._gameoverstate.LoadLayout("GameOverState",mostCurrent.activityBA);
 //BA.debugLineNum = 152;BA.debugLine="GameDefeated.LoadLayout(\"GameDefeated\")";
mostCurrent._gamedefeated.LoadLayout("GameDefeated",mostCurrent.activityBA);
 //BA.debugLineNum = 153;BA.debugLine="PauseState.LoadLayout(\"PauseState\")";
mostCurrent._pausestate.LoadLayout("PauseState",mostCurrent.activityBA);
 //BA.debugLineNum = 155;BA.debugLine="Activity.AddView(GameState,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._gamestate.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 156;BA.debugLine="Activity.AddView(TitleState,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._titlestate.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 157;BA.debugLine="Activity.AddView(GameOverState,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._gameoverstate.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 158;BA.debugLine="Activity.AddView(GameDefeated,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._gamedefeated.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 159;BA.debugLine="Activity.AddView(PauseState,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pausestate.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 160;BA.debugLine="FontStyle";
_fontstyle();
 //BA.debugLineNum = 161;BA.debugLine="End Sub";
return "";
}
public static int  _inttodip(int _integer) throws Exception{
int _dip = 0;
 //BA.debugLineNum = 274;BA.debugLine="Sub IntToDIP(Integer As Int) As Int";
 //BA.debugLineNum = 275;BA.debugLine="Dim DIP As Int";
_dip = 0;
 //BA.debugLineNum = 276;BA.debugLine="DIP = Integer *1dip";
_dip = (int) (_integer*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
 //BA.debugLineNum = 277;BA.debugLine="Return DIP";
if (true) return _dip;
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
return 0;
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
main._process_globals();
starter._process_globals();
xuiviewsutils._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 19;BA.debugLine="Private MonsterType As Int = 0";
_monstertype = (int) (0);
 //BA.debugLineNum = 20;BA.debugLine="Private Monster() As String = Array As String(\"re";
_monster = new String[]{"redslime.png","orc.png","sk\\eleton.png"};
 //BA.debugLineNum = 21;BA.debugLine="Private FileName As String = Monster(MonsterType)";
_filename = _monster[_monstertype];
 //BA.debugLineNum = 22;BA.debugLine="Private MediaPlayer As MediaPlayer";
_mediaplayer = new anywheresoftware.b4a.objects.MediaPlayerWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private Font As Typeface = Typeface.LoadFromAsset";
_font = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
_font = (anywheresoftware.b4a.keywords.constants.TypefaceWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.constants.TypefaceWrapper(), (android.graphics.Typeface)(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets("alagard.ttf")));
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _redraw() throws Exception{
int _i = 0;
 //BA.debugLineNum = 280;BA.debugLine="Sub ReDraw";
 //BA.debugLineNum = 281;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 282;BA.debugLine="For i = Activity.NumberOfViews - 1 To 0 Step -1";
{
final int step2 = -1;
final int limit2 = (int) (0);
_i = (int) (mostCurrent._activity.getNumberOfViews()-1) ;
for (;_i >= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 283;BA.debugLine="Activity.RemoveViewAt(i)";
mostCurrent._activity.RemoveViewAt(_i);
 }
};
 //BA.debugLineNum = 285;BA.debugLine="End Sub";
return "";
}
public static String  _retry_click() throws Exception{
 //BA.debugLineNum = 299;BA.debugLine="Private Sub Retry_Click";
 //BA.debugLineNum = 300;BA.debugLine="hpshake = False";
_hpshake = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 301;BA.debugLine="mobshake = False";
_mobshake = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 302;BA.debugLine="HPval = 100";
_hpval = (int) (100);
 //BA.debugLineNum = 303;BA.debugLine="mobVal = 100";
_mobval = (int) (100);
 //BA.debugLineNum = 304;BA.debugLine="MonsterType = 0";
_monstertype = (int) (0);
 //BA.debugLineNum = 305;BA.debugLine="FileName = Monster(MonsterType)";
_filename = _monster[_monstertype];
 //BA.debugLineNum = 306;BA.debugLine="GameOverState.Visible = False";
mostCurrent._gameoverstate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 307;BA.debugLine="ReDraw";
_redraw();
 //BA.debugLineNum = 308;BA.debugLine="Activity_Create(True)";
_activity_create(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 309;BA.debugLine="GameState.Visible = True";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 312;BA.debugLine="End Sub";
return "";
}
public static String  _shufflearray(String[] _stringarray) throws Exception{
String _arrayval = "";
int _random = 0;
int _i = 0;
 //BA.debugLineNum = 261;BA.debugLine="Sub ShuffleArray(StringArray() As String)";
 //BA.debugLineNum = 262;BA.debugLine="Dim ArrayVal As String";
_arrayval = "";
 //BA.debugLineNum = 263;BA.debugLine="Dim Random As Int";
_random = 0;
 //BA.debugLineNum = 265;BA.debugLine="For i = 0 To StringArray.Length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_stringarray.length-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 266;BA.debugLine="Random = Rnd(i, StringArray.Length)";
_random = anywheresoftware.b4a.keywords.Common.Rnd(_i,_stringarray.length);
 //BA.debugLineNum = 267;BA.debugLine="ArrayVal = StringArray(i)";
_arrayval = _stringarray[_i];
 //BA.debugLineNum = 268;BA.debugLine="StringArray(i) = StringArray(Random)";
_stringarray[_i] = _stringarray[_random];
 //BA.debugLineNum = 269;BA.debugLine="StringArray(Random) = ArrayVal";
_stringarray[_random] = _arrayval;
 }
};
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
return "";
}
public static String  _start_click() throws Exception{
 //BA.debugLineNum = 288;BA.debugLine="Private Sub Start_Click";
 //BA.debugLineNum = 289;BA.debugLine="check = True";
_check = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 290;BA.debugLine="TitleState.Visible = False";
mostCurrent._titlestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 291;BA.debugLine="GameState.Visible = True";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return "";
}
public static String  _start_pressed() throws Exception{
 //BA.debugLineNum = 295;BA.debugLine="Private Sub Start_Pressed";
 //BA.debugLineNum = 297;BA.debugLine="End Sub";
return "";
}
}
