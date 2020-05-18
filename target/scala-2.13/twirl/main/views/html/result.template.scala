
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

object result extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Integer,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(res : Integer):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.17*/("""

"""),format.raw/*3.1*/("""<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>!! Website !!</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
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
				<li><a href=""""),_display_(/*25.19*/routes/*25.25*/.HomeController.openExcelToXMLForm),format.raw/*25.59*/("""" accesskey="3" title="">Excel- XML</a></li>
				<li><a href=""""),_display_(/*26.19*/routes/*26.25*/.HomeController.openXMLExtractForm),format.raw/*26.59*/("""" accesskey="4" title="">XML Extractor</a></li>
				<li><a href=""""),_display_(/*27.19*/routes/*27.25*/.HomeController.openXMLDiffFinderForm),format.raw/*27.62*/("""" accesskey="4" title="">XML Diff Finder</a></li>
				
			</ul>
		</div>
	</div>
	<div id="main"> 
	
		<div id="banner">
			
		</div>
		<div id="welcome">
			
			
		</div>
		<div id="featured">
			 <p><b>The result is : """),_display_(/*42.28*/res),format.raw/*42.31*/("""</b></p>
		</div>
		
	</div>
</div>
</body>
</html>"""))
      }
    }
  }

  def render(res:Integer): play.twirl.api.HtmlFormat.Appendable = apply(res)

  def f:((Integer) => play.twirl.api.HtmlFormat.Appendable) = (res) => apply(res)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-04-13T17:13:11.040
                  SOURCE: C:/Users/Aks/workspace/Tools Website/app/views/result.scala.html
                  HASH: 78d683c5ebbf7af20e93bee8214cba85af590da7
                  MATRIX: 910->1|1020->16|1050->20|1434->377|1449->383|1514->427|1608->494|1623->500|1686->542|2002->831|2017->837|2059->858|2148->920|2163->926|2218->960|2309->1024|2324->1030|2379->1064|2473->1131|2488->1137|2546->1174|2809->1410|2833->1413
                  LINES: 27->1|32->1|34->3|41->10|41->10|41->10|42->11|42->11|42->11|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|58->27|58->27|58->27|73->42|73->42
                  -- GENERATED --
              */
          