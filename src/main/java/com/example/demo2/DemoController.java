package com.example.demo2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "demo2")
public class DemoController {

    @Autowired
    private DemoRepository demoRepository;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity demoGet(){
        return new  ResponseEntity("hello world",HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET,path = "/{name}")
    ResponseEntity getByName(@PathVariable String name){
        List<DemoEntity> demoEntityList = demoRepository.findByName(name);
        return new  ResponseEntity(demoEntityList,HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    ResponseEntity<String> demoPost(@RequestBody String name){
//        return new ResponseEntity<>("Hello "+ name,HttpStatus.OK);

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<String> postName(@RequestBody DemoEntity demoEntity){
    demoRepository.save(demoEntity);
    return new ResponseEntity(demoEntity.getId(),HttpStatus.OK);
    }

}
