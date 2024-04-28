package com.sparkcore.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
 * ClassName: FuncTest
 * Package: com.sparkcore.rdd
 * Description: 
 *
 * @Author Joe
 * @Create 2024-04-23 18:36 
 * @Version
 */
object FuncTest {
  def main(args: Array[String]): Unit = {
    //TODO sc环境准备
    val sparkConf = new SparkConf().setMaster("local[4]").setAppName("RDDCreaet")
    val sc = new SparkContext(sparkConf)

    //TODO 操作
    //val rdd: RDD[String] = sc.textFile("SparkLearn/datas/*")
    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5),2)



    //将一批一批的数据打印
    val result: Int = rdd.aggregate(1)(_ + _, _ + _)
    println(result)

    //TODO 关闭环境
    sc.stop()
  }

}
