package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_titlestate{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("titlepanel").vw.setWidth((int)((100d / 100 * width)));
views.get("titlepanel").vw.setHeight((int)((100d / 100 * height)));
views.get("start").vw.setLeft((int)((views.get("titlepanel").vw.getWidth())/2d - (views.get("start").vw.getWidth() / 2)));
views.get("start").vw.setTop((int)((views.get("titlepanel").vw.getHeight())/1.5d - (views.get("start").vw.getHeight() / 2)));

}
}