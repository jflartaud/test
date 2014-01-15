/**
* @(#) NotUniqueForgeProjectTechnicalNameException.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 22 août 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.api.project.exception;


import com.jeet.domain.base.service.api.exception.FunctionalException;

/**
 * Exception thrown if a forge project technical name already exists within a forge instance
 *  * @author JF LARTAUD
 *
 */
public class NotUniqueProjectTechNameException extends FunctionalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5693228572943491797L;
	
	/**
	 * @param errorCode
	 */
	public NotUniqueProjectTechNameException() {
		super(FunctionalExceptionCodes.UNIQUE_PROJECT_TECHNICAL_NAME_EXCEPTION);
	}
	
}
