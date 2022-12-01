import java.io.File
import java.util.LinkedList

fun main(args: Array<String>) {
    var lines = getLines("src/main/kotlin/input.txt");
    println("-------------------Level 1--------------------")
    println("Sum of top 3 elfs calories: "+getTopThreeElfWithMostCalories(lines));
    println("----------------------------------------------")


}

fun getTopThreeElfWithMostCalories(lines:LinkedList<String>):Int
{
    var listOfCalories = LinkedList<Int>();
    var currCount=0;
    for(line: String in lines)
    {
        if(line.equals(""))
        {
            listOfCalories.add(currCount);
            currCount=0;
        }
        else{
            currCount+=line.toInt();
        }
    }
    listOfCalories.sort();
    return listOfCalories.get(listOfCalories.size-1)+listOfCalories.get(listOfCalories.size-2)+listOfCalories.get(listOfCalories.size-3);
}

fun getLines(path: String):LinkedList<String>
{
    val lineList = LinkedList<String>()
    File(path).useLines { lines -> lines.forEach { lineList.add(it) }}
    return lineList;
}