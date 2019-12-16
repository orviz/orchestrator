package it.reply.orchestrator.dto.security;

import javax.validation.constraints.NotNull;

import org.checkerframework.checker.nullness.qual.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GenericCredential implements GenericCredentialInterface {

  @JsonProperty("username")
  @NonNull
  @NotNull
  private String username;

  @JsonProperty("password")
  @NonNull
  @NotNull
  private String password;

}
