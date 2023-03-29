package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_pausestate{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pausepanel").vw.setWidth((int)((100d / 100 * width)));
views.get("pausepanel").vw.setHeight((int)((100d / 100 * height)));
views.get("buttonresume").vw.setLeft((int)((views.get("pausepanel").vw.getWidth())/2d - (views.get("buttonresume").vw.getWidth() / 2)));
views.get("buttonresume").vw.setTop((int)((views.get("pausepanel").vw.getHeight())/1.7d - (views.get("buttonresume").vw.getHeight() / 2)));
views.get("buttontitle").vw.setLeft((int)((views.get("pausepanel").vw.getWidth())/2d - (views.get("buttontitle").vw.getWidth() / 2)));
views.get("buttontitle").vw.setTop((int)((views.get("pausepanel").vw.getHeight())/1.35d - (views.get("buttontitle").vw.getHeight() / 2)));

}
}