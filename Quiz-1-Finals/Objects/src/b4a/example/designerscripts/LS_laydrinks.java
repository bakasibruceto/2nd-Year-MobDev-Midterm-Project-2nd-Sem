package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_laydrinks{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[laydrinks/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="drinks.SetLeftAndRight(0,100%x)"[laydrinks/General script]
views.get("drinks").vw.setLeft((int)(0d));
views.get("drinks").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 4;BA.debugLine="drinks.SetTopAndBottom(0,100%y)"[laydrinks/General script]
views.get("drinks").vw.setTop((int)(0d));
views.get("drinks").vw.setHeight((int)((100d / 100 * height) - (0d)));
//BA.debugLineNum = 6;BA.debugLine="Label11.HorizontalCenter = drinks.Width/2"[laydrinks/General script]
views.get("label11").vw.setLeft((int)((views.get("drinks").vw.getWidth())/2d - (views.get("label11").vw.getWidth() / 2)));
//BA.debugLineNum = 7;BA.debugLine="Label11.VerticalCenter = drinks.Height/10"[laydrinks/General script]
views.get("label11").vw.setTop((int)((views.get("drinks").vw.getHeight())/10d - (views.get("label11").vw.getHeight() / 2)));
//BA.debugLineNum = 9;BA.debugLine="chkcoffee.HorizontalCenter = drinks.Width/2"[laydrinks/General script]
views.get("chkcoffee").vw.setLeft((int)((views.get("drinks").vw.getWidth())/2d - (views.get("chkcoffee").vw.getWidth() / 2)));
//BA.debugLineNum = 10;BA.debugLine="chkcoffee.VerticalCenter = drinks.Height/4"[laydrinks/General script]
views.get("chkcoffee").vw.setTop((int)((views.get("drinks").vw.getHeight())/4d - (views.get("chkcoffee").vw.getHeight() / 2)));
//BA.debugLineNum = 12;BA.debugLine="chktea.HorizontalCenter = drinks.Width/2"[laydrinks/General script]
views.get("chktea").vw.setLeft((int)((views.get("drinks").vw.getWidth())/2d - (views.get("chktea").vw.getWidth() / 2)));
//BA.debugLineNum = 13;BA.debugLine="chktea.VerticalCenter = drinks.Height/2.7"[laydrinks/General script]
views.get("chktea").vw.setTop((int)((views.get("drinks").vw.getHeight())/2.7d - (views.get("chktea").vw.getHeight() / 2)));
//BA.debugLineNum = 15;BA.debugLine="chksoda.HorizontalCenter = drinks.Width/2"[laydrinks/General script]
views.get("chksoda").vw.setLeft((int)((views.get("drinks").vw.getWidth())/2d - (views.get("chksoda").vw.getWidth() / 2)));
//BA.debugLineNum = 16;BA.debugLine="chksoda.VerticalCenter = drinks.Height/2.03"[laydrinks/General script]
views.get("chksoda").vw.setTop((int)((views.get("drinks").vw.getHeight())/2.03d - (views.get("chksoda").vw.getHeight() / 2)));
//BA.debugLineNum = 18;BA.debugLine="txtprice1.HorizontalCenter = drinks.Width/2"[laydrinks/General script]
views.get("txtprice1").vw.setLeft((int)((views.get("drinks").vw.getWidth())/2d - (views.get("txtprice1").vw.getWidth() / 2)));
//BA.debugLineNum = 19;BA.debugLine="txtprice1.VerticalCenter = drinks.Height/1.55"[laydrinks/General script]
views.get("txtprice1").vw.setTop((int)((views.get("drinks").vw.getHeight())/1.55d - (views.get("txtprice1").vw.getHeight() / 2)));
//BA.debugLineNum = 21;BA.debugLine="btnaccept1.HorizontalCenter = drinks.Width/2"[laydrinks/General script]
views.get("btnaccept1").vw.setLeft((int)((views.get("drinks").vw.getWidth())/2d - (views.get("btnaccept1").vw.getWidth() / 2)));
//BA.debugLineNum = 22;BA.debugLine="btnaccept1.VerticalCenter = drinks.Height/1.3"[laydrinks/General script]
views.get("btnaccept1").vw.setTop((int)((views.get("drinks").vw.getHeight())/1.3d - (views.get("btnaccept1").vw.getHeight() / 2)));
//BA.debugLineNum = 24;BA.debugLine="btnhome1.HorizontalCenter = drinks.Width/2"[laydrinks/General script]
views.get("btnhome1").vw.setLeft((int)((views.get("drinks").vw.getWidth())/2d - (views.get("btnhome1").vw.getWidth() / 2)));
//BA.debugLineNum = 25;BA.debugLine="btnhome1.VerticalCenter = drinks.Height/1.12"[laydrinks/General script]
views.get("btnhome1").vw.setTop((int)((views.get("drinks").vw.getHeight())/1.12d - (views.get("btnhome1").vw.getHeight() / 2)));
//BA.debugLineNum = 27;BA.debugLine="Label21.HorizontalCenter = drinks.Width/5"[laydrinks/General script]
views.get("label21").vw.setLeft((int)((views.get("drinks").vw.getWidth())/5d - (views.get("label21").vw.getWidth() / 2)));
//BA.debugLineNum = 28;BA.debugLine="Label21.VerticalCenter = drinks.Height/1.55"[laydrinks/General script]
views.get("label21").vw.setTop((int)((views.get("drinks").vw.getHeight())/1.55d - (views.get("label21").vw.getHeight() / 2)));
//BA.debugLineNum = 30;BA.debugLine="btnclear1.HorizontalCenter = drinks.Width/1.25"[laydrinks/General script]
views.get("btnclear1").vw.setLeft((int)((views.get("drinks").vw.getWidth())/1.25d - (views.get("btnclear1").vw.getWidth() / 2)));
//BA.debugLineNum = 31;BA.debugLine="btnclear1.VerticalCenter = drinks.Height/1.55"[laydrinks/General script]
views.get("btnclear1").vw.setTop((int)((views.get("drinks").vw.getHeight())/1.55d - (views.get("btnclear1").vw.getHeight() / 2)));

}
}