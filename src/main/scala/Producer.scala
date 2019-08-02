
import java.util.Properties

import org.apache.kafka.clients.producer._
import org.slf4j.LoggerFactory

class Producer {

  def writeToKafka(topic: String): Unit = {

    val logger = LoggerFactory.getLogger("Producer")
    logger.info("Creating producer properties")

    val props = new Properties()

    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    logger.info("Creating producer..")

    //simple producer
    val producer = new KafkaProducer[String, String](props)

    for(i <- 1 to 20){
      logger.info("Producing...")
      val record = new ProducerRecord[String, String](topic, "key", util.Random.nextInt(20).toString)
      producer.send(record)
    }

    /*while(true) {
      logger.info("Enter message to send in topic -"+topic)
      val message = scala.io.StdIn.readLine()

      val record = new ProducerRecord[String, String](topic, "key", message)
      producer.send(record)

    }*/

    //producer sending into partitions
    //val producer = new KafkaProducer[String,String]()


  }
}
