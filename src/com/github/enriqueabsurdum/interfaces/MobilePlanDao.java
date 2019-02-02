package com.github.enriqueabsurdum.interfaces;

import com.github.enriqueabsurdum.models.MobilePlan;
import java.util.List;

public interface MobilePlanDao extends GenericDao<MobilePlan, Integer> {

    public MobilePlan readByMobile(Integer key);

    public List<MobilePlan> findByMobile(Integer key);

    public void deleteByMobile(Integer key);

}
