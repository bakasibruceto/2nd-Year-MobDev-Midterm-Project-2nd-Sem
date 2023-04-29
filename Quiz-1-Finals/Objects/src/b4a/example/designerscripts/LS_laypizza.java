package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_laypizza{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pizza").vw.setLeft((int)(0d));
views.get("pizza").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("pizza").vw.setTop((int)(0d));
views.get("pizza").vw.setHeight((int)((100d / 100 * height) - (0d)));
views.get("label12").vw.setLeft((int)((views.get("pizza").vw.getWidth())/2d - (views.get("label12").vw.getWidth() / 2)));
views.get("label12").vw.setTop((int)((views.get("pizza").vw.getHeight())/10d - (views.get("label12").vw.getHeight() / 2)));
views.get("chkham").vw.setLeft((int)((views.get("pizza").vw.getWidth())/2d - (views.get("chkham").vw.getWidth() / 2)));
views.get("chkham").vw.setTop((int)((views.get("pizza").vw.getHeight())/4d - (views.get("chkham").vw.getHeight() / 2)));
views.get("chkhaw").vw.setLeft((int)((views.get("pizza").vw.getWidth())/2d - (views.get("chkhaw").vw.getWidth() / 2)));
views.get("chkhaw").vw.setTop((int)((views.get("pizza").vw.getHeight())/2.7d - (views.get("chkhaw").vw.getHeight() / 2)));
views.get("chkpep").vw.setLeft((int)((views.get("pizza").vw.getWidth())/2d - (views.get("chkpep").vw.getWidth() / 2)));
views.get("chkpep").vw.setTop((int)((views.get("pizza").vw.getHeight())/2.03d - (views.get("chkpep").vw.getHeight() / 2)));
views.get("txtprice2").vw.setLeft((int)((views.get("pizza").vw.getWidth())/2d - (views.get("txtprice2").vw.getWidth() / 2)));
views.get("txtprice2").vw.setTop((int)((views.get("pizza").vw.getHeight())/1.55d - (views.get("txtprice2").vw.getHeight() / 2)));
views.get("btnaccept2").vw.setLeft((int)((views.get("pizza").vw.getWidth())/2d - (views.get("btnaccept2").vw.getWidth() / 2)));
views.get("btnaccept2").vw.setTop((int)((views.get("pizza").vw.getHeight())/1.3d - (views.get("btnaccept2").vw.getHeight() / 2)));
views.get("btnhome2").vw.setLeft((int)((views.get("pizza").vw.getWidth())/2d - (views.get("btnhome2").vw.getWidth() / 2)));
views.get("btnhome2").vw.setTop((int)((views.get("pizza").vw.getHeight())/1.12d - (views.get("btnhome2").vw.getHeight() / 2)));
views.get("label22").vw.setLeft((int)((views.get("pizza").vw.getWidth())/5d - (views.get("label22").vw.getWidth() / 2)));
views.get("label22").vw.setTop((int)((views.get("pizza").vw.getHeight())/1.55d - (views.get("label22").vw.getHeight() / 2)));
views.get("btnclear2").vw.setLeft((int)((views.get("pizza").vw.getWidth())/1.25d - (views.get("btnclear2").vw.getWidth() / 2)));
views.get("btnclear2").vw.setTop((int)((views.get("pizza").vw.getHeight())/1.55d - (views.get("btnclear2").vw.getHeight() / 2)));

}
}