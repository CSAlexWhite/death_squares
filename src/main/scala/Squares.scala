package com.silly.games

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object Squares extends App {

  /* INITIALIZATION */
  val names = Array("AW", "SD", "BW", "MW", "NW", "KB", "DW", "MR")
  val killers = Array("Jon",	"Sansa",	"Bran",	"Sansa",	"Cersei",	"Jaime",	"Tyrion",	"Arya",	"Danaerys",	"Yara",	"Euron",	"Theon",	"Melisandre",	"Jorah",	"The Hound",	"The Mountain",	"Sam",	"Gilly",	"Sam (Child)",	"Jamie",	"Varys", "Brienne",	"Davos",	"Tyrion",	"Bronne",	"Podrick",	"Tormund",	"Grey Worm",	"Gendry",	"Beric",	"Drogon",	"Rhaegal",	"Viserion",	"Night King",	"Any Direwolf",	"Any Walker", "Rando Person")
  val victims = Array("Jon",	"Sansa",	"Bran",	"Sansa",	"Cersei",	"Jaime",	"Tyrion",	"Arya",	"Danaerys",	"Yara",	"Euron",	"Theon",	"Melisandre",	"Jorah",	"The Hound",	"The Mountain",	"Sam",	"Gilly",	"Sam (Child)",	"Jamie",	"Varys", "Brienne",	"Davos",	"Tyrion",	"Bronne",	"Podrick",	"Tormund",	"Grey Worm",	"Gendry",	"Beric",	"Drogon",	"Rhaegal",	"Viserion",	"Night King",	"Nymeria", "Ghost")

  val (noKillers, noKilled, noParticipants) = (killers.length, victims.length, names.length)

  val squaresPerPerson = (noKilled*noKillers)/noParticipants

  var remainingTiles:ArrayBuffer[Int] = ArrayBuffer()
  var board:ArrayBuffer[ArrayBuffer[String]] = ArrayBuffer[ArrayBuffer[String]]()

  val generator = Random

  for(player <- names) remainingTiles += squaresPerPerson

  /* BUSINESS LOGIC */
  for(victim <- victims) {
    val currentRow = ArrayBuffer[String]()
    for (killer <- killers) {
      var playerIndex = generator.nextInt(noParticipants)
      while (remainingTiles(playerIndex) < 0) playerIndex = generator.nextInt(noParticipants)
      val player = names(playerIndex)
      currentRow += player
      println(player + " chose " + killer + " to kill " + victim)
      remainingTiles(playerIndex) -= 1
    }
    board += currentRow
  }
  for(row <- board){
    for(cell <- row) print(cell + ",")
    println()
  }
}