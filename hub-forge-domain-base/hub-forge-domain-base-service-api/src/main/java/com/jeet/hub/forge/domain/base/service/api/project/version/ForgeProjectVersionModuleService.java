/**
* @(#) ForgeProjectVersionModuleService.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 4 déc. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.api.project.version;

import org.springframework.transaction.annotation.Transactional;

import com.jeet.domain.base.service.api.MetaService;
import com.jeet.hub.forge.domain.base.model.project.version.ForgeProjectVersion;

/**
 * Service to manage the modules on a {@link ForgeProjectVersion}
 * 
 * @author JF LARTAUD
 */
public interface ForgeProjectVersionModuleService extends MetaService {
	
	/**
	 * Synchronize the modules between a version and its previous version
	 * 
	 * @param version
	 * @param previousVersion
	 */
	@Transactional
	void synchronizeModules(ForgeProjectVersion version, ForgeProjectVersion previousVersion);

}
