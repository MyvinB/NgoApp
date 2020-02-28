package com.cts.ngo.service;/*
 *@author Myvin Barboza

 *
 * 12:26 PM 2/27/2020
 */

import com.cts.ngo.model.Ngo;

public interface NgoService {
    public boolean saveNgo(Ngo ngo);

    public Ngo findByNameAndPassword(String name,String password);

    public boolean updateNgo(Ngo ngo,int id);

    public boolean deleteNgo(int id);
}
