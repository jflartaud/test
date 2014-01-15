/**
* @(#) ForgeProjectRuleResut.java - Jeet Hub Forge
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

import com.jeet.domain.base.model.AbstractBaseJeetObject;
import com.jeet.hub.forge.domain.base.model.project.rule.ForgeProjectRule;

/**
 * Defines the result of the execution of a {@link ForgeProjectRule}.<br/>
 * For now it is not persisted.
 * 
 * @author JF LARTAUD
 */
public abstract class ForgeProjectRuleResult<T extends ForgeProjectRule> extends AbstractBaseJeetObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7089008245361385257L;
	
	/**
	 * The rule
	 */
	private T rule;
	
	/**
	 * Define is the rule has matched or not.
	 */
	private boolean matched = false;
	
	public ForgeProjectRuleResult() {
		super();
	}
	
	/**
	 * @param rule
	 * @param matched
	 */
	public ForgeProjectRuleResult(T rule, boolean matched) {
		super();
		this.rule = rule;
		this.matched = matched;
	}

	/**
	 * @return the rule
	 */
	public T getRule() {
		return rule;
	}
	
	/**
	 * @param rule the rule to set
	 */
	public void setRule(T rule) {
		this.rule = rule;
	}
	
	/**
	 * @return the matched
	 */
	public boolean isMatched() {
		return matched;
	}
	
	/**
	 * @param matched the matched to set
	 */
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
	
}
