package com.tlias.controller;

import com.tlias.pojo.Result;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Data
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/setCookie")
    public Result setCookie(HttpServletResponse response) {
        response.setHeader("Set-Cookie", "name=shiyu");
        return  Result.success();
    }

    @GetMapping("/getCookie")
    public Result getCookie(HttpServletRequest request) {
        String name = request.getHeader("Cookie");
        System.out.println("cookie_name:"+name);
        return Result.success(null);
    }

    @GetMapping("/setSession")
    public Result setSession(HttpSession session) {
        log.info("setSession:{}", session.hashCode());
        session.setAttribute("name", "shiyu");
        return Result.success(null);
    }

    @GetMapping("/getSession")
    public Result getSession(HttpSession session) {
        log.info("getSession:{}", session.hashCode());
        String name = (String) session.getAttribute("name");
        System.out.println("getSession:"+name);
        return Result.success();
    }
}
