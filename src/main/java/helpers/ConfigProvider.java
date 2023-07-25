package helpers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();
    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }
    String URL = readConfig().getString("url");
    String ADMIN_LOGIN = readConfig().getString("bookStore.user.login");
    String DEMO_PASSWORD = readConfig().getString("bookStore.user.password");
}
