package com.example.cyb.webapi;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ComponentScan
@EnableAutoConfiguration
public class App {
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	private static ConfigurableApplicationContext cac;
	
	@Value("${server.port}")
	private int port;
	@Value("${server.sessionTimeout}")
	private int sessionTimeout;
	
	public static void main(String[] args) {
		App.cac = SpringApplication.run(App.class, args);
		App app = cac.getBean(App.class);
		app.logStatus();
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	    factory.setPort(port);
	    factory.setSessionTimeout(sessionTimeout, TimeUnit.SECONDS);
	    return factory;
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return cac.getBean(clazz);
	}
	
	public static <T> T getBean(String name, Class<T> clazz) {
		return cac.getBean(name, clazz);
	}
	
	void logStatus() {
		logger.info("process id: " + System.getProperty("PID"));
		logger.info("port: " + port);
		logger.info("session timeout: " + sessionTimeout);
	}
	
}

@Configuration
@ImportResource("/spring/applicationContext.xml")
class XmlImportingConfiguration {
}
