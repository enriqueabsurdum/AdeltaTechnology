package com.github.enriqueabsurdum.interfaces;

import com.github.enriqueabsurdum.models.Mobile;

public interface MobileDao extends GenericDao<Mobile, Integer> {

    public Mobile readByImei(String value);

    public void updateById(Mobile entity);
}
