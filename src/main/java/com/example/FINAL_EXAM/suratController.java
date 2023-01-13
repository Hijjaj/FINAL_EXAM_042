/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.FINAL_EXAM;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@RestController
@CrossOrigin
@ResponseBody
public class suratController {
    Surat data = new Surat();
    SuratJpaController ctrl = new SuratJpaController();
    
    @GetMapping(value="/GET", produces = APPLICATION_JSON_VALUE)
    public List<Barang> getData(){
        List<Surat> buffer = new ArrayList<>();
        buffer = ctrl.findSuratEntities();
        return buffer;
    }
}
