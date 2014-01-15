/**
* @(#) ForgeProjectServiceImpl.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 2 mai 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.jeet.domain.base.service.impl.AbstractBaseEntityService;
import com.jeet.hub.forge.domain.base.model.ForgeInstance;
import com.jeet.hub.forge.domain.base.model.project.ForgeProject;
import com.jeet.hub.forge.domain.base.model.project.version.ForgeProjectVersion;
import com.jeet.hub.forge.domain.base.service.api.ForgeInstanceService;
import com.jeet.hub.forge.domain.base.service.api.project.ForgeProjectService;
import com.jeet.hub.forge.domain.base.service.api.project.exception.NotUniqueForgeProjectNameException;
import com.jeet.hub.forge.domain.base.service.api.project.exception.NotUniqueProjectTechNameException;
import com.jeet.hub.forge.domain.base.service.api.project.version.ForgeProjectVersionService;
import com.jeet.hub.forge.domain.base.service.impl.project.repository.ForgeProjectRepository;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

/**
 * Entity service implementation for {@link ForgeProject}
 * 
 * @author JF LARTAUD
 */
public class ForgeProjectServiceImpl extends AbstractBaseEntityService<ForgeProject, Long> implements
        ForgeProjectService {
	
	private ForgeProjectRepository forgeProjectRepository;
	
	private ForgeInstanceService forgeInstanceService;
	
	private ForgeProjectVersionService forgeProjectVersionService;

	/* (non-Javadoc)
	 * @see com.jeet.core.service.impl.AbstractBaseEntityService#getCrudRepository()
	 */
	@Override
	public CrudRepository<ForgeProject, Long> getCrudRepository() {
		return forgeProjectRepository;
	}
	
	/**
	 * @return the forgeProjectRepository
	 */
	public ForgeProjectRepository getForgeProjectRepository() {
		return forgeProjectRepository;
	}
	
	/**
	 * @param forgeProjectRepository the forgeProjectRepository to set
	 */
	public void setForgeProjectRepository(ForgeProjectRepository forgeProjectRepository) {
		this.forgeProjectRepository = forgeProjectRepository;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.ForgeProjectService#findByTechnicalName(java.lang.String)
	 */
	@Override
	public ForgeProject findByTechnicalName(String technicalName) {
		return forgeProjectRepository.findByTechnicalName(technicalName);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.ForgeProjectService#existByName(java.lang.String)
	 */
	@Override
	public boolean existByName(String name, Long forgeInstanceId) {
		return forgeProjectRepository.countByName(name, forgeInstanceId) > 0L;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.ForgeProjectService#existByTechnicalName(java.lang.String)
	 */
	@Override
	public boolean existByTechnicalName(String technicalName, Long forgeInstanceId) {
		return forgeProjectRepository.countByTechnicalName(technicalName, forgeInstanceId) > 0L;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.ForgeProjectService#findAllByForgeInstance(java.lang.Long,
	 * com.sencha.gxt.data.shared.loader.PagingLoadConfig)
	 */
	@Override
	public PagingLoadResult<ForgeProject> findAllByForgeInstance(Long forgeInstanceId, PagingLoadConfig pagingLoadConfig) {
		Pageable pageable = convertPagingLoadConfig(pagingLoadConfig);
		if (pageable != null) {
			Page<ForgeProject> page = forgeProjectRepository.findAllByForgeInstance(forgeInstanceId, pageable);
			return convertPage(page, pagingLoadConfig);
		} else {
			return convertPage(null, pagingLoadConfig);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * com.jeet.hub.forge.service.api.forge.project.ForgeProjectService#createForgeProject(com.jeet.hub.forge.domainmodel
	 * .forge.project.ForgeProject, java.lang.Long)
	 */
	@Override
	public ForgeProject createForgeProject(ForgeProject project, Long forgeInstanceId)
			throws NotUniqueForgeProjectNameException, NotUniqueProjectTechNameException {
		if (existByName(project.getName(), forgeInstanceId)) {
			throw new NotUniqueForgeProjectNameException();
		} else if (existByTechnicalName(project.getTechnicalName(), forgeInstanceId)) {
			throw new NotUniqueProjectTechNameException();
		}
		ForgeInstance instance = forgeInstanceService.findOne(forgeInstanceId);
		project.setInstance(instance);
		return save(project);
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * com.jeet.hub.forge.service.api.forge.project.ForgeProjectService#updateForgeProject(com.jeet.hub.forge.domainmodel
	 * .forge.project.ForgeProject)
	 */
	@Override
	public ForgeProject updateForgeProjectName(Long projectId, String name) throws NotUniqueForgeProjectNameException {
		ForgeProject p = findOne(projectId);
		if (p.getName().equalsIgnoreCase(name) == false) {
			if (existByName(name, p.getInstance().getId())) {
				throw new NotUniqueForgeProjectNameException();
			}
			p.setName(name);
			return save(p);
		}
		return p;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.ForgeProjectService#deleteForgeProject(java.lang.Long)
	 */
	@Override
	public void deleteForgeProject(Long forgeProjectId) {
		ForgeProject project = findOne(forgeProjectId);
		project.setDeleted(Boolean.TRUE);
		save(project);
	}
	
	/**
	 * @return the forgeInstanceService
	 */
	public ForgeInstanceService getForgeInstanceService() {
		return forgeInstanceService;
	}
	
	/**
	 * @param forgeInstanceService the forgeInstanceService to set
	 */
	public void setForgeInstanceService(ForgeInstanceService forgeInstanceService) {
		this.forgeInstanceService = forgeInstanceService;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.service.api.forge.project.ForgeProjectService#updateMasterVersion(java.lang.Long)
	 */
	@Override
	public ForgeProject updateMasterVersion(Long projectId) {
		ForgeProject project = findOne(projectId);
		
		ForgeProjectVersion master = forgeProjectVersionService.findMasterForgeProjectVersion(projectId);
		if (master != null) {
			project.setMasterVersion(master);
			project = save(project);
		}
		return project;
	}
	
	/**
	 * @return the forgeProjectVersionService
	 */
	public ForgeProjectVersionService getForgeProjectVersionService() {
		return forgeProjectVersionService;
	}
	
	/**
	 * @param forgeProjectVersionService the forgeProjectVersionService to set
	 */
	public void setForgeProjectVersionService(ForgeProjectVersionService forgeProjectVersionService) {
		this.forgeProjectVersionService = forgeProjectVersionService;
	}
}
