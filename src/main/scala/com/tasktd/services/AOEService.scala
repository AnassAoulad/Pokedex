package com.tasktd.services

import com.tasktd.models.{PokemonCase}
import monix.eval.Task
import com.tasktd.Http
import spray.json._
import DefaultJsonProtocol._
import com.tasktd.json.JsonFormatters._
import com.tasktd.AsyncHttp

trait AOEService {

  // def getCivilizations(): Seq[Civilization]

  // def getUnits(): Seq[AOEUnit]

  def getPokemons(): Seq[PokemonCase]

}

trait AOEAsyncService {

  // def getCivilizations(): Task[Seq[Civilization]]

  // def getUnits(): Task[Seq[AOEUnit]]

  def getPokemons(): Task[Seq[PokemonCase]]

}

class AOEServiceOnHttp(http: Http) extends AOEService {

  // def getCivilizations(): Seq[Civilization] = {
  //   http.get("https://age-of-empires-2-api.herokuapp.com/api/v1/civilizations")
  //     .parseJson
  //     .asJsObject
  //     .fields("civilizations")
  //     .convertTo[Seq[Civilization]]
  // }

  def getPokemons(): Seq[PokemonCase] = {
    http.get("https://pokeapi.co/api/v2/pokemon/1")
      .parseJson
      .asJsObject
      .convertTo[Seq[PokemonCase]]

  }

  // def getUnits(): Seq[AOEUnit] =
  //   http.get("https://age-of-empires-2-api.herokuapp.com/api/v1/units")
  //     .parseJson
  //     .asJsObject
  //     .fields("units")
  //     .convertTo[Seq[AOEUnit]]

}

class AOEAsyncServiceOnHttp(http: AsyncHttp) extends AOEAsyncService {

  // def getCivilizations(): Task[Seq[Civilization]] =
  //   http.get("https://age-of-empires-2-api.herokuapp.com/api/v1/civilizations")
  //     .map(content => content
  //       .parseJson.asJsObject
  //       .fields("civilizations")
  //       .convertTo[Seq[Civilization]]
  //     )

  def getPokemons(): Task[Seq[PokemonCase]] =
    http.get("https://pokeapi.co/api/v2/pokemon/1")
      .map(content => content
        .parseJson.asJsObject
        .convertTo[Seq[PokemonCase]]
      )

  // def getUnits(): Task[Seq[AOEUnit]] =
  //   http.get("https://age-of-empires-2-api.herokuapp.com/api/v1/units")
  //     .map(content => content
  //       .parseJson
  //       .asJsObject
  //       .fields("units")
  //       .convertTo[Seq[AOEUnit]]
  //     )

}
