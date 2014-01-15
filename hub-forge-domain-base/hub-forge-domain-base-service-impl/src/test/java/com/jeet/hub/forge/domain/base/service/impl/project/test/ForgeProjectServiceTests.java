/**
* @(#) ForgeProjectServiceTests.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 2 juil. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.project.test;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import com.jeet.domain.base.test.unit.AbstractBaseTest;
import com.jeet.domain.base.test.unit.DomainOption;
import com.jeet.hub.forge.domain.base.model.ForgeInstance;
import com.jeet.hub.forge.domain.base.model.project.ForgeProject;
import com.jeet.hub.forge.domain.base.service.api.ForgeInstanceService;
import com.jeet.hub.forge.domain.base.service.api.project.ForgeProjectService;
import com.jeet.hub.forge.domain.base.service.api.project.exception.NotUniqueForgeProjectNameException;
import com.jeet.hub.forge.domain.base.service.api.project.exception.NotUniqueProjectTechNameException;
import com.sencha.gxt.data.shared.loader.PagingLoadConfigBean;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

/**
 * @author JF LARTAUD
 *
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class ForgeProjectServiceTests extends AbstractBaseTest {

	@Inject
	private ForgeProjectService forgeProjectService;
	
	@Inject
	private ForgeInstanceService forgeInstanceService;

	/*
	 * (non-Javadoc)
	 * @see com.jeet.domain.base.test.unit.AbstractBaseTest#getDomainOptions()
	 */
	@Override
	protected Option[] getDomainOptions() {
		return new Option[] {
				new DomainOption("com.jeet.domain", "base", "1.0.0-SNAPSHOT", "jeet-domain-base-feature",
						"jeet-domain-base-test-feature"),
				// new DomainOption("com.jeet.domain", "party", "1.0.0-SNAPSHOT", "jeet-domain-party-security-feature"),
				// new DomainOption("com.jeet.domain", "party", "1.0.0-SNAPSHOT", "jeet-domain-party-feature"),
				new DomainOption("com.jeet.hub.forge.domain", "base", "1.0.0-SNAPSHOT",
						"jeet-hub-forge-domain-base-test-feature") };
	}

	@Test
	public void testFindByTechnicalName() {
		ForgeProject project = new ForgeProject();
		project.setName("My Project");
		project.setTechnicalName("my_project");
		
		ForgeProject expected = forgeProjectService.save(project);
		
		ForgeProject result = forgeProjectService.findByTechnicalName("my_project");
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void testFindAllByForgeInstance() {
		ForgeInstance forgeInstance = new ForgeInstance();
		forgeInstance = forgeInstanceService.save(forgeInstance);
		
		ForgeProject project = new ForgeProject();
		project.setName("My Project");
		project.setTechnicalName("my_project");
		project.setInstance(forgeInstance);
		project = forgeProjectService.save(project);
		
		project = new ForgeProject();
		project.setName("My Project2");
		project.setTechnicalName("my_project2");
		project.setInstance(forgeInstance);
		project = forgeProjectService.save(project);
		
		project = new ForgeProject();
		project.setName("My Project3");
		project.setTechnicalName("my_project3");
		project = forgeProjectService.save(project);
		
		PagingLoadResult<ForgeProject> results = forgeProjectService.findAllByForgeInstance(forgeInstance.getId(),
				new PagingLoadConfigBean(0, 10));
		Assert.assertEquals(2, results.getData().size());
	}
	
	@Test
	public void testExistByName() {
		ForgeInstance forgeInstance = new ForgeInstance();
		forgeInstance = forgeInstanceService.save(forgeInstance);

		ForgeProject project = new ForgeProject();
		project.setName("My Project");
		project.setTechnicalName("my_project");
		project.setInstance(forgeInstance);
		project = forgeProjectService.save(project);
		
		project = new ForgeProject();
		project.setName("My Project 2");
		project.setTechnicalName("my_project_2");
		project = forgeProjectService.save(project);
		
		boolean result = forgeProjectService.existByName("my project", forgeInstance.getId());
		Assert.assertTrue(result);
		
		result = forgeProjectService.existByName("my project 2", forgeInstance.getId());
		Assert.assertFalse(result);

	}
	
	@Test
	public void testCreateForgeProject() {
		ForgeInstance forgeInstance = new ForgeInstance();
		forgeInstance = forgeInstanceService.save(forgeInstance);
		
		ForgeProject project = new ForgeProject();
		project.setName("My Project");
		project.setTechnicalName("my_project");
		
		try {
			project = forgeProjectService.createForgeProject(project, forgeInstance.getId());
			Assert.assertNotNull(project);
			Assert.assertNotNull(project.getId());
			Assert.assertNotNull(project.getInstance());
		} catch (NotUniqueForgeProjectNameException e) {
			Assert.fail("NotUniqueForgeProjectNameException");
		} catch (NotUniqueProjectTechNameException e) {
			Assert.fail("NotUniqueProjectTechNameException");
		}
		
		project = new ForgeProject();
		project.setName("My Project");
		project.setTechnicalName("my_project2");
		
		try {
			project = forgeProjectService.createForgeProject(project, forgeInstance.getId());
			Assert.fail("Exception should be thrown");
		} catch (NotUniqueForgeProjectNameException e) {
			Assert.assertNotNull(e);
		} catch (NotUniqueProjectTechNameException e) {
			Assert.fail("NotUniqueProjectTechNameException");
		}
		
		project = new ForgeProject();
		project.setName("My Project 2");
		project.setTechnicalName("my_project");
		
		try {
			project = forgeProjectService.createForgeProject(project, forgeInstance.getId());
			Assert.fail("Exception should be thrown");
		} catch (NotUniqueForgeProjectNameException e) {
			Assert.fail("NotUniqueForgeProjectNameException");
		} catch (NotUniqueProjectTechNameException e) {
			Assert.assertNotNull(e);
		}
		
		project = new ForgeProject();
		project.setName("My Project 2");
		project.setTechnicalName("my_project 2");
		
		try {
			project = forgeProjectService.createForgeProject(project, forgeInstance.getId());
			Assert.assertNotNull(project);
			Assert.assertNotNull(project.getId());
			Assert.assertNotNull(project.getInstance());
		} catch (NotUniqueForgeProjectNameException e) {
			Assert.fail("NotUniqueForgeProjectNameException");
		} catch (NotUniqueProjectTechNameException e) {
			Assert.fail("NotUniqueProjectTechNameException");
		}
	}
	
	@Test
	public void testUpdateForgeProjectName() {
		ForgeInstance forgeInstance = new ForgeInstance();
		forgeInstance = forgeInstanceService.save(forgeInstance);
		
		ForgeProject project = new ForgeProject();
		project.setName("My Project");
		project.setTechnicalName("my_project");
		
		ForgeProject project2 = new ForgeProject();
		project2.setName("My Project 3");
		project2.setTechnicalName("my_project 3");
		project2 = forgeProjectService.save(project2);

		try {
			project = forgeProjectService.createForgeProject(project, forgeInstance.getId());
		} catch (NotUniqueForgeProjectNameException e) {
			Assert.fail("NotUniqueForgeProjectNameException");
		} catch (NotUniqueProjectTechNameException e) {
			Assert.fail("NotUniqueProjectTechNameException");
		}
		
		try {
			project = forgeProjectService.updateForgeProjectName(project.getId(), "My project 2");
			Assert.assertNotNull(project);
			Assert.assertEquals("My project 2", project.getName());
		} catch (NotUniqueForgeProjectNameException e) {
			Assert.fail("NotUniqueForgeProjectNameException");
		}
		
		try {
			project = forgeProjectService.updateForgeProjectName(project.getId(), "My project 3");
			Assert.assertNotNull(project);
			Assert.assertEquals("My project 3", project.getName());
		} catch (NotUniqueForgeProjectNameException e) {
			Assert.fail("NotUniqueForgeProjectNameException");
		}
	}
	
	@Test
	public void testDeleteForgeProject() {
		ForgeInstance forgeInstance = new ForgeInstance();
		forgeInstance = forgeInstanceService.save(forgeInstance);
		
		ForgeProject project = new ForgeProject();
		project.setName("My Project");
		project.setTechnicalName("my_project");

		try {
			project = forgeProjectService.createForgeProject(project, forgeInstance.getId());
		} catch (NotUniqueForgeProjectNameException e) {
			Assert.fail("NotUniqueForgeProjectNameException");
		} catch (NotUniqueProjectTechNameException e) {
			Assert.fail("NotUniqueProjectTechNameException");
		}
		
		forgeProjectService.deleteForgeProject(project.getId());
		
		ForgeProject result = forgeProjectService.findOne(project.getId());
		Assert.assertNotNull(result);
		Assert.assertTrue(result.getDeleted().booleanValue());
	}
	

}
