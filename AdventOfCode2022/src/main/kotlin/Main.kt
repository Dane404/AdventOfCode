import day1.Day1
import day2.Day2
import day3.Day3
import java.io.File
import java.util.LinkedList

fun main(args: Array<String>) {
    var linesDay1 = getLines("src/main/kotlin/day1/input_1.txt")
    println("-------------------Level 1.1------------------")
    println("Most Calories: "+Day1.getElfWithMostCalories(linesDay1))
    println("-------------------Level 1.2------------------")
    println("Sum of top 3 elfs calories: "+Day1.getTopThreeElfWithMostCalories(linesDay1))
    var linesDay2 = getLines("src/main/kotlin/day2/input_2.txt")
    println("-------------------Level 2.1------------------")
    println("Score: "+Day2.calculateScorePart1(linesDay2));
    println("-------------------Level 2.2------------------")
    println("Score: "+Day2.calculateScorePart2(linesDay2));
    var linesDay3= getLines("src/main/kotlin/day3/input_3.txt")
    println("-------------------Level 3.1------------------")
    println("Sum of Priority: "+Day3.calculateSumOfPriority(linesDay3))
    println("-------------------Level 3.2------------------")
    println("Sum of Priority: "+Day3.calculateSumOfBadgePriority(linesDay3))
}




fun getLines(path: String):LinkedList<String>
{
    val lineList = LinkedList<String>()
    File(path).useLines { lines -> lines.forEach { lineList.add(it) }}
    return lineList
}