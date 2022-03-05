package com.project.mergentech.service.impl;

import com.project.mergentech.entity.Filtre;
import com.project.mergentech.entity.Master;
import com.project.mergentech.entity.Throwablekonsol;
import com.project.mergentech.repository.RepositoryInterface;
import com.project.mergentech.service.ServiceInterface;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.rmi.ServerException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements ServiceInterface {
    @PersistenceUnit
    @Autowired
    private EntityManagerFactory em;

    private final RepositoryInterface repositoryinterface;


    @Override
    public List<Master> hataKonsolunaGetir() {
        EntityManager entityManager = em.createEntityManager();
        String sorgu = "SELECT m FROM MASTER m";
        Query q = entityManager.createQuery(sorgu);
        List<Master> resultThrowable = q.getResultList();
        return resultThrowable;
    }

    public void kontrol(Filtre filtre) throws ServiceException {
        if (filtre.getIlkTarih() != null && filtre.getSonTarih() != null) {
            if (filtre.getSonTarih().compareTo(filtre.getIlkTarih()) < 0) {
                throw new ServiceException("Geçersiz tarih aralığı girdiniz.");
            }
        } else if (filtre.getHastaneAdi() == null || filtre.getHastaneAdi().isEmpty() || filtre.getHastaneAdi().isBlank()) {
            throw new ServiceException("Hastane adı boş bırakılamaz.");
        }
    }

    @Override
    public List<Master> filtreliListele(Filtre filtre) throws ServiceException {
        kontrol(filtre);
        EntityManager entityManager = em.createEntityManager();
        String query = "SELECT m FROM MASTER m WHERE 0=0";

        if (filtre.getKullaniciKodu() != null) {
            query += " AND m.kullaniciKodu = :id";
        }
        if (filtre.getHastaneAdi() != null) {
            query += " AND m.hastaneAdi = :hastaneadi";
        }
        if (filtre.getIlkTarih() != null) {
            if (filtre.getSonTarih() != null) {
                query += " AND m.zaman > :ilkTarih AND m.zaman < :sonTarih";
            }
        }

        Query Qer = entityManager.createQuery(query);
        if (filtre.getKullaniciKodu() != null) {

            Qer.setParameter("id", filtre.getKullaniciKodu());
        }
        if (filtre.getHastaneAdi() != null) {
            Qer.setParameter("hastaneadi", filtre.getHastaneAdi());
        }
        if (filtre.getIlkTarih() != null && filtre.getSonTarih() != null) {
            Qer.setParameter("ilkTarih", filtre.getIlkTarih()).setParameter("sonTarih", filtre.getSonTarih());
        }

        List<Master> resultMaster = Qer.getResultList();
        return resultMaster;
    }

    @Override
    public Master kaydetMasterdeneme(Master master) {
        master.getThrowables().forEach(throwable -> throwable.setMaster(master));
        return repositoryinterface.save(master);
    }
}
