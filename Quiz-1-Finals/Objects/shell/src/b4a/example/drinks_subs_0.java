package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class drinks_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (drinks) ","drinks",3,drinks.mostCurrent.activityBA,drinks.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.drinks.remoteMe.runUserSub(false, "drinks","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"laydrinks\")";
Debug.ShouldStop(16777216);
drinks.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("laydrinks")),drinks.mostCurrent.activityBA);
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (drinks) ","drinks",3,drinks.mostCurrent.activityBA,drinks.mostCurrent,33);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.drinks.remoteMe.runUserSub(false, "drinks","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (drinks) ","drinks",3,drinks.mostCurrent.activityBA,drinks.mostCurrent,29);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.drinks.remoteMe.runUserSub(false, "drinks","activity_resume");}
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnaccept1_click() throws Exception{
try {
		Debug.PushSubsStack("btnaccept1_Click (drinks) ","drinks",3,drinks.mostCurrent.activityBA,drinks.mostCurrent,49);
if (RapidSub.canDelegate("btnaccept1_click")) { return b4a.example.drinks.remoteMe.runUserSub(false, "drinks","btnaccept1_click");}
 BA.debugLineNum = 49;BA.debugLine="Private Sub btnaccept1_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Main.pricefordrinks = txtprice1.Text";
Debug.ShouldStop(131072);
drinks.mostCurrent._main._pricefordrinks /*RemoteObject*/  = drinks.mostCurrent._txtprice1.runMethod(true,"getText");
 BA.debugLineNum = 51;BA.debugLine="Msgbox(\"Transaction Confirmed\",\"Successful\")";
Debug.ShouldStop(262144);
drinks.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("Transaction Confirmed")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Successful"))),drinks.mostCurrent.activityBA);
 BA.debugLineNum = 52;BA.debugLine="Activity.Finish";
Debug.ShouldStop(524288);
drinks.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnclear1_click() throws Exception{
try {
		Debug.PushSubsStack("btnclear1_Click (drinks) ","drinks",3,drinks.mostCurrent.activityBA,drinks.mostCurrent,41);
if (RapidSub.canDelegate("btnclear1_click")) { return b4a.example.drinks.remoteMe.runUserSub(false, "drinks","btnclear1_click");}
 BA.debugLineNum = 41;BA.debugLine="Private Sub btnclear1_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="chkcoffee.Checked = False";
Debug.ShouldStop(512);
drinks.mostCurrent._chkcoffee.runMethodAndSync(true,"setChecked",drinks.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 43;BA.debugLine="chktea.Checked = False";
Debug.ShouldStop(1024);
drinks.mostCurrent._chktea.runMethodAndSync(true,"setChecked",drinks.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 44;BA.debugLine="chksoda.Checked = False";
Debug.ShouldStop(2048);
drinks.mostCurrent._chksoda.runMethodAndSync(true,"setChecked",drinks.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 45;BA.debugLine="txtprice1.Text = 0";
Debug.ShouldStop(4096);
drinks.mostCurrent._txtprice1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnhome1_click() throws Exception{
try {
		Debug.PushSubsStack("btnhome1_Click (drinks) ","drinks",3,drinks.mostCurrent.activityBA,drinks.mostCurrent,37);
if (RapidSub.canDelegate("btnhome1_click")) { return b4a.example.drinks.remoteMe.runUserSub(false, "drinks","btnhome1_click");}
 BA.debugLineNum = 37;BA.debugLine="Private Sub btnhome1_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32);
drinks.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chkcoffee_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("chkcoffee_CheckedChange (drinks) ","drinks",3,drinks.mostCurrent.activityBA,drinks.mostCurrent,73);
if (RapidSub.canDelegate("chkcoffee_checkedchange")) { return b4a.example.drinks.remoteMe.runUserSub(false, "drinks","chkcoffee_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 73;BA.debugLine="Private Sub chkcoffee_CheckedChange(Checked As Boo";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="If chkcoffee.Checked = True Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",drinks.mostCurrent._chkcoffee.runMethod(true,"getChecked"),drinks.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 75;BA.debugLine="txtprice1.Text = txtprice1.Text + 50";
Debug.ShouldStop(1024);
drinks.mostCurrent._txtprice1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, drinks.mostCurrent._txtprice1.runMethod(true,"getText")),RemoteObject.createImmutable(50)}, "+",1, 0)));
 }else {
 BA.debugLineNum = 77;BA.debugLine="txtprice1.Text = txtprice1.Text - 50";
Debug.ShouldStop(4096);
drinks.mostCurrent._txtprice1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, drinks.mostCurrent._txtprice1.runMethod(true,"getText")),RemoteObject.createImmutable(50)}, "-",1, 0)));
 };
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chksoda_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("chksoda_CheckedChange (drinks) ","drinks",3,drinks.mostCurrent.activityBA,drinks.mostCurrent,64);
if (RapidSub.canDelegate("chksoda_checkedchange")) { return b4a.example.drinks.remoteMe.runUserSub(false, "drinks","chksoda_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 64;BA.debugLine="Private Sub chksoda_CheckedChange(Checked As Boole";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 65;BA.debugLine="If chksoda.Checked = True Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",drinks.mostCurrent._chksoda.runMethod(true,"getChecked"),drinks.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 66;BA.debugLine="txtprice1.Text = txtprice1.Text + 30";
Debug.ShouldStop(2);
drinks.mostCurrent._txtprice1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, drinks.mostCurrent._txtprice1.runMethod(true,"getText")),RemoteObject.createImmutable(30)}, "+",1, 0)));
 }else {
 BA.debugLineNum = 68;BA.debugLine="txtprice1.Text = txtprice1.Text - 30";
Debug.ShouldStop(8);
drinks.mostCurrent._txtprice1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, drinks.mostCurrent._txtprice1.runMethod(true,"getText")),RemoteObject.createImmutable(30)}, "-",1, 0)));
 };
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chktea_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("chktea_CheckedChange (drinks) ","drinks",3,drinks.mostCurrent.activityBA,drinks.mostCurrent,55);
if (RapidSub.canDelegate("chktea_checkedchange")) { return b4a.example.drinks.remoteMe.runUserSub(false, "drinks","chktea_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 55;BA.debugLine="Private Sub chktea_CheckedChange(Checked As Boolea";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="If chktea.Checked = True Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",drinks.mostCurrent._chktea.runMethod(true,"getChecked"),drinks.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 57;BA.debugLine="txtprice1.Text = txtprice1.Text + 40";
Debug.ShouldStop(16777216);
drinks.mostCurrent._txtprice1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, drinks.mostCurrent._txtprice1.runMethod(true,"getText")),RemoteObject.createImmutable(40)}, "+",1, 0)));
 }else {
 BA.debugLineNum = 59;BA.debugLine="txtprice1.Text = txtprice1.Text - 40";
Debug.ShouldStop(67108864);
drinks.mostCurrent._txtprice1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, drinks.mostCurrent._txtprice1.runMethod(true,"getText")),RemoteObject.createImmutable(40)}, "-",1, 0)));
 };
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private txtprice1 As EditText";
drinks.mostCurrent._txtprice1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private chkcoffee As CheckBox";
drinks.mostCurrent._chkcoffee = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private chksoda As CheckBox";
drinks.mostCurrent._chksoda = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private chktea As CheckBox";
drinks.mostCurrent._chktea = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}