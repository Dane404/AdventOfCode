package day2

import java.util.*
import kotlin.collections.HashMap

class Day2 {
    companion object{
        private const val WINNING_POINTS=6
        private const val DRAW_POINTS=3
        private const val LOSING_POINTS=0

        fun calculateScorePart1(lines: LinkedList<String>):Int{
            var winningHands= HashMap<String,String>()
            winningHands.put("A","Y")
            winningHands.put("B","Z")
            winningHands.put("C","X")
            var score = 0
            for(line:String in lines)
            {
                val column = line.split(" ")
                var shapePoints=(column[1].toCharArray()[0]-'X')+1
                score += if(winningHands[column[0]].equals(column[1]))
                {
                    WINNING_POINTS
                }
                else if((column[0].toCharArray()[0]-'A'+1)==shapePoints)
                {
                    DRAW_POINTS
                }
                else
                {
                    LOSING_POINTS
                }
                score+=shapePoints
            }
            return score
        }
        fun calculateScorePart2(lines: LinkedList<String>):Int{
            var winningHands= HashMap<String,String>()
            winningHands.put("A","Y")
            winningHands.put("B","Z")
            winningHands.put("C","X")
            var score = 0
            for(line:String in lines)
            {
                val column = line.split(" ")
                var shapePoints=(column[0].toCharArray()[0]-'A'+1)
                if(column[1]=="X")
                {
                    score+=LOSING_POINTS
                    shapePoints--
                    if(shapePoints==0)
                    {
                        shapePoints=3
                    }
                }
                else if(column[1]=="Y")
                {
                    score+=DRAW_POINTS
                }
                else if(column[1]=="Z")
                {
                    score+=WINNING_POINTS
                    shapePoints++
                    if(shapePoints>3)
                    {
                        shapePoints=1
                    }
                }
                score+=shapePoints
            }
            return score
        }
    }
}