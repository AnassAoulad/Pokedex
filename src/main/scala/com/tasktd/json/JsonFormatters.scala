package com.tasktd.json

import spray.json._
import DefaultJsonProtocol._
// import com.tasktd.models.Civilization
// import com.tasktd.models.AOEUnit
// import com.tasktd.models.AOEUnitCost
import com.tasktd.models.PokemonCase

object JsonFormatters extends DefaultJsonProtocol {

  implicit val intOrString: JsonFormat[Int | String] = new JsonFormat[Int | String] {
    override def read(json: JsValue): Int | String =
      json match {
        case JsNumber(nb) => nb.toInt
        case JsString(str) => str
        case _ =>
          throw new RuntimeException(s"Invalid js value for intOrString: ${json.prettyPrint}")
      }

    override def write(obj: Int | String): JsValue = {
      obj match {
        case x: Int => JsNumber(x)
        case str: String => JsString(str)
      }
    }
  }

  // implicit val civilizationJsonFormat: JsonFormat[Civilization] = jsonFormat8(Civilization.apply)
  // implicit val aoeUnitCostJsonFormat: JsonFormat[AOEUnitCost] = jsonFormat3(AOEUnitCost.apply)
  // implicit val aoeUnitJsonFormat: JsonFormat[AOEUnit] = jsonFormat17(AOEUnit.apply)
  implicit val pokemonJsonFormat: JsonFormat[PokemonCase] = jsonFormat2(PokemonCase.apply)

}
