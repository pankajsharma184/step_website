// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Aks/workspace/Tools Website/conf/routes
// @DATE:Wed May 13 15:03:20 IST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers.javascript {

  // @LINE:8
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def openXMLDiffFinderForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.openXMLDiffFinderForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "xmldifffinderForm"})
        }
      """
    )
  
    // @LINE:19
    def generateXMLFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.generateXMLFile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "generateXMLFile"})
        }
      """
    )
  
    // @LINE:23
    def xmldifffinder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.xmldifffinder",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "xmldifffinder"})
        }
      """
    )
  
    // @LINE:15
    def openExcelToXMLForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.openExcelToXMLForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "exceltoxml"})
        }
      """
    )
  
    // @LINE:21
    def extractPartXML: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.extractPartXML",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "xmlextractor"})
        }
      """
    )
  
    // @LINE:9
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.add",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "add"})
        }
      """
    )
  
    // @LINE:8
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:16
    def openXMLExtractForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.openXMLExtractForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "openExtractXMLForm"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
