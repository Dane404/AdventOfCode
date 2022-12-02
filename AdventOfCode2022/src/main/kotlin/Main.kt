import java.io.File
import java.util.LinkedList

fun main(args: Array<String>) {
    var linesDay1 = getLines("src/main/kotlin/input.txt");
    println("-------------------Level 1--------------------")
    println("Sum of top 3 elfs calories: "+getTopThreeElfWithMostCalories(linesDay1));
    println("----------------------------------------------")
    var linesDay2 = getLines("src/main/kotlin/input_2.txt");
    println("-------------------Level 2.1--------------------")
    println("Score: "+calculateScorePart1(linesDay2));
    println("----------------------------------------------")
    println("-------------------Level 2.2--------------------")
    println("Score: "+calculateScorePart2(linesDay2));
    println("----------------------------------------------")

}


const val WINNING_POINTS=6;
const val DRAW_POINTS=3;
const val LOSING_POINTS=0;
fun calculateScorePart1(lines:LinkedList<String>):Int{
    var winningHands= HashMap<String,String>();
    winningHands.put("A","Y");
    winningHands.put("B","Z");
    winningHands.put("C","X");
    var score = 0;
    for(line:String in lines)
    {
        val column = line.split(" ");
        var shapePoints=(column[1].toCharArray()[0]-'X')+1;
        score += if(winningHands[column[0]].equals(column[1])) {
            WINNING_POINTS;
        } else if((column[0].toCharArray()[0]-'A'+1)==shapePoints) {
            DRAW_POINTS;
        } else{
            LOSING_POINTS;
        }
        score+=shapePoints;
    }
    return score;
}
fun calculateScorePart2(lines:LinkedList<String>):Int{
    var winningHands= HashMap<String,String>();
    winningHands.put("A","Y");
    winningHands.put("B","Z");
    winningHands.put("C","X");
    var score = 0;
    for(line:String in lines)
    {
        val column = line.split(" ");
        var shapePoints=(column[0].toCharArray()[0]-'A'+1);

        println(line)

        if(column[1]=="X") {
            score+=LOSING_POINTS;
            if(shapePoints-1==0)
            {
                shapePoints=3;
            }
            else{
                shapePoints--;
            }
        } else if(column[1]=="Y") {
            score+=DRAW_POINTS;
        } else if(column[1]=="Z"){
            score+=WINNING_POINTS;
            if(shapePoints+1>3)
            {
                shapePoints=1;
            }
            else{
                shapePoints++;
            }
        }
        println(shapePoints)
        println(score)

        score+=shapePoints;
        println(score)
        println();
    }
    return score;
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