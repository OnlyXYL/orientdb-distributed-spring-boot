package com.orientechnologies.spring.boot;

import com.orientechnologies.orient.server.OServer;
import com.orientechnologies.orient.server.OServerMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Enrico Risa on 18/10/14.
 */
@Configuration
public class ContextListener {

  private OServer                server;

  @Autowired
  private OrientDBServerSettings settings;

  @PostConstruct
  public void atStartup() {

    try {
      server = OServerMain.create();

      InputStream resourceAsStream = Thread.currentThread().getContextClassLoader()
          .getResourceAsStream("orientdb-server-config.xml");

      String stringFromInputStream = getStringFromInputStream(resourceAsStream);

      stringFromInputStream = stringFromInputStream.replace("${node}", settings.node);
      stringFromInputStream = stringFromInputStream.replace("${httpPort}", settings.httpPort);
      stringFromInputStream = stringFromInputStream.replace("${binPort}", settings.binPort);
      stringFromInputStream = stringFromInputStream.replace("${hazelcast}", settings.hazelcast);
      stringFromInputStream = stringFromInputStream.replace("${defaultDistributed}", settings.defaultDistributed);
      stringFromInputStream = stringFromInputStream.replace("${dbPath}", settings.path);
      server.startup(stringFromInputStream);
      server.activate();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // convert InputStream to String
  private static String getStringFromInputStream(InputStream is) {

    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();

    String line;
    try {

      br = new BufferedReader(new InputStreamReader(is));
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return sb.toString();

  }

  @PreDestroy
  public void atShutdown() {
    server.shutdown();
  }
}
