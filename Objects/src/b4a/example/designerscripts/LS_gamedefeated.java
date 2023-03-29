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
//BA.debugLineNum = 4;BA.debugLine="WinPanel.SetLeftAndRight (0,100%x)"[GameDefeated/General script]
views.get("winpanel").vw.setLeft((int)(0d));
views.get("winpanel").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 5;BA.debugLine="WinPanel.SetTopAndBottom (0,100%y)"[GameDefeated/General script]
views.get("winpanel").vw.setTop((int)(0d));
views.get("winpanel").vw.setHeight((int)((100d / 100 * height) - (0d)));
//BA.debugLineNum = 7;BA.debugLine="ButtonTitle.HorizontalCenter = WinPanel.Width/2"[GameDefeated/General script]
views.get("buttontitle").vw.setLeft((int)((views.get("winpanel").vw.getWidth())/2d - (views.get("buttontitle").vw.getWidth() / 2)));
//BA.debugLineNum = 8;BA.debugLine="ButtonTitle.VerticalCenter = WinPanel.Height/2"[GameDefeated/General script]
views.get("buttontitle").vw.setTop((int)((views.get("winpanel").vw.getHeight())/2d - (views.get("buttontitle").vw.getHeight() / 2)));
//BA.debugLineNum = 10;BA.debugLine="Retry.HorizontalCenter = WinPanel.Width/2"[GameDefeated/General script]
views.get("retry").vw.setLeft((int)((views.get("winpanel").vw.getWidth())/2d - (views.get("retry").vw.getWidth() / 2)));
//BA.debugLineNum = 11;BA.debugLine="Retry.VerticalCenter = WinPanel.Height/1.4"[GameDefeated/General script]
views.get("retry").vw.setTop((int)((views.get("winpanel").vw.getHeight())/1.4d - (views.get("retry").vw.getHeight() / 2)));

}
}