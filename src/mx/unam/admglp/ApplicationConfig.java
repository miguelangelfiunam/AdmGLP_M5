package mx.unam.admglp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import mx.unam.admglp.repository.ContraRepository;
import mx.unam.admglp.repository.UsuarioRepository;
import mx.unam.admglp.service.ContraServiceImpl;
import mx.unam.admglp.service.UsuarioServiceImpl;

@Configuration
@ComponentScan(basePackages = {
		"mx.unam.admglp.controller",
		"mx.unam.admglp.service",
		"mx.unam.admglp.repository"
})
@PropertySource("classpath:application.properties")
public class ApplicationConfig { 
		
	@Bean
    public DataSource dataSource(
    		@Value("${db.usr}") String user,
    		@Value("${db.pwd}") String pwd,
    		@Value("${db.url}") String jdbcUrl,
    		@Value("${db.driver}") String jdbcDriver) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(user);
        dataSource.setPassword(pwd);
        return dataSource;
    }
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public UsuarioServiceImpl usuarioServiceImpl(@Qualifier("usuarioRepositoryImpl") UsuarioRepository usuarioRepository, @Qualifier("contraRepositoryImpl") ContraRepository contraRepository) {
		return new UsuarioServiceImpl(usuarioRepository, contraRepository);
	}
	
	@Bean
	public ContraServiceImpl contraServiceImpl(@Qualifier("contraRepositoryImpl") ContraRepository contraRepository) {
		return new ContraServiceImpl(contraRepository);
	}
	
	
}
