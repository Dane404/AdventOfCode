package day8

import java.util.*

class Day8 {
    companion object{
        fun calculateBestScenicScore(lines: LinkedList<String>) :Int{
            var listOfScores = LinkedList<Int>()
            for (i in 0 until lines.size) {
                var line = lines[i]
                for (j in line.indices) {
                    var scenicScoreLeft=0
                    var left = line.subSequence(0, j).reversed()
                    for(num in left.indices)
                    {
                        scenicScoreLeft++
                        if(j!=num&&left[num].toInt()>=line[j].toInt())
                        {
                            break
                        }
                    }
                    var right = line.subSequence(j + 1, line.length)
                    var scenicScoreRight=0
                    for(element in right)
                    {
                        scenicScoreRight++
                        if(element.toInt()>=line[j].toInt())
                        {
                            break
                        }

                    }
                    var scenicScoreTop=0
                    for (num in i - 1 downTo 0) {
                        scenicScoreTop++
                        if (lines[num][j].toInt() >= line[j].toInt()) {
                            break
                        }
                    }
                    var scenicScoreDown=0
                    for (x in i + 1 until lines.size) {
                        scenicScoreDown++
                        if (lines[x][j].toInt() >= line[j].toInt()) {
                            break
                        }
                    }
                    listOfScores.add(scenicScoreLeft*scenicScoreRight*scenicScoreDown*scenicScoreTop)
                }
            }
            return listOfScores.maxOf { it }
        }
        fun calculateSumOfVisibleTrees(lines: LinkedList<String>): Int {
            var sumOfVisibleTrees=0
            for(i in 0 until lines.size)
            {
                var line = lines[i]
                for(j in line.indices)
                {
                    if(i==0||i==lines.size-1||j==0||j==line.length-1)
                    {
                        sumOfVisibleTrees++
                    }
                    else{
                        var left=line.subSequence(0,j)
                        var right=line.subSequence(j+1,line.length)
                        var topVisible=true
                        var bottomVisible=true
                        for(num in i-1 downTo 0)
                        {
                            if(lines[num][j].toInt()>=line[j].toInt())
                            {
                                topVisible=false
                            }
                        }
                        for(x in i+1 until lines.size)
                        {
                            if(lines[x][j].toInt()>=line[j].toInt())
                            {
                                bottomVisible=false
                            }
                        }
                        if(
                            left.none { it.toInt() >= line[j].toInt() }||
                            right.none { it.toInt() >= line[j].toInt() }||
                            topVisible||
                            bottomVisible
                        )
                        {
                            sumOfVisibleTrees++
                        }

                    }
                }
            }
            return sumOfVisibleTrees
        }
    }
}