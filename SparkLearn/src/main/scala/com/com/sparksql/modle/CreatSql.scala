package com.com.sparksql.modle

import org.apache.spark
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

/**
 * ClassName: CreatSql
 * Package: com.com.sparksql.modle
 * Description: 
 *
 * @Author Joe
 * @Create 2024-04-24 9:35 
 * @Version
 */
object CreatSql {
  def main(args: Array[String]): Unit = {

     // TODO 创建SparkSQL运行环境
    val sparkConf = new SparkConf().setMaster("local[4]").setAppName("Joe")
    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    //TODO 执行操作

    //DataFrame
    val df: DataFrame = sparkSession.read.json("SparkLearn/datas/user.json")
    df.show()
    val backrdd: RDD[Row] = df.rdd

    //DataSet
    val newrdd: RDD[(Int, String, Int)] = sparkSession.sparkContext.makeRDD(List((1, "joe", 2), (2, "ba", 7)))
//    newrdd.toDF("id", "name", "age").show()

    //TODO 关闭环境
    sparkSession.close()
  }

}
