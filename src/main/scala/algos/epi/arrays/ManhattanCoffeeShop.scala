package algos.epi.arrays

import scala.collection.mutable

/**
  * Created by geek4you on 4/25/17.
  */
/**
  * Twitter Interview
  * You need to setup a coffee shop in manhattan.
  * You are given a grid where (i,j) cell is the roads i,j intersection.
  * You are also given location persons in the manhattan in a separate array.
  * You need to find the location of the cell in the grid which is suitable to set up coffee shop.
  * In other words location of the cell whose distance is minimum from all the persons.
  */
object ManhattanCoffeeShop {

  /**
    * Converts the persons list to map.
    * We need this conversion because one cell might contain 2 or more persons and we potentially
    * adds up to the distance.
    */
  def listToMapPersons(persons: List[Cell]): Map[Cell, Int] = {
    val map = mutable.Map[Cell, Int]()
    persons.foreach(person => {
      if (map.contains(person))
        map(person) += 1
      else
        map(person) = 1
    })
    map.toMap
  }

  /**
    * Distance from the cell to all the persons.
    * Takes O(k) time where k is the number of persons
    */
  def distanceFromAllPersonsToCell(cell: Cell,
                                   personsMap: Map[Cell, Int]): Int = {
    var distance = 0
    personsMap.foreach(person => {
      distance += person._2 * (Math.abs(cell.row - person._1.row) + Math.abs(
        cell.col - person._1.col))
    })
    distance
  }

  /**
    * n - grid size is n x n
    *
    */
  def minDistCell(n: Int, persons: List[Cell]): Cell = {
    val distances = mutable.Map[Cell, Int]()
    val personsMap = listToMapPersons(persons)
    minDistCellHelper(n, Cell(0, 0), distances, personsMap)
  }

  val shift = Array(Array(0, 1), Array(1, 0), Array(0, -1), Array(-1, 0))

  /**
    * Main logic
    */
  def minDistCellHelper(n: Int,
                        cell: Cell,
                        distances: mutable.Map[Cell, Int],
                        personsMap: Map[Cell, Int]): Cell = {

    val distance = if (!distances.contains(cell)) {
      distances += (cell -> distanceFromAllPersonsToCell(cell, personsMap))
      distances(cell)
    } else distances(cell)


    // compare the distances with the adjacent 4 cells. If the cell has distance in the
    // map then we already visited that cell.
    var minDistance = Int.MaxValue
    var minDistanceAdjacentCell = Cell(-1,-1)
    // get the distance from all the adjacent cells and keep track of only lowest one
    shift.foreach(shft => {
      val curCell = Cell(cell.row + shft(0), cell.col + shft(1))
      if(isValid(curCell, n)){
        if(!distances.contains(curCell)){
          distances(curCell) = distanceFromAllPersonsToCell(curCell, personsMap)
          if(minDistance > distances(curCell)){
            minDistance = distances(curCell)
            minDistanceAdjacentCell = curCell
          }
        }
      }
    })

    if(minDistance == Int.MaxValue || minDistance > distances(cell)){
      cell
    }else{
      minDistCellHelper(n,cell,distances,personsMap)
    }
  }

  def isValid(cell: Cell, n: Int): Boolean = {
    Range(0, n - 1).contains(cell.row) && Range(0, n - 1).contains(cell.col)
  }

  case class Cell(row: Int, col: Int)
}
