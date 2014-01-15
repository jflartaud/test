/**
* @(#) ActivitiTests.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 19 déc. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.test;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import com.jeet.domain.base.test.unit.AbstractBaseTest;
import com.jeet.domain.base.test.unit.DomainOption;
import com.jeet.hub.forge.domain.base.service.api.TestBeanInterface;

/**
 * @author JF LARTAUD
 *
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class ActivitiTests extends AbstractBaseTest {
	
	private RuntimeService runtimeService;
	
	private TaskService taskService;
	
	private IdentityService identityService;

	private TestBeanInterface testBean;

	/*
	 * (non-Javadoc)
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
	public void test() {
		System.err.println(executeCommand("bundle:list"));
		// System.err.println(executeCommand("bundle:diag 175"));
		
		testBean = getOsgiService(TestBeanInterface.class);

		runtimeService = getOsgiService(RuntimeService.class);

		String procId = runtimeService.startProcessInstanceByKey("test").getId();
		
		System.err.println("Process id : " + procId);

	}
}
