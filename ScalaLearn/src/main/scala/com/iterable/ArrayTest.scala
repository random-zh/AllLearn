package com.iterable

import scala.collection.mutable.ArrayBuffer

/**
 * ClassName: ArrayTest
 * Package: com.iterable
 * Description: 
 *
 * @Author Joe
 * @Create 2024-04-22 15:51 
 * @Version
 */
object ArrayTest {
  def main(args: Array[String]): Unit = {
    val arr1 = new Array[Int](10)

    val arr2 = Array(1,2,3,4,5)

    arr2(0)  = 2

    val arr3 = arr2 :+ (6, 2, 1)
    arr2.foreach(println)
    println(arr3.mkString("-"))

    val arr5 = ArrayBuffer(3,2,5)
    val arr4 = new ArrayBuffer[Int](22)
    println(arr5.mkString("-"))
//    println(arr4(0))


    val tuple1 = (1,"ww",true)

    val list = List(1,2,3,4,5)
    val list2  = Nil.::(1).::(2)
    println(list2)
    val list3 = 1 :: Nil



  }

}
