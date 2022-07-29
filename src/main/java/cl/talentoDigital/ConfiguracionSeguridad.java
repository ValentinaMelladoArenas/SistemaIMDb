package cl.talentoDigital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	public ConfiguracionSeguridad(AuthenticationSuccessHandler authenticationSuccessHandler) {
		this.authenticationSuccessHandler = authenticationSuccessHandler;
	}

	/* Se inicializa bean de encoder de contraseñas */

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// creamos en memoria un usuario con user:PepeAdmin y contraseña :1234 y le
		// dimos el rol de administrador
		auth.inMemoryAuthentication().withUser("afk").password(passwordEncoder().encode("1234")).roles("USER");// .and().withUser("PabloUser").password(passwordEncoder().encode("1234")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/user/**").hasRole("USER").antMatchers("/login")
				.permitAll()
				.and()
				.authorizeRequests().antMatchers("/register").permitAll()
				// la página de login debe estar libre para poder
				// .antMatchers("/admin/**").hasRole("ADMIN") // autentificarse
				// no podemos dejarla que se acceda solo estando autentificado
				.anyRequest().authenticated()// todas las otras rutas se tiene que acceder estando autentificado

				.and().formLogin().loginPage("/login").successHandler(authenticationSuccessHandler)
				.failureUrl("/login?error=true")// configuramos la página de login
												// y la de error personalizadas
				.usernameParameter("email").passwordParameter("contrasena")

				// Lo desactivé para que pasara a admin / user .defaultSuccessUrl("/user")//
				// sitio de
				// exito al
				// pasar logeado
				.and().exceptionHandling().accessDeniedPage("/error/403");
	}

}
