package com.multidb2.countrydb.repository;

import com.multidb2.countrydb.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}
