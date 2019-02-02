package com.github.enriqueabsurdum.interfaces;

import com.github.enriqueabsurdum.models.Plan;

public interface PlanDao extends GenericDao<Plan, Integer> {

    public Plan readByPlan(String value);
}
