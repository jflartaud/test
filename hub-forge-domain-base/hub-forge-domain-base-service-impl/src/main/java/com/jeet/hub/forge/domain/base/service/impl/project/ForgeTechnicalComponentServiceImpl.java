/**
* @(#) ForgeTechnicalComponentServiceImpl.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 22 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project;

import org.springframework.data.repository.CrudRepository;

import com.jeet.domain.base.service.impl.AbstractBaseEntityService;
import com.jeet.hub.domain.base.model.component.technical.TechnicalComponent;
import com.jeet.hub.forge.domain.base.model.project.ForgeProject;
import com.jeet.hub.forge.domain.base.service.api.project.ForgeTechnicalComponentService;
import com.jeet.hub.forge.domain.base.service.impl.project.repository.ForgeTechnicalComponentRepository;

/**
 * @author JF LARTAUD
 *
 */
public class ForgeTechnicalComponentServiceImpl extends AbstractBaseEntityService<TechnicalComponent, Long> implements
		ForgeTechnicalComponentService {
	
	private ForgeTechnicalComponentRepository forgeTechnicalComponentRepository;


	/* (non-Javadoc)
	 * @see com.jeet.core.service.impl.AbstractBaseEntityService#getCrudRepository()
	 */
	@Override
	public CrudRepository<TechnicalComponent, Long> getCrudRepository() {
		return forgeTechnicalComponentRepository;
	}
	
	/**
	 * @return the forgeTechnicalComponentRepository
	 */
	public ForgeTechnicalComponentRepository getForgeTechnicalComponentRepository() {
		return forgeTechnicalComponentRepository;
	}
	
	/**
	 * @param forgeTechnicalComponentRepository the forgeTechnicalComponentRepository to set
	 */
	public void setForgeTechnicalComponentRepository(ForgeTechnicalComponentRepository forgeTechnicalComponentRepository) {
		this.forgeTechnicalComponentRepository = forgeTechnicalComponentRepository;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * com.jeet.hub.forge.service.api.forge.project.ForgeTechnicalComponentService#findParentComponent(java.lang.Long)
	 */
	@Override
	public TechnicalComponent findParentComponent(Long id) {
		return forgeTechnicalComponentRepository.findParentComponent(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.ForgeTechnicalComponentService#findByKey(java.lang.String)
	 */
	@Override
	public TechnicalComponent findByKey(String key) {
		return forgeTechnicalComponentRepository.findByKey(key);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.jeet.hub.forge.service.api.forge.project.ForgeTechnicalComponentService#buildPathFromKey(java.lang.String,
	 * java.lang.Long)
	 */
	@Override
	public String buildPathFromKey(String key) {
		String path = "";
		TechnicalComponent module = findByKey(key);
		if (module != null) {
			int indexOf = module.getKey().indexOf(":");
			if (indexOf > 0) {
				path = module.getKey().substring(indexOf + 1);
			} else {
				if (module instanceof ForgeProject) {
					path = ((ForgeProject) module).getTechnicalName();
				} else {
					path = module.getName();
				}
			}
			TechnicalComponent parentComponent = findParentComponent(module.getId());
			if (parentComponent != null) {
				path = buildPathFromKey(parentComponent.getKey()) + "/" + path;
			}
		}
		return path;
	}

}
