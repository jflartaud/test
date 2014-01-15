package com.jeet.hub.forge.domain.base.test.integration;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	private static BundleContext context = null;
	private static ServiceRegistration serviceReg = null;

	@Override
	public void start(BundleContext context) throws Exception {
		this.context = context;
		this.context = context;

		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("javax.persistence.provider",
				org.eclipse.persistence.jpa.PersistenceProvider.class.getName());
		props.put(javax.persistence.spi.PersistenceProvider.class.getName(),
				org.eclipse.persistence.jpa.PersistenceProvider.class.getName());
		props.put("javax.persistence.PersistenceProvider",
				org.eclipse.persistence.jpa.PersistenceProvider.class.getName());

		serviceReg = context.registerService(
				javax.persistence.spi.PersistenceProvider.class.getName(),
				new org.eclipse.persistence.jpa.PersistenceProvider(), props);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		if (this.serviceReg != null) {
			this.serviceReg.unregister();
			this.serviceReg = null;
		}

		this.context = null;
	}

}
