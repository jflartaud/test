/**
* @(#) ForgeProjectTag.java - Jeet Hub Forge
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
 * 
 * @author JF LARTAUD
 *
 */
@Entity
@DiscriminatorValue("ForgeProjectTag")
public class ForgeProjectTag extends ForgeProjectVersion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8936086198265219303L;
	
}
