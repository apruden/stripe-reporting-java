
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/alex/workspace/stripe-reporting-java/conf/routes
// @DATE:Thu May 04 19:53:09 EDT 2017


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
