package mx.unam.admglp;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = { "mx.unam.admglp.repository" })
@PropertySource("classpath:application.properties")
public class TestConfigRepository {
	@Bean
	@Qualifier("jdbcTemplate")
	public JdbcTemplate mockJdbcTemplate() {
		return Mockito.mock(JdbcTemplate.class);
	}
}
