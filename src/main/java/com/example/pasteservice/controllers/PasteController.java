package com.example.pasteservice.controllers;

import com.example.pasteservice.dtos.PasteDto;
import com.example.pasteservice.models.Paste;
import com.example.pasteservice.services.PasteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pastes")
public class PasteController {

    private final PasteService pasteService;

    public PasteController(PasteService pasteService) {
        this.pasteService = pasteService;
    }

    @PostMapping
    public ResponseEntity<Paste> addPaste(@RequestBody PasteDto pasteDto, @RequestParam(defaultValue = "0") int minutes){
        return new ResponseEntity<>(pasteService.addPaste(pasteDto, minutes), HttpStatus.CREATED);
    }

    @GetMapping("/{hash}")
    public ResponseEntity<Paste> getPasteByHash(@PathVariable String hash){
        return new ResponseEntity<>(pasteService.getPasteByHash(hash), HttpStatus.OK);
    }

    @GetMapping("/last")
    public ResponseEntity<List<Paste>> getLastPastes(){
        return new ResponseEntity<>(pasteService.getLastPastes(), HttpStatus.OK);
    }


}
