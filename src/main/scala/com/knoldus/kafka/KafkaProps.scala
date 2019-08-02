
package com.knoldus.kafka

import java.util.Properties
import com.typesafe.config.ConfigFactory

object KafkaProps {

  val config = ConfigFactory.load().getConfig("kafkaConf")
  val bootstrapConf = config.getString("bootstrap")
  val portConf = config.getString("port")
  val keySerConf = config.getString("keySerializer")
  val valSerConf = config.getString("valueSerializer")
  val serializerConf = config.getString("stringSerializer")

  def getProducerProps() = {
    val props = new Properties()
    props.put(bootstrapConf, portConf)
    props.put(keySerConf, serializerConf)
    props.put(valSerConf, serializerConf)
    props
  }
  def getConsumerProps() = {
    val keyDeserConf = config.getString("keyDeserializer")
    val valDeserConf = config.getString("valueDeserializer")
    val deserializerConf = config.getString("stringDeserializer")
    val groupIdConf = config.getString("groupId")
    val consumerGroupConf = config.getString("consumerGroup")
    val resetProps = config.getString("resetProps")
    val latestProps = config.getString("latestProps")

    val props = new Properties()
    props.put(bootstrapConf, portConf)
    props.put(keyDeserConf, deserializerConf)
    props.put(valDeserConf, deserializerConf)
    props.put(resetProps, latestProps)
    props.put(groupIdConf, consumerGroupConf)
    props
  }

}
