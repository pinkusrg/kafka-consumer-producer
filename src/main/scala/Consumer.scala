import java.time.Duration
import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.Properties

import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._

class Consumer {

  def consumeFromKafka(topic: String) = {

    val logger = LoggerFactory.getLogger("ConsumerMain")
    logger.info("Creating producer properties")

    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("auto.offset.reset", "latest")
    props.put("group.id", "consumer-group")

    logger.info(props.toString)

    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
    consumer.subscribe(util.Arrays.asList(topic))

    logger.info("Consuming record..")
     print("sssss0ss\n")
    while (true) {
      val record = consumer.poll(Duration.ofSeconds(2)).asScala
      for (data <- record.iterator) {
        logger.info("Consuming....")
        println(data.value())
      }

    }

  }
}
