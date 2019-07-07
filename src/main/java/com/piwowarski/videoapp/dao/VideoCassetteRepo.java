package com.piwowarski.videoapp.dao;

import com.piwowarski.videoapp.dao.Entity.VideoCassette;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCassetteRepo extends CrudRepository<VideoCassette, Long> {

}
