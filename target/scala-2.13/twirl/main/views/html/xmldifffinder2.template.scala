
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

object xmldifffinder2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[XMLDiffFinder],Http.Request,play.i18n.Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(extract : Form[XMLDiffFinder])(implicit  request: Http.Request, messages: play.i18n.Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import views.html.helper._;


Seq[Any](format.raw/*1.96*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>!! Website !!</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href='"""),_display_(/*11.14*/routes/*11.20*/.Assets.versioned("stylesheets/default.css")),format.raw/*11.64*/("""' rel="stylesheet" type="text/css" media="screen" />
<link href='"""),_display_(/*12.14*/routes/*12.20*/.Assets.versioned("stylesheets/fonts.css")),format.raw/*12.62*/("""' rel="stylesheet" type="text/css" media="screen" />

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
				<li><a href=""""),_display_(/*25.19*/routes/*25.25*/.HomeController.index),format.raw/*25.46*/("""" accesskey="1" title="">Homepage</a></li>
				<li><a href=""""),_display_(/*26.19*/routes/*26.25*/.HomeController.openExcelToXMLForm),format.raw/*26.59*/("""" accesskey="2" title="">Excel- XML</a></li>
				<li><a href=""""),_display_(/*27.19*/routes/*27.25*/.HomeController.openXMLExtractForm),format.raw/*27.59*/("""" accesskey="3" title="">XML Extractor</a></li>
				<li class="current_page_item"><a href=""""),_display_(/*28.45*/routes/*28.51*/.HomeController.openXMLDiffFinderForm),format.raw/*28.88*/("""" accesskey="4" title="">XML Diff Finder</a></li>
				
			</ul>
		</div>
	</div>
	<div id="main"> 
		<div id="featured">
			 """),_display_(/*35.6*/helper/*35.12*/.form(action =routes.HomeController.xmldifffinder())/*35.64*/{_display_(Seq[Any](format.raw/*35.65*/("""
			"""),_display_(/*36.5*/helper/*36.11*/.inputText(extract("sourceFilePath"), '_label -> "Enter Source File Path ")),format.raw/*36.86*/("""
			"""),_display_(/*37.5*/helper/*37.11*/.inputText(extract("targetFilePath"), '_label -> "Enter Target File path ")),format.raw/*37.86*/("""		
		
		"""),format.raw/*39.3*/("""<input type="submit" name="Diff" value="Find Difference">
		""")))}),format.raw/*40.4*/("""
		"""),format.raw/*41.3*/("""</div>
		
	</div>
</div>
</body>
</html>

"""))
      }
    }
  }

  def render(extract:Form[XMLDiffFinder],request:Http.Request,messages:play.i18n.Messages): play.twirl.api.HtmlFormat.Appendable = apply(extract)(request,messages)

  def f:((Form[XMLDiffFinder]) => (Http.Request,play.i18n.Messages) => play.twirl.api.HtmlFormat.Appendable) = (extract) => (request,messages) => apply(extract)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-04-14T23:01:27.594
                  SOURCE: C:/Users/Aks/workspace/Tools Website/app/views/xmldifffinder2.scala.html
                  HASH: cbcf0999fc9cf606b38f6e2ce35ff758ebd49df4
                  MATRIX: 962->1|1129->98|1186->95|1214->127|1242->129|1626->486|1641->492|1706->536|1800->603|1815->609|1878->651|2193->939|2208->945|2250->966|2339->1028|2354->1034|2409->1068|2500->1132|2515->1138|2570->1172|2690->1265|2705->1271|2763->1308|2922->1441|2937->1447|2998->1499|3037->1500|3069->1506|3084->1512|3180->1587|3212->1593|3227->1599|3323->1674|3360->1684|3452->1746|3483->1750
                  LINES: 27->1|30->2|33->1|34->3|35->4|42->11|42->11|42->11|43->12|43->12|43->12|56->25|56->25|56->25|57->26|57->26|57->26|58->27|58->27|58->27|59->28|59->28|59->28|66->35|66->35|66->35|66->35|67->36|67->36|67->36|68->37|68->37|68->37|70->39|71->40|72->41
                  -- GENERATED --
              */
          