# Learning Jackson

## O que temos:

Possuo uma aplicação Angular que faz uso dos nossos recursos através de endpoints RESTs

## Cenário:
Precisamos buscar dados de um sistema legado e retornar esses dados para o nosso cliente Angular

## Problema

O sistema legado possui um endpoint REST que recebe uma requisição POST e o body deve ser da seguinte maneira:

`REQUEST BODY`
```
{
   "Command_Name": "STATUS",
   "Command_Target": "ONE" 
}
```

`RESPONSE BODY`

```
    {
        "Command_Name": "STATUS",
        "Command_Target": "ONE",
        "Command_Result_Payload": ["1"]
    }
```

## Como foi resolvido?

[https://www.concretepage.com/jackson-api/jackson-jsonproperty-and-jsonalias-example](Através deste post) que fala sobre @JsonProperty e @JsonAlias

## Melhorias a serem feitas

- Fazer com que os nossos testes não dependam do wiremock (Utilizado para simular o sistema legado) standalone
- Fazer com que a nossa aplicação seja Container friendly
- Criar um profile para testes e um para desenvolvimento

## Contribue aqui :)