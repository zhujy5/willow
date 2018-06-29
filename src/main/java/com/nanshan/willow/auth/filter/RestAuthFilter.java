package com.nanshan.willow.auth.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.nanshan.willow.auth.dto.AuthFilterContext;
import com.nanshan.willow.auth.dto.AuthResultDto;
import com.nanshan.willow.auth.dto.TokenValidateForm;
import com.nanshan.willow.auth.service.RestAuthFilterHandler;
import com.nanshan.willow.auth.util.ValidTokenManager;

/**
 * 
 * @ClassName:  RestAuthFilter   
 * @Description:客户端过滤器， 所有.do请求都需要通过验证
 * @author: zhujy001
 * @date:   2018年2月10日 下午3:33:33
 *
 */
public class RestAuthFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(RestAuthFilter.class);

    /**
     * 这个方法需要被继承
     */
    RestAuthFilterHandler authHandler;
    
    ValidTokenManager validTokenManager;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        AuthFilterContext context = new AuthFilterContext();
        context.setRequest(request);
        context.setResponse(response);

        String serverUrl = ((HttpServletRequest) request).getServletPath();
        log.info("------请求的接口url-----"+serverUrl);
        context.setServerUrl(serverUrl);
        context.setFilterChain(chain);
        
        // 2. 本地判断是否当前请求是否需要校验
        if (!authHandler.shouldBeHandle(context)) {
            chain.doFilter(request, response);
            return;
        }

        // 校验token是否合法
        try {
            // 3.1 从请求中解析授权表单
            TokenValidateForm validateForm = authHandler.decodeValidateForm(context);
            log.info("--------token-------:"+validateForm.getToken());
            // 3.2 校验
            AuthResultDto result = validTokenManager.doValidate(validateForm,request);

            // 3.3
            authHandler.whenValidateResult(context, validateForm, result);
            return;
        } catch (Exception ex) {
            log.error("token认证异常", ex);
            authHandler.whenNotAuth(context);
        }
    }

    /**
     * 初始化
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        authHandler = (RestAuthFilterHandler) ctx.getBean("authHandler");
        validTokenManager = (ValidTokenManager) ctx.getBean("validTokenManager");
    }

    @Override
    public void destroy() {
    	
    }
}
