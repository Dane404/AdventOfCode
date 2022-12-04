package day3

import java.util.*

class Day3 {
    companion object{
        fun calculateSumOfPriority(lines: LinkedList<String>): Int {
            var listOfDuplicates= LinkedList<Char>()
            for(line:String in lines)
            {
                val compartment1 = line.substring(0,line.length/2)
                var compartment2=line.substring(line.length/2,line.length)
                for(character:Char in compartment1)
                {
                    if(compartment2.contains(character))
                    {
                        listOfDuplicates.add(character)
                        break
                    }
                }
            }
            return calculatePriority(listOfDuplicates)
        }
        fun calculateSumOfBadgePriority(lines: LinkedList<String>): Int {
            var listOfDuplicates= LinkedList<Char>()
            var i = 0
            while(i<lines.size)
            {
                var compartment1=lines.get(i)
                var compartment2=lines.get(i+1)
                var compartment3=lines.get(i+2)
                for(character:Char in compartment1)
                {
                    if(compartment2.contains(character)&&compartment3.contains(character))
                    {
                        listOfDuplicates.add(character)
                        break
                    }
                }
                i+=3
            }
            return calculatePriority(listOfDuplicates)
        }

        private fun calculatePriority(listOfDuplicates:LinkedList<Char>): Int {
            var sum=0
            for(character:Char in listOfDuplicates)
            {
                if(character in 'A'..'Z')
                {
                    sum+=(character-'A'+27)
                }
                else if(character in 'a'..'z')
                {
                    sum+=(character-'a'+1)
                }
            }
            return sum
        }
    }

}