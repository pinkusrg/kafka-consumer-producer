
package com.knoldus.kafka

import java.util.Properties
import com.typesafe.config.ConfigFactory

object KafkaProps {

  val config = ConfigFactory.load().getConfig("kafkaConf")
  val bootstrapConf = "bootstrap.servers"
  val portConf = config.getString("port")

  def getProducerProps() = {
    val serializerConf = "org.apache.kafka.common.serialization.StringSerializer"
    val keySerConf = "key.serializer"
    val valSerConf = "value.serializer"
    val props = new Properties()
    props.put(bootstrapConf, portConf)
    props.put(keySerConf, serializerConf)
    props.put(valSerConf, serializerConf)
    props
  }
  def getConsumerProps() = {
    val keyDeserConf = "key.deserializer"
    val valDeserConf = "value.deserializer"
    val deserializerConf = "org.apache.kafka.common.serialization.StringDeserializer"
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
