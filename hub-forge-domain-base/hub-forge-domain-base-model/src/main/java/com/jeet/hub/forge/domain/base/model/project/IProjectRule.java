/**
* @(#) IProjectRule.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 20 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project;

import com.jeet.domain.base.model.JeetObject;

/**
 * Define a rule for a project
 * 
 * @author JF LARTAUD
 */
public interface IProjectRule extends JeetObject {

	
	/**
	 * Defines if the rule is deleted
	 * 
	 * @return
	 */
	Boolean getDeleted();

}
