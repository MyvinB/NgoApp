package com.cts.ngo.repository;/*
 *@author Myvin Barboza

 *
 * 12:24 PM 2/27/2020
 */

import com.cts.ngo.model.Ngo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgoRepository extends JpaRepository<Ngo,Integer> {

    public Ngo findByNameAndPassword(String name,String password);

}
