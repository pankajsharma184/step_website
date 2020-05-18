// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Aks/workspace/Tools Website/conf/routes
// @DATE:Wed May 13 15:03:20 IST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
