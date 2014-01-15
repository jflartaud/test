package com.jeet.hub.forge.domain.base.service.api.element;

import com.jeet.domain.base.service.api.MetaService;
import com.jeet.hub.forge.domain.base.model.element.ForgeElement;
import com.jeet.hub.forge.domain.base.model.project.ForgeProject;

/**
 * 
 * @author Sebastien
 *
 */
public interface ForgeElementManagementService<T extends ForgeElement> extends MetaService {


	/**
	 * Configure a new ForgeElement in given ForgeIntance
	 * @param forgeInstance
	 * @return
	 */
	T configureForgeElement(Long forgeInstanceIentifer);
	
	/**
	 * 
	 * @param forgeElement
	 * @param forgeProjet
	 * @return
	 */
	ForgeProject addForgeProject(T forgeElement , ForgeProject forgeProjet);
	
	
}
