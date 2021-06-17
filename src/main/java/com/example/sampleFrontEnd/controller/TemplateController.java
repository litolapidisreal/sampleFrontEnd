package com.example.sampleFrontEnd.controller;

import com.example.sampleFrontEnd.models.Product;
import com.example.sampleFrontEnd.service.DataSamplerService;
import com.example.sampleFrontEnd.service.ProductQueryService;
import com.example.sampleFrontEnd.service.ProductUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("hello")
    public String getHello(){
        return "hello";
    }}