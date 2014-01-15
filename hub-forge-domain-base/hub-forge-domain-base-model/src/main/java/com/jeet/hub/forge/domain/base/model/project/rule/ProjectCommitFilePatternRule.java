/**
* @(#) ProjectCommitFilePatternRule.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 26 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project.rule;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.jeet.hub.forge.domain.base.model.project.item.CodeActivityPackStatus;
import com.jeet.hub.forge.domain.base.model.project.item.ForgeProjectCodeActivityPack;

/**
 * Rule that check a commited file. This rule is applied when the status of a pack {@link ForgeProjectCodeActivityPack}
 * change to {@link CodeActivityPackStatus#COMMITED}
 * 
 * @author JF LARTAUD
 */
@Entity
@DiscriminatorValue("ProjectCommitFilePatternRule")
public class ProjectCommitFilePatternRule extends ForgeProjectRule {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1987270622883507223L;
	
	/**
	 * File pattern
	 */
	private String pattern;

	/**
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}
	
	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
