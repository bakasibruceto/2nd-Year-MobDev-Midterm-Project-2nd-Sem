package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class pizza_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (pizza) ","pizza",2,pizza.mostCurrent.activityBA,pizza.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.pizza.remoteMe.runUserSub(false, "pizza","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 24;BA.debugLine="Activity.LoadLayout(\"laypizza\")";
Debug.ShouldStop(8388608);
pizza.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("laypizza")),pizza.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Activity_Pause (pizza) ","pizza",2,pizza.mostCurrent.activityBA,pizza.mostCurrent,32);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.pizza.remoteMe.runUserSub(false, "pizza","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Activity_Resume (pizza) ","pizza",2,pizza.mostCurrent.activityBA,pizza.mostCurrent,28);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.pizza.remoteMe.runUserSub(false, "pizza","activity_resume");}
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnaccept2_click() throws Exception{
try {
		Debug.PushSubsStack("btnaccept2_Click (pizza) ","pizza",2,pizza.mostCurrent.activityBA,pizza.mostCurrent,76);
if (RapidSub.canDelegate("btnaccept2_click")) { return b4a.example.pizza.remoteMe.runUserSub(false, "pizza","btnaccept2_click");}
 BA.debugLineNum = 76;BA.debugLine="Private Sub btnaccept2_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 77;BA.debugLine="Main.priceforpizza = txtprice2.Text";
Debug.ShouldStop(4096);
pizza.mostCurrent._main._priceforpizza /*RemoteObject*/  = pizza.mostCurrent._txtprice2.runMethod(true,"getText");
 BA.debugLineNum = 78;BA.debugLine="Msgbox(\"Transaction Confirmed\",\"Successful\")";
Debug.ShouldStop(8192);
pizza.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("Transaction Confirmed")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Successful"))),pizza.mostCurrent.activityBA);
 BA.debugLineNum = 79;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16384);
pizza.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnclear2_click() throws Exception{
try {
		Debug.PushSubsStack("btnclear2_Click (pizza) ","pizza",2,pizza.mostCurrent.activityBA,pizza.mostCurrent,69);
if (RapidSub.canDelegate("btnclear2_click")) { return b4a.example.pizza.remoteMe.runUserSub(false, "pizza","btnclear2_click");}
 BA.debugLineNum = 69;BA.debugLine="Private Sub btnclear2_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="chkham.Checked=False";
Debug.ShouldStop(32);
pizza.mostCurrent._chkham.runMethodAndSync(true,"setChecked",pizza.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 71;BA.debugLine="chkhaw.Checked=False";
Debug.ShouldStop(64);
pizza.mostCurrent._chkhaw.runMethodAndSync(true,"setChecked",pizza.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 72;BA.debugLine="chkpep.Checked=False";
Debug.ShouldStop(128);
pizza.mostCurrent._chkpep.runMethodAndSync(true,"setChecked",pizza.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 73;BA.debugLine="txtprice2.Text =\"0\"";
Debug.ShouldStop(256);
pizza.mostCurrent._txtprice2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnhome2_click() throws Exception{
try {
		Debug.PushSubsStack("btnhome2_Click (pizza) ","pizza",2,pizza.mostCurrent.activityBA,pizza.mostCurrent,64);
if (RapidSub.canDelegate("btnhome2_click")) { return b4a.example.pizza.remoteMe.runUserSub(false, "pizza","btnhome2_click");}
 BA.debugLineNum = 64;BA.debugLine="Private Sub btnhome2_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 65;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1);
pizza.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chkham_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("chkham_CheckedChange (pizza) ","pizza",2,pizza.mostCurrent.activityBA,pizza.mostCurrent,55);
if (RapidSub.canDelegate("chkham_checkedchange")) { return b4a.example.pizza.remoteMe.runUserSub(false, "pizza","chkham_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 55;BA.debugLine="Private Sub chkham_CheckedChange(Checked As Boolea";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="If chkham.Checked = True Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",pizza.mostCurrent._chkham.runMethod(true,"getChecked"),pizza.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 57;BA.debugLine="txtprice2.Text = txtprice2.Text + 200";
Debug.ShouldStop(16777216);
pizza.mostCurrent._txtprice2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, pizza.mostCurrent._txtprice2.runMethod(true,"getText")),RemoteObject.createImmutable(200)}, "+",1, 0)));
 }else {
 BA.debugLineNum = 59;BA.debugLine="txtprice2.Text = txtprice2.Text - 200";
Debug.ShouldStop(67108864);
pizza.mostCurrent._txtprice2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, pizza.mostCurrent._txtprice2.runMethod(true,"getText")),RemoteObject.createImmutable(200)}, "-",1, 0)));
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
public static RemoteObject  _chkhaw_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("chkhaw_CheckedChange (pizza) ","pizza",2,pizza.mostCurrent.activityBA,pizza.mostCurrent,46);
if (RapidSub.canDelegate("chkhaw_checkedchange")) { return b4a.example.pizza.remoteMe.runUserSub(false, "pizza","chkhaw_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 46;BA.debugLine="Private Sub chkhaw_CheckedChange(Checked As Boolea";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="If chkhaw.Checked = True Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",pizza.mostCurrent._chkhaw.runMethod(true,"getChecked"),pizza.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 48;BA.debugLine="txtprice2.Text = txtprice2.Text + 300";
Debug.ShouldStop(32768);
pizza.mostCurrent._txtprice2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, pizza.mostCurrent._txtprice2.runMethod(true,"getText")),RemoteObject.createImmutable(300)}, "+",1, 0)));
 }else {
 BA.debugLineNum = 50;BA.debugLine="txtprice2.Text = txtprice2.Text - 300";
Debug.ShouldStop(131072);
pizza.mostCurrent._txtprice2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, pizza.mostCurrent._txtprice2.runMethod(true,"getText")),RemoteObject.createImmutable(300)}, "-",1, 0)));
 };
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
public static RemoteObject  _chkpep_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("chkpep_CheckedChange (pizza) ","pizza",2,pizza.mostCurrent.activityBA,pizza.mostCurrent,37);
if (RapidSub.canDelegate("chkpep_checkedchange")) { return b4a.example.pizza.remoteMe.runUserSub(false, "pizza","chkpep_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 37;BA.debugLine="Private Sub chkpep_CheckedChange(Checked As Boolea";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="If chkpep.Checked = True Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",pizza.mostCurrent._chkpep.runMethod(true,"getChecked"),pizza.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 39;BA.debugLine="txtprice2.Text = txtprice2.Text + 400";
Debug.ShouldStop(64);
pizza.mostCurrent._txtprice2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, pizza.mostCurrent._txtprice2.runMethod(true,"getText")),RemoteObject.createImmutable(400)}, "+",1, 0)));
 }else {
 BA.debugLineNum = 41;BA.debugLine="txtprice2.Text = txtprice2.Text - 400";
Debug.ShouldStop(256);
pizza.mostCurrent._txtprice2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, pizza.mostCurrent._txtprice2.runMethod(true,"getText")),RemoteObject.createImmutable(400)}, "-",1, 0)));
 };
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private txtprice2 As EditText";
pizza.mostCurrent._txtprice2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private chkham, chkhaw, chkpep As CheckBox";
pizza.mostCurrent._chkham = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
pizza.mostCurrent._chkhaw = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
pizza.mostCurrent._chkpep = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}