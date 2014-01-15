/**
* @(#) ForgeServiceTests.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 5 déc. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.test;

import java.util.HashSet;

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
import com.jeet.hub.forge.domain.base.model.Forge;
import com.jeet.hub.forge.domain.base.model.ForgeInstance;
import com.jeet.hub.forge.domain.base.service.api.ForgeService;

/**
 * @author JF LARTAUD
 *
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class ForgeServiceTests extends AbstractBaseTest {
	
	@Inject
	private ForgeService forgeService;

	/* (non-Javadoc)
	 * @see com.jeet.domain.base.test.unit.AbstractBaseTest#getDomainOptions()
	 */
	@Override
	protected Option[] getDomainOptions() {
		return new Option[] {
				new DomainOption("com.jeet.domain", "base", "1.0.0-SNAPSHOT", "jeet-domain-base-feature",
						"jeet-domain-base-test-feature"),
				new DomainOption("com.jeet.domain", "party", "1.0.0-SNAPSHOT", "jeet-domain-party-feature",
						"jeet-domain-party-security-feature"),
				new DomainOption("com.jeet.hub.forge.domain", "base", "1.0.0-SNAPSHOT",
						"jeet-hub-forge-domain-base-test-feature") };
	}
	
	@Test
	public void testSave() {
		System.err.println(executeCommand("bundle:list"));

		Assert.assertNotNull(getBundleContext());

		Forge entity = new Forge();
		entity.setName("my test forge");
		entity.setInstances(new HashSet<ForgeInstance>());
		
		ForgeInstance instance1 = new ForgeInstance();
		instance1.setName("VM tools 1");
		instance1.setForge(entity);
		
		ForgeInstance instance2 = new ForgeInstance();
		instance2.setName("VM tools 2");
		instance2.setForge(entity);
		entity.getInstances().add(instance1);
		entity.getInstances().add(instance2);
		
		entity = forgeService.save(entity);
		Assert.assertNotNull(entity);
		Assert.assertNotNull(entity.getId());
		
		// test the cascading
		for (ForgeInstance instance : entity.getInstances()) {
			Assert.assertNotNull(instance.getId());
		}
	}
}
