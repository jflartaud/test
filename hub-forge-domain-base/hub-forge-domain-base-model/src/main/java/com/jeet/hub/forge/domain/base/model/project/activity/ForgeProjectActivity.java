/**
* @(#) ForgeProjectActivity.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 19 août 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.model.project.activity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jeet.domain.base.model.AbstractBaseSequenceIdJeetObject;
import com.jeet.domain.party.model.party.Party;
import com.jeet.hub.forge.domain.base.model.project.version.ForgeProjectVersion;


@Entity
@Table(name = "t_hub_prj_activity")
@SequenceGenerator(name = "s_hub_prj_activity", sequenceName = "s_hub_prj_activity", allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "activity")
@DiscriminatorValue("activity")
public class ForgeProjectActivity extends AbstractBaseSequenceIdJeetObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4880157592439373195L;
	
	/**
	 * Identifier
	 */
	private Long id;
	
	/**
	 * Date of action.<br/>
	 * For period activities (with start and end date), the action date represent the end date.
	 */
	private Date actionDate;
	
	/**
	 * Project version on which the activity is about.
	 */
	private ForgeProjectVersion projectVersion;
	
	/**
	 * Activity discriminator
	 */
	private String activity;
	
	/**
	 * Party (is the assignee)
	 */
	private Party party;
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#getId()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "s_hub_prj_activity")
	public Long getId() {
		return id;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.core.domainmodel.AbstractBaseSequenceIdJeetObject#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the actionDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getActionDate() {
		return actionDate;
	}
	
	/**
	 * @param actionDate the actionDate to set
	 */
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	
	/**
	 * @return the projectVersion
	 */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "PROJECT_VERSION_ID")
	public ForgeProjectVersion getProjectVersion() {
		return projectVersion;
	}
	
	/**
	 * @param projectVersion the projectVersion to set
	 */
	public void setProjectVersion(ForgeProjectVersion projectVersion) {
		this.projectVersion = projectVersion;
	}

	/**
	 * @return the activity
	 */
	@Column(insertable = false, updatable = false, nullable = false)
	public String getActivity() {
		return activity;
	}
	
	/**
	 * @param activity the activity to set
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	/**
	 * @return the party
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARTY_ID")
	public Party getParty() {
		return party;
	}
	
	/**
	 * @param party the party to set
	 */
	public void setParty(Party party) {
		this.party = party;
	}
	
}
