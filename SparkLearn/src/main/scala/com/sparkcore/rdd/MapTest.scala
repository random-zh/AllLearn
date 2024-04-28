package com.sparkcore.rdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * ClassName: MapTest
 * Package: com.sparkcore.rdd
 * Description: 
 *
 * @Author Joe
 * @Create 2024-04-23 16:25 
 * @Version
 */
object MapTest {
  def main(args: Array[String]): Unit = {
    //TODO sc环境准备
    val sparkConf = new SparkConf().setMaster("local[4]").setAppName("RDDCreaet")
    val sc = new SparkContext(sparkConf)

    //TODO 操作
    //val rdd: RDD[String] = sc.textFile("SparkLearn/datas/*")
    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5))

//    val mpRDD = rdd.mapPartitions(
//      iter => {
//        iter.map(_ * 2)
//      }
//    )

    val mpRDD = rdd.mapPartitions(_.map(_ * 2))


    //将一批一批的数据打印
    mpRDD.collect().foreach(println)

    //TODO 关闭环境
    sc.stop()
  }

}
