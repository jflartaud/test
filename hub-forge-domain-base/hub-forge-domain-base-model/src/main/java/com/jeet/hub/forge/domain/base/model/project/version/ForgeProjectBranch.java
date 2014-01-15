/**
* @(#) ForgeProjectBranch.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 10 oct. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project.version;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Defines a branch within the forge projects
 * 
 * @author JF LARTAUD
 */
@Entity
@DiscriminatorValue("ForgeProjectBranch")
public class ForgeProjectBranch extends ForgeProjectVersion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3934142231767571923L;
	
}
