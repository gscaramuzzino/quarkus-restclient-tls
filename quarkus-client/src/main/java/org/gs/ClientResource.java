package org.gs;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Path("/client")
public class ClientResource {

    @ConfigProperty(name = "url")
    URL serverURL;

    @ConfigProperty(name = "keyStore")
    String keyStoreFile;

    @ConfigProperty(name = "keyStorePassword")
    String keyStoreFilePassword;

    @ConfigProperty(name = "trustStore")
    String trustStoreFile;

    @ConfigProperty(name = "trustStorePassword")
    String trustStoreFilePassword;

    @RestClient
    @Inject
    Client client;

    @GET
    @Path("client")
    @Produces(MediaType.TEXT_PLAIN)
    public String callWithClient() {
        return client.call();
    }

    @GET
    @Path("clientBuilder")
    @Produces(MediaType.TEXT_PLAIN)
    public String callWithClientBuilder() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream inputStreamKeyStore = this.getClass()
                .getClassLoader()
                .getResourceAsStream(keyStoreFile);
        keyStore.load(inputStreamKeyStore,keyStoreFilePassword.toCharArray());

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream inputStreamTrustStore = this.getClass()
                .getClassLoader()
                .getResourceAsStream(trustStoreFile);
        trustStore.load(inputStreamTrustStore,trustStoreFilePassword.toCharArray());

        Client clientBuild = RestClientBuilder.newBuilder()
                .baseUrl(serverURL)
                .keyStore(keyStore, keyStoreFilePassword)
                .trustStore(trustStore)
                .build(Client.class);
        return clientBuild.call();

    }
}
