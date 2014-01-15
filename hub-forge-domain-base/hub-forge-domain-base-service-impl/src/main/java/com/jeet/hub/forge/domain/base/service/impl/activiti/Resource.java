/**
* @(#) Resource.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 20 déc. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.activiti;

import java.io.InputStream;
import java.net.URL;

/**
 * @author JF LARTAUD
 *
 */
public interface Resource {
	
	/**
	 * Check if the resource exists
	 * 
	 * @return
	 */
	boolean exists();
	
	/**
	 * Retrieve an input stream
	 */
	InputStream getInputStream();

	/**
	 * Retrieve the url
	 * 
	 * @return
	 */
	URL getURL();
	
	/**
	 * Retrieve the resource name
	 */
	String getResourceName();


}
