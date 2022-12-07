package day5

import java.util.*
import kotlin.collections.ArrayDeque

class Day5 {
    companion object{
        fun getTopOfCratesAfterInstructionPart1(lines: LinkedList<String>) {
            var stacks= fillStackList(lines)
            var arguments = lines.subList(lines.indexOf("")+1,lines.size)
            for(argument in arguments)
            {
                var splitArgument = argument.split(" ")
                var quantity= splitArgument[1].toInt()
                var from = splitArgument[3].toInt()-1
                val to = splitArgument[5].toInt()-1
                for(num in 0 until quantity)
                {
                    var removedChars = stacks[from].removeFirst()
                    stacks[to].addFirst(removedChars)
                }
            }
            printResult(stacks)
        }

        fun getTopOfCratesAfterInstructionsPart2(lines: LinkedList<String>)
        {
            var stacks = fillStackList(lines)
            var arguments = lines.subList(lines.indexOf("")+1,lines.size)
            for(argument in arguments)
            {
                var splitArgument = argument.split(" ")
                var quantity= splitArgument[1].toInt()
                var from = splitArgument[3].toInt()-1
                val to = splitArgument[5].toInt()-1
                for(num in quantity-1 downTo 0)
                {
                    var removedChars = stacks[from].removeAt(num)
                    stacks[to].addFirst(removedChars)
                }
            }
            printResult(stacks)
        }

        private fun printResult(stacks: LinkedList<ArrayDeque<Char>>)
        {
            for(stack in stacks)
            {
                print(stack.first())
            }
            println()
        }
        private fun fillStackList(lines: LinkedList<String>): LinkedList<ArrayDeque<Char>> {
            val endIndex = lines.indexOf("")-1
            var stacks= LinkedList<ArrayDeque<Char>>()
            val rows = lines[endIndex].split("   ")
            for(num in (rows.indices))
            {
                stacks.add(ArrayDeque<Char>())
            }
            for(line:String in lines)
            {
                for(num in rows.indices)
                {
                    if(line[lines[endIndex].indexOf(String.format("%d",num+1))]!=' ')
                    {
                        stacks[num].add(line[lines[endIndex].indexOf(String.format("%d",num+1))])
                    }
                }
                if(lines.indexOf(line)==endIndex-1)
                {
                    break
                }
            }
            return stacks
        }
    }
}