import java.io.File
import java.util.LinkedList

fun main(args: Array<String>) {
    var lines = getLines("src/main/kotlin/input.txt");
    println("-------------------Level 1.1------------------")
    println("Most Calories: "+getElfWithMostCalories(lines));
    println("----------------------------------------------")
    println("-------------------Level 1.2------------------")
    println("Sum of top 3 elfs calories: "+getTopThreeElfWithMostCalories(lines));
    println("----------------------------------------------")
}
fun getElfWithMostCalories(lines:LinkedList<String>):Int
{
    var mostCalories = 0;
    var currCount=0;
    for(line: String in lines)
    {
        if(line.equals(""))
        {
            if(currCount>mostCalories)
            {
                mostCalories=currCount;
            }
            currCount=0;
        }
        else{
            currCount+=line.toInt();
        }
    }
    return mostCalories;
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
    listOfCalories.sort();//sorts the array in asc order
    return listOfCalories.get(listOfCalories.size-1)+listOfCalories.get(listOfCalories.size-2)+listOfCalories.get(listOfCalories.size-3);//the last three items of the list are the biggest
}

fun getLines(path: String):LinkedList<String>
{
    val lineList = LinkedList<String>()
    File(path).useLines { lines -> lines.forEach { lineList.add(it) }}
    return lineList;
}