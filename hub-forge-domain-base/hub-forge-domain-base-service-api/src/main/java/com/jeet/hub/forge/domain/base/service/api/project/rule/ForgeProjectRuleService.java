/**
* @(#) ForgeProjectRuleService.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 29 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.api.project.rule;

import java.util.List;

import com.jeet.domain.base.service.api.EntityService;
import com.jeet.hub.forge.domain.base.model.project.rule.ForgeProjectRule;

/**
 * @author JF LARTAUD
 *
 */
public interface ForgeProjectRuleService extends EntityService<ForgeProjectRule, Long> {
	
	/**
	 * Find all the rules for a specific project that are not deleted
	 * 
	 * @param projectId
	 * @return
	 */
	List<ForgeProjectRule> findByProjectId(Long projectId);
	
	/**
	 * Find all the rules a specific that are not deleted and not hidden.
	 * 
	 * @param projectId
	 * @return
	 */
	List<ForgeProjectRule> findByProjectIdAndVisible(Long projectId);

}
