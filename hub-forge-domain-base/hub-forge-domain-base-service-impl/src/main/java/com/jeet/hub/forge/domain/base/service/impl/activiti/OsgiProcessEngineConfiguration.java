/**
* @(#) OsgiProcessEngineConfiguration.java - Jeet Hub Forge
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

import javax.sql.DataSource;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.cfg.JtaProcessEngineConfiguration;
import org.activiti.engine.impl.interceptor.CommandConfig;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * @author JF LARTAUD
 *
 */
public class OsgiProcessEngineConfiguration extends JtaProcessEngineConfiguration {
	
	protected Resource[] deploymentResources = new Resource[0];

	protected String deploymentName = "OSGIAutoDeployement";

	protected void autoDeployResources(ProcessEngine processEngine) {
		if (deploymentResources != null && deploymentResources.length > 0) {
			RepositoryService repositoryService = processEngine.getRepositoryService();
			DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().enableDuplicateFiltering()
					.name(deploymentName);
			for (Resource resource : deploymentResources) {
				System.err.println("Resource Name :" + resource.getResourceName());
				deploymentBuilder.addInputStream(resource.getResourceName(), resource.getInputStream());
			}
			deploymentBuilder.deploy();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl#buildProcessEngine()
	 */
	@Override
	public ProcessEngine buildProcessEngine() {
		ProcessEngine processEngine = super.buildProcessEngine();
		autoDeployResources(processEngine);
		return processEngine;
	}

	@Override
	protected void initDefaultCommandConfig() {
		if (defaultCommandConfig == null) {
			defaultCommandConfig = new CommandConfig().setContextReusePossible(true);
		}
	}

	public Resource[] getDeploymentResources() {
		return deploymentResources;
	}
	
	public void setDeploymentResources(Resource[] deploymentResources) {
		this.deploymentResources = deploymentResources;
	}
	
	public String getDeploymentName() {
		return deploymentName;
	}
	
	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}
	
	/**
	 * All the setters are override to return void as expected by blueprint
	 * 
	 * @param dataSource
	 */
	public void setDataSourceOsgi(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	public void setDatabaseSchemaOsgi(String databaseSchema) {
		super.setDatabaseSchema(databaseSchema);
	}
	
	public void setDatabaseSchemaUpdateOsgi(String databaseSchemaUpdate) {
		super.setDatabaseSchemaUpdate(databaseSchemaUpdate);
	}

	public void setJobExecutorActivateOsgi(boolean jobExecutorActivate) {
		super.setJobExecutorActivate(jobExecutorActivate);
	}
	
	public void setJpaEntityManagerFactoryOsgi(Object jpaEntityManagerFactory) {
		super.setJpaEntityManagerFactory(jpaEntityManagerFactory);
	}
	
	public void setJpaHandleTransactionOsgi(boolean jpaHandleTransaction) {
		super.setJpaHandleTransaction(jpaHandleTransaction);
	}
	
	public void setJpaCloseEntityManagerOsgi(boolean jpaCloseEntityManager) {
		super.setJpaCloseEntityManager(jpaCloseEntityManager);
	}
	
	public void setMailServerDefaultFromOsgi(String mailServerDefaultFrom) {
		super.setMailServerDefaultFrom(mailServerDefaultFrom);
	}
	
	public void setMailServerHostOsgi(String mailServerHost) {
		super.setMailServerHost(mailServerHost);
	}
	
	public void setMailServerPasswordOsgi(String mailServerPassword) {
		super.setMailServerPassword(mailServerPassword);
	}
	
	public void setMailServerPortOsgi(int mailServerPort) {
		super.setMailServerPort(mailServerPort);
	}
	
	public void setMailServerUsernameOsgi(String mailServerUsername) {
		super.setMailServerUsername(mailServerUsername);
	}
	
	public void setMailServerUseSSLOsgi(boolean useSSL) {
		super.setMailServerUseSSL(useSSL);
	}
	
	public void setMailServerUseTLSOsgi(boolean useTLS) {
		super.setMailServerUseTLS(useTLS);
	}
	
	public void setMailSessionJndiOsgi(String mailSessionJndi) {
		super.setMailSessionJndi(mailSessionJndi);
	}

}
