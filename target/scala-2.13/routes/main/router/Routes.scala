// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Aks/workspace/Tools Website/conf/routes
// @DATE:Wed May 13 15:03:20 IST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  HomeController_1: controllers.HomeController,
  // @LINE:12
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    HomeController_1: controllers.HomeController,
    // @LINE:12
    Assets_0: controllers.Assets
  ) = this(errorHandler, HomeController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """add""", """controllers.HomeController.add(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """exceltoxml""", """controllers.HomeController.openExcelToXMLForm(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """openExtractXMLForm""", """controllers.HomeController.openXMLExtractForm(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """xmldifffinderForm""", """controllers.HomeController.openXMLDiffFinderForm(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """generateXMLFile""", """controllers.HomeController.generateXMLFile(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """xmlextractor""", """controllers.HomeController.extractPartXML(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """xmldifffinder""", """controllers.HomeController.xmldifffinder(request:Request)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:8
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """index page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_add1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("add")))
  )
  private[this] lazy val controllers_HomeController_add1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.add(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "add",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """add""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Assets_versioned2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned2_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """static routes""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_openExcelToXMLForm3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("exceltoxml")))
  )
  private[this] lazy val controllers_HomeController_openExcelToXMLForm3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.openExcelToXMLForm(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "openExcelToXMLForm",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """exceltoxml""",
      """Project pages""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_openXMLExtractForm4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("openExtractXMLForm")))
  )
  private[this] lazy val controllers_HomeController_openXMLExtractForm4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.openXMLExtractForm(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "openXMLExtractForm",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """openExtractXMLForm""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_openXMLDiffFinderForm5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("xmldifffinderForm")))
  )
  private[this] lazy val controllers_HomeController_openXMLDiffFinderForm5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.openXMLDiffFinderForm(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "openXMLDiffFinderForm",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """xmldifffinderForm""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_HomeController_generateXMLFile6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("generateXMLFile")))
  )
  private[this] lazy val controllers_HomeController_generateXMLFile6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.generateXMLFile(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "generateXMLFile",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """generateXMLFile""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:21
  private[this] lazy val controllers_HomeController_extractPartXML7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("xmlextractor")))
  )
  private[this] lazy val controllers_HomeController_extractPartXML7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.extractPartXML(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "extractPartXML",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """xmlextractor""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:23
  private[this] lazy val controllers_HomeController_xmldifffinder8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("xmldifffinder")))
  )
  private[this] lazy val controllers_HomeController_xmldifffinder8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.xmldifffinder(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "xmldifffinder",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """xmldifffinder""",
      """""",
      Seq("""nocsrf""")
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:9
    case controllers_HomeController_add1_route(params@_) =>
      call { 
        controllers_HomeController_add1_invoker.call(
          req => HomeController_1.add(req))
      }
  
    // @LINE:12
    case controllers_Assets_versioned2_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned2_invoker.call(Assets_0.versioned(path, file))
      }
  
    // @LINE:15
    case controllers_HomeController_openExcelToXMLForm3_route(params@_) =>
      call { 
        controllers_HomeController_openExcelToXMLForm3_invoker.call(
          req => HomeController_1.openExcelToXMLForm(req))
      }
  
    // @LINE:16
    case controllers_HomeController_openXMLExtractForm4_route(params@_) =>
      call { 
        controllers_HomeController_openXMLExtractForm4_invoker.call(
          req => HomeController_1.openXMLExtractForm(req))
      }
  
    // @LINE:17
    case controllers_HomeController_openXMLDiffFinderForm5_route(params@_) =>
      call { 
        controllers_HomeController_openXMLDiffFinderForm5_invoker.call(
          req => HomeController_1.openXMLDiffFinderForm(req))
      }
  
    // @LINE:19
    case controllers_HomeController_generateXMLFile6_route(params@_) =>
      call { 
        controllers_HomeController_generateXMLFile6_invoker.call(
          req => HomeController_1.generateXMLFile(req))
      }
  
    // @LINE:21
    case controllers_HomeController_extractPartXML7_route(params@_) =>
      call { 
        controllers_HomeController_extractPartXML7_invoker.call(
          req => HomeController_1.extractPartXML(req))
      }
  
    // @LINE:23
    case controllers_HomeController_xmldifffinder8_route(params@_) =>
      call { 
        controllers_HomeController_xmldifffinder8_invoker.call(
          req => HomeController_1.xmldifffinder(req))
      }
  }
}
