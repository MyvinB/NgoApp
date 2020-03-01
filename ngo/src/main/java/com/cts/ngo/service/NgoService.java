package com.cts.ngo.service;/*
 *@author Myvin Barboza

 *
 * 12:26 PM 2/27/2020
 */

import com.cts.ngo.model.Ngo;

public interface NgoService {
    public boolean saveNgo(Ngo ngo);

    public Ngo getNgo(String id);

    public boolean updateNgo(Ngo ngo,String id);

    public boolean deleteNgo(String id);
}
