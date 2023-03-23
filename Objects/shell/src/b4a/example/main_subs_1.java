package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_1 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,80);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 80;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 82;BA.debugLine="InitializeState";
Debug.ShouldStop(131072);
_initializestate();
 BA.debugLineNum = 83;BA.debugLine="DrawState";
Debug.ShouldStop(262144);
_drawstate();
 BA.debugLineNum = 85;BA.debugLine="If(HPval <= 100 And HPval >=1)Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("k",main._hpval,BA.numberCast(double.class, 100)) && RemoteObject.solveBoolean("g",main._hpval,BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 87;BA.debugLine="DrawMonster";
Debug.ShouldStop(4194304);
_drawmonster();
 BA.debugLineNum = 88;BA.debugLine="DrawHealth";
Debug.ShouldStop(8388608);
_drawhealth();
 BA.debugLineNum = 89;BA.debugLine="DrawEquation";
Debug.ShouldStop(16777216);
_drawequation();
 };
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,100);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 100;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,96);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 96;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button0_click() throws Exception{
try {
		Debug.PushSubsStack("Button0_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,333);
if (RapidSub.canDelegate("button0_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button0_click");}
 BA.debugLineNum = 333;BA.debugLine="Private Sub Button0_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 334;BA.debugLine="answer.Text = tempStr&\"0\"";
Debug.ShouldStop(8192);
main.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._tempstr,RemoteObject.createImmutable("0"))));
 BA.debugLineNum = 335;BA.debugLine="tempStr = answer.Text";
Debug.ShouldStop(16384);
main.mostCurrent._tempstr = main.mostCurrent._answer.runMethod(true,"getText");
 BA.debugLineNum = 337;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,339);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button1_click");}
 BA.debugLineNum = 339;BA.debugLine="Private Sub Button1_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 340;BA.debugLine="answer.Text = tempStr&\"1\"";
Debug.ShouldStop(524288);
main.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._tempstr,RemoteObject.createImmutable("1"))));
 BA.debugLineNum = 341;BA.debugLine="tempStr = answer.Text";
Debug.ShouldStop(1048576);
main.mostCurrent._tempstr = main.mostCurrent._answer.runMethod(true,"getText");
 BA.debugLineNum = 342;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button2_click() throws Exception{
try {
		Debug.PushSubsStack("Button2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,344);
if (RapidSub.canDelegate("button2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button2_click");}
 BA.debugLineNum = 344;BA.debugLine="Private Sub Button2_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 345;BA.debugLine="answer.Text = tempStr&\"2\"";
Debug.ShouldStop(16777216);
main.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._tempstr,RemoteObject.createImmutable("2"))));
 BA.debugLineNum = 346;BA.debugLine="tempStr = answer.Text";
Debug.ShouldStop(33554432);
main.mostCurrent._tempstr = main.mostCurrent._answer.runMethod(true,"getText");
 BA.debugLineNum = 347;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button3_click() throws Exception{
try {
		Debug.PushSubsStack("Button3_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,349);
if (RapidSub.canDelegate("button3_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button3_click");}
 BA.debugLineNum = 349;BA.debugLine="Private Sub Button3_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 350;BA.debugLine="answer.Text = tempStr&\"3\"";
Debug.ShouldStop(536870912);
main.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._tempstr,RemoteObject.createImmutable("3"))));
 BA.debugLineNum = 351;BA.debugLine="tempStr = answer.Text";
Debug.ShouldStop(1073741824);
main.mostCurrent._tempstr = main.mostCurrent._answer.runMethod(true,"getText");
 BA.debugLineNum = 352;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button4_click() throws Exception{
try {
		Debug.PushSubsStack("Button4_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,354);
if (RapidSub.canDelegate("button4_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button4_click");}
 BA.debugLineNum = 354;BA.debugLine="Private Sub Button4_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 355;BA.debugLine="answer.Text = tempStr&\"4\"";
Debug.ShouldStop(4);
main.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._tempstr,RemoteObject.createImmutable("4"))));
 BA.debugLineNum = 356;BA.debugLine="tempStr = answer.Text";
Debug.ShouldStop(8);
main.mostCurrent._tempstr = main.mostCurrent._answer.runMethod(true,"getText");
 BA.debugLineNum = 357;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button5_click() throws Exception{
try {
		Debug.PushSubsStack("Button5_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,359);
if (RapidSub.canDelegate("button5_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button5_click");}
 BA.debugLineNum = 359;BA.debugLine="Private Sub Button5_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 360;BA.debugLine="answer.Text = tempStr&\"5\"";
Debug.ShouldStop(128);
main.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._tempstr,RemoteObject.createImmutable("5"))));
 BA.debugLineNum = 361;BA.debugLine="tempStr = answer.Text";
Debug.ShouldStop(256);
main.mostCurrent._tempstr = main.mostCurrent._answer.runMethod(true,"getText");
 BA.debugLineNum = 362;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button6_click() throws Exception{
try {
		Debug.PushSubsStack("Button6_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,364);
if (RapidSub.canDelegate("button6_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button6_click");}
 BA.debugLineNum = 364;BA.debugLine="Private Sub Button6_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 365;BA.debugLine="answer.Text = tempStr&\"6\"";
Debug.ShouldStop(4096);
main.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._tempstr,RemoteObject.createImmutable("6"))));
 BA.debugLineNum = 366;BA.debugLine="tempStr = answer.Text";
Debug.ShouldStop(8192);
main.mostCurrent._tempstr = main.mostCurrent._answer.runMethod(true,"getText");
 BA.debugLineNum = 367;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button7_click() throws Exception{
try {
		Debug.PushSubsStack("Button7_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,369);
if (RapidSub.canDelegate("button7_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button7_click");}
 BA.debugLineNum = 369;BA.debugLine="Private Sub Button7_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 370;BA.debugLine="answer.Text = tempStr&\"7\"";
Debug.ShouldStop(131072);
main.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._tempstr,RemoteObject.createImmutable("7"))));
 BA.debugLineNum = 371;BA.debugLine="tempStr = answer.Text";
Debug.ShouldStop(262144);
main.mostCurrent._tempstr = main.mostCurrent._answer.runMethod(true,"getText");
 BA.debugLineNum = 372;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button8_click() throws Exception{
try {
		Debug.PushSubsStack("Button8_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,374);
if (RapidSub.canDelegate("button8_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button8_click");}
 BA.debugLineNum = 374;BA.debugLine="Private Sub Button8_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 375;BA.debugLine="answer.Text = tempStr&\"8\"";
Debug.ShouldStop(4194304);
main.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._tempstr,RemoteObject.createImmutable("8"))));
 BA.debugLineNum = 376;BA.debugLine="tempStr = answer.Text";
Debug.ShouldStop(8388608);
main.mostCurrent._tempstr = main.mostCurrent._answer.runMethod(true,"getText");
 BA.debugLineNum = 377;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button9_click() throws Exception{
try {
		Debug.PushSubsStack("Button9_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,379);
if (RapidSub.canDelegate("button9_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button9_click");}
 BA.debugLineNum = 379;BA.debugLine="Private Sub Button9_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 380;BA.debugLine="answer.Text = tempStr&\"9\"";
Debug.ShouldStop(134217728);
main.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._tempstr,RemoteObject.createImmutable("9"))));
 BA.debugLineNum = 381;BA.debugLine="tempStr = answer.Text";
Debug.ShouldStop(268435456);
main.mostCurrent._tempstr = main.mostCurrent._answer.runMethod(true,"getText");
 BA.debugLineNum = 382;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonclear_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonClear_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,327);
if (RapidSub.canDelegate("buttonclear_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonclear_click");}
 BA.debugLineNum = 327;BA.debugLine="Private Sub ButtonClear_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 328;BA.debugLine="answer.Text=\"\"";
Debug.ShouldStop(128);
main.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 329;BA.debugLine="tempStr=\"\"";
Debug.ShouldStop(256);
main.mostCurrent._tempstr = BA.ObjectToString("");
 BA.debugLineNum = 331;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonenter_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonEnter_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,295);
if (RapidSub.canDelegate("buttonenter_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonenter_click");}
 BA.debugLineNum = 295;BA.debugLine="Private Sub ButtonEnter_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 296;BA.debugLine="tempStr=\"\"";
Debug.ShouldStop(128);
main.mostCurrent._tempstr = BA.ObjectToString("");
 BA.debugLineNum = 297;BA.debugLine="damage = str";
Debug.ShouldStop(256);
main._damage = BA.numberCast(int.class, main.mostCurrent._str);
 BA.debugLineNum = 298;BA.debugLine="If answer.Text = str Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",main.mostCurrent._answer.runMethod(true,"getText"),main.mostCurrent._str)) { 
 BA.debugLineNum = 299;BA.debugLine="strAn.Text = \"Correct\"";
Debug.ShouldStop(1024);
main.mostCurrent._stran.runMethod(true,"setText",BA.ObjectToCharSequence("Correct"));
 BA.debugLineNum = 300;BA.debugLine="mobVal= mobVal-damage";
Debug.ShouldStop(2048);
main._mobval = RemoteObject.solve(new RemoteObject[] {main._mobval,main._damage}, "-",1, 1);
 BA.debugLineNum = 301;BA.debugLine="mobshake = True";
Debug.ShouldStop(4096);
main._mobshake = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 302;BA.debugLine="MediaPlayer.Load(File.DirAssets,\"dam.mp3\")";
Debug.ShouldStop(8192);
main._mediaplayer.runVoidMethod ("Load",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("dam.mp3")));
 }else {
 BA.debugLineNum = 305;BA.debugLine="strAn.Text = \"InCorrect\"";
Debug.ShouldStop(65536);
main.mostCurrent._stran.runMethod(true,"setText",BA.ObjectToCharSequence("InCorrect"));
 BA.debugLineNum = 306;BA.debugLine="HPval = HPval-damage";
Debug.ShouldStop(131072);
main._hpval = RemoteObject.solve(new RemoteObject[] {main._hpval,main._damage}, "-",1, 1);
 BA.debugLineNum = 307;BA.debugLine="MediaPlayer.Play";
Debug.ShouldStop(262144);
main._mediaplayer.runVoidMethod ("Play");
 BA.debugLineNum = 308;BA.debugLine="hpshake = True";
Debug.ShouldStop(524288);
main._hpshake = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 309;BA.debugLine="MediaPlayer.Load(File.DirAssets,\"pdam.mp3\")";
Debug.ShouldStop(1048576);
main._mediaplayer.runVoidMethod ("Load",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("pdam.mp3")));
 };
 BA.debugLineNum = 311;BA.debugLine="MediaPlayer.Play";
Debug.ShouldStop(4194304);
main._mediaplayer.runVoidMethod ("Play");
 BA.debugLineNum = 313;BA.debugLine="GameState.Visible=False";
Debug.ShouldStop(16777216);
main.mostCurrent._gamestate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 314;BA.debugLine="ReDraw";
Debug.ShouldStop(33554432);
_redraw();
 BA.debugLineNum = 315;BA.debugLine="Activity_Create(True)";
Debug.ShouldStop(67108864);
_activity_create(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 316;BA.debugLine="If MonsterType == 3 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main._monstertype,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 317;BA.debugLine="GameDefeated.Visible=True";
Debug.ShouldStop(268435456);
main.mostCurrent._gamedefeated.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 319;BA.debugLine="check = True";
Debug.ShouldStop(1073741824);
main._check = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 320;BA.debugLine="If HPval <= 100 And HPval >= 0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("k",main._hpval,BA.numberCast(double.class, 100)) && RemoteObject.solveBoolean("g",main._hpval,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 321;BA.debugLine="GameState.Visible=True";
Debug.ShouldStop(1);
main.mostCurrent._gamestate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 };
 };
 BA.debugLineNum = 325;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawequation() throws Exception{
try {
		Debug.PushSubsStack("DrawEquation (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,227);
if (RapidSub.canDelegate("drawequation")) { return b4a.example.main.remoteMe.runUserSub(false, "main","drawequation");}
RemoteObject _rand1 = RemoteObject.createImmutable(0);
RemoteObject _rand2 = RemoteObject.createImmutable(0);
 BA.debugLineNum = 227;BA.debugLine="Sub DrawEquation";
Debug.ShouldStop(4);
 BA.debugLineNum = 228;BA.debugLine="Dim rand1 As Int = Rnd(1,11)";
Debug.ShouldStop(8);
_rand1 = main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 11)));Debug.locals.put("rand1", _rand1);Debug.locals.put("rand1", _rand1);
 BA.debugLineNum = 229;BA.debugLine="Dim rand2 As Int = Rnd(1,11)";
Debug.ShouldStop(16);
_rand2 = main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 11)));Debug.locals.put("rand2", _rand2);Debug.locals.put("rand2", _rand2);
 BA.debugLineNum = 230;BA.debugLine="num1.Text=rand1";
Debug.ShouldStop(32);
main.mostCurrent._num1.runMethod(true,"setText",BA.ObjectToCharSequence(_rand1));
 BA.debugLineNum = 231;BA.debugLine="num2.Text=rand2";
Debug.ShouldStop(64);
main.mostCurrent._num2.runMethod(true,"setText",BA.ObjectToCharSequence(_rand2));
 BA.debugLineNum = 232;BA.debugLine="ShuffleArray(operator)";
Debug.ShouldStop(128);
_shufflearray(main.mostCurrent._operator);
 BA.debugLineNum = 233;BA.debugLine="operation.text = operator(0)";
Debug.ShouldStop(256);
main.mostCurrent._operation.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._operator.getArrayElement(true,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 234;BA.debugLine="Select operator(0)";
Debug.ShouldStop(512);
switch (BA.switchObjectToInt(main.mostCurrent._operator.getArrayElement(true,BA.numberCast(int.class, 0)),BA.ObjectToString("+"),BA.ObjectToString("-"),BA.ObjectToString("*"),BA.ObjectToString("/"))) {
case 0: {
 BA.debugLineNum = 236;BA.debugLine="str =rand1+rand2";
Debug.ShouldStop(2048);
main.mostCurrent._str = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_rand1,_rand2}, "+",1, 1));
 break; }
case 1: {
 BA.debugLineNum = 238;BA.debugLine="str =rand1-rand2";
Debug.ShouldStop(8192);
main.mostCurrent._str = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_rand1,_rand2}, "-",1, 1));
 break; }
case 2: {
 BA.debugLineNum = 240;BA.debugLine="str =rand1*rand2";
Debug.ShouldStop(32768);
main.mostCurrent._str = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_rand1,_rand2}, "*",0, 1));
 break; }
case 3: {
 BA.debugLineNum = 242;BA.debugLine="str =rand1/rand2";
Debug.ShouldStop(131072);
main.mostCurrent._str = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_rand1,_rand2}, "/",0, 0));
 break; }
}
;
 BA.debugLineNum = 244;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawhealth() throws Exception{
try {
		Debug.PushSubsStack("DrawHealth (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,182);
if (RapidSub.canDelegate("drawhealth")) { return b4a.example.main.remoteMe.runUserSub(false, "main","drawhealth");}
 BA.debugLineNum = 182;BA.debugLine="Sub DrawHealth";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 183;BA.debugLine="HP.Text=HPval";
Debug.ShouldStop(4194304);
main.mostCurrent._hp.runMethod(true,"setText",BA.ObjectToCharSequence(main._hpval));
 BA.debugLineNum = 184;BA.debugLine="mobHP.Text=mobVal";
Debug.ShouldStop(8388608);
main.mostCurrent._mobhp.runMethod(true,"setText",BA.ObjectToCharSequence(main._mobval));
 BA.debugLineNum = 186;BA.debugLine="If MonsterType<3 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("<",main._monstertype,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 187;BA.debugLine="Select MonsterType";
Debug.ShouldStop(67108864);
switch (BA.switchObjectToInt(main._monstertype,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 189;BA.debugLine="barsize = mobVal*4.68";
Debug.ShouldStop(268435456);
main._barsize = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._mobval,RemoteObject.createImmutable(4.68)}, "*",0, 0));
 break; }
case 1: {
 BA.debugLineNum = 191;BA.debugLine="barsize = mobVal*2.34";
Debug.ShouldStop(1073741824);
main._barsize = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._mobval,RemoteObject.createImmutable(2.34)}, "*",0, 0));
 break; }
case 2: {
 BA.debugLineNum = 193;BA.debugLine="barsize = mobVal*1.56";
Debug.ShouldStop(1);
main._barsize = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._mobval,RemoteObject.createImmutable(1.56)}, "*",0, 0));
 break; }
}
;
 };
 BA.debugLineNum = 197;BA.debugLine="mob.Color = Colors.ARGB(0, 0, 0, 0)";
Debug.ShouldStop(16);
main.mostCurrent._mob.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 198;BA.debugLine="cvsGraph.Initialize(mob)";
Debug.ShouldStop(32);
main.mostCurrent._cvsgraph.runVoidMethod ("Initialize",(Object)((main.mostCurrent._mob.getObject())));
 BA.debugLineNum = 199;BA.debugLine="rect1.Initialize(10dip, 10dip, 250dip, 35dip)";
Debug.ShouldStop(64);
main.mostCurrent._rect1.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))));
 BA.debugLineNum = 200;BA.debugLine="cvsGraph.DrawRect(rect1, xui.Color_Black, False,";
Debug.ShouldStop(128);
main.mostCurrent._cvsgraph.runVoidMethod ("DrawRect",(Object)((main.mostCurrent._rect1.getObject())),(Object)(main._xui.getField(true,"Color_Black")),(Object)(main.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 202;BA.debugLine="mob2.Color=Colors.ARGB(0, 0, 0, 0)";
Debug.ShouldStop(512);
main.mostCurrent._mob2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 203;BA.debugLine="cvsGraph2.Initialize(mob2)";
Debug.ShouldStop(1024);
main.mostCurrent._cvsgraph2.runVoidMethod ("Initialize",(Object)((main.mostCurrent._mob2.getObject())));
 BA.debugLineNum = 204;BA.debugLine="rect2.Initialize(10dip, 10dip, IntToDIP(barsize),";
Debug.ShouldStop(2048);
main.mostCurrent._rect2.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(_inttodip(main._barsize)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))));
 BA.debugLineNum = 205;BA.debugLine="cvsGraph2.DrawRect(rect2, xui.Color_Red , True, 2";
Debug.ShouldStop(4096);
main.mostCurrent._cvsgraph2.runVoidMethod ("DrawRect",(Object)((main.mostCurrent._rect2.getObject())),(Object)(main._xui.getField(true,"Color_Red")),(Object)(main.mostCurrent.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 207;BA.debugLine="ply1.Color = Colors.ARGB(0, 0, 0, 0)";
Debug.ShouldStop(16384);
main.mostCurrent._ply1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 208;BA.debugLine="cvsGraph3.Initialize(ply1)";
Debug.ShouldStop(32768);
main.mostCurrent._cvsgraph3.runVoidMethod ("Initialize",(Object)((main.mostCurrent._ply1.getObject())));
 BA.debugLineNum = 209;BA.debugLine="rect3.Initialize(10dip, 10dip, 250dip, 35dip)";
Debug.ShouldStop(65536);
main.mostCurrent._rect3.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))));
 BA.debugLineNum = 210;BA.debugLine="cvsGraph3.DrawRect(rect3, xui.Color_Black, False,";
Debug.ShouldStop(131072);
main.mostCurrent._cvsgraph3.runVoidMethod ("DrawRect",(Object)((main.mostCurrent._rect3.getObject())),(Object)(main._xui.getField(true,"Color_Black")),(Object)(main.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 212;BA.debugLine="ply2.Color=Colors.ARGB(0, 0, 0, 0)";
Debug.ShouldStop(524288);
main.mostCurrent._ply2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 213;BA.debugLine="cvsGraph4.Initialize(ply2)";
Debug.ShouldStop(1048576);
main.mostCurrent._cvsgraph4.runVoidMethod ("Initialize",(Object)((main.mostCurrent._ply2.getObject())));
 BA.debugLineNum = 214;BA.debugLine="rect4.Initialize(10dip, 10dip, IntToDIP(HPval*4.6";
Debug.ShouldStop(2097152);
main.mostCurrent._rect4.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(_inttodip(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._hpval,RemoteObject.createImmutable(4.68)}, "*",0, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))));
 BA.debugLineNum = 215;BA.debugLine="cvsGraph4.DrawRect(rect4, xui.Color_Red , True, 2";
Debug.ShouldStop(4194304);
main.mostCurrent._cvsgraph4.runVoidMethod ("DrawRect",(Object)((main.mostCurrent._rect4.getObject())),(Object)(main._xui.getField(true,"Color_Red")),(Object)(main.mostCurrent.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 217;BA.debugLine="If hpshake == True Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",main._hpshake,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 218;BA.debugLine="hpshake = False";
Debug.ShouldStop(33554432);
main._hpshake = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 219;BA.debugLine="shake.Start(ply2)";
Debug.ShouldStop(67108864);
main.mostCurrent._shake.runVoidMethod ("Start",(Object)((main.mostCurrent._ply2.getObject())));
 }else 
{ BA.debugLineNum = 220;BA.debugLine="Else If mobshake == True Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main._mobshake,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 221;BA.debugLine="mobshake = False";
Debug.ShouldStop(268435456);
main._mobshake = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 222;BA.debugLine="shake.Start(mob2)";
Debug.ShouldStop(536870912);
main.mostCurrent._shake.runVoidMethod ("Start",(Object)((main.mostCurrent._mob2.getObject())));
 BA.debugLineNum = 223;BA.debugLine="shake.Start(ImageView1)";
Debug.ShouldStop(1073741824);
main.mostCurrent._shake.runVoidMethod ("Start",(Object)((main.mostCurrent._imageview1.getObject())));
 }}
;
 BA.debugLineNum = 225;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawmonster() throws Exception{
try {
		Debug.PushSubsStack("DrawMonster (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,162);
if (RapidSub.canDelegate("drawmonster")) { return b4a.example.main.remoteMe.runUserSub(false, "main","drawmonster");}
 BA.debugLineNum = 162;BA.debugLine="Sub DrawMonster";
Debug.ShouldStop(2);
 BA.debugLineNum = 163;BA.debugLine="If mobVal <= 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("k",main._mobval,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 164;BA.debugLine="MonsterType = MonsterType+1";
Debug.ShouldStop(8);
main._monstertype = RemoteObject.solve(new RemoteObject[] {main._monstertype,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 165;BA.debugLine="Select MonsterType";
Debug.ShouldStop(16);
switch (BA.switchObjectToInt(main._monstertype,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 167;BA.debugLine="mobVal = 200";
Debug.ShouldStop(64);
main._mobval = BA.numberCast(int.class, 200);
 break; }
case 1: {
 BA.debugLineNum = 169;BA.debugLine="mobVal = 300";
Debug.ShouldStop(256);
main._mobval = BA.numberCast(int.class, 300);
 break; }
}
;
 };
 BA.debugLineNum = 174;BA.debugLine="If MonsterType<3 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("<",main._monstertype,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 175;BA.debugLine="FileName = Monster(MonsterType)";
Debug.ShouldStop(16384);
main._filename = main._monster.getArrayElement(true,main._monstertype);
 BA.debugLineNum = 176;BA.debugLine="ImageView1.Bitmap = LoadBitmap(File.DirAssets, F";
Debug.ShouldStop(32768);
main.mostCurrent._imageview1.runMethod(false,"setBitmap",(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(main._filename)).getObject()));
 };
 BA.debugLineNum = 179;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawstate() throws Exception{
try {
		Debug.PushSubsStack("DrawState (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,146);
if (RapidSub.canDelegate("drawstate")) { return b4a.example.main.remoteMe.runUserSub(false, "main","drawstate");}
 BA.debugLineNum = 146;BA.debugLine="Sub DrawState";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="If check == False Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",main._check,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 148;BA.debugLine="Load.Visible = True";
Debug.ShouldStop(524288);
main.mostCurrent._load.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 149;BA.debugLine="Load.Visible = False";
Debug.ShouldStop(1048576);
main.mostCurrent._load.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 150;BA.debugLine="TitleState.Visible = True";
Debug.ShouldStop(2097152);
main.mostCurrent._titlestate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 153;BA.debugLine="If HPval <=0 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("k",main._hpval,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 154;BA.debugLine="GameState.Visible = False";
Debug.ShouldStop(33554432);
main.mostCurrent._gamestate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 155;BA.debugLine="GameOverState.Visible = True";
Debug.ShouldStop(67108864);
main.mostCurrent._gameoverstate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fontstyle() throws Exception{
try {
		Debug.PushSubsStack("FontStyle (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,104);
if (RapidSub.canDelegate("fontstyle")) { return b4a.example.main.remoteMe.runUserSub(false, "main","fontstyle");}
 BA.debugLineNum = 104;BA.debugLine="Sub FontStyle";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="num1.Typeface = Font";
Debug.ShouldStop(256);
main.mostCurrent._num1.runMethod(false,"setTypeface",(main._font.getObject()));
 BA.debugLineNum = 106;BA.debugLine="num2.Typeface = Font";
Debug.ShouldStop(512);
main.mostCurrent._num2.runMethod(false,"setTypeface",(main._font.getObject()));
 BA.debugLineNum = 107;BA.debugLine="operation.Typeface = Font";
Debug.ShouldStop(1024);
main.mostCurrent._operation.runMethod(false,"setTypeface",(main._font.getObject()));
 BA.debugLineNum = 108;BA.debugLine="HP.Typeface = Font";
Debug.ShouldStop(2048);
main.mostCurrent._hp.runMethod(false,"setTypeface",(main._font.getObject()));
 BA.debugLineNum = 109;BA.debugLine="mobHP.Typeface = Font";
Debug.ShouldStop(4096);
main.mostCurrent._mobhp.runMethod(false,"setTypeface",(main._font.getObject()));
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 26;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 28;BA.debugLine="Private num1, num2, operation As Label";
main.mostCurrent._num1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
main.mostCurrent._num2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
main.mostCurrent._operation = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private HP, mobHP As Label";
main.mostCurrent._hp = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
main.mostCurrent._mobhp = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private answer As Label";
main.mostCurrent._answer = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private countdown As Label";
main.mostCurrent._countdown = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private ImageView1 As ImageView";
main.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private strAn As Label";
main.mostCurrent._stran = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private str As String";
main.mostCurrent._str = RemoteObject.createImmutable("");
 //BA.debugLineNum = 39;BA.debugLine="Private damage As Int = 0";
main._damage = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 40;BA.debugLine="Private HPval As Int = 100";
main._hpval = BA.numberCast(int.class, 100);
 //BA.debugLineNum = 41;BA.debugLine="Private mobVal As Int = 100";
main._mobval = BA.numberCast(int.class, 100);
 //BA.debugLineNum = 42;BA.debugLine="Private tempStr As String =\"\"";
main.mostCurrent._tempstr = BA.ObjectToString("");
 //BA.debugLineNum = 43;BA.debugLine="Private check As Boolean = False";
main._check = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 44;BA.debugLine="Private operator() As String = Array As String(\"+";
main.mostCurrent._operator = RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("+"),RemoteObject.createImmutable("*")});
 //BA.debugLineNum = 45;BA.debugLine="Private barsize As Int";
main._barsize = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 46;BA.debugLine="Private hpshake As Boolean = False";
main._hpshake = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 47;BA.debugLine="Private mobshake As Boolean = False";
main._mobshake = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 49;BA.debugLine="Private Load, GameState, PauseState, TitleState,";
main.mostCurrent._load = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._gamestate = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._pausestate = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._titlestate = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._gameoverstate = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._gamedefeated = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private Button1 As Button";
main.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private mob, mob2, ply1, ply2 As Panel";
main.mostCurrent._mob = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._mob2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._ply1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._ply2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private cvsGraph, cvsGraph2, cvsGraph3, cvsGraph4";
main.mostCurrent._cvsgraph = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
main.mostCurrent._cvsgraph2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
main.mostCurrent._cvsgraph3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
main.mostCurrent._cvsgraph4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private rect1, rect2, rect3, rect4 As Rect";
main.mostCurrent._rect1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
main.mostCurrent._rect2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
main.mostCurrent._rect3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
main.mostCurrent._rect4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private Button0 As Button";
main.mostCurrent._button0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private Button1 As Button";
main.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private Button2 As Button";
main.mostCurrent._button2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private Button3 As Button";
main.mostCurrent._button3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private Button4 As Button";
main.mostCurrent._button4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private Button5 As Button";
main.mostCurrent._button5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private Button6 As Button";
main.mostCurrent._button6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 65;BA.debugLine="Private Button7 As Button";
main.mostCurrent._button7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Private Button8 As Button";
main.mostCurrent._button8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Private Button9 As Button";
main.mostCurrent._button9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 68;BA.debugLine="Private ButtonEnter As Button";
main.mostCurrent._buttonenter = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 69;BA.debugLine="Private ButtonClear As Button";
main.mostCurrent._buttonclear = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 71;BA.debugLine="Private shake As Animation";
main.mostCurrent._shake = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initializestate() throws Exception{
try {
		Debug.PushSubsStack("InitializeState (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,114);
if (RapidSub.canDelegate("initializestate")) { return b4a.example.main.remoteMe.runUserSub(false, "main","initializestate");}
 BA.debugLineNum = 114;BA.debugLine="Sub InitializeState";
Debug.ShouldStop(131072);
 BA.debugLineNum = 117;BA.debugLine="MediaPlayer.Initialize()";
Debug.ShouldStop(1048576);
main._mediaplayer.runVoidMethod ("Initialize");
 BA.debugLineNum = 118;BA.debugLine="shake.InitializeTranslate(\"\", -9dip, 0, 9dip, 0)";
Debug.ShouldStop(2097152);
main.mostCurrent._shake.runVoidMethod ("InitializeTranslate",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("")),(Object)(BA.numberCast(float.class, -(double) (0 + main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 9))).<Integer>get().intValue()))),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 9))))),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 119;BA.debugLine="shake.RepeatCount = 3";
Debug.ShouldStop(4194304);
main.mostCurrent._shake.runMethod(true,"setRepeatCount",BA.numberCast(int.class, 3));
 BA.debugLineNum = 120;BA.debugLine="shake.RepeatMode = shake.REPEAT_REVERSE";
Debug.ShouldStop(8388608);
main.mostCurrent._shake.runMethod(true,"setRepeatMode",main.mostCurrent._shake.getField(true,"REPEAT_REVERSE"));
 BA.debugLineNum = 121;BA.debugLine="shake.Duration = 30";
Debug.ShouldStop(16777216);
main.mostCurrent._shake.runMethod(true,"setDuration",BA.numberCast(long.class, 30));
 BA.debugLineNum = 124;BA.debugLine="Load.Initialize(\"\") : Load.Visible = False";
Debug.ShouldStop(134217728);
main.mostCurrent._load.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 124;BA.debugLine="Load.Initialize(\"\") : Load.Visible = False";
Debug.ShouldStop(134217728);
main.mostCurrent._load.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 125;BA.debugLine="GameState.Initialize(\"\") : GameState.Visible = Fa";
Debug.ShouldStop(268435456);
main.mostCurrent._gamestate.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 125;BA.debugLine="GameState.Initialize(\"\") : GameState.Visible = Fa";
Debug.ShouldStop(268435456);
main.mostCurrent._gamestate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 126;BA.debugLine="GameOverState.Initialize(\"\") : GameOverState.Visi";
Debug.ShouldStop(536870912);
main.mostCurrent._gameoverstate.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 126;BA.debugLine="GameOverState.Initialize(\"\") : GameOverState.Visi";
Debug.ShouldStop(536870912);
main.mostCurrent._gameoverstate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 127;BA.debugLine="PauseState.Initialize(\"\"): PauseState.Visible = F";
Debug.ShouldStop(1073741824);
main.mostCurrent._pausestate.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 127;BA.debugLine="PauseState.Initialize(\"\"): PauseState.Visible = F";
Debug.ShouldStop(1073741824);
main.mostCurrent._pausestate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 128;BA.debugLine="TitleState.Initialize(\"\"): TitleState.Visible = F";
Debug.ShouldStop(-2147483648);
main.mostCurrent._titlestate.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 128;BA.debugLine="TitleState.Initialize(\"\"): TitleState.Visible = F";
Debug.ShouldStop(-2147483648);
main.mostCurrent._titlestate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 129;BA.debugLine="GameDefeated.Initialize(\"\"): GameDefeated.Visible";
Debug.ShouldStop(1);
main.mostCurrent._gamedefeated.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 129;BA.debugLine="GameDefeated.Initialize(\"\"): GameDefeated.Visible";
Debug.ShouldStop(1);
main.mostCurrent._gamedefeated.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 131;BA.debugLine="Load.LoadLayout(\"Load\") 'Regular layouts created";
Debug.ShouldStop(4);
main.mostCurrent._load.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Load")),main.mostCurrent.activityBA);
 BA.debugLineNum = 132;BA.debugLine="GameState.LoadLayout(\"GameState\")";
Debug.ShouldStop(8);
main.mostCurrent._gamestate.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("GameState")),main.mostCurrent.activityBA);
 BA.debugLineNum = 133;BA.debugLine="TitleState.LoadLayout(\"TitleState\")";
Debug.ShouldStop(16);
main.mostCurrent._titlestate.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("TitleState")),main.mostCurrent.activityBA);
 BA.debugLineNum = 134;BA.debugLine="GameOverState.LoadLayout(\"GameOverState\")";
Debug.ShouldStop(32);
main.mostCurrent._gameoverstate.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("GameOverState")),main.mostCurrent.activityBA);
 BA.debugLineNum = 135;BA.debugLine="GameDefeated.LoadLayout(\"GameDefeated\")";
Debug.ShouldStop(64);
main.mostCurrent._gamedefeated.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("GameDefeated")),main.mostCurrent.activityBA);
 BA.debugLineNum = 136;BA.debugLine="PauseState.LoadLayout(\"PauseState\")";
Debug.ShouldStop(128);
main.mostCurrent._pausestate.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("PauseState")),main.mostCurrent.activityBA);
 BA.debugLineNum = 137;BA.debugLine="Activity.AddView(Load,0,0,100%x,100%y)";
Debug.ShouldStop(256);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._load.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 138;BA.debugLine="Activity.AddView(GameState,0,0,100%x,100%y)";
Debug.ShouldStop(512);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._gamestate.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 139;BA.debugLine="Activity.AddView(TitleState,0,0,100%x,100%y)";
Debug.ShouldStop(1024);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._titlestate.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 140;BA.debugLine="Activity.AddView(GameOverState,0,0,100%x,100%y)";
Debug.ShouldStop(2048);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._gameoverstate.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 141;BA.debugLine="Activity.AddView(GameDefeated,0,0,100%x,100%y)";
Debug.ShouldStop(4096);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._gamedefeated.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 142;BA.debugLine="Activity.AddView(PauseState,0,0,100%x,100%y)";
Debug.ShouldStop(8192);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._pausestate.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 143;BA.debugLine="FontStyle";
Debug.ShouldStop(16384);
_fontstyle();
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _inttodip(RemoteObject _integer) throws Exception{
try {
		Debug.PushSubsStack("IntToDIP (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,259);
if (RapidSub.canDelegate("inttodip")) { return b4a.example.main.remoteMe.runUserSub(false, "main","inttodip", _integer);}
RemoteObject _dip = RemoteObject.createImmutable(0);
Debug.locals.put("Integer", _integer);
 BA.debugLineNum = 259;BA.debugLine="Sub IntToDIP(Integer As Int) As Int";
Debug.ShouldStop(4);
 BA.debugLineNum = 260;BA.debugLine="Dim DIP As Int";
Debug.ShouldStop(8);
_dip = RemoteObject.createImmutable(0);Debug.locals.put("DIP", _dip);
 BA.debugLineNum = 261;BA.debugLine="DIP = Integer *1dip";
Debug.ShouldStop(16);
_dip = RemoteObject.solve(new RemoteObject[] {_integer,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "*",0, 1);Debug.locals.put("DIP", _dip);
 BA.debugLineNum = 262;BA.debugLine="Return DIP";
Debug.ShouldStop(32);
if (true) return _dip;
 BA.debugLineNum = 263;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
xuiviewsutils_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
b4xdrawer.myClass = BA.getDeviceClass ("b4a.example.b4xdrawer");
animatedcounter.myClass = BA.getDeviceClass ("b4a.example.animatedcounter");
anotherprogressbar.myClass = BA.getDeviceClass ("b4a.example.anotherprogressbar");
b4xbreadcrumb.myClass = BA.getDeviceClass ("b4a.example.b4xbreadcrumb");
b4xcolortemplate.myClass = BA.getDeviceClass ("b4a.example.b4xcolortemplate");
b4xcombobox.myClass = BA.getDeviceClass ("b4a.example.b4xcombobox");
b4xdatetemplate.myClass = BA.getDeviceClass ("b4a.example.b4xdatetemplate");
b4xdialog.myClass = BA.getDeviceClass ("b4a.example.b4xdialog");
b4xfloattextfield.myClass = BA.getDeviceClass ("b4a.example.b4xfloattextfield");
b4ximageview.myClass = BA.getDeviceClass ("b4a.example.b4ximageview");
b4xinputtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xinputtemplate");
b4xlisttemplate.myClass = BA.getDeviceClass ("b4a.example.b4xlisttemplate");
b4xloadingindicator.myClass = BA.getDeviceClass ("b4a.example.b4xloadingindicator");
b4xlongtexttemplate.myClass = BA.getDeviceClass ("b4a.example.b4xlongtexttemplate");
b4xplusminus.myClass = BA.getDeviceClass ("b4a.example.b4xplusminus");
b4xradiobutton.myClass = BA.getDeviceClass ("b4a.example.b4xradiobutton");
b4xsearchtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xsearchtemplate");
b4xseekbar.myClass = BA.getDeviceClass ("b4a.example.b4xseekbar");
b4xsignaturetemplate.myClass = BA.getDeviceClass ("b4a.example.b4xsignaturetemplate");
b4xswitch.myClass = BA.getDeviceClass ("b4a.example.b4xswitch");
b4xtimedtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xtimedtemplate");
madewithlove.myClass = BA.getDeviceClass ("b4a.example.madewithlove");
b4xformatter.myClass = BA.getDeviceClass ("b4a.example.b4xformatter");
roundslider.myClass = BA.getDeviceClass ("b4a.example.roundslider");
scrollinglabel.myClass = BA.getDeviceClass ("b4a.example.scrollinglabel");
swiftbutton.myClass = BA.getDeviceClass ("b4a.example.swiftbutton");
xuiviewsutils.myClass = BA.getDeviceClass ("b4a.example.xuiviewsutils");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Private MonsterType As Int = 0";
main._monstertype = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 20;BA.debugLine="Private Monster() As String = Array As String(\"re";
main._monster = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("redslime.png"),BA.ObjectToString("orc.png"),RemoteObject.createImmutable("skeleton.png")});
 //BA.debugLineNum = 21;BA.debugLine="Private FileName As String = Monster(MonsterType)";
main._filename = main._monster.getArrayElement(true,main._monstertype);
 //BA.debugLineNum = 22;BA.debugLine="Private MediaPlayer As MediaPlayer";
main._mediaplayer = RemoteObject.createNew ("anywheresoftware.b4a.objects.MediaPlayerWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private Font As Typeface = Typeface.LoadFromAsset";
main._font = RemoteObject.createNew ("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
main._font = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.constants.TypefaceWrapper"), main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("alagard.ttf"))));
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _redraw() throws Exception{
try {
		Debug.PushSubsStack("ReDraw (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,265);
if (RapidSub.canDelegate("redraw")) { return b4a.example.main.remoteMe.runUserSub(false, "main","redraw");}
RemoteObject _i = RemoteObject.createImmutable(0);
 BA.debugLineNum = 265;BA.debugLine="Sub ReDraw";
Debug.ShouldStop(256);
 BA.debugLineNum = 266;BA.debugLine="Dim i As Int";
Debug.ShouldStop(512);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 267;BA.debugLine="For i = Activity.NumberOfViews - 1 To 0 Step -1";
Debug.ShouldStop(1024);
{
final int step2 = -1;
final int limit2 = 0;
_i = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1) ;
for (;(step2 > 0 && _i.<Integer>get().intValue() <= limit2) || (step2 < 0 && _i.<Integer>get().intValue() >= limit2) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 268;BA.debugLine="Activity.RemoveViewAt(i)";
Debug.ShouldStop(2048);
main.mostCurrent._activity.runVoidMethod ("RemoveViewAt",(Object)(_i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 270;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _retry_click() throws Exception{
try {
		Debug.PushSubsStack("Retry_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,280);
if (RapidSub.canDelegate("retry_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","retry_click");}
 BA.debugLineNum = 280;BA.debugLine="Private Sub Retry_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 281;BA.debugLine="hpshake = False";
Debug.ShouldStop(16777216);
main._hpshake = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 282;BA.debugLine="mobshake = False";
Debug.ShouldStop(33554432);
main._mobshake = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 283;BA.debugLine="HPval = 100";
Debug.ShouldStop(67108864);
main._hpval = BA.numberCast(int.class, 100);
 BA.debugLineNum = 284;BA.debugLine="mobVal = 100";
Debug.ShouldStop(134217728);
main._mobval = BA.numberCast(int.class, 100);
 BA.debugLineNum = 285;BA.debugLine="MonsterType = 0";
Debug.ShouldStop(268435456);
main._monstertype = BA.numberCast(int.class, 0);
 BA.debugLineNum = 286;BA.debugLine="FileName = Monster(MonsterType)";
Debug.ShouldStop(536870912);
main._filename = main._monster.getArrayElement(true,main._monstertype);
 BA.debugLineNum = 287;BA.debugLine="GameOverState.Visible = False";
Debug.ShouldStop(1073741824);
main.mostCurrent._gameoverstate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 288;BA.debugLine="ReDraw";
Debug.ShouldStop(-2147483648);
_redraw();
 BA.debugLineNum = 289;BA.debugLine="Activity_Create(True)";
Debug.ShouldStop(1);
_activity_create(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 290;BA.debugLine="GameState.Visible = True";
Debug.ShouldStop(2);
main.mostCurrent._gamestate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 293;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _shufflearray(RemoteObject _stringarray) throws Exception{
try {
		Debug.PushSubsStack("ShuffleArray (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,246);
if (RapidSub.canDelegate("shufflearray")) { return b4a.example.main.remoteMe.runUserSub(false, "main","shufflearray", _stringarray);}
RemoteObject _arrayval = RemoteObject.createImmutable("");
RemoteObject _random = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("StringArray", _stringarray);
 BA.debugLineNum = 246;BA.debugLine="Sub ShuffleArray(StringArray() As String)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 247;BA.debugLine="Dim ArrayVal As String";
Debug.ShouldStop(4194304);
_arrayval = RemoteObject.createImmutable("");Debug.locals.put("ArrayVal", _arrayval);
 BA.debugLineNum = 248;BA.debugLine="Dim Random As Int";
Debug.ShouldStop(8388608);
_random = RemoteObject.createImmutable(0);Debug.locals.put("Random", _random);
 BA.debugLineNum = 250;BA.debugLine="For i = 0 To StringArray.Length - 1";
Debug.ShouldStop(33554432);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {_stringarray.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 251;BA.debugLine="Random = Rnd(i, StringArray.Length)";
Debug.ShouldStop(67108864);
_random = main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, _i)),(Object)(_stringarray.getField(true,"length")));Debug.locals.put("Random", _random);
 BA.debugLineNum = 252;BA.debugLine="ArrayVal = StringArray(i)";
Debug.ShouldStop(134217728);
_arrayval = _stringarray.getArrayElement(true,BA.numberCast(int.class, _i));Debug.locals.put("ArrayVal", _arrayval);
 BA.debugLineNum = 253;BA.debugLine="StringArray(i) = StringArray(Random)";
Debug.ShouldStop(268435456);
_stringarray.setArrayElement (_stringarray.getArrayElement(true,_random),BA.numberCast(int.class, _i));
 BA.debugLineNum = 254;BA.debugLine="StringArray(Random) = ArrayVal";
Debug.ShouldStop(536870912);
_stringarray.setArrayElement (_arrayval,_random);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 257;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _start_click() throws Exception{
try {
		Debug.PushSubsStack("Start_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,273);
if (RapidSub.canDelegate("start_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","start_click");}
 BA.debugLineNum = 273;BA.debugLine="Private Sub Start_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 274;BA.debugLine="check = True";
Debug.ShouldStop(131072);
main._check = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 275;BA.debugLine="TitleState.Visible = False";
Debug.ShouldStop(262144);
main.mostCurrent._titlestate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 276;BA.debugLine="GameState.Visible = True";
Debug.ShouldStop(524288);
main.mostCurrent._gamestate.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 278;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}