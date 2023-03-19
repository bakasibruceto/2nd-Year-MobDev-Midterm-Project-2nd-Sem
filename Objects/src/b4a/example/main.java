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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.LabelWrapper _num1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _num2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _operation = null;
public anywheresoftware.b4a.objects.LabelWrapper _hp = null;
public anywheresoftware.b4a.objects.LabelWrapper _mobhp = null;
public anywheresoftware.b4a.objects.LabelWrapper _answer = null;
public anywheresoftware.b4a.objects.LabelWrapper _countdown = null;
public anywheresoftware.b4a.objects.LabelWrapper _stran = null;
public static String _str = "";
public static int _dammage = 0;
public static int _hpval = 0;
public static int _mobval = 0;
public anywheresoftware.b4a.objects.Timer _timer1 = null;
public static long _targettime = 0L;
public static String _tempstr = "";
public static boolean _check = false;
public anywheresoftware.b4a.objects.PanelWrapper _load = null;
public anywheresoftware.b4a.objects.PanelWrapper _gamestate = null;
public anywheresoftware.b4a.objects.PanelWrapper _pausestate = null;
public anywheresoftware.b4a.objects.PanelWrapper _titlestate = null;
public anywheresoftware.b4a.objects.PanelWrapper _gameoverstate = null;
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
public b4a.example.dateutils _dateutils = null;
public b4a.example.starter _starter = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
String[] _symbol = null;
int _rand1 = 0;
int _rand2 = 0;
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="state";
_state();
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="If check == False Then";
if (_check==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="Load.Visible = True";
mostCurrent._load.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="Load.Visible = False";
mostCurrent._load.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="TitleState.Visible = True";
mostCurrent._titlestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=262154;
 //BA.debugLineNum = 262154;BA.debugLine="If HPval <=0 Then";
if (_hpval<=0) { 
RDebugUtils.currentLine=262155;
 //BA.debugLineNum = 262155;BA.debugLine="GameState.Visible = False";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=262156;
 //BA.debugLineNum = 262156;BA.debugLine="GameOverState.Visible = True";
mostCurrent._gameoverstate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=262158;
 //BA.debugLineNum = 262158;BA.debugLine="If(HPval <= 100 And HPval >=1)Then";
if ((_hpval<=100 && _hpval>=1)) { 
RDebugUtils.currentLine=262160;
 //BA.debugLineNum = 262160;BA.debugLine="HP.Text=HPval";
mostCurrent._hp.setText(BA.ObjectToCharSequence(_hpval));
RDebugUtils.currentLine=262161;
 //BA.debugLineNum = 262161;BA.debugLine="mobHP.Text=mobVal";
mostCurrent._mobhp.setText(BA.ObjectToCharSequence(_mobval));
RDebugUtils.currentLine=262163;
 //BA.debugLineNum = 262163;BA.debugLine="mob.Color = Colors.ARGB(0, 0, 0, 0)";
mostCurrent._mob.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=262164;
 //BA.debugLineNum = 262164;BA.debugLine="cvsGraph.Initialize(mob)";
mostCurrent._cvsgraph.Initialize((android.view.View)(mostCurrent._mob.getObject()));
RDebugUtils.currentLine=262165;
 //BA.debugLineNum = 262165;BA.debugLine="rect1.Initialize(10dip, 10dip, 250dip, 35dip)";
mostCurrent._rect1.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
RDebugUtils.currentLine=262166;
 //BA.debugLineNum = 262166;BA.debugLine="cvsGraph.DrawRect(rect1, xui.Color_Black, False";
mostCurrent._cvsgraph.DrawRect((android.graphics.Rect)(mostCurrent._rect1.getObject()),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=262168;
 //BA.debugLineNum = 262168;BA.debugLine="mob2.Color=Colors.ARGB(0, 0, 0, 0)";
mostCurrent._mob2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=262169;
 //BA.debugLineNum = 262169;BA.debugLine="cvsGraph2.Initialize(mob2)";
mostCurrent._cvsgraph2.Initialize((android.view.View)(mostCurrent._mob2.getObject()));
RDebugUtils.currentLine=262170;
 //BA.debugLineNum = 262170;BA.debugLine="rect2.Initialize(10dip, 10dip, IntToDIP(mobVal-";
mostCurrent._rect2.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_inttodip((int) (_mobval-33)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
RDebugUtils.currentLine=262171;
 //BA.debugLineNum = 262171;BA.debugLine="cvsGraph2.DrawRect(rect2, xui.Color_Red , True,";
mostCurrent._cvsgraph2.DrawRect((android.graphics.Rect)(mostCurrent._rect2.getObject()),_xui.Color_Red,anywheresoftware.b4a.keywords.Common.True,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=262173;
 //BA.debugLineNum = 262173;BA.debugLine="ply1.Color = Colors.ARGB(0, 0, 0, 0)";
mostCurrent._ply1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=262174;
 //BA.debugLineNum = 262174;BA.debugLine="cvsGraph3.Initialize(ply1)";
mostCurrent._cvsgraph3.Initialize((android.view.View)(mostCurrent._ply1.getObject()));
RDebugUtils.currentLine=262175;
 //BA.debugLineNum = 262175;BA.debugLine="rect3.Initialize(10dip, 10dip, 250dip, 35dip)";
mostCurrent._rect3.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
RDebugUtils.currentLine=262176;
 //BA.debugLineNum = 262176;BA.debugLine="cvsGraph3.DrawRect(rect3, xui.Color_Black, Fals";
mostCurrent._cvsgraph3.DrawRect((android.graphics.Rect)(mostCurrent._rect3.getObject()),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=262178;
 //BA.debugLineNum = 262178;BA.debugLine="ply2.Color=Colors.ARGB(0, 0, 0, 0)";
mostCurrent._ply2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=262179;
 //BA.debugLineNum = 262179;BA.debugLine="cvsGraph4.Initialize(ply2)";
mostCurrent._cvsgraph4.Initialize((android.view.View)(mostCurrent._ply2.getObject()));
RDebugUtils.currentLine=262180;
 //BA.debugLineNum = 262180;BA.debugLine="rect4.Initialize(10dip, 10dip, IntToDIP(HPval*4";
mostCurrent._rect4.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_inttodip((int) (_hpval*4.67)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
RDebugUtils.currentLine=262181;
 //BA.debugLineNum = 262181;BA.debugLine="cvsGraph4.DrawRect(rect4, xui.Color_Red , True,";
mostCurrent._cvsgraph4.DrawRect((android.graphics.Rect)(mostCurrent._rect4.getObject()),_xui.Color_Red,anywheresoftware.b4a.keywords.Common.True,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=262183;
 //BA.debugLineNum = 262183;BA.debugLine="Dim symbol() As String = Array As String(\"+\", \"";
_symbol = new String[]{"+","*"};
RDebugUtils.currentLine=262184;
 //BA.debugLineNum = 262184;BA.debugLine="Dim rand1 As Int = Rnd(0,10)";
_rand1 = anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (10));
RDebugUtils.currentLine=262185;
 //BA.debugLineNum = 262185;BA.debugLine="Dim rand2 As Int = Rnd(0,10)";
_rand2 = anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (10));
RDebugUtils.currentLine=262186;
 //BA.debugLineNum = 262186;BA.debugLine="num1.Text=rand1";
mostCurrent._num1.setText(BA.ObjectToCharSequence(_rand1));
RDebugUtils.currentLine=262187;
 //BA.debugLineNum = 262187;BA.debugLine="num2.Text=rand2";
mostCurrent._num2.setText(BA.ObjectToCharSequence(_rand2));
RDebugUtils.currentLine=262188;
 //BA.debugLineNum = 262188;BA.debugLine="ShuffleArray(symbol)";
_shufflearray(_symbol);
RDebugUtils.currentLine=262189;
 //BA.debugLineNum = 262189;BA.debugLine="operation.text = symbol(0)";
mostCurrent._operation.setText(BA.ObjectToCharSequence(_symbol[(int) (0)]));
RDebugUtils.currentLine=262191;
 //BA.debugLineNum = 262191;BA.debugLine="Select symbol(0)";
switch (BA.switchObjectToInt(_symbol[(int) (0)],"+","-","*","/")) {
case 0: {
RDebugUtils.currentLine=262193;
 //BA.debugLineNum = 262193;BA.debugLine="str =rand1+rand2";
mostCurrent._str = BA.NumberToString(_rand1+_rand2);
 break; }
case 1: {
RDebugUtils.currentLine=262195;
 //BA.debugLineNum = 262195;BA.debugLine="str =rand1-rand2";
mostCurrent._str = BA.NumberToString(_rand1-_rand2);
 break; }
case 2: {
RDebugUtils.currentLine=262197;
 //BA.debugLineNum = 262197;BA.debugLine="str =rand1*rand2";
mostCurrent._str = BA.NumberToString(_rand1*_rand2);
 break; }
case 3: {
RDebugUtils.currentLine=262199;
 //BA.debugLineNum = 262199;BA.debugLine="str =rand1/rand2";
mostCurrent._str = BA.NumberToString(_rand1/(double)_rand2);
 break; }
}
;
 };
RDebugUtils.currentLine=262204;
 //BA.debugLineNum = 262204;BA.debugLine="End Sub";
return "";
}
public static String  _state() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "state", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "state", null));}
RDebugUtils.currentLine=25427968;
 //BA.debugLineNum = 25427968;BA.debugLine="Sub state";
RDebugUtils.currentLine=25427970;
 //BA.debugLineNum = 25427970;BA.debugLine="Load.Initialize(\"\") : Load.Visible = False";
mostCurrent._load.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=25427970;
 //BA.debugLineNum = 25427970;BA.debugLine="Load.Initialize(\"\") : Load.Visible = False";
mostCurrent._load.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25427971;
 //BA.debugLineNum = 25427971;BA.debugLine="GameState.Initialize(\"\") : GameState.Visible = Fa";
mostCurrent._gamestate.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=25427971;
 //BA.debugLineNum = 25427971;BA.debugLine="GameState.Initialize(\"\") : GameState.Visible = Fa";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25427972;
 //BA.debugLineNum = 25427972;BA.debugLine="GameOverState.Initialize(\"\") : GameOverState.Visi";
mostCurrent._gameoverstate.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=25427972;
 //BA.debugLineNum = 25427972;BA.debugLine="GameOverState.Initialize(\"\") : GameOverState.Visi";
mostCurrent._gameoverstate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25427973;
 //BA.debugLineNum = 25427973;BA.debugLine="PauseState.Initialize(\"\"): PauseState.Visible = F";
mostCurrent._pausestate.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=25427973;
 //BA.debugLineNum = 25427973;BA.debugLine="PauseState.Initialize(\"\"): PauseState.Visible = F";
mostCurrent._pausestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25427974;
 //BA.debugLineNum = 25427974;BA.debugLine="TitleState.Initialize(\"\"): TitleState.Visible = F";
mostCurrent._titlestate.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=25427974;
 //BA.debugLineNum = 25427974;BA.debugLine="TitleState.Initialize(\"\"): TitleState.Visible = F";
mostCurrent._titlestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25427976;
 //BA.debugLineNum = 25427976;BA.debugLine="Load.LoadLayout(\"Load\") 'Regular layouts created";
mostCurrent._load.LoadLayout("Load",mostCurrent.activityBA);
RDebugUtils.currentLine=25427977;
 //BA.debugLineNum = 25427977;BA.debugLine="GameState.LoadLayout(\"GameState\")";
mostCurrent._gamestate.LoadLayout("GameState",mostCurrent.activityBA);
RDebugUtils.currentLine=25427978;
 //BA.debugLineNum = 25427978;BA.debugLine="TitleState.LoadLayout(\"TitleState\")";
mostCurrent._titlestate.LoadLayout("TitleState",mostCurrent.activityBA);
RDebugUtils.currentLine=25427979;
 //BA.debugLineNum = 25427979;BA.debugLine="GameOverState.LoadLayout(\"GameOverState\")";
mostCurrent._gameoverstate.LoadLayout("GameOverState",mostCurrent.activityBA);
RDebugUtils.currentLine=25427980;
 //BA.debugLineNum = 25427980;BA.debugLine="Activity.AddView(Load,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._load.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=25427981;
 //BA.debugLineNum = 25427981;BA.debugLine="Activity.AddView(GameState,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._gamestate.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=25427982;
 //BA.debugLineNum = 25427982;BA.debugLine="Activity.AddView(TitleState,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._titlestate.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=25427983;
 //BA.debugLineNum = 25427983;BA.debugLine="Activity.AddView(GameOverState,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._gameoverstate.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=25427985;
 //BA.debugLineNum = 25427985;BA.debugLine="End Sub";
return "";
}
public static int  _inttodip(int _integer) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "inttodip", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "inttodip", new Object[] {_integer}));}
int _dip = 0;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub IntToDIP(Integer As Int) As Int";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Dim DIP As Int";
_dip = 0;
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="DIP = Integer *1dip";
_dip = (int) (_integer*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="Return DIP";
if (true) return _dip;
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="End Sub";
return 0;
}
public static String  _shufflearray(String[] _stringarray) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "shufflearray", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "shufflearray", new Object[] {_stringarray}));}
String _arrayval = "";
int _random = 0;
int _i = 0;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Public Sub ShuffleArray(StringArray() As String)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Dim ArrayVal As String";
_arrayval = "";
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Dim Random As Int";
_random = 0;
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="For i = 0 To StringArray.Length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_stringarray.length-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="Random = Rnd(i, StringArray.Length)";
_random = anywheresoftware.b4a.keywords.Common.Rnd(_i,_stringarray.length);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="ArrayVal = StringArray(i)";
_arrayval = _stringarray[_i];
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="StringArray(i) = StringArray(Random)";
_stringarray[_i] = _stringarray[_random];
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="StringArray(Random) = ArrayVal";
_stringarray[_random] = _arrayval;
 }
};
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="End Sub";
return "";
}
public static String  _button0_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button0_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button0_click", null));}
RDebugUtils.currentLine=23724032;
 //BA.debugLineNum = 23724032;BA.debugLine="Private Sub Button0_Click";
RDebugUtils.currentLine=23724033;
 //BA.debugLineNum = 23724033;BA.debugLine="answer.Text = tempStr&\"0\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"0"));
RDebugUtils.currentLine=23724034;
 //BA.debugLineNum = 23724034;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=23724036;
 //BA.debugLineNum = 23724036;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button1_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub Button1_Click";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="answer.Text = tempStr&\"1\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"1"));
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button2_click", null));}
RDebugUtils.currentLine=24641536;
 //BA.debugLineNum = 24641536;BA.debugLine="Private Sub Button2_Click";
RDebugUtils.currentLine=24641537;
 //BA.debugLineNum = 24641537;BA.debugLine="answer.Text = tempStr&\"2\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"2"));
RDebugUtils.currentLine=24641538;
 //BA.debugLineNum = 24641538;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=24641539;
 //BA.debugLineNum = 24641539;BA.debugLine="End Sub";
return "";
}
public static String  _button3_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button3_click", null));}
RDebugUtils.currentLine=24576000;
 //BA.debugLineNum = 24576000;BA.debugLine="Private Sub Button3_Click";
RDebugUtils.currentLine=24576001;
 //BA.debugLineNum = 24576001;BA.debugLine="answer.Text = tempStr&\"3\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"3"));
RDebugUtils.currentLine=24576002;
 //BA.debugLineNum = 24576002;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=24576003;
 //BA.debugLineNum = 24576003;BA.debugLine="End Sub";
return "";
}
public static String  _button4_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button4_click", null));}
RDebugUtils.currentLine=24510464;
 //BA.debugLineNum = 24510464;BA.debugLine="Private Sub Button4_Click";
RDebugUtils.currentLine=24510465;
 //BA.debugLineNum = 24510465;BA.debugLine="answer.Text = tempStr&\"4\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"4"));
RDebugUtils.currentLine=24510466;
 //BA.debugLineNum = 24510466;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=24510467;
 //BA.debugLineNum = 24510467;BA.debugLine="End Sub";
return "";
}
public static String  _button5_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button5_click", null));}
RDebugUtils.currentLine=24444928;
 //BA.debugLineNum = 24444928;BA.debugLine="Private Sub Button5_Click";
RDebugUtils.currentLine=24444929;
 //BA.debugLineNum = 24444929;BA.debugLine="answer.Text = tempStr&\"5\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"5"));
RDebugUtils.currentLine=24444930;
 //BA.debugLineNum = 24444930;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=24444931;
 //BA.debugLineNum = 24444931;BA.debugLine="End Sub";
return "";
}
public static String  _button6_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button6_click", null));}
RDebugUtils.currentLine=24379392;
 //BA.debugLineNum = 24379392;BA.debugLine="Private Sub Button6_Click";
RDebugUtils.currentLine=24379393;
 //BA.debugLineNum = 24379393;BA.debugLine="answer.Text = tempStr&\"6\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"6"));
RDebugUtils.currentLine=24379394;
 //BA.debugLineNum = 24379394;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=24379395;
 //BA.debugLineNum = 24379395;BA.debugLine="End Sub";
return "";
}
public static String  _button7_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button7_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button7_click", null));}
RDebugUtils.currentLine=24313856;
 //BA.debugLineNum = 24313856;BA.debugLine="Private Sub Button7_Click";
RDebugUtils.currentLine=24313857;
 //BA.debugLineNum = 24313857;BA.debugLine="answer.Text = tempStr&\"7\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"7"));
RDebugUtils.currentLine=24313858;
 //BA.debugLineNum = 24313858;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=24313859;
 //BA.debugLineNum = 24313859;BA.debugLine="End Sub";
return "";
}
public static String  _button8_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button8_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button8_click", null));}
RDebugUtils.currentLine=24248320;
 //BA.debugLineNum = 24248320;BA.debugLine="Private Sub Button8_Click";
RDebugUtils.currentLine=24248321;
 //BA.debugLineNum = 24248321;BA.debugLine="answer.Text = tempStr&\"8\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"8"));
RDebugUtils.currentLine=24248322;
 //BA.debugLineNum = 24248322;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=24248323;
 //BA.debugLineNum = 24248323;BA.debugLine="End Sub";
return "";
}
public static String  _button9_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button9_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button9_click", null));}
RDebugUtils.currentLine=24182784;
 //BA.debugLineNum = 24182784;BA.debugLine="Private Sub Button9_Click";
RDebugUtils.currentLine=24182785;
 //BA.debugLineNum = 24182785;BA.debugLine="answer.Text = tempStr&\"9\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"9"));
RDebugUtils.currentLine=24182786;
 //BA.debugLineNum = 24182786;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=24182787;
 //BA.debugLineNum = 24182787;BA.debugLine="End Sub";
return "";
}
public static String  _buttonclear_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonclear_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonclear_click", null));}
RDebugUtils.currentLine=23658496;
 //BA.debugLineNum = 23658496;BA.debugLine="Private Sub ButtonClear_Click";
RDebugUtils.currentLine=23658497;
 //BA.debugLineNum = 23658497;BA.debugLine="answer.Text=\"\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=23658498;
 //BA.debugLineNum = 23658498;BA.debugLine="tempStr=\"\"";
mostCurrent._tempstr = "";
RDebugUtils.currentLine=23658500;
 //BA.debugLineNum = 23658500;BA.debugLine="End Sub";
return "";
}
public static String  _buttonenter_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonenter_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonenter_click", null));}
RDebugUtils.currentLine=23592960;
 //BA.debugLineNum = 23592960;BA.debugLine="Private Sub ButtonEnter_Click";
RDebugUtils.currentLine=23592961;
 //BA.debugLineNum = 23592961;BA.debugLine="tempStr=\"\"";
mostCurrent._tempstr = "";
RDebugUtils.currentLine=23592962;
 //BA.debugLineNum = 23592962;BA.debugLine="dammage = str";
_dammage = (int)(Double.parseDouble(mostCurrent._str));
RDebugUtils.currentLine=23592963;
 //BA.debugLineNum = 23592963;BA.debugLine="If answer.Text = str Then";
if ((mostCurrent._answer.getText()).equals(mostCurrent._str)) { 
RDebugUtils.currentLine=23592964;
 //BA.debugLineNum = 23592964;BA.debugLine="strAn.Text = \"Correct\"";
mostCurrent._stran.setText(BA.ObjectToCharSequence("Correct"));
RDebugUtils.currentLine=23592966;
 //BA.debugLineNum = 23592966;BA.debugLine="mobVal= mobVal-dammage";
_mobval = (int) (_mobval-_dammage);
 }else {
RDebugUtils.currentLine=23592969;
 //BA.debugLineNum = 23592969;BA.debugLine="strAn.Text = \"InCorrect\"";
mostCurrent._stran.setText(BA.ObjectToCharSequence("InCorrect"));
RDebugUtils.currentLine=23592970;
 //BA.debugLineNum = 23592970;BA.debugLine="HPval = HPval-dammage";
_hpval = (int) (_hpval-_dammage);
 };
RDebugUtils.currentLine=23592974;
 //BA.debugLineNum = 23592974;BA.debugLine="GameState.Visible=False";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23592975;
 //BA.debugLineNum = 23592975;BA.debugLine="RemoveViews";
_removeviews();
RDebugUtils.currentLine=23592976;
 //BA.debugLineNum = 23592976;BA.debugLine="Activity_Create(True)";
_activity_create(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=23592977;
 //BA.debugLineNum = 23592977;BA.debugLine="check = True";
_check = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=23592978;
 //BA.debugLineNum = 23592978;BA.debugLine="If HPval <= 100 And HPval >= 0 Then";
if (_hpval<=100 && _hpval>=0) { 
RDebugUtils.currentLine=23592979;
 //BA.debugLineNum = 23592979;BA.debugLine="GameState.Visible=True";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=23592981;
 //BA.debugLineNum = 23592981;BA.debugLine="End Sub";
return "";
}
public static String  _removeviews() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "removeviews", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "removeviews", null));}
int _i = 0;
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub RemoveViews";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="For i = Activity.NumberOfViews - 1 To 0 Step -1";
{
final int step2 = -1;
final int limit2 = (int) (0);
_i = (int) (mostCurrent._activity.getNumberOfViews()-1) ;
for (;_i >= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Activity.RemoveViewAt(i)";
mostCurrent._activity.RemoveViewAt(_i);
 }
};
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="End Sub";
return "";
}
public static String  _retry_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "retry_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "retry_click", null));}
RDebugUtils.currentLine=25034752;
 //BA.debugLineNum = 25034752;BA.debugLine="Private Sub Retry_Click";
RDebugUtils.currentLine=25034754;
 //BA.debugLineNum = 25034754;BA.debugLine="HPval = 100";
_hpval = (int) (100);
RDebugUtils.currentLine=25034755;
 //BA.debugLineNum = 25034755;BA.debugLine="mobVal = 500";
_mobval = (int) (500);
RDebugUtils.currentLine=25034757;
 //BA.debugLineNum = 25034757;BA.debugLine="GameOverState.Visible = False";
mostCurrent._gameoverstate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25034758;
 //BA.debugLineNum = 25034758;BA.debugLine="RemoveViews";
_removeviews();
RDebugUtils.currentLine=25034759;
 //BA.debugLineNum = 25034759;BA.debugLine="Activity_Create(True)";
_activity_create(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25034760;
 //BA.debugLineNum = 25034760;BA.debugLine="GameState.Visible = True";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25034761;
 //BA.debugLineNum = 25034761;BA.debugLine="time(True)";
_time(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25034763;
 //BA.debugLineNum = 25034763;BA.debugLine="End Sub";
return "";
}
public static String  _time(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "time", new Object[] {_firsttime}));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub time (FirstTime As Boolean)";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="If True Then";
if (anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="timer1.Initialize(\"timer1\", 100)";
mostCurrent._timer1.Initialize(processBA,"timer1",(long) (100));
 };
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="StartTimer(2)";
_starttimer((int) (2));
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="End Sub";
return "";
}
public static String  _start_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "start_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "start_click", null));}
RDebugUtils.currentLine=24117248;
 //BA.debugLineNum = 24117248;BA.debugLine="Private Sub Start_Click";
RDebugUtils.currentLine=24117249;
 //BA.debugLineNum = 24117249;BA.debugLine="check = True";
_check = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=24117250;
 //BA.debugLineNum = 24117250;BA.debugLine="TitleState.Visible = False";
mostCurrent._titlestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24117251;
 //BA.debugLineNum = 24117251;BA.debugLine="GameState.Visible = True";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24117252;
 //BA.debugLineNum = 24117252;BA.debugLine="time(True)";
_time(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24117253;
 //BA.debugLineNum = 24117253;BA.debugLine="End Sub";
return "";
}
public static String  _starttimer(int _minutes) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "starttimer", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "starttimer", new Object[] {_minutes}));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub StartTimer (Minutes As Int) 'insert Hours As I";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="targetTime = DateTime.Now + Minutes * DateTime.Ti";
_targettime = (long) (anywheresoftware.b4a.keywords.Common.DateTime.getNow()+_minutes*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="timer1.Enabled = True";
mostCurrent._timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timer1_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "timer1_tick", null));}
long _t = 0L;
int _minutes = 0;
int _seconds = 0;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Timer1_Tick";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim t As Long = Max(0, targetTime - DateTime.Now)";
_t = (long) (anywheresoftware.b4a.keywords.Common.Max(0,_targettime-anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="Dim  minutes, seconds As Int";
_minutes = 0;
_seconds = 0;
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="minutes = (t Mod DateTime.TicksPerHour) / DateTim";
_minutes = (int) ((_t%anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour)/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute);
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="seconds = (t Mod DateTime.TicksPerMinute) / DateT";
_seconds = (int) ((_t%anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute)/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerSecond);
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="Log($\"$2.0{minutes}:$2.0{seconds}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("3720904",(""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("2.0",(Object)(_minutes))+":"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("2.0",(Object)(_seconds))+""),0);
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="If t = 0 Then";
if (_t==0) { 
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="timer1.Enabled = False";
mostCurrent._timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="countdown.Text=($\"$2.0{minutes}:$2.0{seconds}\"$)";
mostCurrent._countdown.setText(BA.ObjectToCharSequence(((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("2.0",(Object)(_minutes))+":"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("2.0",(Object)(_seconds))+""))));
RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="End Sub";
return "";
}
}