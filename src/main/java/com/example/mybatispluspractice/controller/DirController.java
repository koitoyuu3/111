package com.example.mybatispluspractice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatispluspractice.entity.Directory;
import com.example.mybatispluspractice.service.IDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Wrapper;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/")
public class DirController {

    private static final String UPLOAD_DIR = "src/main/resources/images/";


    @Autowired
    IDirService dirService;

    @GetMapping()
    String list(Model model) {
        List<Directory> directories = dirService.list();
        model.addAttribute("Directories", directories);
        return "list_page";
    }

    @GetMapping("/add")
    String addForm() {
        return "add_page";
    }

    @PostMapping("/add")
    String add(@RequestParam String name, @RequestParam String phone, @RequestParam String email) {
        if (!isLegal(name, phone, email))
            return "add_page";
        Directory directory = new Directory();
        directory.setName(name);
        directory.setEmail(email);
        directory.setPhone(phone);
        dirService.save(directory);
        return "redirect:/";
    }

    @GetMapping("/edit")
    String editForm(Model model, @RequestParam int id) {
        Directory directory = dirService.getById(id);
        model.addAttribute("directory", directory);
        return "edit_page";
    }

    @PostMapping("/edit")
    String edit(@ModelAttribute Directory directory) {
        dirService.updateById(directory);
        return "redirect:/";
    }

    @GetMapping("/delete")
    String delete(@RequestParam int id) {
        dirService.removeById(id);
        return "redirect:/";
    }

    @GetMapping("/getByName")
    String getFormByName() {return "input_name";}

    @PostMapping("/getByName")
    String getByName(Model model, @RequestParam String name) {
        //T getOne(Wrapper<T> queryWrapper);
        QueryWrapper<Directory> qw = new QueryWrapper<>();
        qw.eq("name", name);
        Directory directory = dirService.getOne(qw);
        model.addAttribute("directory", directory);
        return "get_pageByName";
    }
    @GetMapping("/getByPhone")
    String getFormByPhone() {return "input_phone";}

    @PostMapping("/getByPhone")
    String getByPhone(Model model, @RequestParam String phone) {
        //T getOne(Wrapper<T> queryWrapper);
        QueryWrapper<Directory> qw = new QueryWrapper<>();
        qw.eq("phone", phone);
        Directory directory = dirService.getOne(qw);
        model.addAttribute("directory", directory);
        return "get_pageByPhone";
    }

    boolean isLegal(String name, String phone, String email) {
        int flag = 1;
        String re_email = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern_email = Pattern.compile(re_email);
        Matcher matcher_email = pattern_email.matcher(email);
        if (!matcher_email.matches())
            flag = 0;

        String re_phone = "^1[345789]\\d{9}$";
        Pattern pattern_phone = Pattern.compile(re_email);
        Matcher matcher_phone = pattern_phone.matcher(email);
        if (!matcher_phone.matches())
            flag = 0;

        return flag == 1;
    }

}

