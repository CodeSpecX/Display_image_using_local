package com.example.demo.controller;

import com.example.demo.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("user")
public class UserController {

      @Value("${file.prefix}")
      String prefix;

      @PostMapping("/save")
      public User saveUser(MultipartFile image , @RequestParam String userDetails) throws IOException {

            User user = new ObjectMapper().readValue(userDetails, User.class);

            String fileName = image.getOriginalFilename();


            File uploadFolder = new File("assets");

            if(!uploadFolder.exists()){
                 uploadFolder.mkdirs();
            }

            File filepath  = new File(uploadFolder,fileName);

            image.transferTo(filepath.getAbsoluteFile());

            String imageUrl = "localhost"+":"+"8080"+"/"+prefix+"/"+fileName;
            user.setImageUrl(imageUrl);

            return  user;
      }
}
