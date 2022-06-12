package com.example.restcontroller.Controller;

import com.example.restcontroller.Repository.UserRepo;
import com.example.restcontroller.restDto.UserDto;
import com.example.restcontroller.restDto.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/deneme")
@CrossOrigin
public class UserController {

    @Autowired
    UserRepo repo;

    //SAVE
    //http://localhost:8088/api/deneme/save
    @PostMapping("/save")
    public ResponseEntity<UserEntity> postUser(@RequestBody UserEntity userEntity){
        repo.save(userEntity);
        return  ResponseEntity.ok(userEntity);
    }

    //PUT(update)
    //http://localhost:8088/api/deneme/put
    @PutMapping("/put")
    public ResponseEntity<Void> getPut(@RequestBody UserEntity userEntity){
        repo.save(userEntity);
        return ResponseEntity.ok().build();
    }

    //LIST
    //http://localhost:8088/api/deneme/list
    @GetMapping("/list")
    public ResponseEntity<List<UserEntity>> getList(){
        List<UserEntity> entityList=repo.findAll();
        return ResponseEntity.ok(entityList);
    }

    //DELETE
    //http://localhost:8088/api/deneme/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> getDelete(@PathVariable(name = "id") Long id){
        UserEntity userEntity = repo.findById(id).orElseThrow(()->new ResourceNotFoundException(id+" id bulunmadı"));
        repo.delete(userEntity);
        return ResponseEntity.ok().build();
    }

    //FIND
    //http://localhost:8088/api/deneme/find/1
    @GetMapping("/find/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable(name = "id")Long id){
        UserEntity entity = repo.findById(id).orElseThrow(()->new ResourceNotFoundException(id+" id bulunmadı"));
        return ResponseEntity.ok(entity);
    }

}
