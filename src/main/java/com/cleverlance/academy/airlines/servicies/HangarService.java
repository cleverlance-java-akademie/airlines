package com.cleverlance.academy.airlines.servicies;

import com.cleverlance.academy.airlines.entities.Airplane;
import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.repository.HangarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public void addPlaneToHangar(final Hangar h, final Airplane aP) {
        final List<Airplane> list = h.getPlanes();
        if(list == null){
            h.setPlanes(new ArrayList<>());
        }
        h.getPlanes().add(aP);
        updateHangar(h);
    }

    @Override
    public Optional<Hangar> getHangarById(final Long hangar) {
        return hR.findById(hangar);
    }
}
