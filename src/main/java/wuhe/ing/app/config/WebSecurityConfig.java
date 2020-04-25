package wuhe.ing.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import wuhe.ing.app.service.DemoUserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	@Autowired
	public UserDetailsService userDetailsService() { // 覆盖写userDetailsService方法 (1)
		return new DemoUserDetailService();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// super.configure(http);
		http.csrf().disable();

		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/resources/", "/amchart/**", "/bootstrap/**", "/build/**", "/css/**", "/dist/**",
						"/documentation/**", "/fonts/**", "/js/**", "/pages/**", "/plugins/**")
				.permitAll() // 默认不拦截静态资源的url pattern （2）
				.anyRequest().authenticated().and().formLogin().loginPage("/login")// 登录url请求路径 (3)
				.defaultSuccessUrl("/home").permitAll().and() // 登录成功跳转路径url(4)
				.logout().permitAll();

		http.logout().logoutSuccessUrl("/"); // 退出默认跳转页面 (5)
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// AuthenticationManager使用我们的 lightSwordUserDetailService 来获取用户信息
		auth.userDetailsService(userDetailsService()); // （6）
	}

	// skip static resources
	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/resourcesDir/**"); }
	 */
}
