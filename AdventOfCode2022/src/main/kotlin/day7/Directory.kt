package day7

import java.util.LinkedList

class Directory {
    var dirName:String
    var parentDir: Directory?=null
    var files:LinkedList<Int>
    var childDirectories:LinkedList<Directory>
    constructor(dirName:String,parentDir: Directory)
    {
        this.dirName=dirName
        this.parentDir=parentDir
        this.files = LinkedList<Int>()
        this.childDirectories=LinkedList<Directory>()
    }
    constructor(dirName:String)
    {
        this.dirName=dirName
        files = LinkedList<Int>()
        childDirectories=LinkedList<Directory>()
    }
    fun addFile(fileSize:Int)
    {
        files.add(fileSize)
    }
    fun addChildDirectory(dir: Directory)
    {
        childDirectories.add(dir)
    }
}