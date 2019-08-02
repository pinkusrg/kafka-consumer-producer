object KafkaDemoApp extends App{


  val producer = new Producer
  producer.writeToKafka("coffee")
  print("main ----------------------------------file")
  val consumer = new Consumer
  consumer.consumeFromKafka("coffee")

}
