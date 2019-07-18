package com.cleverlance.academy.airlines;

import com.cleverlance.academy.airlines.mapper.HangarMapper;
import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.service.IHangarService;
import com.cleverlance.academy.airlines.service.IPlaneService;
import generated.rest.api.HangarsApi;
import generated.rest.model.HangarGen;
import generated.rest.model.HangarListGen;
import generated.rest.model.PlaneGen;
import generated.rest.model.PlaneListGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
public class HangarController implements HangarsApi
{
    @Autowired
    private IHangarService hangarService;

    @Autowired
    private HangarMapper hangarMapper;

    @Autowired
    private IPlaneService planeService;

    @RequestMapping(path = "/hangars", method = RequestMethod.GET)
    @Override
    public CompletableFuture<ResponseEntity<HangarListGen>> getHangars() {
        final List<Hangar> result = hangarService.getAllHangars();
        List<HangarGen> responseList = result.stream().map(item -> hangarMapper.convertToHangarGen(item))
                .collect(Collectors.toList());
        HangarListGen response = new HangarListGen();
        response.addAll(responseList);
        return CompletableFuture.completedFuture(ResponseEntity.ok(response));
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.POST)
    public void createHangar(@RequestBody Hangar hangar) {
        hangarService.createHangar(hangar);
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.DELETE)
    public void deleteHangar(@RequestBody Hangar hangar) {
        hangarService.deleteHangar(hangar.getHangarId());
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.PUT)
    public void updateHangar(@RequestBody Hangar hangar) {
        hangarService.updateHangar(hangar);
    }

    @RequestMapping(path = "/hangars/{hangarId}/{planeId}", method = RequestMethod.PUT)
    public void parkPlaneToHangar(@PathVariable("hangarId") Long hangarId, @PathVariable("planeId") Long planeId) {
        final Optional<Hangar> hangar = hangarService.getHangarById(hangarId);
        final Optional<Plane> plane = planeService.getPlaneById(planeId);
        if (hangar.isPresent() && plane.isPresent()) {
            hangarService.addPlaneToHangar(hangar.get(), plane.get());
        }
    }
}
