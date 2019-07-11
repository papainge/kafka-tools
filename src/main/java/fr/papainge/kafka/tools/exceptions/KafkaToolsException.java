package fr.papainge.kafka.tools.exceptions;

/**
 * All exceptions thrown by this project must be encapsulated by this exception class
 */
public class KafkaToolsException extends Exception {
  public KafkaToolsException() {
  }

  public KafkaToolsException(String message) {
    super(message);
  }

  public KafkaToolsException(String message, Throwable cause) {
    super(message, cause);
  }

  public KafkaToolsException(Throwable cause) {
    super(cause);
  }

  public KafkaToolsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
