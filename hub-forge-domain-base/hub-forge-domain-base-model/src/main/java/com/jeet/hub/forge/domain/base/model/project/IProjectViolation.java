/**
* @(#) IProjectViolation.java - Jeet Hub Forge
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
 * Define a violation for a project
 * 
 * @author JF LARTAUD
 */
public interface IProjectViolation extends JeetObject {
	
	/**
	 * Get the message of the violation
	 */
	String getMessage();

}
