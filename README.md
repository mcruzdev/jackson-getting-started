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

Precisamos ter os seguintes conceitos em mente:

**JSON para POJO** chamamos de **Deserialization**

**POJO para JSON** chamamos de **Serialization**

[Através deste post](https://www.concretepage.com/jackson-api/jackson-jsonproperty-and-jsonalias-example) que fala sobre @JsonProperty e @JsonAlias

- Quando enviamos a requisição para o sistema legado enviamos o nosso objeto serializado 
CommandRequest
  

- Quando recebemos a resposta do sistema legado, o nosso objeto CommandResponse deve ser deserializado.
Podemos ver acima qual é o formato JSON que recebemos do sistema legado e a anotação `@JsonAlias` nos ajuda na **desserialização** aceitando
  **"Command_Result_Payload": "..."** para desserializar o nosso objeto CommandResponse.
  
  
- Quando vamos retornar para o nosso frontend (Angular) devemos retornar **"commandResultPayload": "..."**
e pra isso a anotação `@JsonProperty` nos ajuda, no nosso caso não é necessário o uso da anotação `@JsonProperty` pois as nossas propriedades possuem os mesmo valores contidos nas anotação `@JsonProperty`:
  ```
    @JsonProperty("commandTarget")
    private String commandTarget; 
    // Por padrão o Jackson utiliza o nome da propriedade
  ```
  
- Devemos lembrar que a anotação **@JsonAlias** sempre é **usada na desserialização (JSON para Java)**, ela diz quais são as keys que aquela determinada propriedade da nossa classe aceita,
podendo ter múltiplos valores aceitáveis na desserialização:
  ```
    @JsonAlias({"Command_Target", "CT", "CommandTgt"})
    private String commandTarget;
  ```

## Melhorias

- Fazer com que os nossos testes não dependam do wiremock (Utilizado para simular o sistema legado) standalone
- Fazer com que a nossa aplicação seja Container friendly
- Criar um profile para testes e um para desenvolvimento
- Remover `@JsonProperties` das propriedades, pois no nosso caso a anotação é redundante

## Contribue aqui :)