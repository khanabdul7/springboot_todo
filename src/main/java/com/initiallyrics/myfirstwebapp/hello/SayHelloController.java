package com.initiallyrics.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class SayHelloController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, How's your learning so far ?";
    }

    @RequestMapping("hello-html")
    @ResponseBody
    public String helloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> HTML Response </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My First HTML page Response");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    @RequestMapping("hello-jsp")

    public String helloJSP() {
        return "helloJSP";
    }
}
