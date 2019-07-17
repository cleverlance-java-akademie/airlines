package com.cleverlance.academy.airlines.servicies;

import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.repository.HangarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangarService implements IHangarService {

    @Autowired
    HangarRepo hR;

    @Override
    public List<Hangar> getAllHangars() {
        return hR.findAll();
    }

    @Override
    public void deleteHangar(long id) {

        hR.deleteById(id);
    }

    @Override
    public void updateHangar(Hangar h) {

        hR.saveAndFlush(h);
    }

    @Override
    public void createHangar(Hangar h) {

        hR.saveAndFlush(h);
    }
}
