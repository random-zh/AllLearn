package com.mapreduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * ClassName: WordCountMapper
 * Package: com.mapreduce.wordcount
 * Description:
 *
 * @Author Joe
 * @Create 2024-04-19 10:55
 * @Version
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text outK = new Text();
    private IntWritable outV = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        //1 获取一行
        //zlw zlw zlw
        String line = value.toString();

        //2 切割
        //zlw
        //zlw
        //zlw
        String[] words = line.split(" ");

        //3 循环输出
        //(zlw,1)
        //(zlw,1)
        //(zlw,1)
        for (String word : words) {
            outK.set(word);
            context.write(outK, outV);
        }
    }
}
