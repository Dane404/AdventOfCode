package day4

import java.util.*

class Day4 {
    companion object{
        private fun taskToList(task:String):List<Int>{
            var taskSplit=task.split("-")
            return (taskSplit[0].toInt()..taskSplit[1].toInt()).toList()
        }
        fun sumOfOverlaps(lines: LinkedList<String>): Int {
            var sum=0
            for(line:String in lines)
            {
                val tasks=line.split(",")
                val task1= taskToList(tasks[0])
                val task2=taskToList(tasks[1])
                for( num in task2)
                {
                    if(task1.contains(num))
                    {
                        sum++
                        break
                    }
                }
            }
            return sum
        }
        fun sumOfFullyDuplicateTasks(lines: LinkedList<String>): Int {
            var sum=0
            for(line:String in lines)
            {
                val tasks=line.split(",")
                val task1= taskToList(tasks[0])
                val task2=taskToList(tasks[1])
                if(task1.containsAll(task2)||task2.containsAll(task1))
                {
                    sum++
                }
            }
            return sum
        }
    }
}