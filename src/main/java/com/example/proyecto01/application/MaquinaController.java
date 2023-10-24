package com.example.proyecto01.application;


import com.example.proyecto01.domain.Maquina;
import com.example.proyecto01.Service.MaquinaService;
import com.example.proyecto01.infrastracture.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/maquina")
public class MaquinaController {
    @Autowired
    private MaquinaService maquinaService;

    @GetMapping
    public ResponseEntity<List<Maquina>> AllMaquinas(){
        List<Maquina> maquina = maquinaService.getAllMaquina();
        return new ResponseEntity<>(maquina,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> PostMaquina(@RequestBody Maquina maquina){
        maquinaService.saveMaquina(maquina);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMaquina(@PathVariable Long id, @RequestBody Maquina maquina){
        Optional<Maquina> updatedMaquina = maquinaService.updateMaquina(id,maquina);
        return updatedMaquina.isPresent() ? ResponseEntity.status(200).body("Updated") :
                ResponseEntity.status(404).body("Not Found");

    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchMaquina(@PathVariable Long id, @RequestBody Maquina maquina){
        Optional<Maquina> patchedMaquina = maquinaService.patchMaquina(id,maquina);
        return patchedMaquina.isPresent() ? ResponseEntity.status(200).body("Updated partially") :
                ResponseEntity.status(404).body("Not Found");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMaquina(@PathVariable Long id) {
        Optional<Maquina> deletedMaquina = maquinaService.deleteMaquina(id);
        return deletedMaquina.isPresent() ? ResponseEntity.status(200).body("Deleted") : ResponseEntity.status(404).body("Not Found");
    }
}
