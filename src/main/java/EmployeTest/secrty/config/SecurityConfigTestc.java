package EmployeTest.secrty.config;

//@Configuration
//@EnableWebSecurity
public class SecurityConfigTestc {
        //extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/applicant/**").hasAnyAuthority("SUPER_ADMIN","APPLICANT_ADMIN")
//                .antMatchers("/worker/**").hasAnyAuthority("SUPER_ADMIN","WORKER_ADMIN")
//                .antMatchers("/player/**").hasAnyAuthority("SUPER_ADMIN","PLAYER_ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
////                .formLogin()
////                .loginPage("/login") // Custom login page
////                .permitAll()
////                .and()
////                .logout()
////                .permitAll();
//    }
}



