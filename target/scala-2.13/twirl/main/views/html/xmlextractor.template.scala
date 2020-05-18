
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

object xmlextractor extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[XMLExtractor],List[String],Http.Request,play.i18n.Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(extract : Form[XMLExtractor], types: List[String])(implicit  request: Http.Request, messages: play.i18n.Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import views.html.helper._;


Seq[Any](format.raw/*1.116*/("""
"""),format.raw/*3.1*/("""

"""),format.raw/*5.1*/("""<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>!! Website !!</title>
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href='"""),_display_(/*10.14*/routes/*10.20*/.Assets.versioned("stylesheets/default.css")),format.raw/*10.64*/("""' rel="stylesheet" type="text/css" media="screen" />
<link href='"""),_display_(/*11.14*/routes/*11.20*/.Assets.versioned("stylesheets/fonts.css")),format.raw/*11.62*/("""' rel="stylesheet" type="text/css" media="screen" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src=""""),_display_(/*13.15*/routes/*13.21*/.Assets.versioned("js/custom.js")),format.raw/*13.54*/("""" type="text/javascript"></script>
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
				<li ><a href=""""),_display_(/*26.20*/routes/*26.26*/.HomeController.index),format.raw/*26.47*/("""" accesskey="1" title="">Homepage</a></li>
				<li ><a href=""""),_display_(/*27.20*/routes/*27.26*/.HomeController.openExcelToXMLForm),format.raw/*27.60*/("""" accesskey="2" title="">Excel- XML</a></li>
				<li class="current_page_item"><a href=""""),_display_(/*28.45*/routes/*28.51*/.HomeController.openXMLExtractForm),format.raw/*28.85*/("""" accesskey="3" title="">XML Extractor</a></li>
				<li><a href=""""),_display_(/*29.19*/routes/*29.25*/.HomeController.openXMLDiffFinderForm),format.raw/*29.62*/("""" accesskey="4" title="">XML Diff Finder</a></li>
				
			</ul>
			
		</div>
	</div>
	<div id="main"> 
		
		<div id="featured">
		
			"""),_display_(/*39.5*/helper/*39.11*/.form( action =routes.HomeController.extractPartXML(),'id -> "formExtract")/*39.86*/{_display_(Seq[Any](format.raw/*39.87*/("""
			"""),_display_(/*40.5*/helper/*40.11*/.textarea(extract("stepNodeTypeIDs"), 'id -> "result", 'readonly -> "true")),format.raw/*40.86*/("""
			
			"""),format.raw/*42.4*/("""<div class ="group" id="grp1">
			"""),_display_(/*43.5*/helper/*43.11*/.select(field = extract("stepNodeType"), options = helper.options(types).toSeq, '_label -> "Select STEP Node Type", 'placeholder -> "Name", 'class -> "GrpChild")),format.raw/*43.172*/("""
			"""),_display_(/*44.5*/helper/*44.11*/.inputText(extract("stepNodeIDs"), '_label -> "Enter Node IDs ", 'placeholder -> "ID", 'class -> "GrpChild", 'onchange->"myFunc()")),format.raw/*44.142*/("""
			"""),format.raw/*45.4*/("""</div>
			<button id="addMore">Add more fields</button><br/>
			"""),_display_(/*47.5*/helper/*47.11*/.inputText(extract("inputFilePath"), '_label -> "Enter Input File Path(along with Name) ")),format.raw/*47.101*/("""
			"""),_display_(/*48.5*/helper/*48.11*/.inputText(extract("outputFilePath"), '_label -> "Enter Output file path ")),format.raw/*48.86*/("""
			
		
		"""),format.raw/*51.3*/("""<input type="submit" name="Convert" value="Extract">
		""")))}),format.raw/*52.4*/("""
		
		"""),format.raw/*54.3*/("""</div>
		
	</div>
</div>
</body>
</html>"""))
      }
    }
  }

  def render(extract:Form[XMLExtractor],types:List[String],request:Http.Request,messages:play.i18n.Messages): play.twirl.api.HtmlFormat.Appendable = apply(extract,types)(request,messages)

  def f:((Form[XMLExtractor],List[String]) => (Http.Request,play.i18n.Messages) => play.twirl.api.HtmlFormat.Appendable) = (extract,types) => (request,messages) => apply(extract,types)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-04-13T17:13:11.103
                  SOURCE: C:/Users/Aks/workspace/Tools Website/app/views/xmlextractor.scala.html
                  HASH: 9fcebb4333edd1d4dc99e5a65f93fc3b52794fb7
                  MATRIX: 972->1|1159->118|1217->115|1245->147|1275->151|1546->395|1561->401|1626->445|1720->512|1735->518|1798->560|1983->718|1998->724|2052->757|2353->1031|2368->1037|2410->1058|2500->1121|2515->1127|2570->1161|2687->1251|2702->1257|2757->1291|2851->1358|2866->1364|2924->1401|3095->1546|3110->1552|3194->1627|3233->1628|3265->1634|3280->1640|3376->1715|3413->1725|3475->1761|3490->1767|3673->1928|3705->1934|3720->1940|3873->2071|3905->2076|3998->2143|4013->2149|4125->2239|4157->2245|4172->2251|4268->2326|4308->2339|4395->2396|4430->2404
                  LINES: 27->1|30->2|33->1|34->3|36->5|41->10|41->10|41->10|42->11|42->11|42->11|44->13|44->13|44->13|57->26|57->26|57->26|58->27|58->27|58->27|59->28|59->28|59->28|60->29|60->29|60->29|70->39|70->39|70->39|70->39|71->40|71->40|71->40|73->42|74->43|74->43|74->43|75->44|75->44|75->44|76->45|78->47|78->47|78->47|79->48|79->48|79->48|82->51|83->52|85->54
                  -- GENERATED --
              */
          