package com.sparkcore.wc

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * ClassName: WordCountSpark
 * Package: com.sparkcore.wc
 * Description: 
 *
 * @Author Joe
 * @Create 2024-04-22 23:16 
 * @Version
 */
object WordCountSpark {

  def main(args: Array[String]): Unit = {

    //Application
    //Spark框架

    // TODO 建立连接
    val saprkConf = new SparkConf().setMaster("local").setAppName("WordCount");
    val sc = new SparkContext(saprkConf);

    //TODO 执行业务


    val lines:RDD[String] = sc.textFile("/D:/BIGDATALEARN/AllLearn/SparkLearn/datas/*")

    val words:RDD[String] = lines.flatMap(_.split(" "))

    val wordToOne: RDD[(String, Int)] = words.map((_, 1)) //words.map (word => (word,1))
    //(Hello,1),(World,1),(Hello,1),(Spark,1),(Hello,1),(World,1),(Hello,1),(Spark,1),(Hello,1),(Scala,1)

    //Spark使用了一个方法实现
    //相同的key数据，对value进行reduce聚合
    val wordToCount: RDD[(String, Int)] = wordToOne.reduceByKey(_ + _) //_和_表示 key相同的第一个和第二个value
    //(Hello,5),(World,2),(Spark,2),(Scala,1)

//    val wordGroup: RDD[(String, Iterable[(String, Int)])] = wordToOne.groupBy(_._1)
//
//    val wordToCount = wordGroup.map{
//      case (wcnm,list) =>list.reduce( (t1,t2) =>(t1._1,t1._2+t2._2))
//    }
//
    val array:Array[(String, Int)] = wordToCount.collect()
    array.foreach(println)

    //TODO 关闭连接
    sc.stop();

  }


}
