/**
* @(#) ProjectRule.java - Jeet Hub Forge
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

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jeet.domain.base.model.AbstractBaseSequenceIdJeetObject;
import com.jeet.hub.forge.domain.base.model.project.ForgeProject;
import com.jeet.hub.forge.domain.base.model.project.IProjectRule;
import com.jeet.hub.forge.domain.base.model.project.rule.task.ForgeProjectTask;

/**
 * Define a project rule
 * 
 * @author JF LARTAUD
 */
@Entity
@Table(name = "t_hub_prj_rule")
@SequenceGenerator(name = "s_hub_prj_rule", sequenceName = "s_hub_prj_rule", allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "subclass_disc")
public abstract class ForgeProjectRule extends AbstractBaseSequenceIdJeetObject implements IProjectRule {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8053336433731987767L;

	private Long id;
	
	/**
	 * Project on which the rule is applied
	 */
	private ForgeProject project;
	
	/**
	 * Task applied
	 */
	private ForgeProjectTask task;

	/**
	 * Define the rule as deleted
	 */
	private Boolean deleted = Boolean.FALSE;
	
	/**
	 * Define the rule as hidden
	 */
	private Boolean hidden = Boolean.FALSE;
	
	/**
	 * Test if the rule should match or not.
	 */
	private Boolean matched;

	/* (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#getId()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "s_hub_prj_rule")
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
	 * @return the project
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	public ForgeProject getProject() {
		return project;
	}
	
	/**
	 * @param project the project to set
	 */
	public void setProject(ForgeProject project) {
		this.project = project;
	}
	
	/**
	 * @return the task
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "TASK_ID")
	public ForgeProjectTask getTask() {
		return task;
	}
	
	/**
	 * @param task the task to set
	 */
	public void setTask(ForgeProjectTask task) {
		this.task = task;
	}
	
	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}
	
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	/**
	 * @return the matched
	 */
	public Boolean getMatched() {
		return matched;
	}
	
	/**
	 * @param matched the matched to set
	 */
	public void setMatched(Boolean matched) {
		this.matched = matched;
	}
	
	/**
	 * @return the hidden
	 */
	public Boolean getHidden() {
		return hidden;
	}
	
	/**
	 * @param hidden the hidden to set
	 */
	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}
}
