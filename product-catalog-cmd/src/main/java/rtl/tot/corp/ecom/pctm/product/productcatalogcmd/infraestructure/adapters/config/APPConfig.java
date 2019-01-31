package rtl.tot.corp.ecom.pctm.product.productcatalogcmd.infraestructure.adapters.config;

import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import lombok.Getter;
import lombok.Setter;
/**
 * Application configuration
 * 
 * @author: jameswang
 * @version: 1.0, Feb 14, 2018
 */
@Slf4j
public class APPConfig {
	@Getter @Setter
	private Properties configFile;



	public APPConfig() {
		setConfigFile(new java.util.Properties());
		try {
			configFile
					.load(this.getClass().getClassLoader().getResourceAsStream("ApplicationConfiguration.properties"));
		} catch (Exception e) {
			log.error("log configuration failed, due to: ", e);
		}
	}



	public String getProperty(String key) {
		String value = this.configFile.getProperty(key);
		return value;
	}
}
