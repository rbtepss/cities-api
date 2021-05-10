package com.github.rbtepss.cities.api.cities.resource;

import com.github.rbtepss.cities.api.cities.service.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

    private final DistanceService service;
    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    public DistanceResource (DistanceService service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long cityOne,
                                   @RequestParam(name = "to") final Long cityTwo) {
        log.info("byPoints");
        return ResponseEntity.ok().body(service.distanceByPointsInMiles(cityOne,cityTwo));
    }

    @GetMapping("/by-cube")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long cityOne,
                         @RequestParam(name = "to") final Long cityTwo) {
        log.info("byCube");
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(cityOne, cityTwo));
    }
}
