package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_gamedefeated{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[GameDefeated/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 4;BA.debugLine="DefPanel.SetLeftAndRight(0,100%x)"[GameDefeated/General script]
views.get("defpanel").vw.setLeft((int)(0d));
views.get("defpanel").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 5;BA.debugLine="DefPanel.SetTopAndBottom(0,100%y)"[GameDefeated/General script]
views.get("defpanel").vw.setTop((int)(0d));
views.get("defpanel").vw.setHeight((int)((100d / 100 * height) - (0d)));
//BA.debugLineNum = 9;BA.debugLine="retry.HorizontalCenter = DefPanel.Width/2"[GameDefeated/General script]
views.get("retry").vw.setLeft((int)((views.get("defpanel").vw.getWidth())/2d - (views.get("retry").vw.getWidth() / 2)));
//BA.debugLineNum = 10;BA.debugLine="retry.VerticalCenter = DefPanel.Height/1.2"[GameDefeated/General script]
views.get("retry").vw.setTop((int)((views.get("defpanel").vw.getHeight())/1.2d - (views.get("retry").vw.getHeight() / 2)));
//BA.debugLineNum = 12;BA.debugLine="ButtonTitle.HorizontalCenter = DefPanel.Width/2"[GameDefeated/General script]
views.get("buttontitle").vw.setLeft((int)((views.get("defpanel").vw.getWidth())/2d - (views.get("buttontitle").vw.getWidth() / 2)));
//BA.debugLineNum = 13;BA.debugLine="ButtonTitle.VerticalCenter = DefPanel.Height/2"[GameDefeated/General script]
views.get("buttontitle").vw.setTop((int)((views.get("defpanel").vw.getHeight())/2d - (views.get("buttontitle").vw.getHeight() / 2)));

}
}