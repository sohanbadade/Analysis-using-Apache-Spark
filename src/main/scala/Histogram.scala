import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object Histogram {

      def main ( args: Array[ String ] ) {
              val conf = new SparkConf().setAppName("Histogram_Scala_Spark")
              val sc = new SparkContext(conf)
              val data = sc.textFile(args(0)) //getting data from text file

              val col_obj = data.map( row => ((1,row.split(",")(0)), (2,row.split(",")(1)), (3,row.split(",")(2))) ) //attaching the color tag to intensity values

              val key_pairs1 = col_obj.map(_._1).union(col_obj.map(_._2)).union(col_obj.map(_._3)) //aggregating the values
              val key_pairs2 =  key_pairs1.map(rows => rows.productIterator.mkString("\t")) //seperating values by a tab-space
              val key_value_pairs = key_pairs2.map(color_object => (color_object,1)) //attaching the count values to color values


              val result1 = key_value_pairs.reduceByKey(_+_) //reducer
              val result2= result1.map(rows => rows.productIterator.mkString("\t")) //seperating values by a tab-space

              result2.collect().foreach(println) //print result
              sc.stop(); //stop spark context
      }
}
