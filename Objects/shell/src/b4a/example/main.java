
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.example.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _monstertype = RemoteObject.createImmutable(0);
public static RemoteObject _monster = null;
public static RemoteObject _filename = RemoteObject.createImmutable("");
public static RemoteObject _mediaplayer = RemoteObject.declareNull("anywheresoftware.b4a.objects.MediaPlayerWrapper");
public static RemoteObject _num1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _num2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _operation = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hp = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _mobhp = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _answer = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _countdown = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _imageview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titlepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _titlebg = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _stran = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _str = RemoteObject.createImmutable("");
public static RemoteObject _damage = RemoteObject.createImmutable(0);
public static RemoteObject _hpval = RemoteObject.createImmutable(0);
public static RemoteObject _mobval = RemoteObject.createImmutable(0);
public static RemoteObject _timer1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _targettime = RemoteObject.createImmutable(0L);
public static RemoteObject _tempstr = RemoteObject.createImmutable("");
public static RemoteObject _check = RemoteObject.createImmutable(false);
public static RemoteObject _operator = null;
public static RemoteObject _barsize = RemoteObject.createImmutable(0);
public static RemoteObject _load = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _gamestate = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pausestate = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _titlestate = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _gameoverstate = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _gamedefeated = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _button1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _mob = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _mob2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _ply1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _ply2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cvsgraph = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
public static RemoteObject _cvsgraph2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
public static RemoteObject _cvsgraph3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
public static RemoteObject _cvsgraph4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
public static RemoteObject _rect1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
public static RemoteObject _rect2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
public static RemoteObject _rect3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
public static RemoteObject _rect4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
public static RemoteObject _button0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _button2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _button3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _button4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _button5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _button6 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _button7 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _button8 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _button9 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonenter = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonclear = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _shake = RemoteObject.declareNull("anywheresoftware.b4a.objects.AnimationWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static b4a.example.starter _starter = null;
public static b4a.example.xuiviewsutils _xuiviewsutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"answer",main.mostCurrent._answer,"barsize",main._barsize,"Button0",main.mostCurrent._button0,"Button1",main.mostCurrent._button1,"Button2",main.mostCurrent._button2,"Button3",main.mostCurrent._button3,"Button4",main.mostCurrent._button4,"Button5",main.mostCurrent._button5,"Button6",main.mostCurrent._button6,"Button7",main.mostCurrent._button7,"Button8",main.mostCurrent._button8,"Button9",main.mostCurrent._button9,"ButtonClear",main.mostCurrent._buttonclear,"ButtonEnter",main.mostCurrent._buttonenter,"check",main._check,"countdown",main.mostCurrent._countdown,"cvsGraph",main.mostCurrent._cvsgraph,"cvsGraph2",main.mostCurrent._cvsgraph2,"cvsGraph3",main.mostCurrent._cvsgraph3,"cvsGraph4",main.mostCurrent._cvsgraph4,"damage",main._damage,"DateUtils",main.mostCurrent._dateutils,"FileName",main._filename,"GameDefeated",main.mostCurrent._gamedefeated,"GameOverState",main.mostCurrent._gameoverstate,"GameState",main.mostCurrent._gamestate,"HP",main.mostCurrent._hp,"HPval",main._hpval,"ImageView1",main.mostCurrent._imageview1,"Load",main.mostCurrent._load,"MediaPlayer",main._mediaplayer,"mob",main.mostCurrent._mob,"mob2",main.mostCurrent._mob2,"mobHP",main.mostCurrent._mobhp,"mobVal",main._mobval,"Monster",main._monster,"MonsterType",main._monstertype,"num1",main.mostCurrent._num1,"num2",main.mostCurrent._num2,"operation",main.mostCurrent._operation,"operator",main.mostCurrent._operator,"PauseState",main.mostCurrent._pausestate,"ply1",main.mostCurrent._ply1,"ply2",main.mostCurrent._ply2,"rect1",main.mostCurrent._rect1,"rect2",main.mostCurrent._rect2,"rect3",main.mostCurrent._rect3,"rect4",main.mostCurrent._rect4,"shake",main.mostCurrent._shake,"Starter",Debug.moduleToString(b4a.example.starter.class),"str",main.mostCurrent._str,"strAn",main.mostCurrent._stran,"targetTime",main._targettime,"tempStr",main.mostCurrent._tempstr,"timer1",main.mostCurrent._timer1,"titlebg",main.mostCurrent._titlebg,"titlepanel",main.mostCurrent._titlepanel,"TitleState",main.mostCurrent._titlestate,"xui",main._xui,"XUIViewsUtils",Debug.moduleToString(b4a.example.xuiviewsutils.class)};
}
}