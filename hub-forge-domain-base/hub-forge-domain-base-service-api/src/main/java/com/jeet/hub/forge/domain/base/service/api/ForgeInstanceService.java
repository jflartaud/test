package com.jeet.hub.forge.domain.base.service.api;

import com.jeet.domain.base.service.api.EntityService;
import com.jeet.hub.forge.domain.base.model.ForgeInstance;
import com.jeet.hub.forge.domain.base.model.template.Template;

/**
 * Created by Sébastien on 04/10/13.
 */
public interface ForgeInstanceService extends EntityService<ForgeInstance , Long>{

    /**
     *
     * @param forgeInstanceIdentifier
     * @return
     */
    Template getTemplate(Long forgeInstanceIdentifier);
}
