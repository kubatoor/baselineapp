package com.i2e.baselineapp.repository;

import com.i2e.baselineapp.model.Release;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

import java.util.Date;

/**
 * Created by anirudh on 11/22/15.
 */
public interface ReleaseRepository extends CrudRepository<Release,Long> {

    public Release findByReleaseDate(Date date);
    public List<Release> findAll();

}
