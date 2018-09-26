package com.boot.security.server.filter;

import com.alibaba.druid.util.StringUtils;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.utils.ConstUtil;
import com.boot.security.server.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created By Seven.wk
 * Description: 验证码过滤器
 * Created At 2018/09/26
 */
@Component
public class CaptchaFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if(StringUtils.equals("/login", httpServletRequest.getRequestURI())
                && StringUtils.equalsIgnoreCase("post", httpServletRequest.getMethod())) {

            HttpSession session = httpServletRequest.getSession();
            String captchaCode = (String) session.getAttribute(ConstUtil.CAPTCHA_CODE);
            if(!captchaCode.equals(httpServletRequest.getParameter("captchaCode"))) {
                ResponseInfo info = new ResponseInfo(HttpStatus.UNAUTHORIZED.value() + "", "验证码错误");
                ResponseUtil.responseJson(httpServletResponse, HttpStatus.UNAUTHORIZED.value(), info);
                return ;
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
