package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(1);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 34;BA.debugLine="txtpricedrinks.Enabled=False";
Debug.ShouldStop(2);
main.mostCurrent._txtpricedrinks.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 35;BA.debugLine="txtpricepizza.Enabled=False";
Debug.ShouldStop(4);
main.mostCurrent._txtpricepizza.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 36;BA.debugLine="txtdiscountedprice.Enabled=False";
Debug.ShouldStop(8);
main.mostCurrent._txtdiscountedprice.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 37;BA.debugLine="txttotal.Enabled=False";
Debug.ShouldStop(16);
main.mostCurrent._txttotal.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 38;BA.debugLine="txttotaldiscount.Enabled=False";
Debug.ShouldStop(32);
main.mostCurrent._txttotaldiscount.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 39;BA.debugLine="priceforpizza = 0";
Debug.ShouldStop(64);
main._priceforpizza = BA.NumberToString(0);
 BA.debugLineNum = 40;BA.debugLine="pricefordrinks = 0";
Debug.ShouldStop(128);
main._pricefordrinks = BA.NumberToString(0);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,50);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 50;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="txtpricepizza.Text = priceforpizza";
Debug.ShouldStop(4096);
main.mostCurrent._txtpricepizza.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main._priceforpizza));
 BA.debugLineNum = 46;BA.debugLine="txtpricedrinks.Text = pricefordrinks";
Debug.ShouldStop(8192);
main.mostCurrent._txtpricedrinks.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main._pricefordrinks));
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btndrinks_click() throws Exception{
try {
		Debug.PushSubsStack("btnDrinks_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,88);
if (RapidSub.canDelegate("btndrinks_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btndrinks_click");}
 BA.debugLineNum = 88;BA.debugLine="Private Sub btnDrinks_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="StartActivity(Drinks)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._drinks.getObject())));
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnexit_click() throws Exception{
try {
		Debug.PushSubsStack("btnexit_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,93);
if (RapidSub.canDelegate("btnexit_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnexit_click");}
 BA.debugLineNum = 93;BA.debugLine="Private Sub btnexit_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 94;BA.debugLine="Activity.Finish";
Debug.ShouldStop(536870912);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnpizza_click() throws Exception{
try {
		Debug.PushSubsStack("btnPizza_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,83);
if (RapidSub.canDelegate("btnpizza_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnpizza_click");}
 BA.debugLineNum = 83;BA.debugLine="Private Sub btnPizza_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="StartActivity(Pizza)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._pizza.getObject())));
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btntotal_click() throws Exception{
try {
		Debug.PushSubsStack("btntotal_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,78);
if (RapidSub.canDelegate("btntotal_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btntotal_click");}
 BA.debugLineNum = 78;BA.debugLine="Private Sub btntotal_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="txttotal.Text=txtpricepizza.Text + txtpricedrinks";
Debug.ShouldStop(16384);
main.mostCurrent._txttotal.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._txtpricepizza.runMethod(true,"getText")),BA.numberCast(double.class, main.mostCurrent._txtpricedrinks.runMethod(true,"getText"))}, "+",1, 0)));
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private txtdiscountedprice As EditText";
main.mostCurrent._txtdiscountedprice = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private txtpricedrinks As EditText";
main.mostCurrent._txtpricedrinks = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private txtpricepizza As EditText";
main.mostCurrent._txtpricepizza = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private txttotal As EditText";
main.mostCurrent._txttotal = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private txttotaldiscount As EditText";
main.mostCurrent._txttotaldiscount = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
pizza_subs_0._process_globals();
drinks_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
pizza.myClass = BA.getDeviceClass ("b4a.example.pizza");
drinks.myClass = BA.getDeviceClass ("b4a.example.drinks");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Dim priceforpizza As String";
main._priceforpizza = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="Dim pricefordrinks As String";
main._pricefordrinks = RemoteObject.createImmutable("");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _rdo0_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rdo0_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,72);
if (RapidSub.canDelegate("rdo0_checkedchange")) { return b4a.example.main.remoteMe.runUserSub(false, "main","rdo0_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 72;BA.debugLine="Private Sub rdo0_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="txttotaldiscount.Text = txttotal.Text * 0";
Debug.ShouldStop(256);
main.mostCurrent._txttotaldiscount.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._txttotal.runMethod(true,"getText")),RemoteObject.createImmutable(0)}, "*",0, 0)));
 BA.debugLineNum = 74;BA.debugLine="txtdiscountedprice.Text = txttotal.Text - txttota";
Debug.ShouldStop(512);
main.mostCurrent._txtdiscountedprice.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._txttotal.runMethod(true,"getText")),BA.numberCast(double.class, main.mostCurrent._txttotaldiscount.runMethod(true,"getText"))}, "-",1, 0)));
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rdo05_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rdo05_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,66);
if (RapidSub.canDelegate("rdo05_checkedchange")) { return b4a.example.main.remoteMe.runUserSub(false, "main","rdo05_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 66;BA.debugLine="Private Sub rdo05_CheckedChange(Checked As Boolean";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="txttotaldiscount.Text = txttotal.Text * 0.05";
Debug.ShouldStop(4);
main.mostCurrent._txttotaldiscount.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._txttotal.runMethod(true,"getText")),RemoteObject.createImmutable(0.05)}, "*",0, 0)));
 BA.debugLineNum = 68;BA.debugLine="txtdiscountedprice.Text = txttotal.Text - txttota";
Debug.ShouldStop(8);
main.mostCurrent._txtdiscountedprice.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._txttotal.runMethod(true,"getText")),BA.numberCast(double.class, main.mostCurrent._txttotaldiscount.runMethod(true,"getText"))}, "-",1, 0)));
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rdo10_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rdo10_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,60);
if (RapidSub.canDelegate("rdo10_checkedchange")) { return b4a.example.main.remoteMe.runUserSub(false, "main","rdo10_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 60;BA.debugLine="Private Sub rdo10_CheckedChange(Checked As Boolean";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="txttotaldiscount.Text = txttotal.Text * 1";
Debug.ShouldStop(268435456);
main.mostCurrent._txttotaldiscount.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._txttotal.runMethod(true,"getText")),RemoteObject.createImmutable(1)}, "*",0, 0)));
 BA.debugLineNum = 62;BA.debugLine="txtdiscountedprice.Text = txttotal.Text - txttota";
Debug.ShouldStop(536870912);
main.mostCurrent._txtdiscountedprice.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._txttotal.runMethod(true,"getText")),BA.numberCast(double.class, main.mostCurrent._txttotaldiscount.runMethod(true,"getText"))}, "-",1, 0)));
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rdo20_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rdo20_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,54);
if (RapidSub.canDelegate("rdo20_checkedchange")) { return b4a.example.main.remoteMe.runUserSub(false, "main","rdo20_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 54;BA.debugLine="Private Sub rdo20_CheckedChange(Checked As Boolean";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="txttotaldiscount.Text = txttotal.Text * 2";
Debug.ShouldStop(4194304);
main.mostCurrent._txttotaldiscount.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._txttotal.runMethod(true,"getText")),RemoteObject.createImmutable(2)}, "*",0, 0)));
 BA.debugLineNum = 56;BA.debugLine="txtdiscountedprice.Text = txttotal.Text - txttota";
Debug.ShouldStop(8388608);
main.mostCurrent._txtdiscountedprice.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._txttotal.runMethod(true,"getText")),BA.numberCast(double.class, main.mostCurrent._txttotaldiscount.runMethod(true,"getText"))}, "-",1, 0)));
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}