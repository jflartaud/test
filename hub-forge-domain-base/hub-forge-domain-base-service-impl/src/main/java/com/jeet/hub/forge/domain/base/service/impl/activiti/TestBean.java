/**
* @(#) TestBean.java - Jeet Hub Forge
*
* Copyright 2013 - JeetConsulting
*
* Licence : http://www.jeet-consulting.com/jeet-hub-forge/licence.txt
* Auteur : JeetConsulting
* Créé le : 19 déc. 2013
* Contact : http://jeet-consulting.com/
*
*/
	
package com.jeet.hub.forge.domain.base.service.impl.activiti;

import com.jeet.hub.forge.domain.base.model.Forge;
import com.jeet.hub.forge.domain.base.service.api.ForgeService;
import com.jeet.hub.forge.domain.base.service.api.TestBeanInterface;

/**
 * @author JF LARTAUD
 *
 */
public class TestBean implements TestBeanInterface {
	
	private ForgeService forgeService;
	
	/*
	 * (non-Javadoc)
	 * @see com.jeet.hub.forge.domain.base.service.impl.activiti.TestBeanInterface#doSomething()
	 */
	@Override
	public void doSomething() {
		System.err.println("DO SOMETHING INTO ACTIVITI");
		Forge f = new Forge();
		f.setName("Activiti forge");
		f = forgeService.save(f);
		System.err.println("FORGE CREATED " + f.getId());
		
		// forgeService.flush();
		// throw new RuntimeException("Arf !");
	}
	
	public ForgeService getForgeService() {
		return forgeService;
	}
	
	public void setForgeService(ForgeService forgeService) {
		this.forgeService = forgeService;
	}
	


}
