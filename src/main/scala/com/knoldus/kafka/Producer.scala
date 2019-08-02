package com.knoldus.kafka

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.slf4j.LoggerFactory

object Producer {

  val logger = LoggerFactory.getLogger("Producer")

  def writeToKafka(topic: String): Unit = {

    logger.info("Creating producer properties")

    val RandomNumber = 20
    val props = KafkaProps.getProducerProps()

    val producer = new KafkaProducer[String, String](props)

    for(i <- 1 to 20){
      logger.info("Producing...")
      val record = new ProducerRecord[String, String](topic, "key", util.Random.nextInt(RandomNumber).toString)
      producer.send(record)
    }
  }
}
