package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_layout{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("main").vw.setLeft((int)(0d));
views.get("main").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("main").vw.setTop((int)(0d));
views.get("main").vw.setHeight((int)((100d / 100 * height) - (0d)));
views.get("btnpizza").vw.setLeft((int)((views.get("main").vw.getWidth())/4.5d - (views.get("btnpizza").vw.getWidth() / 2)));
views.get("btnpizza").vw.setTop((int)((views.get("main").vw.getHeight())/7d - (views.get("btnpizza").vw.getHeight() / 2)));
views.get("btndrinks").vw.setLeft((int)((views.get("main").vw.getWidth())/4.5d - (views.get("btndrinks").vw.getWidth() / 2)));
views.get("btndrinks").vw.setTop((int)((views.get("main").vw.getHeight())/3.9d - (views.get("btndrinks").vw.getHeight() / 2)));
views.get("btntotal").vw.setLeft((int)((views.get("main").vw.getWidth())/4.5d - (views.get("btntotal").vw.getWidth() / 2)));
views.get("btntotal").vw.setTop((int)((views.get("main").vw.getHeight())/2.69d - (views.get("btntotal").vw.getHeight() / 2)));
views.get("txtpricepizza").vw.setLeft((int)((views.get("main").vw.getWidth())/1.9d - (views.get("txtpricepizza").vw.getWidth() / 2)));
views.get("txtpricepizza").vw.setTop((int)((views.get("main").vw.getHeight())/7d - (views.get("txtpricepizza").vw.getHeight() / 2)));
views.get("txtpricedrinks").vw.setLeft((int)((views.get("main").vw.getWidth())/1.9d - (views.get("txtpricedrinks").vw.getWidth() / 2)));
views.get("txtpricedrinks").vw.setTop((int)((views.get("main").vw.getHeight())/3.9d - (views.get("txtpricedrinks").vw.getHeight() / 2)));
views.get("txttotal").vw.setLeft((int)((views.get("main").vw.getWidth())/1.9d - (views.get("txttotal").vw.getWidth() / 2)));
views.get("txttotal").vw.setTop((int)((views.get("main").vw.getHeight())/2.69d - (views.get("txttotal").vw.getHeight() / 2)));
views.get("label2").vw.setLeft((int)((views.get("main").vw.getWidth())/4.5d - (views.get("label2").vw.getWidth() / 2)));
views.get("label2").vw.setTop((int)((views.get("main").vw.getHeight())/1.65d - (views.get("label2").vw.getHeight() / 2)));
views.get("label3").vw.setLeft((int)((views.get("main").vw.getWidth())/4.5d - (views.get("label3").vw.getWidth() / 2)));
views.get("label3").vw.setTop((int)((views.get("main").vw.getHeight())/1.39d - (views.get("label3").vw.getHeight() / 2)));
views.get("txttotaldiscount").vw.setLeft((int)((views.get("main").vw.getWidth())/1.9d - (views.get("txttotaldiscount").vw.getWidth() / 2)));
//BA.debugLineNum = 35;BA.debugLine="txttotaldiscount.VerticalCenter = main.Height/1.65"[Layout/General script]
views.get("txttotaldiscount").vw.setTop((int)((views.get("main").vw.getHeight())/1.65d - (views.get("txttotaldiscount").vw.getHeight() / 2)));
//BA.debugLineNum = 37;BA.debugLine="txtdiscountedprice.HorizontalCenter = main.Width/1.9"[Layout/General script]
views.get("txtdiscountedprice").vw.setLeft((int)((views.get("main").vw.getWidth())/1.9d - (views.get("txtdiscountedprice").vw.getWidth() / 2)));
//BA.debugLineNum = 38;BA.debugLine="txtdiscountedprice.VerticalCenter = main.Height/1.39"[Layout/General script]
views.get("txtdiscountedprice").vw.setTop((int)((views.get("main").vw.getHeight())/1.39d - (views.get("txtdiscountedprice").vw.getHeight() / 2)));
//BA.debugLineNum = 40;BA.debugLine="Panel1.HorizontalCenter = main.Width/2"[Layout/General script]
views.get("panel1").vw.setLeft((int)((views.get("main").vw.getWidth())/2d - (views.get("panel1").vw.getWidth() / 2)));
//BA.debugLineNum = 41;BA.debugLine="Panel1.VerticalCenter = main.Height/2.05"[Layout/General script]
views.get("panel1").vw.setTop((int)((views.get("main").vw.getHeight())/2.05d - (views.get("panel1").vw.getHeight() / 2)));
//BA.debugLineNum = 43;BA.debugLine="btnexit.HorizontalCenter = main.Width/1.9"[Layout/General script]
views.get("btnexit").vw.setLeft((int)((views.get("main").vw.getWidth())/1.9d - (views.get("btnexit").vw.getWidth() / 2)));
//BA.debugLineNum = 44;BA.debugLine="btnexit.VerticalCenter = main.Height/1.2"[Layout/General script]
views.get("btnexit").vw.setTop((int)((views.get("main").vw.getHeight())/1.2d - (views.get("btnexit").vw.getHeight() / 2)));

}
}