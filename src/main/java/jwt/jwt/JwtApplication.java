package jwt.jwt;

import jwt.jwt.Context.SpringApplicationContext;
import jwt.jwt.Security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class JwtApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return super.configure(builder);
		return builder.sources(JwtApplication.class);
	}

	public static void main(String[] args) {
        ApplicationContext ctx=SpringApplication.run(JwtApplication.class, args);

        String []beanNames = ctx.getBeanDefinitionNames();

        Arrays.sort(beanNames);

        for (String name: beanNames){
            System.out.println(name);
        }
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SpringApplicationContext springApplicationContext(){
		return new SpringApplicationContext();
	}
	@Bean(name = "AppProperties")
	public AppProperties getAppProperties(){
		return new AppProperties();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		UrlBasedCorsConfigurationSource source = new
				UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration.applyPermitDefaultValues());
		configuration.setExposedHeaders(Arrays.asList("Authorization", "UserID"));
//		configuration.setExposedHeaders(Arrays.asList("UserID"));
		return source;
	}

}
