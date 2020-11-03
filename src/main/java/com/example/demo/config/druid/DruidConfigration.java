package com.example.demo.config.druid;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.DruidLobHandler;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import com.alibaba.druid.util.JdbcUtils;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.lob.LobHandler;

@Configuration
public class DruidConfigration {
	
	@Bean("lobHandler")
	public LobHandler lobHandler() {
		return new DruidLobHandler();
	}
    
//	@Bean("dataSource")
//    @ConfigurationProperties(prefix="spring.datasource")
//     public DataSource druidDataSource() {
//		DruidDataSource druidDataSource = new DruidDataSource();
//		List<Filter> list = new ArrayList<Filter>() {
//			{
//				add(logFilter());
//				add(statFilter());
//				add(wallFilter());
//			}
//		};
//		druidDataSource.setProxyFilters(list);
//		druidDataSource.setInitialSize(50);
//		druidDataSource.setMinIdle(10);
//		druidDataSource.setMaxActive(1000);
//		druidDataSource.setMaxWait(60000);
//		druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
//		druidDataSource.setTestWhileIdle(true);
//		druidDataSource.setTestOnBorrow(false);
//		druidDataSource.setTestOnReturn(false);
//		druidDataSource.setPoolPreparedStatements(false);
//		return druidDataSource;
//     }
    @Bean("log-filter")
	public Slf4jLogFilter logFilter() {
		Slf4jLogFilter filter = new Slf4jLogFilter();
		// filter.setStatementSqlFormatOption(new FormatOption(true,true,true));
		filter.setStatementExecutableSqlLogEnable(true);
        filter.setResultSetLogEnabled(false);
		filter.setConnectionLogEnabled(false);
		filter.setStatementLogEnabled(false);
		filter.setStatementParameterClearLogEnable(false);
		filter.setStatementCreateAfterLogEnabled(false);
		filter.setStatementCloseAfterLogEnabled(false);
		filter.setStatementParameterSetLogEnabled(false);
		filter.setStatementPrepareAfterLogEnabled(false);
		return filter;
    }

    @Bean("stat-filter")
    public StatFilter statFilter(){
        StatFilter filter = new StatFilter();
        //慢SQL统计，如果SQL执行时间超过一定时间则记录为慢SQL
        filter.setSlowSqlMillis(3000);
        //慢SQL统计日志输出
        filter.setLogSlowSql(true);
        //合并SQL统计 例如select * from table t where t.id =1，会被变为select * from table t where t.id =？来统计
        filter.setMergeSql(true);
        
        return filter;
    }
    @Bean("wallConfig")
    public WallConfig wallConfig(){
    	WallConfig config = new WallConfig();
    	config.setDeleteWhereNoneCheck(true);
    	config.setUpdateWhereNoneCheck(true);
    	return config;
    }
    
    @Bean("wall-filter")
    public WallFilter wallFilter(){
    	WallFilter filter = new WallFilter();
    	filter.setDbType(JdbcUtils.ORACLE);
    	filter.setConfig(wallConfig());
    	return filter;
    }
    /**
     * Spring监控配置
     * @return
     */
    @Bean
    public Advice druidSpringAdvice(){
        return new DruidStatInterceptor();
    }
    @Bean
    public Advisor druidSpringAdvisor() {
        return new RegexpMethodPointcutAdvisor("classpath: mapping/*", druidSpringAdvice());
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
    
    @Bean
    public ServletRegistrationBean druidServlet() {
//        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //白名单：
//        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
//        servletRegistrationBean.addInitParameter("deny","192.168.1.73");
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        //是否能够重置数据.
		servletRegistrationBean.addInitParameter("resetEnable", "true");
        return servletRegistrationBean;
    }
    
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        WebStatFilter webStatFilter = new WebStatFilter();
        webStatFilter.setProfileEnable(true);
        filterRegistrationBean.setFilter(webStatFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
    
}
