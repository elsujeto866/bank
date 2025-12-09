package com.banking.accounts.infrastructure.input.rest;

import com.banking.accounts.infrastructure.input.rest.model.AccountRequest;
import com.banking.accounts.infrastructure.input.rest.model.AccountResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.HttpStatus;

@RestController
public class AccountController implements AccountsApi {

    @Override
    public Mono<ResponseEntity<AccountResponse>> createAccount(Mono<AccountRequest> accountRequest, ServerWebExchange exchange) {

        return accountRequest.map(request -> {
                    // 1. LOG: Para ver en la consola que la petición llegó
                    System.out.println("✅ [DUMMY CONTROLLER] Petición recibida:");
                    System.out.println("   - Cuenta: " + request.getAccountNumber());
                    System.out.println("   - Tipo: " + request.getAccountType());
                    System.out.println("   - Cliente: " + request.getClientId());

                    // 2. MOCK: Creamos una respuesta falsa para probar
                    AccountResponse response = new AccountResponse();
                    response.setId(12345L); // ID inventado
                    response.setAccountNumber(request.getAccountNumber());
                    response.setBalance(request.getInitialBalance());
                    response.setStatus(true);
                    response.setClientId(request.getClientId());

                    return response;
                })
                // 3. RESPUESTA: Envolvemos en un HTTP 201 Created
                .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response));
    }
}
