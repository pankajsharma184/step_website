
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(bodyText: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.20*/("""
"""),format.raw/*2.1*/("""<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Step Automation Projects</title>
      <!-- Bootstrap core CSS -->
      <link href='"""),_display_(/*10.20*/routes/*10.26*/.Assets.versioned("vendor/bootstrap/css/bootstrap.min.css")),format.raw/*10.85*/("""' rel="stylesheet" type="text/css" media="screen" />
      <!-- Custom styles for this template -->
      <link href='"""),_display_(/*12.20*/routes/*12.26*/.Assets.versioned("css/scrolling-nav.css")),format.raw/*12.68*/("""' rel="stylesheet" type="text/css" media="screen" />
      <link href='"""),_display_(/*13.20*/routes/*13.26*/.Assets.versioned("css/custom.css")),format.raw/*13.61*/("""' rel="stylesheet" type="text/css" media="screen" />
   </head>
   <body id="page-top">
      <!-- Navigation -->
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
         <div class="container">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">CODIFYD</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
               <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                     <a class="nav-link js-scroll-trigger" href="#about">Information</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link js-scroll-trigger" href="#services">Projects</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link js-scroll-trigger" href="#contact">Contact</a>
                  </li>
               </ul>
            </div>
         </div>
      </nav>
      <header class="bg-primary banner">
         <div class="container text-center">
            <h1>Welcome to Connect Internal Project</h1>
            <p class="lead"></p>
         </div>
      </header>
      <section id="about">
         <div class="container">
            <div class="row">
               <div class="col-lg-8 mx-auto">
                  <h2>About</h2>
                  <p class="lead"> As part of connect team, we developed a set of java code functionalities which can be shared between customers.
                     These are mostly STEP based and will help with processes like import, export etc. 
                  </p>
                  <ul>
                     <li>To access code, refer to <a href="https://bitbucket.org/vivekrs/step_automation/src"> git repository </a> </li>
                     <li>To access related Jira, refer to Jira board: Connect-Internal </li>
                  </ul>
               </div>
            </div>
         </div>
      </section>
      <section id="services" class="bg-light">
         <div class="container">
         	<div class="row">
         	 <div class="col-sm"><h5> Projects</h5></div>         	
         	</div>
         	 <hr class="style1">
            <div class="row">
               <div class="col-sm">
                  <p class="lead"><b>XML Difference Finder</b></p>
                  <p> Get the changes made in attribute schema by comparing two XML.</p>
                  <a href=""""),_display_(/*70.29*/routes/*70.35*/.HomeController.openXMLDiffFinderForm),format.raw/*70.72*/("""" accesskey="4" >Here</a>
               </div>
               <div class="col-sm">
                  <p class="lead"><b>XML Extractor</b></p>
                  <p> Get the snippet XML based on ID of the component in the given XML.</p>
                  <a href=""""),_display_(/*75.29*/routes/*75.35*/.HomeController.openXMLExtractForm),format.raw/*75.69*/("""" accesskey="4">Here</a>
               </div>
               <div class="col-sm">
                  One of three columns
               </div>
            </div>
            <hr class="style1">
            <div class="row">
               <div class="col-sm">
                  One of three columns
               </div>
               <div class="col-sm">
                  One of three columns
               </div>
               <div class="col-sm">
                  One of three columns
               </div>
            </div>
         </div>
      </section>
      <section id="contact">
         <div class="container">
            <div class="row">
               <div class="col-lg-8 mx-auto">
                  <h2>Contact us</h2>
                  <p class="lead"> Please contact Divya for Information. She is the wonder woman here. </p>
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
      <script src=""""),_display_(/*113.21*/routes/*113.27*/.Assets.versioned("vendor/jquery/jquery.min.js")),format.raw/*113.75*/("""" type="text/javascript"></script>
      <script src=""""),_display_(/*114.21*/routes/*114.27*/.Assets.versioned("vendor/bootstrap/js/bootstrap.bundle.min.js")),format.raw/*114.91*/("""" type="text/javascript"></script>
      <!-- Plugin JavaScript -->
      <script src=""""),_display_(/*116.21*/routes/*116.27*/.Assets.versioned("vendor/jquery-easing/jquery.easing.min.js")),format.raw/*116.89*/("""" type="text/javascript"></script>
      <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
      <!-- Custom JavaScript for this theme -->
      <script src=""""),_display_(/*119.21*/routes/*119.27*/.Assets.versioned("js/scrolling-nav.js")),format.raw/*119.67*/("""" type="text/javascript"></script>
   </body>
</html>"""))
      }
    }
  }

  def render(bodyText:String): play.twirl.api.HtmlFormat.Appendable = apply(bodyText)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (bodyText) => apply(bodyText)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-05-08T17:38:31.617
                  SOURCE: C:/Users/Aks/workspace/Tools Website/app/views/index.scala.html
                  HASH: d59e364f518f378efca71acc1a6c7a2b25613a74
                  MATRIX: 908->1|1021->19|1049->21|1413->358|1428->364|1508->423|1656->544|1671->550|1734->592|1834->665|1849->671|1905->706|4701->3475|4716->3481|4774->3518|5070->3787|5085->3793|5140->3827|6430->5089|6446->5095|6516->5143|6600->5199|6616->5205|6702->5269|6820->5359|6836->5365|6920->5427|7126->5605|7142->5611|7204->5651
                  LINES: 27->1|32->1|33->2|41->10|41->10|41->10|43->12|43->12|43->12|44->13|44->13|44->13|101->70|101->70|101->70|106->75|106->75|106->75|144->113|144->113|144->113|145->114|145->114|145->114|147->116|147->116|147->116|150->119|150->119|150->119
                  -- GENERATED --
              */
          