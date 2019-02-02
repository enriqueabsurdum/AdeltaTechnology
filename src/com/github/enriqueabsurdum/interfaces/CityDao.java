package com.github.enriqueabsurdum.interfaces;

import com.github.enriqueabsurdum.models.City;

public interface CityDao extends GenericDao<City, Integer> {

    public City getByCity(String value);
}
