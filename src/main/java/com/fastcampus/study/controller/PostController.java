package com.fastcampus.study.controller;

import com.fastcampus.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    //HTML <Form>
    //ajax 일떄 주로 사용
    //http post body - > data
    // json, xml , multipart-form / text-plain
    //@RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){

        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put(){


    }

    @PatchMapping("/patchMethod")
    public void patch(){

    }
}
