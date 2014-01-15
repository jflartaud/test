/**
* @(#) ItemUniqueIdentifierRepository.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 26 sept. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project.item.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;

import com.jeet.domain.base.service.repository.jpa.JeetRepository;
import com.jeet.hub.forge.domain.base.model.project.item.ItemUniqueIdentifier;

/**
 * @author JF LARTAUD
 *
 */
public interface ItemUniqueIdentifierRepository extends JeetRepository<ItemUniqueIdentifier, Long> {
	
	/**
	 * Find an item unique identifier by the path of its code activity item and the project.
	 * 
	 * @param path
	 * @param projectVersionId
	 * @param maxDate
	 * @return
	 */
	@Query("select c.itemIdentifier from ForgeProjectCodeActivityItem c where c.id = (select max(item.id) from ForgeProjectCodeActivityItem item join item.pack pack join pack.projectVersion version where item.path like (?1) and pack.status=com.jeet.hub.forge.domain.base.model.project.item.CodeActivityPackStatus.COMMITED and version.id = (?2) and item.versionDate <= (?3) and item.action in (com.jeet.hub.forge.domain.base.model.project.item.CodeItemActionType.ADD, com.jeet.hub.forge.domain.base.model.project.item.CodeItemActionType.UPDATED))")
	ItemUniqueIdentifier findByPathAndProjectVersionId(String path, Long projectVersionId, Date maxDate);

}
