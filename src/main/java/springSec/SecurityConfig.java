package springSec;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder encoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    private final static String USER = "user";
    private final static String ROLE = "USER";
    private final static String PASSWORD = "password";

    private static final String HELLO = "/hello";
    private static final String GET_COMMON_INFO = "/get-info/common";
    private static final String GET_USER_INFO = "/get-info/user";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HELLO, GET_COMMON_INFO).permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and().formLogin();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(USER)
                .password(encoder.encode(PASSWORD))
                .roles(ROLE);
    }
}
