package com.class_object

import scala.beans.BeanProperty

/**
 * ClassName: Test01
 * Package: com.class_object
 * Description: 
 *
 * @Author Joe
 * @Create 2024-04-22 9:22 
 * @Version
 */
object Test01 {
  def main(args: Array[String]): Unit = {
    val ming = new XiaoMing
//    val student = new Student("对对对")
    println("——————————————————————————————")
//    val student2 = new Student()
//    println(student.sex) // 打印性别
//    student.setSccondName("??")
//    student.sccondName = "!!"
//    student.setName("ZLW") // 设置姓名
//    val name = student.getName // 获取姓名
//    println("Name: " + name) // 打印姓名
  }
}

abstract class Student {
  println("主构造器")

  import scala.beans.BeanProperty

//  @BeanProperty
  var sccondName:String = _
//  @BeanProperty
  private var name: String = _
  private var age = 18
  val sex: String = "man"
  var id:Int

  //构造器
  def this(name1:String){
//    name = "666"
    this()
    println("辅构造器")
    this.name = name1
    println(f"name:${name}")
  }
}

class XiaoMing extends Student{
  private var name: String = _
  private var age = 18
  override val sex: String = "?"
  override var id: Int = _
//  id = 2
//  override val id: Int = 2
  println(id)

}

