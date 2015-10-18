package com.orientechnologies.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Enrico Risa on 17/10/14.
 */
@Component
@ConfigurationProperties(prefix = "orientdb")
public class OrientDBServerSettings {

  public String binPort;
  public String httpPort;
  public String node;
  public String hazelcast;
  public String path;
  public String defaultDistributed;


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getNode() {
    return node;
  }

  public void setNode(String node) {
    this.node = node;
  }

  public String getBinPort() {
    return binPort;
  }

  public void setBinPort(String binPort) {
    this.binPort = binPort;
  }

  public String getHttpPort() {
    return httpPort;
  }

  public void setHttpPort(String httpPort) {
    this.httpPort = httpPort;
  }

  public String getHazelcast() {
    return hazelcast;
  }

  public void setHazelcast(String hazelcast) {
    this.hazelcast = hazelcast;
  }

  public String getDefaultDistributed() {
    return defaultDistributed;
  }

  public void setDefaultDistributed(String defaultDistributed) {
    this.defaultDistributed = defaultDistributed;
  }
}
