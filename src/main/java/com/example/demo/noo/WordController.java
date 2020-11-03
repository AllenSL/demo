package com.example.demo.noo;

import com.example.demo.util.FileUtils;
import noo.json.JsonObject;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName wordController
 * @Description TODO
 * @Autor ansonglin
 * @Date 2019/5/5 10:08
 * @Version 1.0
 **/
@RestController
public class WordController {

    @Autowired
    private UserService userService;


    @PostMapping("/test")
    public JsonObject getById(JsonObject parms){
//        Integer id = parms.getInteger("id");
          return userService.getById(1);
    }

    @PostMapping("/checkFileType")
    public void test(MultipartFile file) throws IOException {
        File file1 = new File(file.getOriginalFilename());
        FileUtils.inputStreamToFile(file.getInputStream(),file1);
        Tika tika = new Tika();
        String filetype = null;
        try {
            filetype = tika.detect(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(filetype);
    }
}
   