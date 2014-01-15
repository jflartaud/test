package com.jeet.hub.forge.domain.base.command.forge;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

import com.jeet.hub.forge.domain.base.model.Forge;
import com.jeet.hub.forge.domain.base.service.api.ForgeService;

@Command(scope = "hub-forge", name = "forge-add", description = "Says hello")
public class AddForgeCommand extends OsgiCommandSupport {

	@Argument(index = 0, name = "arg", description = "Name of the forge", required = true, multiValued = false)
	String name = null;


	private ForgeService forgeService;

    public ForgeService getForgeService() {
        return forgeService;
    }

    public void setForgeService(ForgeService forgeService) {
        this.forgeService = forgeService;
    }

    @Override
	protected Object doExecute() throws Exception {
    	Forge forge = new Forge();
		forge.setName(name);
		forge = getForgeService().save(forge);
		return forge;
	}

}
