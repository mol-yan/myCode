package com.hangyan.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@Component 无需添加此注解，@WebFilter会自动将此filter加入容器
/**
过滤器的urlPatterns的过滤路径规则：
1.全路径匹配： /abc/myServlet1.do
2.部分路径匹配： /abc/*
3.通配符匹配 ：/*
4.后缀名匹配 ：*.do (注意:前面不加/)
 filterName的首字母一定要小写，指定过滤器的 name 属性
 urlPattern拦截的url映射，不是包下的文件
 注意配合@ServletComponentScan
*/
@Slf4j//一种注解写法的过滤器
@WebFilter(urlPatterns = "/*", filterName = "filter_c")//也可以在配置中New一个实例设置urlPatterns
@Order(1)
public class filter_c implements Filter {
    public filter_c() {
        super();
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }
   //出发拦截时被调用
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        log.info(req.getRequestURL().toString());
        log.info("dayin");
        chain.doFilter(request,response);



    }

    public void destroy() {

    }
}
