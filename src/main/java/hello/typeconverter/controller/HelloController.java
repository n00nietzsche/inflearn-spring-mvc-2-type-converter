package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        // .getParameter()는 기본으로는 문자 타입으로 조회함
        String data = request.getParameter("data");
        // 숫자 타입으로 변경
        Integer intValue = Integer.valueOf(data);
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        // 형변환되어 그대로 출력 가능
        System.out.println("intValue = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort data) {
        // 형변환되어 그대로 출력 가능
        System.out.println("ipPort = " + data);
        return "ok";
    }
}
