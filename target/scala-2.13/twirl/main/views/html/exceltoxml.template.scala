
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._

object exceltoxml extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[ExcelToXMLConverter],List[String],Http.Request,play.i18n.Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(calc : Form[ExcelToXMLConverter], opt: List[String])(implicit  request: Http.Request, messages: play.i18n.Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import views.html.helper._;


Seq[Any](format.raw/*1.118*/("""
"""),format.raw/*3.1*/("""

"""),format.raw/*5.1*/("""<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>!! Website !!</title>
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href='"""),_display_(/*10.14*/routes/*10.20*/.Assets.versioned("stylesheets/default.css")),format.raw/*10.64*/("""' rel="stylesheet" type="text/css" media="screen" />
<link href='"""),_display_(/*11.14*/routes/*11.20*/.Assets.versioned("stylesheets/fonts.css")),format.raw/*11.62*/("""' rel="stylesheet" type="text/css" media="screen" />

</head>
<body>
<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<img src="" alt="" />
			<h1><a href="#">!mG</a></h1>
			<span>Designed</span>
		</div>
		<div id="menu">
			<ul>
				<li ><a href=""""),_display_(/*24.20*/routes/*24.26*/.HomeController.index),format.raw/*24.47*/("""" accesskey="1" title="">Homepage</a></li>
				<li class="current_page_item"><a href=""""),_display_(/*25.45*/routes/*25.51*/.HomeController.openExcelToXMLForm),format.raw/*25.85*/("""" accesskey="2" title="">Excel- XML</a></li>
				<li><a href=""""),_display_(/*26.19*/routes/*26.25*/.HomeController.openXMLExtractForm),format.raw/*26.59*/("""" accesskey="3" title="">XML Extractor</a></li>
				<li><a href=""""),_display_(/*27.19*/routes/*27.25*/.HomeController.openXMLDiffFinderForm),format.raw/*27.62*/("""" accesskey="4" title="">XML Diff Finder</a></li>
				
			</ul>
		</div>
	</div>
	<div id="main"> 
	
		<div id="featured">
		
			"""),_display_(/*36.5*/helper/*36.11*/.form(action =routes.HomeController.generateXMLFile, Symbol("enctype") -> "multipart/form-data")/*36.107*/{_display_(Seq[Any](format.raw/*36.108*/("""
		"""),_display_(/*37.4*/helper/*37.10*/.select(field = calc("opt"), options = helper.options(opt).toSeq, '_label -> "Select an Option")),format.raw/*37.106*/("""
		"""),format.raw/*38.3*/("""<br><br><br><br><br>
		<input type="file" name="excelFile" value="Select Excel File">
		
		<input type="submit" name="Convert" value="Convert">
		""")))}),format.raw/*42.4*/("""
		"""),format.raw/*43.3*/("""</div>
		
	</div>
</div>
</body>
</html>"""))
      }
    }
  }

  def render(calc:Form[ExcelToXMLConverter],opt:List[String],request:Http.Request,messages:play.i18n.Messages): play.twirl.api.HtmlFormat.Appendable = apply(calc,opt)(request,messages)

  def f:((Form[ExcelToXMLConverter],List[String]) => (Http.Request,play.i18n.Messages) => play.twirl.api.HtmlFormat.Appendable) = (calc,opt) => (request,messages) => apply(calc,opt)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-04-13T17:13:10.971
                  SOURCE: C:/Users/Aks/workspace/Tools Website/app/views/exceltoxml.scala.html
                  HASH: 906389b8214b9c11c2416214ef556d99bf7895c6
                  MATRIX: 977->1|1166->120|1224->117|1252->149|1282->153|1553->397|1568->403|1633->447|1727->514|1742->520|1805->562|2121->851|2136->857|2178->878|2293->966|2308->972|2363->1006|2454->1070|2469->1076|2524->1110|2618->1177|2633->1183|2691->1220|2856->1359|2871->1365|2977->1461|3017->1462|3048->1467|3063->1473|3181->1569|3212->1573|3393->1724|3424->1728
                  LINES: 27->1|30->2|33->1|34->3|36->5|41->10|41->10|41->10|42->11|42->11|42->11|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|58->27|58->27|58->27|67->36|67->36|67->36|67->36|68->37|68->37|68->37|69->38|73->42|74->43
                  -- GENERATED --
              */
          