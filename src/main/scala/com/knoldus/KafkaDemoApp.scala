import com.knoldus.kafka.{Consumer, Producer}
import com.typesafe.config.ConfigFactory

object KafkaDemoApp extends App{


  val config = ConfigFactory.load().getConfig("kafkaConf")

  val topic = config.getString("topic")

  Producer.writeToKafka(topic)
  Consumer.consumeFromKafka(topic)

}
