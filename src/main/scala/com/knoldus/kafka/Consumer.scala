package com.knoldus.kafka

import java.time.Duration
import java.util
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.slf4j.LoggerFactory
import scala.collection.JavaConverters._

object Consumer {

  val logger = LoggerFactory.getLogger("ConsumerMain")

  def consumeFromKafka(topic: String) = {

    logger.info("Creating consumer properties")

    val props = KafkaProps.getConsumerProps()
    logger.info(props.toString)

    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
    consumer.subscribe(util.Arrays.asList(topic))

    while (true) {
      val record = consumer.poll(Duration.ofSeconds(2)).asScala

      for (data <- record.iterator) {
        logger.info("Consuming....")
      }
    }
  }
}
