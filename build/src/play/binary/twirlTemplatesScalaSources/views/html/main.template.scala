
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._;import controllers._;import play.api.templates.PlayMagic._;import java.lang._;import java.util._;import scala.collection.JavaConversions._;import scala.collection.JavaConverters._;import play.api.i18n._;import play.core.j.PlayMagicForJava._;import play.mvc._;import play.data._;import play.api.data.Field;import play.mvc.Http.Context.Implicit._;import views.html._;

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.32*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/routes/*14.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*14.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/routes/*15.65*/.Assets.versioned("images/favicon.png")),format.raw/*15.104*/("""">
    </head>
    <body>
        """),format.raw/*19.32*/("""
        """),_display_(/*20.10*/content),format.raw/*20.17*/("""

        """),format.raw/*22.9*/("""<script src=""""),_display_(/*22.23*/routes/*22.29*/.Assets.versioned("javascripts/main.js")),format.raw/*22.69*/("""" type="text/javascript"></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


}

/*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Thu May 04 19:53:11 EDT 2017
                  SOURCE: /home/alex/workspace/stripe-reporting-java/app/views/main.scala.html
                  HASH: 4e6dd6c2cc51f21666a7f6b86e84a3e17a417bdc
                  MATRIX: 1003->260|1128->290|1156->292|1236->397|1272->406|1307->414|1333->419|1422->481|1437->487|1500->528|1588->589|1603->595|1664->634|1726->758|1763->768|1791->775|1828->785|1869->799|1884->805|1945->845
                  LINES: 19->7|24->7|26->9|29->12|30->13|30->13|30->13|31->14|31->14|31->14|32->15|32->15|32->15|35->19|36->20|36->20|38->22|38->22|38->22|38->22
                  -- GENERATED --
              */
          