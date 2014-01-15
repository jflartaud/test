/**
* @(#) BundleClassPathResource.java - Jeet Hub Forge
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
public class BundleClassPathResource implements Resource {
	
	private final String path;
	
	private ClassLoader classLoader;

	public BundleClassPathResource(String path) {
		this(path, null);
	}
	
	public BundleClassPathResource(String path, ClassLoader classLoader) {
		this.path = path;
		this.classLoader = classLoader;
	}

	/* (non-Javadoc)
	 * @see com.jeet.hub.forge.domain.base.service.impl.activiti.Resource#exists()
	 */
	@Override
	public boolean exists() {
		return getInputStream() != null;
	}
	
	/* (non-Javadoc)
	 * @see com.jeet.hub.forge.domain.base.service.impl.activiti.Resource#getInputStream()
	 */
	@Override
	public InputStream getInputStream() {
		return getClassLoader().getResourceAsStream(path);
	}
	
	/* (non-Javadoc)
	 * @see com.jeet.hub.forge.domain.base.service.impl.activiti.Resource#getResourceName()
	 */
	@Override
	public String getResourceName() {
		return getURL().getFile();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.domain.base.service.impl.activiti.Resource#getURL()
	 */
	@Override
	public URL getURL() {
		return getClassLoader().getResource(path);
	}

	/**
	 * Return the ClassLoader that this resource will be obtained from.
	 */
	public final ClassLoader getClassLoader() {
		return (this.classLoader != null ? this.classLoader : getClass().getClassLoader());
	}

}
