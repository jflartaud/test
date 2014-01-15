package com.jeet.hub.forge.domain.base.model.configuration;

import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import java.util.HashMap;

/**
 */
public class ConfigurationContainer extends ConfigurationItem {


    private HashMap<String , ConfigurationElement> elements;

    @OneToMany
    @MapKeyColumn(name="name")
    public HashMap<String, ConfigurationElement> getElements() {
        return elements;
    }

    public void setElements(HashMap<String, ConfigurationElement> elements) {
        this.elements = elements;
    }
}
