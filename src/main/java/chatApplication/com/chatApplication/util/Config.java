package chatApplication.com.chatApplication.util;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class Config implements WebMvcConfigurer 
{

	@Bean
	public OpenAPI swaggerDocOpenApi()
	{
		Server devserver=new Server();
		devserver.setUrl("localhost:8080");
		devserver.setDescription("Development Server");
		
		Server testServer=new Server();
		testServer.setUrl("localhost:8081");
		testServer.setDescription("Test Server");
		
		Contact co=new Contact();
		co.setEmail("benedit123india@gmail.com");
		co.setName("Benedit");
		co.setUrl("../https://github.com");
		
		License ls=new License();
		ls.setName("License");
		ls.setUrl("License Provider");
		
		Info in=new Info();
		in.setContact(co);
		in.setLicense(ls);
		in.setDescription("InstaSphere:To connect With Each Other");
		in.setTermsOfService("../Terms.html");
		in.setTitle("Insta Sphere");
		in.setVersion("2.0");
		
		OpenAPI op=new OpenAPI();
		op.info(in);op.setServers(Arrays.asList(devserver,testServer));
		return op;
	}
}
