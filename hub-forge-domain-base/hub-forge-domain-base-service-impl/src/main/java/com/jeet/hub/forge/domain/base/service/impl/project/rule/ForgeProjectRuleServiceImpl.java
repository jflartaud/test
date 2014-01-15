/**
* @(#) ForgeProjectRuleServiceImpl.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 29 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project.rule;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeet.domain.base.service.impl.AbstractBaseEntityService;
import com.jeet.hub.forge.domain.base.model.project.rule.ForgeProjectRule;
import com.jeet.hub.forge.domain.base.service.api.project.rule.ForgeProjectRuleService;
import com.jeet.hub.forge.domain.base.service.impl.project.rule.repository.ForgeProjectRuleRepository;

/**
 * @author JF LARTAUD
 *
 */
public class ForgeProjectRuleServiceImpl extends AbstractBaseEntityService<ForgeProjectRule, Long> implements
		ForgeProjectRuleService {
	
	private ForgeProjectRuleRepository forgeProjectRuleRepository;

	/* (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.rule.ForgeProjectRuleService#findByProjectId(java.lang.Long)
	 */
	@Override
	public List<ForgeProjectRule> findByProjectId(Long projectId) {
		return forgeProjectRuleRepository.findByProjectId(projectId);
	}
	
	/* (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.rule.ForgeProjectRuleService#findByProjectIdAndVisible(java.lang.Long)
	 */
	@Override
	public List<ForgeProjectRule> findByProjectIdAndVisible(Long projectId) {
		return forgeProjectRuleRepository.findByProjectIdAndVisible(projectId);
	}
	
	/* (non-Javadoc)
	 * @see com.jeet.core.service.impl.AbstractBaseEntityService#getCrudRepository()
	 */
	@Override
	public CrudRepository<ForgeProjectRule, Long> getCrudRepository() {
		return forgeProjectRuleRepository;
	}
	
	/**
	 * @return the forgeProjectRuleRepository
	 */
	public ForgeProjectRuleRepository getForgeProjectRuleRepository() {
		return forgeProjectRuleRepository;
	}
	
	/**
	 * @param forgeProjectRuleRepository the forgeProjectRuleRepository to set
	 */
	public void setForgeProjectRuleRepository(ForgeProjectRuleRepository forgeProjectRuleRepository) {
		this.forgeProjectRuleRepository = forgeProjectRuleRepository;
	}
	

}
