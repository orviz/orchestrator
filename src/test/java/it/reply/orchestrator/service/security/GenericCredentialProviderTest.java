package it.reply.orchestrator.service.security;

import static org.junit.Assert.assertNotNull;

import it.reply.orchestrator.dto.security.GenericCredentialWithTenant;
import it.reply.orchestrator.dto.vault.TokenAuthenticationExtended;
import it.reply.orchestrator.dto.vault.VaultTokenExtended;
import it.reply.orchestrator.service.VaultService;
import it.reply.orchestrator.service.deployment.providers.CredentialProviderService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class GenericCredentialProviderTest {
  
  @ClassRule
  public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

  @Rule
  public final SpringMethodRule springMethodRule = new SpringMethodRule();
  
  private static final String defaultVaultEndpoint = "https://default.vault.com:8200";
  
  @InjectMocks
  private CredentialProviderService credProvServ ;
  
  @MockBean
  private VaultService vaultService;
  
  @Before
  public void setup() throws Exception {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void testCredentialProvider() throws URISyntaxException, IOException {
      
    Mockito
    .when(vaultService.getServiceUri())
    .thenReturn(Optional.of(new URI(defaultVaultEndpoint)));
    
    TokenAuthenticationExtended tokenExt = new TokenAuthenticationExtended(new VaultTokenExtended("vaultToken".toCharArray()),"entityId");
    
    Mockito
    .when(vaultService.retrieveToken(new URI(defaultVaultEndpoint), "accessToken"))
    .thenReturn(tokenExt);
    
    GenericCredentialWithTenant genCredWTen = new GenericCredentialWithTenant("username", "password", "tenant");
    
    Mockito
    .when(vaultService.readSecret(tokenExt, "https://default.vault.com:8200/v1/secret/data/entityIdnullcom.amazonaws.ec2", GenericCredentialWithTenant.class))
    .thenReturn(genCredWTen); 
    
    GenericCredentialWithTenant imCred = credProvServ.credentialProvider("com.amazonaws.ec2", "accessToken", GenericCredentialWithTenant.class);

    assertNotNull(imCred);
    
    assertNotNull(imCred.getUsername());

    assertNotNull(imCred.getPassword());
  }

}
