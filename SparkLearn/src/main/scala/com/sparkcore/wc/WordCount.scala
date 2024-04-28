package com.sparkcore.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * ClassName: WordCount
 * Package: com.sparkcore.wc
 * Description: 
 *
 * @Author Joe
 * @Create 2024-04-21 19:47 
 * @Version
 */
object WordCount {

  def not_main(args: Array[String]): Unit = {

    //Application
    //Spark框架

    // TODO 建立连接
    val saprkConf = new SparkConf().setMaster("local").setAppName("WordCount");
    val sc = new SparkContext(saprkConf);

    //TODO 执行业务

    //1、读取文件，以行为单位
    val lines:RDD[String] = sc.textFile("/D:/BIGDATALEARN/AllLearn/SparkLearn/datas/*")
    //Hello World
    //Hello Spark
    //Hello World
    //Hello Spark
    //Hello Scala


    //2、将一行数据拆分，形成一个个单词
    val words:RDD[String] = lines.flatMap(_.split(" "))
    //Hello,World,Hello,Spark,Hello,World,Hello,Spark,Hello,Scala

    //3、将单词分组聚合
    val wordGroup:RDD[(String, Iterable[String])] = words.groupBy(word => word)
    //[Hello,(Hello,Hello,Hello,Hello,Hello)], [World,(World,World)],[Spark,(Spark,Spark)],[ Scala,(Scala)]

    //4、对分组数据转换
    val wordToCount = wordGroup.map {
      case (word, list) => (word, list.size)
      case _ => throw new RuntimeException("Invalid input")
    }
    //5、对结果进行采集和打印
    val array:Array[(String, Int)] = wordToCount.collect()
    array.foreach(println)

    //TODO 关闭连接
    sc.stop();

  }

}

object WordCount2 {

  def main(args: Array[String]): Unit = {

    //Application
    //Spark框架

    // TODO 建立连接
    val saprkConf = new SparkConf().setMaster("local").setAppName("WordCount");
    val sc = new SparkContext(saprkConf);

    //TODO 执行业务

    //1、读取文件，以行为单位
    val lines:RDD[String] = sc.textFile("/D:/BIGDATALEARN/AllLearn/SparkLearn/datas/*")
    //Hello World
    //Hello Spark
    //Hello World
    //Hello Spark
    //Hello Scala


    //2、将一行数据拆分，形成一个个单词
    val words:RDD[String] = lines.flatMap(_.split(" "))
    //Hello,World,Hello,Spark,Hello,World,Hello,Spark,Hello,Scala

    //3、将单词计数为1
    val wordToOne: RDD[(String, Int)] = words.map((_, 1)) //words.map (word => (word,1))
    //(Hello,1),(World,1),(Hello,1),(Spark,1),(Hello,1),(World,1),(Hello,1),(Spark,1),(Hello,1),(Scala,1)

    //4、将单词分组聚合
    val wordGroup: RDD[(String, Iterable[(String, Int)])] = wordToOne.groupBy(_._1)
    //Map("Hello" -> List(("Hello", 1), ("Hello", 1), ("Hello", 1), ("Hello", 1)),
    //    "World" -> List(("World", 1), ("World", 1)),
    //    "Spark" -> List(("Spark", 1), ("Spark", 1)),
    //    "Scala" -> List(("Scala", 1)))

    //5、对分组数据规约计算
    val wordToCount = wordGroup.map{
      case (wcnm,list) =>list.reduce( (t1,t2) =>(t1._1,t1._2+t2._2))
      }


    //    val wordToCount = value.reduce(_._2.foreach(_._2)+_._2.foreach(_._2))
    //5、对结果进行采集和打印
    val array:Array[(String, Int)] = wordToCount.collect()
    array.foreach(println)

    //TODO 关闭连接
    sc.stop();

  }

}
