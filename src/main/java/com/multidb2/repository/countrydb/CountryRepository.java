package com.multidb2.repository.countrydb;

import com.multidb2.entity.countrydb.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}
