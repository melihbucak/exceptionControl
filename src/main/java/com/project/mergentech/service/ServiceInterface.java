package com.project.mergentech.service;

import com.project.mergentech.entity.Filtre;
import com.project.mergentech.entity.Master;
import com.project.mergentech.entity.Throwablekonsol;
import org.hibernate.service.spi.ServiceException;
//import net.bytebuddy.implementation.bytecode.*;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {

    List<Master> hataKonsolunaGetir();
    List<Master> filtreliListele(Filtre master);

    Master kaydetMasterdeneme(Master master);

}
