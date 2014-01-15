/**
 * @(#) CodeItemActionType.java - Jeet Hub Forge
 *
 * Copyright 2013 - JeetConsulting
 *
 * Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
 * Auteur : JeetConsulting
 * Créé le : 11 juin 2013
 * Contact : http://jeet-consulting.com/
 *
 */

package com.jeet.hub.forge.domain.base.model.project.item;


/**
 * Defines the kind of actions made on a {@link ForgeProjectCodeActivityItem}
 * 
 * @author JF LARTAUD
 */
public enum CodeItemActionType {
	
	/**
	 * Added
	 */
	ADD,
	/**
	 * Updated
	 */
	UPDATED,
	/**
	 * Deleted
	 */
	DELETE,
	/**
	 * No action (this is often the case of directories)
	 */
	NONE
}
