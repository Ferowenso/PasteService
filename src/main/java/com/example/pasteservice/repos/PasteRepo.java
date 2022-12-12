package com.example.pasteservice.repos;

import com.example.pasteservice.models.Access;
import com.example.pasteservice.models.Paste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PasteRepo extends JpaRepository<Paste, Long> {

    boolean existsPasteByHash(String hash);

    Optional<Paste> findByHash(String hash);

    List<Paste> findFirst10ByAccessOrderByCreatedAtDesc(Access access);

}
