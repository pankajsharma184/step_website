
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

object template extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<html xmlns="http://www.w3.org/1999/xhtml">
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
			 <p><b> This is HOMEPAGE!!</b></p>
		</div>
		
	</div>
</div>
</body>
</html>

"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-04-13T17:13:11.056
                  SOURCE: C:/Users/Aks/workspace/Tools Website/app/views/template.scala.html
                  HASH: 789fd3a0b382a242242fcab24eb84d6561b3d05b
                  MATRIX: 993->2|1376->359|1390->365|1454->409|1548->476|1563->482|1626->524|1967->838|1982->844|2024->865|2113->927|2128->933|2183->967|2274->1031|2289->1037|2344->1071|2438->1138|2453->1144|2511->1181
                  LINES: 32->2|39->9|39->9|39->9|40->10|40->10|40->10|53->23|53->23|53->23|54->24|54->24|54->24|55->25|55->25|55->25|56->26|56->26|56->26
                  -- GENERATED --
              */
          