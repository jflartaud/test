/**
* @(#) ResourceConverter.java - Jeet Hub Forge
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

import org.osgi.service.blueprint.container.Converter;
import org.osgi.service.blueprint.container.ReifiedType;

/**
 * @author JF LARTAUD
 *
 */
public class ResourceConverter implements Converter {
	
	private static final String CLASSPATH_PREFIX = "classpath";

	/*
	 * (non-Javadoc)
	 * @see org.osgi.service.blueprint.container.Converter#canConvert(java.lang.Object,
	 * org.osgi.service.blueprint.container.ReifiedType)
	 */
	@Override
	public boolean canConvert(Object sourceObject, ReifiedType targetType) {
		if (String.class.isInstance(sourceObject) && sourceObject != null
				&& ((String) sourceObject).startsWith(CLASSPATH_PREFIX)) {
			return true;
		}
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.service.blueprint.container.Converter#convert(java.lang.Object,
	 * org.osgi.service.blueprint.container.ReifiedType)
	 */
	@Override
	public Object convert(Object sourceObject, ReifiedType targetType) throws Exception {
		Resource resource = null;
		String stringObject = (String)sourceObject;
		if (stringObject.startsWith(CLASSPATH_PREFIX)) {
			String path = stringObject.substring(stringObject.indexOf(":")+1);
			resource = new BundleClassPathResource(path);
		}
		return resource;
	}
	
}
