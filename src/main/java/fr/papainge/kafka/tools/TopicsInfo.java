package fr.papainge.kafka.tools;


import com.google.gson.Gson;
import fr.papainge.kafka.tools.exceptions.KafkaToolsException;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.internal.HelpScreenException;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.List;
import java.util.Map;
import java.util.Properties;


/**
 * List all topics for given kafka brokers and expose it in json format through the standard output
 *
 * TODO : Add new outputs and new outputs formats
 */
public class TopicsInfo {
  private static final Gson gson = new Gson();

  public static void main(String[] args) throws KafkaToolsException {
    ArgumentParser parser = ArgumentParsers.newArgumentParser("Topics Info");

    parser.addArgument("--brokers")
      .type(String.class)
      .dest("brokers")
      .help("List of kafka brokers, each one must be separated by ',' (Default: localhost)")
      .required(true)
      .setDefault("localhost");

    try {
      Namespace namespace = parser.parseArgs(args);
      String brokers = namespace.getString("brokers");

      Properties properties = new Properties();
      properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
      properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

      KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

      Map<String, List<PartitionInfo>> topics = consumer.listTopics();
      System.out.println(gson.toJson(topics));

    } catch (HelpScreenException ignored) {
    } catch (Exception e) {
      throw new KafkaToolsException("Unable to run TopicsInfo", e);
    }

    System.exit(0);
  }
}
