package com.jacker.redis_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SessionController {

    @RequestMapping(value = "/setSession",method = RequestMethod.GET)
    public Map<String,Object> setSession(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        request.getSession().setAttribute("request url",request.getRequestURL());
        map.put("request url",request.getRequestURL());
        return map;
    }

    @RequestMapping(value = "/getSession",method = RequestMethod.GET)
    public Object getSession(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("sessionIdUrl",request.getSession().getAttribute("request url"));
        map.put("sessionId",request.getSession().getId());
        return map;
    }
}
