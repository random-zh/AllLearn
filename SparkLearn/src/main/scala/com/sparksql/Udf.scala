package com.sparksql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

/**
 * ClassName: udf
 * Package: com.sparksql
 * Description: 
 *
 * @Author Joe
 * @Create 2024-04-24 12:38 
 * @Version
 */
object Udf {
  def main(args: Array[String]): Unit = {

    // TODO 创建SparkSQL运行环境
    val sparkConf = new SparkConf().setMaster("local[4]").setAppName("Joe")
    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    //TODO 执行操作




    //DataFrame
    val df: DataFrame = sparkSession.read.json("SparkLearn/datas/user.json")
    df.show()
    df.createOrReplaceTempView("user")
    sparkSession.sql("SELECT concat(1,'_',age) as NB from user").show
//    sparkSession.sql("SELECT age from user").show

    //TODO 关闭环境
    sparkSession.close()
  }

}
