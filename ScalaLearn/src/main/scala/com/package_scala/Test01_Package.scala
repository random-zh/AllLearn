package com.package_scala

/**
 * ClassName: Test01_Package
 * Package: com.package_scala
 * Description: 
 *
 * @Author Joe
 * @Create 2024-04-22 9:05 
 * @Version
 */
object Test01_Package {
  def main(args: Array[String]): Unit = {
    val value = Package.getPackage(commonValue)
    commonPrint("98k")
    println("------------------------------")
    println(value)
  }

}
