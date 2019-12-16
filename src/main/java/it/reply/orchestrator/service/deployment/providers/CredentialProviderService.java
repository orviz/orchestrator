package it.reply.orchestrator.service.deployment.providers;

import it.reply.orchestrator.dto.security.GenericCredentialInterface;
import it.reply.orchestrator.dto.vault.TokenAuthenticationExtended;
import it.reply.orchestrator.service.VaultService;

import java.net.URI;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CredentialProviderService implements CredentialProviderServiceInterface {

  @Autowired
  private VaultService vaultService;

  public <T extends GenericCredentialInterface> T credentialProvider(String serviceId,
      String accessToken, Class<T> clazz) {

    if (serviceId == null || serviceId.isEmpty()) {
      LOG.error("SeriviceId is empty");
    }
    URI uriVault = vaultService.getServiceUri().get();

    TokenAuthenticationExtended vaultToken =
        (TokenAuthenticationExtended) vaultService.retrieveToken(uriVault, accessToken);

    String pathVaultComplete =
        vaultService.getServiceUri().get() +
            "/v1/secret/data/" +
            vaultToken.getEntityId() +
            vaultService.getServicePath() +
            serviceId;

    return vaultService.readSecret(vaultToken, pathVaultComplete, clazz);
  }

}
