package amadorcf.es.YourBank_API_Gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        http
//                .authorizeExchange()
//                //ALLOWING REGISTER API FOR DIRECT ACCESS
//                .pathMatchers("/api/users/register").permitAll()
//                //ALL OTHER APIS ARE AUTHENTICATED
//                .anyExchange().authenticated()
//                .and()
//                .csrf().disable()
//                .oauth2Login()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//        return http.build();
        http
                .authorizeExchange(exchanges -> exchanges
                        // ALLOWING REGISTER API FOR DIRECT ACCESS
                        .pathMatchers("/api/users/register").permitAll()
                        // ALL OTHER APIS ARE AUTHENTICATED
                        .anyExchange().authenticated()
                )
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .oauth2Login(withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(withDefaults())
                );
        return http.build();
    }
}

