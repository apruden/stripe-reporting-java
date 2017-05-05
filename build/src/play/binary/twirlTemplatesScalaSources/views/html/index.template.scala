
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._;import controllers._;import play.api.templates.PlayMagic._;import java.lang._;import java.util._;import scala.collection.JavaConversions._;import scala.collection.JavaConverters._;import play.api.i18n._;import play.core.j.PlayMagicForJava._;import play.mvc._;import play.data._;import play.api.data.Field;import play.mvc.Http.Context.Implicit._;import views.html._;

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
  """),format.raw/*4.3*/("""<h1>Welcome to Play!</h1>
""")))}),format.raw/*5.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Thu May 04 19:53:11 EDT 2017
                  SOURCE: /home/alex/workspace/stripe-reporting-java/app/views/index.scala.html
                  HASH: 3098d3fb758e9ab1eee7e5524530e92d114a45be
                  MATRIX: 739->1|835->3|863->6|894->29|933->31|962->34|1018->61
                  LINES: 14->1|19->1|21->3|21->3|21->3|22->4|23->5
                  -- GENERATED --
              */
          