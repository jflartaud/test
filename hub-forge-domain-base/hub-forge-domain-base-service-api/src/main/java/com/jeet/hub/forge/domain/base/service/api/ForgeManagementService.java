package com.jeet.hub.forge.domain.base.service.api;

import com.jeet.domain.base.service.api.MetaService;
import com.jeet.domain.party.model.party.Party;
import com.jeet.hub.forge.domain.base.model.Forge;

public interface ForgeManagementService extends MetaService {

	
	/**
	 * Create a new Forge for specified Party;
	 * @param party
	 */
	Forge createForge(Party party);
}
