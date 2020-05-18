
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

object calculator extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[Calculator],Http.Request,play.i18n.Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(calc : Form[Calculator])(implicit  request: Http.Request, messages: play.i18n.Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import views.html.helper._;


Seq[Any](format.raw/*1.90*/("""
"""),format.raw/*3.1*/("""

"""),format.raw/*5.1*/("""<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>!! Website !!</title>

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
				<li><a href=""""),_display_(/*26.19*/routes/*26.25*/.HomeController.index),format.raw/*26.46*/("""" accesskey="1" title="">Homepage</a></li>
				<li><a href=""""),_display_(/*27.19*/routes/*27.25*/.HomeController.openExcelToXMLForm),format.raw/*27.59*/("""" accesskey="3" title="">Excel- XML</a></li>
				<li><a href=""""),_display_(/*28.19*/routes/*28.25*/.HomeController.openXMLDiffFinderForm),format.raw/*28.62*/("""" accesskey="4" title="">XML Extractor</a></li>
				
			</ul>
		</div>
	</div>
	<div id="main"> 
	
		<div id="banner">
			
		</div>
		<div id="welcome">
			
			
		</div>
		
			 """),_display_(/*43.6*/helper/*43.12*/.form(action=routes.HomeController.add())/*43.53*/{_display_(Seq[Any](format.raw/*43.54*/("""
			"""),_display_(/*44.5*/helper/*44.11*/.inputText(field = calc("a"), '_label -> "Enter 1st Num")),format.raw/*44.68*/("""
			"""),_display_(/*45.5*/helper/*45.11*/.inputText(calc("b"), '_label -> "Enter 2nd Num")),format.raw/*45.60*/("""
			
			"""),format.raw/*47.4*/("""<input type="submit" name="Add" value="Add">
		""")))}),format.raw/*48.4*/("""
		
		
	"""),format.raw/*51.2*/("""</div>
</div>
</body>
</html>"""))
      }
    }
  }

  def render(calc:Form[Calculator],request:Http.Request,messages:play.i18n.Messages): play.twirl.api.HtmlFormat.Appendable = apply(calc)(request,messages)

  def f:((Form[Calculator]) => (Http.Request,play.i18n.Messages) => play.twirl.api.HtmlFormat.Appendable) = (calc) => (request,messages) => apply(calc)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-04-13T17:13:10.940
                  SOURCE: C:/Users/Aks/workspace/Tools Website/app/views/calculator.scala.html
                  HASH: eab190528f459b94bdcfb142e1de472692e77701
                  MATRIX: 955->1|1116->92|1173->89|1201->121|1231->125|1504->371|1519->377|1584->421|1678->488|1693->494|1756->536|2073->826|2088->832|2130->853|2219->915|2234->921|2289->955|2380->1019|2395->1025|2453->1062|2672->1255|2687->1261|2737->1302|2776->1303|2808->1309|2823->1315|2901->1372|2933->1378|2948->1384|3018->1433|3055->1443|3134->1492|3172->1503
                  LINES: 27->1|30->2|33->1|34->3|36->5|42->11|42->11|42->11|43->12|43->12|43->12|57->26|57->26|57->26|58->27|58->27|58->27|59->28|59->28|59->28|74->43|74->43|74->43|74->43|75->44|75->44|75->44|76->45|76->45|76->45|78->47|79->48|82->51
                  -- GENERATED --
              */
          