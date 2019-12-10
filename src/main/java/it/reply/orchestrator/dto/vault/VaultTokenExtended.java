package it.reply.orchestrator.dto.vault;

import lombok.Getter;

import org.springframework.vault.support.VaultToken;
@Getter
public class VaultTokenExtended extends VaultToken {
  
  public VaultTokenExtended(char[] token) {
    super(token);
  }


}
