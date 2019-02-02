package com.github.enriqueabsurdum.interfaces;

import com.github.enriqueabsurdum.models.Brand;

public interface BrandDao extends GenericDao<Brand, Integer> {

    public Brand getByBrand(String value);
}
