package com.rakesh.flume.source;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.Encoders;
import org.apache.spark.internal.Logging;
import org.apache.spark.sql.SparkSession;


/**
 * Created by cloudera on 7/2/17.
 */
public class testSpark {

    public static void main(String args[])
    {

        SparkSession spark = SparkSession
                .builder()
                .appName("Spark SQL examples")
                .config("spark.some.config.option", "some-value")
                .master("local")
                .getOrCreate();

        System.out.println("Test");

        Dataset<Row> data = spark.read().json("hdfs://quickstart.cloudera:8020/tmp/kafka/channel/FlumeTweet.1498965486767.json");

        data.show();

        data.printSchema();

        spark.stop();


    }
}
