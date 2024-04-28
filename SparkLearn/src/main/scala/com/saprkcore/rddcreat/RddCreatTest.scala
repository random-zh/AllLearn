package com.saprkcore.rddcreat

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * ClassName: RddCreatTest
 * Package: com.saprkcore.rddcreat
 * Description: 
 *
 * @Author Joe
 * @Create 2024-04-23 14:04 
 * @Version
 */
object RddCreatTest {
  def main1(args: Array[String]): Unit = {

    //TODO sc环境准备
    val sparkConf = new SparkConf().setMaster("local[4]").setAppName("RDDCreaet")
    val sc = new SparkContext(sparkConf)

    //TODO 内存中创建RDD，集合数据作为处理的数据源
    val seq: Seq[Int] = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    //将集合数据并行化，创建RDD
    //val rdd: RDD[Int] = sc.parallelize(seq)

    //底层也是将集合数据并行化，创建RDD
    val rdd: RDD[Int] = sc.makeRDD(seq)

    //将一批一批的数据打印
    rdd.collect().foreach(println)

    //TODO 关闭环境
    sc.stop()

  }

  def main(args: Array[String]): Unit = {

    //TODO sc环境准备
    val sparkConf = new SparkConf().setMaster("local[4]").setAppName("RDDCreaet")
    val sc = new SparkContext(sparkConf)

    //TODO 文件中创建RDD，数据源路径为环境的根路径
    val rdd: RDD[String] = sc.textFile("SparkLearn/datas/*")


    //将一批一批的数据打印
    rdd.collect().foreach(println)

    //TODO 关闭环境
    sc.stop()
  }

}
