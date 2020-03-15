package com.piwowarski.videoapp.manager;

import com.piwowarski.videoapp.dao.Entity.VideoCassette;
import com.piwowarski.videoapp.dao.VideoCassetteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired //wstrzykiwanie klasy video app repository
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepo.findAll();
    } // iterable czyli element po których da się iterować

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id) {
        videoCassetteRepo.deleteById(id);
    }

    //na starcie aplikacji będą już dwa elementy w bazie danych
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new VideoCassette(1L,"Titanic", LocalDate.of(1995, 1,1)));
        save(new VideoCassette(2L,"Pulp Fiction", LocalDate.of(1990, 2,2)));
    }

}