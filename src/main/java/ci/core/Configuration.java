package ci.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Kyrylo_Delehoidin on 2/4/2016.
 */
public class Configuration {

  public static final String PROPERTIES_FILE = "src/main/resources/properties/config.properties";
  private static Configuration configuration;
  private String searchQuery;
  private String seachUrl;


  public String getSeachUrl() {
    return seachUrl;
  }

  public String getSearchQuery() {
    return searchQuery;
  }


  public static Configuration getInstance() {
    if (null == configuration) {
      configuration = new Configuration();
    }
    return configuration;
  }

  public Configuration() {
    Properties properties = new Properties();
    InputStream is;

    try {
      is = new FileInputStream(PROPERTIES_FILE);
      properties.load(is);

      searchQuery = properties.getProperty("search_query");
      seachUrl = properties.getProperty("search_url");

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
