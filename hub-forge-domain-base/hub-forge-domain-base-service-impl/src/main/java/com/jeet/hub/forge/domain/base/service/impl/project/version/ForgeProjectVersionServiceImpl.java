/**
* @(#) ForgeProjectVersionServiceImpl.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 10 oct. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project.version;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeet.domain.base.service.impl.AbstractBaseEntityService;
import com.jeet.hub.forge.domain.base.model.project.version.ForgeProjectVersion;
import com.jeet.hub.forge.domain.base.service.api.project.version.ForgeProjectVersionService;
import com.jeet.hub.forge.domain.base.service.impl.project.version.repository.ForgeProjectVersionRepository;

/**
 * @author JF LARTAUD
 *
 */
public class ForgeProjectVersionServiceImpl extends AbstractBaseEntityService<ForgeProjectVersion, Long> implements
		ForgeProjectVersionService {
	
	private ForgeProjectVersionRepository forgeProjectVersionRepository;
	
	/* (non-Javadoc)
	 * @see com.jeet.core.service.impl.AbstractBaseEntityService#getCrudRepository()
	 */
	@Override
	public CrudRepository<ForgeProjectVersion, Long> getCrudRepository() {
		return forgeProjectVersionRepository;
	}
	
	/**
	 * @return the forgeProjectVersionRepository
	 */
	public ForgeProjectVersionRepository getForgeProjectVersionRepository() {
		return forgeProjectVersionRepository;
	}
	
	/**
	 * @param forgeProjectVersionRepository the forgeProjectVersionRepository to set
	 */
	public void setForgeProjectVersionRepository(ForgeProjectVersionRepository forgeProjectVersionRepository) {
		this.forgeProjectVersionRepository = forgeProjectVersionRepository;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * com.jeet.hub.forge.service.api.forge.project.version.ForgeProjectVersionService#findForgeProjectVersion(java.
	 * lang.Long, java.lang.String)
	 */
	@Override
	public ForgeProjectVersion findForgeProjectVersion(Long projectId, String completeName) {
		return forgeProjectVersionRepository.findForgeProjectVersion(projectId, completeName);
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * com.jeet.hub.forge.service.api.forge.project.version.ForgeProjectVersionService#findAllPreviousVersions(java.
	 * lang.Long)
	 */
	@Override
	public List<ForgeProjectVersion> findAllPreviousVersions(Long forgeProjectVersionId) {
		List<ForgeProjectVersion> versions = new ArrayList<ForgeProjectVersion>();
		ForgeProjectVersion version = findOne(forgeProjectVersionId);
		while (version.getPreviousVersion() != null) {
			versions.add(version);
			version = version.getPreviousVersion();
		}
		return versions;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * com.jeet.hub.forge.service.api.forge.project.version.ForgeProjectVersionService#findMasterForgeProjectVersion
	 * (java.lang.Long)
	 */
	@Override
	public ForgeProjectVersion findMasterForgeProjectVersion(Long projectId) {
		return forgeProjectVersionRepository.findMasterForgeProjectVersion(projectId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.jeet.hub.forge.service.api.forge.project.version.ForgeProjectVersionService#findAllByForgeProject(java.lang
	 * .Long)
	 */
	@Override
	public List<ForgeProjectVersion> findAllByForgeProject(Long projectId) {
		return forgeProjectVersionRepository.findAllByForgeProject(projectId);
	}

}
