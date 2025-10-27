package andreasjiu.ac.api_jdbc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    //lalu saya buat class SecurityConfig unutk pengaturan keamanan utama si    Spring Security.

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //disini kita pake csrf.disable untuk mattin CSRF karena kita pake REST API
        //apa itu CSRF? itu adalah Cross-Site Request Forgery
        //yaitu kayak serangan di mana orang lain bisa menyuruh browser kita ngelakuin request ke website tanpa izin kita.
        //dan authorizeHTTPRequest untuk tentuin mana yang bisa di akses tanpa token
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth ->
                auth.requestMatchers("/login", "/roles/hello").permitAll().anyRequest().authenticated()).sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    //pada intinya si SecurityConfig ini itu adalah keamanan aplikasi termasuk daftar endpoint bebas yang butuh token
}
