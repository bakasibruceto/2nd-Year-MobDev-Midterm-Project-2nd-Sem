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
public static int _monstertype = 0;
public static String[] _monster = null;
public static String _filename = "";
public static anywheresoftware.b4a.objects.MediaPlayerWrapper _mediaplayer = null;
public anywheresoftware.b4a.objects.LabelWrapper _num1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _num2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _operation = null;
public anywheresoftware.b4a.objects.LabelWrapper _hp = null;
public anywheresoftware.b4a.objects.LabelWrapper _mobhp = null;
public anywheresoftware.b4a.objects.LabelWrapper _answer = null;
public anywheresoftware.b4a.objects.LabelWrapper _countdown = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _titlepanel = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _titlebg = null;
public anywheresoftware.b4a.objects.LabelWrapper _stran = null;
public static String _str = "";
public static int _damage = 0;
public static int _hpval = 0;
public static int _mobval = 0;
public anywheresoftware.b4a.objects.Timer _timer1 = null;
public static long _targettime = 0L;
public static String _tempstr = "";
public static boolean _check = false;
public static String[] _operator = null;
public static int _barsize = 0;
public anywheresoftware.b4a.objects.PanelWrapper _load = null;
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
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="InitializeState";
_initializestate();
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="DrawState";
_drawstate();
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="SoundEfx";
_soundefx();
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="If(HPval <= 100 And HPval >=1)Then";
if ((_hpval<=100 && _hpval>=1)) { 
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="DrawMonster";
_drawmonster();
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="DrawHealth";
_drawhealth();
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="DrawEquation";
_drawequation();
 };
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="End Sub";
return "";
}
public static String  _initializestate() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "initializestate", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "initializestate", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub InitializeState";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="titlepanel.Initialize(\"\")";
mostCurrent._titlepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="Activity.AddView(titlepanel, 0, 0, 100dip, 100dip";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._titlepanel.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Load.Initialize(\"\") : Load.Visible = False";
mostCurrent._load.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Load.Initialize(\"\") : Load.Visible = False";
mostCurrent._load.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="GameState.Initialize(\"\") : GameState.Visible = Fa";
mostCurrent._gamestate.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="GameState.Initialize(\"\") : GameState.Visible = Fa";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="GameOverState.Initialize(\"\") : GameOverState.Visi";
mostCurrent._gameoverstate.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="GameOverState.Initialize(\"\") : GameOverState.Visi";
mostCurrent._gameoverstate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="PauseState.Initialize(\"\"): PauseState.Visible = F";
mostCurrent._pausestate.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="PauseState.Initialize(\"\"): PauseState.Visible = F";
mostCurrent._pausestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="TitleState.Initialize(\"\"): TitleState.Visible = F";
mostCurrent._titlestate.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="TitleState.Initialize(\"\"): TitleState.Visible = F";
mostCurrent._titlestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="GameDefeated.Initialize(\"\"): GameDefeated.Visible";
mostCurrent._gamedefeated.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="GameDefeated.Initialize(\"\"): GameDefeated.Visible";
mostCurrent._gamedefeated.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="Load.LoadLayout(\"Load\") 'Regular layouts created";
mostCurrent._load.LoadLayout("Load",mostCurrent.activityBA);
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="GameState.LoadLayout(\"GameState\")";
mostCurrent._gamestate.LoadLayout("GameState",mostCurrent.activityBA);
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="TitleState.LoadLayout(\"TitleState\")";
mostCurrent._titlestate.LoadLayout("TitleState",mostCurrent.activityBA);
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="GameOverState.LoadLayout(\"GameOverState\")";
mostCurrent._gameoverstate.LoadLayout("GameOverState",mostCurrent.activityBA);
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="GameDefeated.LoadLayout(\"GameDefeated\")";
mostCurrent._gamedefeated.LoadLayout("GameDefeated",mostCurrent.activityBA);
RDebugUtils.currentLine=458767;
 //BA.debugLineNum = 458767;BA.debugLine="Activity.AddView(Load,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._load.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="Activity.AddView(GameState,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._gamestate.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=458769;
 //BA.debugLineNum = 458769;BA.debugLine="Activity.AddView(TitleState,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._titlestate.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=458770;
 //BA.debugLineNum = 458770;BA.debugLine="Activity.AddView(GameOverState,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._gameoverstate.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=458771;
 //BA.debugLineNum = 458771;BA.debugLine="Activity.AddView(GameDefeated,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._gamedefeated.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=458773;
 //BA.debugLineNum = 458773;BA.debugLine="End Sub";
return "";
}
public static String  _drawstate() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawstate", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "drawstate", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub DrawState";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="If check == False Then";
if (_check==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Load.Visible = True";
mostCurrent._load.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="Load.Visible = False";
mostCurrent._load.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="TitleState.Visible = True";
mostCurrent._titlestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="If HPval <=0 Then";
if (_hpval<=0) { 
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="GameState.Visible = False";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="GameOverState.Visible = True";
mostCurrent._gameoverstate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=524302;
 //BA.debugLineNum = 524302;BA.debugLine="End Sub";
return "";
}
public static String  _soundefx() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "soundefx", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "soundefx", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub SoundEfx";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="MediaPlayer.Initialize()";
_mediaplayer.Initialize();
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="MediaPlayer.Load(File.DirAssets,\"pdam.mp3\")";
_mediaplayer.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"pdam.mp3");
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="End Sub";
return "";
}
public static String  _drawmonster() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawmonster", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "drawmonster", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub DrawMonster";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="If mobVal <= 0 Then";
if (_mobval<=0) { 
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="MonsterType = MonsterType+1";
_monstertype = (int) (_monstertype+1);
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Select MonsterType";
switch (_monstertype) {
case 1: {
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="mobVal = 1";
_mobval = (int) (1);
 break; }
case 2: {
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="mobVal = 1";
_mobval = (int) (1);
 break; }
}
;
 };
RDebugUtils.currentLine=589836;
 //BA.debugLineNum = 589836;BA.debugLine="If MonsterType<3 Then";
if (_monstertype<3) { 
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="FileName = Monster(MonsterType)";
_filename = _monster[_monstertype];
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="ImageView1.Bitmap = LoadBitmap(File.DirAssets, F";
mostCurrent._imageview1.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_filename).getObject()));
 };
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="End Sub";
return "";
}
public static String  _drawhealth() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawhealth", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "drawhealth", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub DrawHealth";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="HP.Text=HPval";
mostCurrent._hp.setText(BA.ObjectToCharSequence(_hpval));
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="mobHP.Text=mobVal";
mostCurrent._mobhp.setText(BA.ObjectToCharSequence(_mobval));
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="mob.Color = Colors.ARGB(0, 0, 0, 0)";
mostCurrent._mob.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="cvsGraph.Initialize(mob)";
mostCurrent._cvsgraph.Initialize((android.view.View)(mostCurrent._mob.getObject()));
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="rect1.Initialize(10dip, 10dip, 250dip, 35dip)";
mostCurrent._rect1.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="cvsGraph.DrawRect(rect1, xui.Color_Black, False,";
mostCurrent._cvsgraph.DrawRect((android.graphics.Rect)(mostCurrent._rect1.getObject()),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="mob2.Color=Colors.ARGB(0, 0, 0, 0)";
mostCurrent._mob2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="cvsGraph2.Initialize(mob2)";
mostCurrent._cvsgraph2.Initialize((android.view.View)(mostCurrent._mob2.getObject()));
RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="rect2.Initialize(10dip, 10dip, IntToDIP(mobVal-33";
mostCurrent._rect2.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_inttodip((int) (_mobval-33)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
RDebugUtils.currentLine=655372;
 //BA.debugLineNum = 655372;BA.debugLine="cvsGraph2.DrawRect(rect2, xui.Color_Red , True, 2";
mostCurrent._cvsgraph2.DrawRect((android.graphics.Rect)(mostCurrent._rect2.getObject()),_xui.Color_Red,anywheresoftware.b4a.keywords.Common.True,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="ply1.Color = Colors.ARGB(0, 0, 0, 0)";
mostCurrent._ply1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="cvsGraph3.Initialize(ply1)";
mostCurrent._cvsgraph3.Initialize((android.view.View)(mostCurrent._ply1.getObject()));
RDebugUtils.currentLine=655376;
 //BA.debugLineNum = 655376;BA.debugLine="rect3.Initialize(10dip, 10dip, 250dip, 35dip)";
mostCurrent._rect3.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
RDebugUtils.currentLine=655377;
 //BA.debugLineNum = 655377;BA.debugLine="cvsGraph3.DrawRect(rect3, xui.Color_Black, False,";
mostCurrent._cvsgraph3.DrawRect((android.graphics.Rect)(mostCurrent._rect3.getObject()),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=655379;
 //BA.debugLineNum = 655379;BA.debugLine="ply2.Color=Colors.ARGB(0, 0, 0, 0)";
mostCurrent._ply2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=655380;
 //BA.debugLineNum = 655380;BA.debugLine="cvsGraph4.Initialize(ply2)";
mostCurrent._cvsgraph4.Initialize((android.view.View)(mostCurrent._ply2.getObject()));
RDebugUtils.currentLine=655381;
 //BA.debugLineNum = 655381;BA.debugLine="rect4.Initialize(10dip, 10dip, IntToDIP(HPval*4.6";
mostCurrent._rect4.Initialize(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_inttodip((int) (_hpval*4.67)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
RDebugUtils.currentLine=655382;
 //BA.debugLineNum = 655382;BA.debugLine="cvsGraph4.DrawRect(rect4, xui.Color_Red , True, 2";
mostCurrent._cvsgraph4.DrawRect((android.graphics.Rect)(mostCurrent._rect4.getObject()),_xui.Color_Red,anywheresoftware.b4a.keywords.Common.True,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=655383;
 //BA.debugLineNum = 655383;BA.debugLine="End Sub";
return "";
}
public static String  _drawequation() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawequation", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "drawequation", null));}
int _rand1 = 0;
int _rand2 = 0;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub DrawEquation";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim rand1 As Int = Rnd(0,10)";
_rand1 = anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (10));
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Dim rand2 As Int = Rnd(0,10)";
_rand2 = anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (10));
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="num1.Text=rand1";
mostCurrent._num1.setText(BA.ObjectToCharSequence(_rand1));
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="num2.Text=rand2";
mostCurrent._num2.setText(BA.ObjectToCharSequence(_rand2));
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="ShuffleArray(operator)";
_shufflearray(mostCurrent._operator);
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="operation.text = operator(0)";
mostCurrent._operation.setText(BA.ObjectToCharSequence(mostCurrent._operator[(int) (0)]));
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="Select operator(0)";
switch (BA.switchObjectToInt(mostCurrent._operator[(int) (0)],"+","-","*","/")) {
case 0: {
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="str =rand1+rand2";
mostCurrent._str = BA.NumberToString(_rand1+_rand2);
 break; }
case 1: {
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="str =rand1-rand2";
mostCurrent._str = BA.NumberToString(_rand1-_rand2);
 break; }
case 2: {
RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="str =rand1*rand2";
mostCurrent._str = BA.NumberToString(_rand1*_rand2);
 break; }
case 3: {
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="str =rand1/rand2";
mostCurrent._str = BA.NumberToString(_rand1/(double)_rand2);
 break; }
}
;
RDebugUtils.currentLine=720913;
 //BA.debugLineNum = 720913;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _button0_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button0_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button0_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub Button0_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="answer.Text = tempStr&\"0\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"0"));
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button1_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub Button1_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="answer.Text = tempStr&\"1\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"1"));
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button2_click", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Private Sub Button2_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="answer.Text = tempStr&\"2\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"2"));
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="End Sub";
return "";
}
public static String  _button3_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button3_click", null));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Private Sub Button3_Click";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="answer.Text = tempStr&\"3\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"3"));
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="End Sub";
return "";
}
public static String  _button4_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button4_click", null));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Private Sub Button4_Click";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="answer.Text = tempStr&\"4\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"4"));
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="End Sub";
return "";
}
public static String  _button5_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button5_click", null));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Private Sub Button5_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="answer.Text = tempStr&\"5\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"5"));
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="End Sub";
return "";
}
public static String  _button6_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button6_click", null));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Private Sub Button6_Click";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="answer.Text = tempStr&\"6\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"6"));
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="End Sub";
return "";
}
public static String  _button7_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button7_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button7_click", null));}
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Private Sub Button7_Click";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="answer.Text = tempStr&\"7\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"7"));
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="End Sub";
return "";
}
public static String  _button8_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button8_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button8_click", null));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub Button8_Click";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="answer.Text = tempStr&\"8\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"8"));
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="End Sub";
return "";
}
public static String  _button9_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button9_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button9_click", null));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Private Sub Button9_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="answer.Text = tempStr&\"9\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(mostCurrent._tempstr+"9"));
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="tempStr = answer.Text";
mostCurrent._tempstr = mostCurrent._answer.getText();
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="End Sub";
return "";
}
public static String  _buttonclear_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonclear_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonclear_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub ButtonClear_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="answer.Text=\"\"";
mostCurrent._answer.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="tempStr=\"\"";
mostCurrent._tempstr = "";
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="End Sub";
return "";
}
public static String  _buttonenter_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonenter_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonenter_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub ButtonEnter_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="tempStr=\"\"";
mostCurrent._tempstr = "";
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="damage = str";
_damage = (int)(Double.parseDouble(mostCurrent._str));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="If answer.Text = str Then";
if ((mostCurrent._answer.getText()).equals(mostCurrent._str)) { 
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="strAn.Text = \"Correct\"";
mostCurrent._stran.setText(BA.ObjectToCharSequence("Correct"));
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="mobVal= mobVal-damage";
_mobval = (int) (_mobval-_damage);
 }else {
RDebugUtils.currentLine=1310729;
 //BA.debugLineNum = 1310729;BA.debugLine="strAn.Text = \"InCorrect\"";
mostCurrent._stran.setText(BA.ObjectToCharSequence("InCorrect"));
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="HPval = HPval-damage";
_hpval = (int) (_hpval-_damage);
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="MediaPlayer.Play";
_mediaplayer.Play();
 };
RDebugUtils.currentLine=1310735;
 //BA.debugLineNum = 1310735;BA.debugLine="GameState.Visible=False";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1310736;
 //BA.debugLineNum = 1310736;BA.debugLine="ReDraw";
_redraw();
RDebugUtils.currentLine=1310737;
 //BA.debugLineNum = 1310737;BA.debugLine="Activity_Create(True)";
_activity_create(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1310738;
 //BA.debugLineNum = 1310738;BA.debugLine="If MonsterType == 3 Then";
if (_monstertype==3) { 
RDebugUtils.currentLine=1310739;
 //BA.debugLineNum = 1310739;BA.debugLine="GameDefeated.Visible=True";
mostCurrent._gamedefeated.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=1310741;
 //BA.debugLineNum = 1310741;BA.debugLine="check = True";
_check = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1310742;
 //BA.debugLineNum = 1310742;BA.debugLine="If HPval <= 100 And HPval >= 0 Then";
if (_hpval<=100 && _hpval>=0) { 
RDebugUtils.currentLine=1310743;
 //BA.debugLineNum = 1310743;BA.debugLine="GameState.Visible=True";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 };
RDebugUtils.currentLine=1310747;
 //BA.debugLineNum = 1310747;BA.debugLine="End Sub";
return "";
}
public static String  _redraw() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "redraw", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "redraw", null));}
int _i = 0;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub ReDraw";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="For i = Activity.NumberOfViews - 1 To 0 Step -1";
{
final int step2 = -1;
final int limit2 = (int) (0);
_i = (int) (mostCurrent._activity.getNumberOfViews()-1) ;
for (;_i >= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="Activity.RemoveViewAt(i)";
mostCurrent._activity.RemoveViewAt(_i);
 }
};
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="End Sub";
return "";
}
public static String  _shufflearray(String[] _stringarray) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "shufflearray", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "shufflearray", new Object[] {_stringarray}));}
String _arrayval = "";
int _random = 0;
int _i = 0;
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub ShuffleArray(StringArray() As String)";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Dim ArrayVal As String";
_arrayval = "";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Dim Random As Int";
_random = 0;
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="For i = 0 To StringArray.Length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_stringarray.length-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="Random = Rnd(i, StringArray.Length)";
_random = anywheresoftware.b4a.keywords.Common.Rnd(_i,_stringarray.length);
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="ArrayVal = StringArray(i)";
_arrayval = _stringarray[_i];
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="StringArray(i) = StringArray(Random)";
_stringarray[_i] = _stringarray[_random];
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="StringArray(Random) = ArrayVal";
_stringarray[_random] = _arrayval;
 }
};
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="End Sub";
return "";
}
public static int  _inttodip(int _integer) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "inttodip", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "inttodip", new Object[] {_integer}));}
int _dip = 0;
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub IntToDIP(Integer As Int) As Int";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Dim DIP As Int";
_dip = 0;
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="DIP = Integer *1dip";
_dip = (int) (_integer*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="Return DIP";
if (true) return _dip;
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="End Sub";
return 0;
}
public static String  _retry_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "retry_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "retry_click", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub Retry_Click";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="HPval = 100";
_hpval = (int) (100);
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="mobVal = 100";
_mobval = (int) (100);
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="MonsterType = 0";
_monstertype = (int) (0);
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="FileName = Monster(MonsterType)";
_filename = _monster[_monstertype];
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="GameOverState.Visible = False";
mostCurrent._gameoverstate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="ReDraw";
_redraw();
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="Activity_Create(True)";
_activity_create(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="GameState.Visible = True";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1245196;
 //BA.debugLineNum = 1245196;BA.debugLine="End Sub";
return "";
}
public static String  _start_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "start_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "start_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub Start_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="check = True";
_check = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="TitleState.Visible = False";
mostCurrent._titlestate.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="GameState.Visible = True";
mostCurrent._gamestate.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="End Sub";
return "";
}
}