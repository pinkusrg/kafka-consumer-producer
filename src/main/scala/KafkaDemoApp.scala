object KafkaDemoApp extends App{


  val producer = new Producer
  producer.writeToKafka("coffee")
 
  val consumer = new Consumer
  consumer.consumeFromKafka("coffee")

}
