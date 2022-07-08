package com.example.EventManagementSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventManagementSystem.Exception.ResourceNotFoundException;
import com.example.EventManagementSystem.Model.Register;
import com.example.EventManagementSystem.repository.RegisterRepo;

@CrossOrigin
@RestController
@RequestMapping("api/registers")
public class RegisterController {
    @Autowired
    private RegisterRepo registerRepo; 


//get(view) all data in my Register table
    @GetMapping("/")

    public List<Register> getAllRegister(){
        return registerRepo.findAll();
    }



     //post (add ) data to my Register table
     @PostMapping("/")
     public Register addRegister(@RequestBody Register  register)
     {
         return registerRepo.save(register);
     }



       //update data in my register table
    @PutMapping("/{id}")
    public ResponseEntity<Register> updateRegister(@PathVariable long id, @RequestBody Register register)
    {
        Register rg = registerRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        rg.setFirstname(register.getFirstname());
        rg.setLastname(register.getLastname());
        rg.setEmail(register.getEmail());
        rg.setPhoneno(register.getPhoneno());
        rg.setAddress(register.getAddress());


        Register rgt = registerRepo.save(rg);
        return ResponseEntity.ok(rgt);
    }



     //get(view) register  by id
     @GetMapping("/{id}")
     public ResponseEntity<Register> getRegisterById(@PathVariable long id)
     {
         Register rgt = registerRepo.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
         return ResponseEntity.ok(rgt);
     }


     //delete register
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteStaff(@PathVariable long id)
    {
        Register rg = registerRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        registerRepo.delete(rg);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
    

