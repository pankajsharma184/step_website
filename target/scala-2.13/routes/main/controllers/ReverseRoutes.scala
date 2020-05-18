// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Aks/workspace/Tools Website/conf/routes
// @DATE:Wed May 13 15:03:20 IST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers {

  // @LINE:8
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def openXMLDiffFinderForm(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "xmldifffinderForm")
    }
  
    // @LINE:19
    def generateXMLFile(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "generateXMLFile")
    }
  
    // @LINE:23
    def xmldifffinder(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "xmldifffinder")
    }
  
    // @LINE:15
    def openExcelToXMLForm(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "exceltoxml")
    }
  
    // @LINE:21
    def extractPartXML(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "xmlextractor")
    }
  
    // @LINE:9
    def add(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "add")
    }
  
    // @LINE:8
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:16
    def openXMLExtractForm(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "openExtractXMLForm")
    }
  
  }

  // @LINE:12
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
