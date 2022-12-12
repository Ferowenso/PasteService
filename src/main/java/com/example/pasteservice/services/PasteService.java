package com.example.pasteservice.services;

import com.example.pasteservice.dtos.PasteDto;
import com.example.pasteservice.exceptions.PasteNotFoundException;
import com.example.pasteservice.models.Access;
import com.example.pasteservice.models.Paste;
import com.example.pasteservice.repos.PasteRepo;
import com.example.pasteservice.utils.Utils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PasteService {

    private final PasteRepo pasteRepo;

    public PasteService(PasteRepo pasteRepo) {
        this.pasteRepo = pasteRepo;
    }

    public Paste addPaste(PasteDto pasteDto, int minutes){
        Paste paste = new Paste();
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(minutes);
        paste.setAccess(pasteDto.getAccess());
        paste.setContent(pasteDto.getContent());
        String hash = Utils.generateRandomString(12);
        while (pasteRepo.existsPasteByHash(hash)){
            hash = Utils.generateRandomString(12);
        }
        paste.setHash(hash);
        paste.setCreatedAt(localDateTime);
        return pasteRepo.save(paste);
    }

    public Paste getPasteByHash(String hash){
        Paste paste = pasteRepo.findByHash(hash).orElseThrow(PasteNotFoundException::new);
        if(LocalDateTime.now().isBefore(paste.getValidUntil())){
            return paste;
        }else{
            pasteRepo.delete(paste);
            throw new PasteNotFoundException();
        }
    }

    public List<Paste> getLastPastes(){
        return pasteRepo.findFirst10ByAccessOrderByCreatedAtDesc(Access.PUBLIC);
    }

}
