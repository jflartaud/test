/**
* @(#) ProjectCommitFilePatternRuleResut.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 27 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project.rule.result;

import com.jeet.hub.forge.domain.base.model.project.rule.ProjectCommitFilePatternRule;

/**
 * Result of the execution of a {@link ProjectCommitFilePatternRule}
 * 
 * @author JF LARTAUD
 */
public class ProjectCommitFilePatternRuleResut extends ForgeProjectRuleResult<ProjectCommitFilePatternRule> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4328162146691160077L;
	
	/**
	 * 
	 */
	public ProjectCommitFilePatternRuleResut() {
		super();
	}
	
	/**
	 * @param rule
	 * @param matched
	 */
	public ProjectCommitFilePatternRuleResut(ProjectCommitFilePatternRule rule, boolean matched) {
		super(rule, matched);
	}
	
}
