package com.github.rbtepss.cities.api.countries.repositories;

import com.github.rbtepss.cities.api.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
