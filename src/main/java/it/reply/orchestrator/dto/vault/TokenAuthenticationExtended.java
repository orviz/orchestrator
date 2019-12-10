package it.reply.orchestrator.dto.vault;

import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.support.VaultToken;


public class TokenAuthenticationExtended extends TokenAuthentication{

  private String entityId;
  
  public TokenAuthenticationExtended(VaultToken token, String entityId) {
    super(token);
    this.entityId = entityId;
  }
  
  public String getEntityId() {
    return entityId;
  }

}