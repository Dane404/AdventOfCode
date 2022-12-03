package day1

import java.util.*

class Day1 {
    companion object{
        fun getElfWithMostCalories(lines: LinkedList<String>):Int
        {
            var mostCalories = 0
            var currCount=0
            for(line: String in lines)
            {
                if(line.equals(""))
                {
                    if(currCount>mostCalories)
                    {
                        mostCalories=currCount;
                    }
                    currCount=0
                }
                else{
                    currCount+=line.toInt()
                }
            }
            return mostCalories
        }
        fun getTopThreeElfWithMostCalories(lines: LinkedList<String>):Int
        {
            var listOfCalories = LinkedList<Int>()
            var currCount=0
            for(line: String in lines)
            {
                if(line.equals(""))
                {
                    listOfCalories.add(currCount)
                    currCount=0
                }
                else{
                    currCount+=line.toInt()
                }
            }
            listOfCalories.sort();//sorts the array in asc order
            return listOfCalories.get(listOfCalories.size-1)+listOfCalories.get(listOfCalories.size-2)+listOfCalories.get(listOfCalories.size-3)//the last three items of the list are the biggest
        }
    }

}