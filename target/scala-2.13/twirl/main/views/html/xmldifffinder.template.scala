
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

object xmldifffinder extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[XMLDiffFinder],Http.Request,play.i18n.Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(extract : Form[XMLDiffFinder])(implicit  request: Http.Request, messages: play.i18n.Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import views.html.helper._;


Seq[Any](format.raw/*1.96*/("""
"""),format.raw/*3.1*/("""<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Step Automation Projects</title>

  <!-- Bootstrap core CSS -->
  <link href='"""),_display_(/*15.16*/routes/*15.22*/.Assets.versioned("vendor/bootstrap/css/bootstrap.min.css")),format.raw/*15.81*/("""' rel="stylesheet" type="text/css" media="screen" />

  <!-- Custom styles for this template -->
  <link href='"""),_display_(/*18.16*/routes/*18.22*/.Assets.versioned("css/scrolling-nav.css")),format.raw/*18.64*/("""' rel="stylesheet" type="text/css" media="screen" />
  <link href='"""),_display_(/*19.16*/routes/*19.22*/.Assets.versioned("css/custom.css")),format.raw/*19.57*/("""' rel="stylesheet" type="text/css" media="screen" />
  

</head>

<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href=""""),_display_(/*29.56*/routes/*29.62*/.HomeController.index),format.raw/*29.83*/("""">CODIFYD</a>
     
    </div>
  </nav>

  <div class="bg-primary body-banner body-header">
    <div class="container text-center">
      <h1>XML Difference Finder</h1>
      <p class="lead"></p>
    </div>
  </div>

  <section id="about">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>About</h2>
          <p class="lead"> Used when we need to compare two XML and check what changes are made to schema of an attribute.</p>
          <ul>
            <li>Input: 1 source and 1 target XML to be compared with for changes.</li>
            <li>Output: List of attributes which have changes with additions and deletions</li>           
          </ul>
        </div>
      </div>
    </div>
  </section>

  <section id="services" class="bg-light">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>Form</h2>
          <hr class="style1">
          <div id="featured">
			"""),_display_(/*63.5*/helper/*63.11*/.form(action =routes.HomeController.xmldifffinder())/*63.63*/{_display_(Seq[Any](format.raw/*63.64*/("""
			"""),_display_(/*64.5*/helper/*64.11*/.inputText(extract("sourceFilePath"), '_label -> "Enter Source File Path ")),format.raw/*64.86*/("""
			"""),_display_(/*65.5*/helper/*65.11*/.inputText(extract("targetFilePath"), '_label -> "Enter Target File path ")),format.raw/*65.86*/("""		
		
		"""),format.raw/*67.3*/("""<input type="submit" name="Diff" value="Find Difference">
		""")))}),format.raw/*68.4*/("""
		"""),format.raw/*69.3*/("""</div>
        </div>
      </div>
    </div>
  </section>

  

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Codifyd 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src=""""),_display_(/*86.17*/routes/*86.23*/.Assets.versioned("vendor/jquery/jquery.min.js")),format.raw/*86.71*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*87.17*/routes/*87.23*/.Assets.versioned("vendor/bootstrap/js/bootstrap.bundle.min.js")),format.raw/*87.87*/("""" type="text/javascript"></script>
  
  <!-- Plugin JavaScript -->
  <script src=""""),_display_(/*90.17*/routes/*90.23*/.Assets.versioned("vendor/jquery-easing/jquery.easing.min.js")),format.raw/*90.85*/("""" type="text/javascript"></script>
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom JavaScript for this theme -->
  <script src=""""),_display_(/*94.17*/routes/*94.23*/.Assets.versioned("js/scrolling-nav.js")),format.raw/*94.63*/("""" type="text/javascript"></script>
  
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
                  DATE: 2020-05-13T15:03:20.038
                  SOURCE: C:/Users/Aks/workspace/Tools Website/app/views/xmldifffinder.scala.html
                  HASH: 9e01886819fed738e454c1764ae7df168f3f0d2c
                  MATRIX: 961->1|1128->98|1185->95|1213->127|1554->441|1569->447|1649->506|1791->621|1806->627|1869->669|1965->738|1980->744|2036->779|2349->1065|2364->1071|2406->1092|3449->2109|3464->2115|3525->2167|3564->2168|3596->2174|3611->2180|3707->2255|3739->2261|3754->2267|3850->2342|3887->2352|3979->2414|4010->2418|4376->2757|4391->2763|4460->2811|4539->2863|4554->2869|4639->2933|4752->3019|4767->3025|4850->3087|5045->3255|5060->3261|5121->3301
                  LINES: 27->1|30->2|33->1|34->3|46->15|46->15|46->15|49->18|49->18|49->18|50->19|50->19|50->19|60->29|60->29|60->29|94->63|94->63|94->63|94->63|95->64|95->64|95->64|96->65|96->65|96->65|98->67|99->68|100->69|117->86|117->86|117->86|118->87|118->87|118->87|121->90|121->90|121->90|125->94|125->94|125->94
                  -- GENERATED --
              */
          