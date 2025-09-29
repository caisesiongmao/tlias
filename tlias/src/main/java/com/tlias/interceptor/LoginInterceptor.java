package com.tlias.interceptor;

import com.aliyuncs.utils.StringUtils;
import com.tlias.utils.JWTUtils;
import com.tlias.utils.ThreadLocalUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle ...");
        String requestURI = request.getRequestURI();
        if(requestURI.contains("/login")){
            log.info("login request, release");
            return true;
        }
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            log.info("token is empty");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        try {
            Claims claims = JWTUtils.parseJWT(token);
            Integer id = Integer.parseInt(claims.get("id").toString());
            String username = claims.get("username").toString();
            String name = claims.get("name").toString();
            String password = claims.get("password").toString();
            log.info("current user info, id:{}, username:{}, name:{}, password:{}", id, username, name, password);
            ThreadLocalUtils.setCurrentId(id);
            ThreadLocalUtils.setCurrentUsername(username);
            ThreadLocalUtils.setCurrentName(name);
            ThreadLocalUtils.setCurrentPassword(password);
        } catch (Exception e) {
            log.info("token is illegal");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        log.info("token right, release");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle ...");
        ThreadLocalUtils.removeCurrentId();
        ThreadLocalUtils.removeCurrentUsername();
        ThreadLocalUtils.removeCurrentName();
        ThreadLocalUtils.removeCurrentPassword();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion ...");
    }
}
