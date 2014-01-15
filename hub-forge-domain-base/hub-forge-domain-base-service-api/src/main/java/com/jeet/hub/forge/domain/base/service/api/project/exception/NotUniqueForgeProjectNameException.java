/**
* @(#) NotUniqueForgeProjectNameException.java - Jeet Hub Forge
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
import com.jeet.hub.forge.domain.base.service.api.project.exception.FunctionalExceptionCodes;

/**
 * Exception thrown if a forge project name already exists within a forge instance
 * 
 * @author JF LARTAUD
 */
public class NotUniqueForgeProjectNameException extends FunctionalException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8052207110653261069L;
	
	/**
	 * @param errorCode
	 */
	public NotUniqueForgeProjectNameException() {
		super(FunctionalExceptionCodes.UNIQUE_PROJECT_NAME_EXCEPTION);
	}
	
}
