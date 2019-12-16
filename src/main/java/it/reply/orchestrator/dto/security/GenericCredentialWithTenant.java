package it.reply.orchestrator.dto.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

import lombok.Getter;

import org.checkerframework.checker.nullness.qual.NonNull;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GenericCredentialWithTenant extends GenericCredential {
  
  public GenericCredentialWithTenant(@NonNull String username, @NonNull String password, @NonNull String tenant) {
    super(username, password);
    this.tenant = tenant;
  }

  @JsonProperty("tenant")
  @NonNull
  @NotNull
  @Getter 
  private String tenant;

}
