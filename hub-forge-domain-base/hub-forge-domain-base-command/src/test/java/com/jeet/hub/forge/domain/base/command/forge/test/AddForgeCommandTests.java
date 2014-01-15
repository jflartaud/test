/**
* @(#) AddForgeCommandTest.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 9 déc. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.command.forge.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import com.jeet.domain.base.test.unit.AbstractBaseTest;
import com.jeet.domain.base.test.unit.DomainOption;

/**
 * @author JF LARTAUD
 *
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class AddForgeCommandTests extends AbstractBaseTest {
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.domain.base.test.unit.AbstractBaseTest#getDomainOptions()
	 */
	@Override
	protected Option[] getDomainOptions() {
		return new Option[] {
				new DomainOption("com.jeet.domain", "base", "1.0.0-SNAPSHOT", "jeet-domain-base-feature",
						"jeet-domain-base-test-feature"),
				new DomainOption("com.jeet.domain", "party", "1.0.0-SNAPSHOT", "jeet-domain-party-feature"),
				new DomainOption("com.jeet.hub.forge.domain", "base", "1.0.0-SNAPSHOT",
						"jeet-hub-forge-domain-base-test-feature") };
	}
	
	@Test
	public void testAddForgeCommand() {
		String result = executeCommand("hub-forge:forge-add MyForge");
		System.err.println("Result of command: " + result);
		Assert.assertEquals("Forge", result);

	}

}
