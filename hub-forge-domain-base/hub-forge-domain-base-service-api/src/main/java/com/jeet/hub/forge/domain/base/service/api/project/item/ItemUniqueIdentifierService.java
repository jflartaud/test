/**
* @(#) CC.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 26 sept. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.api.project.item;

import java.util.Date;

import com.jeet.domain.base.service.api.EntityService;
import com.jeet.hub.forge.domain.base.model.project.item.ItemUniqueIdentifier;

/**
 * @author JF LARTAUD
 *
 */
public interface ItemUniqueIdentifierService extends EntityService<ItemUniqueIdentifier, Long> {
	
	/**
	 * Find by path and project version
	 * 
	 * @param path
	 * @param projectVersionId
	 * @return
	 */
	ItemUniqueIdentifier findByPathAndProjectVersion(String path, Long projectVersionId, Date maxDate);
}
