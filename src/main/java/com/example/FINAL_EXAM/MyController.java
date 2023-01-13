/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.FINAL_EXAM;

import com.example.FINAL_EXAM.exceptions.NonexistentEntityException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */

@RestController
@CrossOrigin
@ResponseBody
public class MyController {
    //deklarasi import Surat dan SuratJpaController
    Surat data = new Surat();
    SuratJpaController control = new SuratJpaController();
    //membuat method get
    @GetMapping(value="/GET", produces = APPLICATION_JSON_VALUE)
    public List<Surat> getData(){
        List<Surat> buffer = new ArrayList<>();
        buffer = control.findSuratEntities();
        return buffer;
    }
    //membuat method post
     @PostMapping(value = "/POST", consumes = APPLICATION_JSON_VALUE)
    public String sendData(HttpEntity<String> datasend) throws JsonProcessingException{
        String feedback = "Do Nothing";
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(datasend.getBody(), Surat.class);
        try {
            control.create(data);
            feedback = data.getJudul() + "Saved";
        } catch (Exception error) {
            feedback = error.getMessage();
        }
            return feedback;
    //membuat method put    
    }
    @PutMapping(value = "/PUT", consumes = APPLICATION_JSON_VALUE)
    public String editData(HttpEntity<String> datasend) throws JsonProcessingException{
        String feedback = "Do Nothing";
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(datasend.getBody(), Surat.class);
        try {
            control.edit(data);
            feedback = data.getJudul() + "Edited";
        } catch (Exception error) {
            feedback = error.getMessage();
        }
            return feedback;
        
    }
    
    
    
}
