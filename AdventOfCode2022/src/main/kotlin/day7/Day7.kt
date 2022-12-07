package day7

import java.util.*
import kotlin.collections.HashMap

class Day7 {
    companion object{
        fun calculateSumOfUnder100kDirectories(lines: LinkedList<String>): Int {
            val directories =compileTasks(lines)
            var sumOfUnder100k=0
            for(dir in directories)
            {
                val sum=calcSum(dir)
                if(sum<=100000)
                {
                    sumOfUnder100k+=sum
                }
            }
            return sumOfUnder100k
        }

        fun calculateRequiredSpaceToDelete(lines: LinkedList<String>):Int
        {
            val directories=compileTasks(lines)
            val sum = calcSum(directories[0])
            val sumMap = HashMap<Directory,Int>()
            val requiredSpace=30000000
            val maxSpace =70000000
            for(dir in directories)
            {
                val calculatedSum=calcSum(dir)
                sumMap[dir] = calculatedSum
            }
            val neededSpace = requiredSpace-(maxSpace-sum)
            val filteredList = sumMap.filter { it.value>=neededSpace }
            return filteredList.values.sorted()[0]
        }

        private fun compileTasks(lines: LinkedList<String>): LinkedList<Directory>
        {
            val directories = LinkedList<Directory>()
            val rootDir = Directory("/")
            var currDirectory=rootDir
            directories.add(rootDir)
            for(line in lines)
            {
                var args = line.split(" ")
                if(args.size==3)
                {
                    if(args[2]=="/")
                    {
                        currDirectory=rootDir
                    }
                    else if(args[2]=="..")
                    {
                        if(currDirectory.parentDir!=null)
                        {
                            currDirectory= currDirectory.parentDir!!
                        }
                    }
                    else{
                        currDirectory = if(currDirectory.childDirectories.find{ it ->it.dirName==args[2]}!=null) {
                            val newDir = Directory(args[2],currDirectory)
                            directories.add(newDir)
                            currDirectory.addChildDirectory(newDir)
                            newDir
                        } else{
                            currDirectory.childDirectories.find { it.dirName==args[2] }!!
                        }
                    }
                }
                else{
                    if(args[1]!="ls")
                    {
                        if(args[0]=="dir")
                        {
                            if(!currDirectory.childDirectories.stream().anyMatch{it.dirName==args[1]})
                            {
                                val newDir = Directory(args[1],currDirectory)
                                currDirectory.childDirectories.add(newDir)
                            }
                        }
                        else{
                            currDirectory.addFile(args[0].toInt())
                        }
                    }
                }
            }
            return directories
        }
        private fun calcSum(dir:Directory):Int{
            var sum=0
            for(fileSize in dir.files)
            {
                sum+=fileSize
            }
            for(child in dir.childDirectories)
            {
                sum+=calcSum(child)
            }
            return sum
        }
    }
}