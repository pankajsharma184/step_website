
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

object archive2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(bodyText: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.20*/("""
"""),format.raw/*2.1*/("""<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>!! Website !!</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href='"""),_display_(/*9.14*/routes/*9.20*/.Assets.versioned("stylesheets/default.css")),format.raw/*9.64*/("""' rel="stylesheet" type="text/css" media="screen" />
<link href='"""),_display_(/*10.14*/routes/*10.20*/.Assets.versioned("stylesheets/fonts.css")),format.raw/*10.62*/("""' rel="stylesheet" type="text/css" media="screen" />

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
				<li class="current_page_item"><a href=""""),_display_(/*23.45*/routes/*23.51*/.HomeController.index),format.raw/*23.72*/("""" accesskey="1" title="">Homepage</a></li>
				<li><a href=""""),_display_(/*24.19*/routes/*24.25*/.HomeController.openExcelToXMLForm),format.raw/*24.59*/("""" accesskey="2" title="">Excel- XML</a></li>
				<li><a href=""""),_display_(/*25.19*/routes/*25.25*/.HomeController.openXMLExtractForm),format.raw/*25.59*/("""" accesskey="3" title="">XML Extractor</a></li>
				<li><a href=""""),_display_(/*26.19*/routes/*26.25*/.HomeController.openXMLDiffFinderForm),format.raw/*26.62*/("""" accesskey="4" title="">XML Diff Finder</a></li>
				
			</ul>
		</div>
	</div>
	<div id="main"> 
	
		<div id="banner">
			
		</div>
		<div id="welcome">
			
			
		</div>
		<div id="featured">
			 <p><b> """),_display_(/*41.13*/bodyText),format.raw/*41.21*/("""</b></p>
		</div>
		
	</div>
</div>
</body>
</html>

"""))
      }
    }
  }

  def render(bodyText:String): play.twirl.api.HtmlFormat.Appendable = apply(bodyText)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (bodyText) => apply(bodyText)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-04-14T19:31:17.508
                  SOURCE: C:/Users/Aks/workspace/Tools Website/app/views/archive2.scala.html
                  HASH: efdf77306c60d2fe6a8c3ebbeca64e2fb2263051
                  MATRIX: 911->1|1024->19|1052->21|1435->378|1449->384|1513->428|1607->495|1622->501|1685->543|2026->857|2041->863|2083->884|2172->946|2187->952|2242->986|2333->1050|2348->1056|2403->1090|2497->1157|2512->1163|2570->1200|2818->1421|2847->1429
                  LINES: 27->1|32->1|33->2|40->9|40->9|40->9|41->10|41->10|41->10|54->23|54->23|54->23|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|72->41|72->41
                  -- GENERATED --
              */
          