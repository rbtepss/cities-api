package com.github.rbtepss.cities.api.cities.service;

import com.github.rbtepss.cities.api.cities.City;
import com.github.rbtepss.cities.api.cities.repositories.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {

    private final CityRepository cityRepository;
    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService (final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Double distanceByPointsInMiles(final Long cityOne, final Long cityTwo) {
        log.info("nativePostgresInMiles({}, {})", cityOne, cityTwo);
        return cityRepository.distanceByPoints(cityOne, cityTwo);
    }

    public Double distanceByCubeInMeters(Long cityOne, Long cityTwo) {
        log.info("distanceByCubeInMeters({}, {})", cityOne, cityTwo);
        final List<City> cities = cityRepository.findAllById((Arrays.asList(cityOne, cityTwo)));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
