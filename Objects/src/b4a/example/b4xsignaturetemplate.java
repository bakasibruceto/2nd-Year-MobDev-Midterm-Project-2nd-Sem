package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xsignaturetemplate extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.b4xsignaturetemplate");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.b4xsignaturetemplate.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
public float _lastx = 0f;
public float _lasty = 0f;
public float _strokewidth = 0f;
public int _strokecolor = 0;
public int _textcolor = 0;
public int _backgroundcolor = 0;
public boolean _adddateandtime = false;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _textfont = null;
public int _numberofpoints = 0;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public anywheresoftware.b4a.objects.B4XViewWrapper  _getpanel(b4a.example.b4xsignaturetemplate __ref,b4a.example.b4xdialog _dialog) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xsignaturetemplate";
if (Debug.shouldDelegate(ba, "getpanel", true))
	 {return ((anywheresoftware.b4a.objects.B4XViewWrapper) Debug.delegate(ba, "getpanel", new Object[] {_dialog}));}
RDebugUtils.currentLine=19791872;
 //BA.debugLineNum = 19791872;BA.debugLine="Public Sub GetPanel (Dialog As B4XDialog) As B4XVi";
RDebugUtils.currentLine=19791873;
 //BA.debugLineNum = 19791873;BA.debugLine="Return mBase";
if (true) return __ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ;
RDebugUtils.currentLine=19791874;
 //BA.debugLineNum = 19791874;BA.debugLine="End Sub";
return null;
}
public String  _show(b4a.example.b4xsignaturetemplate __ref,b4a.example.b4xdialog _dialog) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xsignaturetemplate";
if (Debug.shouldDelegate(ba, "show", true))
	 {return ((String) Debug.delegate(ba, "show", new Object[] {_dialog}));}
RDebugUtils.currentLine=19857408;
 //BA.debugLineNum = 19857408;BA.debugLine="Private Sub Show (Dialog As B4XDialog) 'ignore";
RDebugUtils.currentLine=19857409;
 //BA.debugLineNum = 19857409;BA.debugLine="cvs.DrawRect(cvs.TargetRect, BackgroundColor, Tru";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawRect(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect(),__ref._backgroundcolor /*int*/ ,__c.True,(float) (0));
RDebugUtils.currentLine=19857410;
 //BA.debugLineNum = 19857410;BA.debugLine="cvs.Invalidate";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Invalidate();
RDebugUtils.currentLine=19857411;
 //BA.debugLineNum = 19857411;BA.debugLine="NumberOfPoints = 0";
__ref._numberofpoints /*int*/  = (int) (0);
RDebugUtils.currentLine=19857412;
 //BA.debugLineNum = 19857412;BA.debugLine="End Sub";
return "";
}
public String  _dialogclosed(b4a.example.b4xsignaturetemplate __ref,int _result) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xsignaturetemplate";
if (Debug.shouldDelegate(ba, "dialogclosed", true))
	 {return ((String) Debug.delegate(ba, "dialogclosed", new Object[] {_result}));}
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _r = null;
int _baseline = 0;
RDebugUtils.currentLine=20054016;
 //BA.debugLineNum = 20054016;BA.debugLine="Private Sub DialogClosed (Result As Int)";
RDebugUtils.currentLine=20054017;
 //BA.debugLineNum = 20054017;BA.debugLine="If Result = xui.DialogResponse_Positive And AddDa";
if (_result==__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .DialogResponse_Positive && __ref._adddateandtime /*boolean*/ ) { 
RDebugUtils.currentLine=20054018;
 //BA.debugLineNum = 20054018;BA.debugLine="Dim r As B4XRect = cvs.MeasureText(\"M\", TextFont";
_r = __ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .MeasureText("M",__ref._textfont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/ );
RDebugUtils.currentLine=20054019;
 //BA.debugLineNum = 20054019;BA.debugLine="Dim Baseline As Int = cvs.TargetRect.Bottom - r.";
_baseline = (int) (__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect().getBottom()-_r.getHeight()-_r.getTop()-__c.DipToCurrent((int) (2)));
RDebugUtils.currentLine=20054020;
 //BA.debugLineNum = 20054020;BA.debugLine="cvs.DrawText($\"$DateTime{DateTime.Now}\"$, 2dip,";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawText(ba,(""+__c.SmartStringFormatter("datetime",(Object)(__c.DateTime.getNow()))+""),(float) (__c.DipToCurrent((int) (2))),(float) (_baseline),__ref._textfont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/ ,__ref._textcolor /*int*/ ,BA.getEnumFromString(android.graphics.Paint.Align.class,"LEFT"));
 };
RDebugUtils.currentLine=20054022;
 //BA.debugLineNum = 20054022;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.b4xsignaturetemplate __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xsignaturetemplate";
RDebugUtils.currentLine=19595264;
 //BA.debugLineNum = 19595264;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=19595265;
 //BA.debugLineNum = 19595265;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=19595266;
 //BA.debugLineNum = 19595266;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=19595267;
 //BA.debugLineNum = 19595267;BA.debugLine="Private cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=19595268;
 //BA.debugLineNum = 19595268;BA.debugLine="Private LastX, LastY As Float";
_lastx = 0f;
_lasty = 0f;
RDebugUtils.currentLine=19595269;
 //BA.debugLineNum = 19595269;BA.debugLine="Public StrokeWidth As Float = 2dip";
_strokewidth = (float) (__c.DipToCurrent((int) (2)));
RDebugUtils.currentLine=19595270;
 //BA.debugLineNum = 19595270;BA.debugLine="Public StrokeColor As Int = xui.Color_Black";
_strokecolor = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_Black;
RDebugUtils.currentLine=19595271;
 //BA.debugLineNum = 19595271;BA.debugLine="Public TextColor As Int = 0xFFFF8800";
_textcolor = ((int)0xffff8800);
RDebugUtils.currentLine=19595272;
 //BA.debugLineNum = 19595272;BA.debugLine="Public BackgroundColor As Int = xui.Color_White";
_backgroundcolor = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_White;
RDebugUtils.currentLine=19595273;
 //BA.debugLineNum = 19595273;BA.debugLine="Public AddDateAndTime As Boolean = True";
_adddateandtime = __c.True;
RDebugUtils.currentLine=19595274;
 //BA.debugLineNum = 19595274;BA.debugLine="Public TextFont As B4XFont";
_textfont = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
RDebugUtils.currentLine=19595275;
 //BA.debugLineNum = 19595275;BA.debugLine="Public NumberOfPoints As Int";
_numberofpoints = 0;
RDebugUtils.currentLine=19595276;
 //BA.debugLineNum = 19595276;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper  _getbitmap(b4a.example.b4xsignaturetemplate __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xsignaturetemplate";
if (Debug.shouldDelegate(ba, "getbitmap", true))
	 {return ((anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) Debug.delegate(ba, "getbitmap", null));}
RDebugUtils.currentLine=19988480;
 //BA.debugLineNum = 19988480;BA.debugLine="Public Sub getBitmap As B4XBitmap";
RDebugUtils.currentLine=19988481;
 //BA.debugLineNum = 19988481;BA.debugLine="Return cvs.CreateBitmap";
if (true) return __ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .CreateBitmap();
RDebugUtils.currentLine=19988482;
 //BA.debugLineNum = 19988482;BA.debugLine="End Sub";
return null;
}
public String  _initialize(b4a.example.b4xsignaturetemplate __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="b4xsignaturetemplate";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba}));}
RDebugUtils.currentLine=19660800;
 //BA.debugLineNum = 19660800;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=19660801;
 //BA.debugLineNum = 19660801;BA.debugLine="mBase = xui.CreatePanel(\"mBase\")";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .CreatePanel(ba,"mBase");
RDebugUtils.currentLine=19660802;
 //BA.debugLineNum = 19660802;BA.debugLine="mBase.SetLayoutAnimated(0, 0, 0, 300dip, 200dip)";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),(int) (0),(int) (0),__c.DipToCurrent((int) (300)),__c.DipToCurrent((int) (200)));
RDebugUtils.currentLine=19660803;
 //BA.debugLineNum = 19660803;BA.debugLine="cvs.Initialize(mBase)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Initialize(__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
RDebugUtils.currentLine=19660804;
 //BA.debugLineNum = 19660804;BA.debugLine="TextFont = xui.CreateDefaultFont(14)";
__ref._textfont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .CreateDefaultFont((float) (14));
RDebugUtils.currentLine=19660805;
 //BA.debugLineNum = 19660805;BA.debugLine="End Sub";
return "";
}
public String  _mbase_touch(b4a.example.b4xsignaturetemplate __ref,int _action,float _x,float _y) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xsignaturetemplate";
if (Debug.shouldDelegate(ba, "mbase_touch", true))
	 {return ((String) Debug.delegate(ba, "mbase_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=19922944;
 //BA.debugLineNum = 19922944;BA.debugLine="Private Sub mBase_Touch (Action As Int, X As Float";
RDebugUtils.currentLine=19922945;
 //BA.debugLineNum = 19922945;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .TOUCH_ACTION_DOWN,__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .TOUCH_ACTION_MOVE)) {
case 0: {
RDebugUtils.currentLine=19922947;
 //BA.debugLineNum = 19922947;BA.debugLine="LastX = X";
__ref._lastx /*float*/  = _x;
RDebugUtils.currentLine=19922948;
 //BA.debugLineNum = 19922948;BA.debugLine="LastY = Y";
__ref._lasty /*float*/  = _y;
 break; }
case 1: {
RDebugUtils.currentLine=19922950;
 //BA.debugLineNum = 19922950;BA.debugLine="cvs.DrawLine(LastX, LastY, X, Y, StrokeColor, S";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine(__ref._lastx /*float*/ ,__ref._lasty /*float*/ ,_x,_y,__ref._strokecolor /*int*/ ,__ref._strokewidth /*float*/ );
RDebugUtils.currentLine=19922951;
 //BA.debugLineNum = 19922951;BA.debugLine="LastX = X";
__ref._lastx /*float*/  = _x;
RDebugUtils.currentLine=19922952;
 //BA.debugLineNum = 19922952;BA.debugLine="LastY = Y";
__ref._lasty /*float*/  = _y;
RDebugUtils.currentLine=19922953;
 //BA.debugLineNum = 19922953;BA.debugLine="cvs.Invalidate";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Invalidate();
RDebugUtils.currentLine=19922954;
 //BA.debugLineNum = 19922954;BA.debugLine="NumberOfPoints = NumberOfPoints + 1";
__ref._numberofpoints /*int*/  = (int) (__ref._numberofpoints /*int*/ +1);
 break; }
}
;
RDebugUtils.currentLine=19922956;
 //BA.debugLineNum = 19922956;BA.debugLine="End Sub";
return "";
}
public String  _resize(b4a.example.b4xsignaturetemplate __ref,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xsignaturetemplate";
if (Debug.shouldDelegate(ba, "resize", true))
	 {return ((String) Debug.delegate(ba, "resize", new Object[] {_width,_height}));}
RDebugUtils.currentLine=19726336;
 //BA.debugLineNum = 19726336;BA.debugLine="Public Sub Resize(Width As Int, Height As Int)";
RDebugUtils.currentLine=19726337;
 //BA.debugLineNum = 19726337;BA.debugLine="mBase.SetLayoutAnimated(0, 0, 0, Width, Height)";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),(int) (0),(int) (0),_width,_height);
RDebugUtils.currentLine=19726338;
 //BA.debugLineNum = 19726338;BA.debugLine="cvs.Resize(Width, Height)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Resize((float) (_width),(float) (_height));
RDebugUtils.currentLine=19726339;
 //BA.debugLineNum = 19726339;BA.debugLine="End Sub";
return "";
}
}