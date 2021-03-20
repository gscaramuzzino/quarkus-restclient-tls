# Microprofile Rest Client with Mutual TLS Authentication
Microprofile Rest Client with Mutual TLS Authentication implemented with Quarkus

TLS authentication is an extension of TLS transport encryption. \
Not only servers have keys and certs that the client uses to verify the identity of servers, clients also have keys and certs that the server uses to verify the identity of clients. You must have TLS transport encryption configured on your cluster before you can use TLS authentication. This guide assumes you already have TLS transport encryption configured.

### Credits
> This project has been implemented after the study of the article \
> https://quarkus.io/blog/quarkus-mutual-tls/ \
> written by Mattia Mascia

Follow the video tutorial:

[![Alt text](https://user-images.githubusercontent.com/8536722/110162186-aa6eab00-7dee-11eb-8289-bd3cf6c13a11.png)](https://youtu.be/d3YZ-PVex78 "Click to play on Youtube.com")


This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/. \
If you want to learn more about Microprofile, please visit its website: https://microprofile.io/ .

## Running the quarkus-service application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
ssh quarkus-service/src/main/resources/META-INF/resources/generate_server_keystore.ssh
cd quarkus-service
./mvnw compile quarkus:dev
```

## Running the quarkus-client application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
ssh quarkus-client/src/main/resources/META-INF/resources/generate_client_keystore.ssh
cd quarkus-client
./mvnw compile quarkus:dev
curl http://localhost:8080/client
```
