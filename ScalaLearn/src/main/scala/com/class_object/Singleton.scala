package com.class_object

/**
 * ClassName: Singleton
 * Package: com.class_object
 * Description: 
 *
 * @Author Joe
 * @Create 2024-04-22 13:54 
 * @Version
 */

object mm {
  def main(args: Array[String]): Unit = {
    Student01.getInstance().printInfo()
    println("===========================")
    val student01 = Student01.getInstance()
    student01.printInfo()

  }
}

class Student01 private(val name:String, val age:Int) {
  def printInfo(): Unit ={
    println(f"hello,${name},${age}")
  }
}

////饿汉式
//object Student01 {
//  private val student01 = new Student01("zhangsan", 18)
//  def getInstance(): Student01 = student01
//}

//懒汉式
object Student01 {
  private var student01:Student01 = _
  def getInstance(): Student01 = {
    if(student01 == null)  student01 = new Student01("zhangsan", 18)
    student01
  }
}