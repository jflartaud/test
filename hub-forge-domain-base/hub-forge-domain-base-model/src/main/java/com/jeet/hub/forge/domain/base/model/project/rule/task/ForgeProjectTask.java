/**
* @(#) ProjectTask.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 26 nov. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project.rule.task;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jeet.domain.base.model.AbstractBaseSequenceIdJeetObject;
import com.jeet.hub.forge.domain.base.model.project.ITask;
import com.jeet.hub.forge.domain.base.model.project.rule.ForgeProjectRule;

/**
 * Define a task applied to a project rule
 * 
 * @author JF LARTAUD
 */
@Entity
@Table(name = "t_hub_prj_task")
@SequenceGenerator(name = "s_hub_prj_task", sequenceName = "s_hub_prj_task", allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "subclass_disc")
public abstract class ForgeProjectTask extends AbstractBaseSequenceIdJeetObject implements ITask {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3880699484476532526L;
	
	/**
	 * Identifier
	 */
	private Long id;
	
	/**
	 * Owning rule
	 */
	private ForgeProjectRule rule;

	/* (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#getId()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "s_hub_prj_task")
	public Long getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the rule
	 */
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "task")
	public ForgeProjectRule getRule() {
		return rule;
	}
	
	/**
	 * @param rule the rule to set
	 */
	public void setRule(ForgeProjectRule rule) {
		this.rule = rule;
	}
	
}
