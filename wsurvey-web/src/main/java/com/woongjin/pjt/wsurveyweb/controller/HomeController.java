package com.woongjin.pjt.wsurveyweb.controller;

import com.woongjin.pjt.wsurveyweb.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @GetMapping("/userForm")
    public String viewUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "userForm";
    }
    @PostMapping("/submitUser")
    public String submitUser(@Valid @ModelAttribute User user, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "userForm"; // 유효성 검증 실패 시 다시 폼을 보여줌
        }

        model.addAttribute("message", "전송성공!");
        model.addAttribute("user",user);
        return "result";
    }
}
