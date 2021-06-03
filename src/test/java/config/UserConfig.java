package config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@PropertySource("jdbc.properties")
public class UserConfig {
  @Value("${jdbc.driver}")
  private String driver;
  @Value("${jdbc.url}")
  private String url;
  @Value("${jdbc.username}")
  private String username;
  @Value("${jdbc.password}")
  private String password;
  @Bean("dateSource")
  public DruidDataSource getDateSource(){
    DruidDataSource dds = new DruidDataSource();
    dds.setDriverClassName(driver);
    dds.setUrl(url);
    dds.setUsername(username);
    dds.setPassword(password);
    return dds;
  }



}
