package day6

import java.util.*
import kotlin.streams.toList

class Day6 {
    companion object{
        fun markerAfterFirstCharacters(lines: LinkedList<String>): Int {

            for(num in 0..lines[0].length)
            {
                if(num+3<lines[0].length)
                {
                    var subList = lines[0].subSequence(num,num+4)
                    if( subList.chars().distinct().toList().size==4)
                    {
                        return num+4;
                    }
                }
            }
            return -1;
        }
        fun messageAfterFirstCharacters(lines: LinkedList<String>): Int {

            for(num in 0..lines[0].length)
            {
                if(num+13<lines[0].length)
                {
                    var subList = lines[0].subSequence(num,num+14)
                    if( subList.chars().distinct().toList().size==14)
                    {
                        return num+14;
                    }
                }
            }
            return -1;
        }
    }
}