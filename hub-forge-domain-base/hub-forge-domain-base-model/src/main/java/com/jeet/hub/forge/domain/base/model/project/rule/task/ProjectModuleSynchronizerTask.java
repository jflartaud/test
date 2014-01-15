/**
* @(#) ForgeProjectModuleSynchronizerTask.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 26 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project.rule.task;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author JF LARTAUD
 *
 */
@Entity
@DiscriminatorValue("ProjectModuleSynchronizerTask")
public class ProjectModuleSynchronizerTask extends ForgeProjectTask {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4255601183034430674L;
	
}
