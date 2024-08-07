package com.woongjin.pjt.wsurveyweb.controller;

import com.woongjin.pjt.wsurveycore.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    @Value("${local.local.key}")
    private String localLocalKey;

    @Value("${local.key}")
    private String localKey;

    @GetMapping("/getUser")
    public String getUserTest(){
        User user = new User();
        user.setId("77106636");
        user.setName("이호경");
        return user.getId() + user.getName();
    }

    @GetMapping("/getProfileValue")
    public String getProfileValueTest(){

        log.trace("TRACE!");
        log.debug("DEBUG!");
        log.info("INFO!");
        log.warn("WARN!");
        log.error("ERROR!");

        return localLocalKey + " | " + localKey;
    }

    @GetMapping("/testAPI")
    public String getTestAPIValue(@RequestParam String id, @RequestParam String pw){
        if("".equals(id.toString())){
            return "id가 입력되지 않았습니다.";
        }
        return "id : " + id + "pw : " + pw;
    }
}
