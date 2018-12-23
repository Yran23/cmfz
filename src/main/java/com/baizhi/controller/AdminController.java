package com.baizhi.controller;

import com.baizhi.conf.CreateValidateCode;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CreateValidateCode createValidateCode;

    @RequestMapping("/getCode")
    public void getCode(HttpSession httpSession, HttpServletResponse response) throws Exception {
        String code = createValidateCode.getCode();
        httpSession.setAttribute("valCode", code);
        createValidateCode.write(response.getOutputStream());
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpSession httpSession, Model model, Admin admin) {
        try {
            adminService.login(admin);
            httpSession.setAttribute("admin", admin);
            return "redirect:/view/main.jsp";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "login";
        }
    }

    @RequestMapping("/valCode")
    @ResponseBody
    public String valCode(HttpSession session, String code) {
        String valCode = (String) session.getAttribute("valCode");
        if (valCode.equalsIgnoreCase(code)) {
            return "ok";
        } else {
            return "验证码错误";
        }
    }
}
