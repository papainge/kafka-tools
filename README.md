# kafka-tools
## Requirements
You need to install:
* Java (>= 1.8)
* Maven, compatible with Java 1.8 (for example Maven 3.5.3)
* Kafka client (>= 1.1.1)

## Build
```
mvn clean package
```

## TopicsInfo

This tool lists all topics with their [PartitionInfo](https://kafka.apache.org/11/javadoc/org/apache/kafka/common/PartitionInfo.html) for a given list of kafka brokers.
For the moment, it is exposed in json format on the standard output (std::out).

**Warning**: the following lines are also exposed to the standard output before the targeted result
```
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
```

### How to run
1. Build the project
2. Move the built jar file where you need it `mv target/kafka-tools-*-jar-with-dependencies.jar $TARGET_DIR/kafka-tools.jar`
3. Run `/path/to/java/bin/java -cp fr.papainge.kafka.tools.TopicsInfo --brokers broker1,borker2`


### Help command
```
/opt/java/bin/java -cp kafka-tools.jar fr.papainge.kafka.tools.TopicsInfo --help
usage: [-h] --brokers BROKERS

optional arguments:
  -h, --help             show this help message and exit
  --brokers BROKERS      List of kafka brokers, each one must be separated by ',' (Default: localhost)
```

### Next
* Expose info to another output (file, queue, db, ...)
* Use another output format (yaml, serialized, ...)