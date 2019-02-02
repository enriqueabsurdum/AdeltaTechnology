package com.github.enriqueabsurdum.interfaces;

import com.github.enriqueabsurdum.models.Profile;

public interface ProfileDao extends GenericDao<Profile, Integer> {

    public Profile getByProfile(String value);
}
