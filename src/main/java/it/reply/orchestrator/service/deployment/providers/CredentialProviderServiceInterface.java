package it.reply.orchestrator.service.deployment.providers;

import it.reply.orchestrator.dto.CloudProviderEndpoint;
import it.reply.orchestrator.dto.security.GenericCredentialInterface;

public interface CredentialProviderServiceInterface {

  public <T extends GenericCredentialInterface> T credentialProvider(String serviceId,
      String accessToken, Class<T> clazz);

}
