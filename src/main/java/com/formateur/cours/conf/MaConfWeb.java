package com.formateur.cours.conf;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.formateur.cours.rest.ControllerAuthorizationInterceptor;
import com.formateur.cours.rest.RestTemplateAuthorizationInterceptor;

//Configuration MVC : ajoute 
//des capacités à Spring Web
@Configuration
public class MaConfWeb implements WebMvcConfigurer {

    //La configuration de sécurité est désactivée : 
    //A activer si spring-security-starter est ajoutée 
    //comme dépendance dans le pom.xml
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     // Réutilisation de HttpSecurity fourni par SpringSecurity
    //     http
    //             .authorizeHttpRequests(requests -> requests
    //                     // / et /home peuvent être requêtées par tout le monde
    //                     .requestMatchers("/", "/home").permitAll()
    //                     // Cette page est restreinte aux personnes avec le role admin
    //                     .requestMatchers("/planes").hasRole("PLANE_MANAGER")
    //                     .requestMatchers("/page-d-administration").hasRole("ADMIN")
    //                     // Toute autre requête ne peut être émise que par une personne
    //                     // authentifiée
    //                     .anyRequest().authenticated())
    //             // la page de login est accessible via /login
    //             // et est accessible par tout le monde
    //             .httpBasic(Customizer.withDefaults())
    //             .formLogin(form -> form
    //                     .loginPage("/login")
    //                     .permitAll())
    //             // La page de logout est aussi accessible
    //             // par tout le monde
    //             .logout(logout -> logout.logoutUrl("/logout")
    //                     .logoutSuccessUrl("/login?logout")
    //                     .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).permitAll());
    //     return http.build();
    // }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     // La méthode ci-dessous est dépréciée : il n'est pas conseillé
    //     // de mettre en dur un login et un mot de passe, mais de
    //     // récupérer un utilisateur d'une base de données, ou d'un
    //     // référentiel d'utilisateurs (annuaire LDAP)
    //     @SuppressWarnings("deprecation")
    //     UserDetails user = User.withDefaultPasswordEncoder()
    //             .username("user")
    //             .password("password")
    //             .roles("USER", "PLANE_MANAGER")
    //             .build();
    //     // Renvoie une implémentation de UserDetailsService
    //     // qui stocke les utilisateurs en mémoire (ici, un seul utilisateur)
    //     return new InMemoryUserDetailsManager(user);
    // }

    // AJoute des intercepteurs pour les contrôleurs :
    // ces intercepteurs vont agir avant et après chaque
    // requête HTTP traitée par ce serveur.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ControllerAuthorizationInterceptor());
    }

    // Crée un restTemplate avec son interceptor (qui ajoute des informations de
    // sécurité)
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(new RestTemplateAuthorizationInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
