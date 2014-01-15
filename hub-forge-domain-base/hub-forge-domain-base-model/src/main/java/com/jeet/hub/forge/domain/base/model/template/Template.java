package com.jeet.hub.forge.domain.base.model.template;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.jeet.domain.base.model.AbstractBaseSequenceIdJeetObject;
import com.jeet.hub.forge.domain.base.model.configuration.Configuration;

/**
 * 
 * @author Sebastien
 * 
 */
@Entity
@Table(name = "t_hub_forge_template", uniqueConstraints = @UniqueConstraint(columnNames = {
		"rootTemplate_Id", "key" }))
@javax.persistence.SequenceGenerator(name = "s_hub_forge_template", sequenceName = "s_hub_forge_template", allocationSize = 1)
public class Template extends AbstractBaseSequenceIdJeetObject {
	/**
	 * Identifer
	 */
	private Long id;

	/**
	 * 
	 */
	private HashSet<Template> templates;

	/**
	 * 
	 */
	private HashSet<Template> parent;

	/**
	 * 
	 */
	private String key;

	/**
	 * 
	 */
	private Configuration configuration;

	/**
	 * 
	 */
	private Template rootTemplate;

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#getId()
	 */
	@Override
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "s_hub_forge_item_template")
	public Long getId() {
		return id;
	}

	/**
	 * @return the templates
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	public HashSet<Template> getTemplates() {
		return templates;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#setId(java
	 * .lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param templates
	 *            the templates to set
	 */
	public void setTemplates(HashSet<Template> templates) {
		this.templates = templates;
	}

	/**
	 * @return the parent
	 */
	@ManyToOne
	public HashSet<Template> getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(HashSet<Template> parent) {
		this.parent = parent;
	}

	/**
	 * @return the rootTemplate
	 */
	@ManyToOne
	public Template getRootTemplate() {
		return rootTemplate;
	}

	/**
	 * @param rootTemplate
	 *            the rootTemplate to set
	 */
	public void setRootTemplate(Template rootTemplate) {
		this.rootTemplate = rootTemplate;
	}

}
