package it.reply.orchestrator.dto.vault;

import org.springframework.vault.support.VaultTokenResponse;

public class VaultTokenResponseExtended extends VaultTokenResponse {
  
  public String getEntityId() {
    return (String) getAuth().get("entity_id");
  }

}
