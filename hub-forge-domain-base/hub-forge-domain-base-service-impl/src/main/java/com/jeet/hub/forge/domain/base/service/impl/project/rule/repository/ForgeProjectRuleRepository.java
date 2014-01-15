/**
* @(#) ForgeProjectRuleRepository.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 29 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project.rule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.jeet.domain.base.service.repository.jpa.JeetRepository;
import com.jeet.hub.forge.domain.base.model.project.rule.ForgeProjectRule;

/**
 * @author JF LARTAUD
 *
 */
public interface ForgeProjectRuleRepository extends JeetRepository<ForgeProjectRule, Long> {
	
	/**
	 * Find all the rules for a specific project that are not deleted
	 * 
	 * @param projectId
	 * @return
	 */
	@Query("select r from ForgeProjectRule r join r.project p where p.id = (?1) and r.deleted = false")
	List<ForgeProjectRule> findByProjectId(Long projectId);
	
	/**
	 * Find all the rules a specific that are not deleted and not hidden.
	 * 
	 * @param projectId
	 * @return
	 */
	@Query("select r from ForgeProjectRule r join r.project p where p.id = (?1) and r.deleted = false and r.hidden = false")
	List<ForgeProjectRule> findByProjectIdAndVisible(Long projectId);
	
}
