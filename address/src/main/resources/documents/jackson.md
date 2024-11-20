# Personalizar o comportamento de serialização e desserialização

## Configurações

- `spring.jackson.default-property-inclusion`: Define a inclusão padrão de propriedades durante a serialização.
- `NON_NULL` significa que apenas propriedades não nulas serão incluídas.
- `NON_ABSENT` significa que apenas propriedades não ausentes serão incluídas.
- `NON_EMPTY` significa que apenas propriedades não vazias serão incluídas.
- `NON_DEFAULT` significa que apenas propriedades que não são iguais ao valor padrão serão incluídas.
- `ALWAYS` significa que todas as propriedades serão incluídas.

```yaml
spring:
  jackson:
    default-property-inclusion: NON_NULL
```

### Visibilidade

- `spring.jackson.visibility`: Configura a visibilidade das propriedades para serialização e desserialização.
- `getter`: Define a visibilidade dos métodos getter.
- `is-getter`: Define a visibilidade dos métodos is-getter.
- `field`: Define a visibilidade dos campos.
- `setter`: Define a visibilidade dos métodos setter.
- `creator`: Define a visibilidade dos métodos de criação.
- `ANY`: significa que todas as propriedades serão consideradas.
- `PUBLIC_ONLY` significa que apenas propriedades públicas serão consideradas.
- `PROTECTED_AND_PUBLIC` significa que propriedades protegidas e públicas serão consideradas.
- `NONE` significa que nenhuma propriedade será considerada.
- `PRIVATE` significa que apenas propriedades privadas serão consideradas.

```yaml
spring:
  jackson:
    visibility:
      getter: NONE
      is-getter: NONE
      field: ANY
      setter: NONE
      creator: NONE
```

### Formatação

**Formato de Data**

Para configurar o formato de data, use a propriedade `spring.jackson.date-format`.

```yaml
spring:
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
```

**Estratégia de Nomeação de Propriedades**

Para definir a estratégia de nomeação de propriedades, use a propriedade `spring.jackson.property-naming-strategy`.

- `CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES` converte nomes de propriedades de camelCase para snake_case.
- `UPPER_CAMEL_CASE` converte nomes de propriedades para UpperCamelCase.
- `LOWER_CASE` converte nomes de propriedades para lower_case.
- `KEBAB_CASE` converte nomes de propriedades para kebab-case.
- `SNAKE_CASE` converte nomes de propriedades para snake_case.

```yaml
spring:
  jackson:
    property-naming-strategy: SNAKE_CASE
```

**Fuso Horário**

Para definir o fuso horário usado ao formatar datas, use a propriedade `spring.jackson.time-zone`.

```yaml
spring:
  jackson:
    time-zone: America/Sao_Paulo
```

**Locale**

Para definir o locale usado para formatação, use a propriedade `spring.jackson.locale`.

```yaml
spring:
  jackson:
    locale: pt_BR
```

### Desserialização

- `spring.jackson.deserialization`: Configura recursos de desserialização.
- `FAIL_ON_UNKNOWN_PROPERTIES: false` desabilita a falha ao encontrar propriedades desconhecidas.
- `ACCEPT_SINGLE_VALUE_AS_ARRAY: true` permite aceitar valores únicos como arrays.
- `UNWRAP_ROOT_VALUE: true` permite desembrulhar valores de raiz.
- `READ_UNKNOWN_ENUM_VALUES_AS_NULL: true` permite ler valores de enumeração desconhecidos como nulos.
- `READ_ENUMS_USING_TO_STRING: true` permite ler valores de enumeração usando o método `toString`.
- `READ_DATE_TIMESTAMPS_AS_NANOSECONDS: true` permite ler valores de data e hora como nanossegundos.
- `ADJUST_DATES_TO_CONTEXT_TIME_ZONE: true` permite ajustar datas ao fuso horário do contexto.

```yaml
spring:
  jackson:
    deserialization:
      FAIL_ON_UNKNOWN_PROPERTIES: false
      ACCEPT_SINGLE_VALUE_AS_ARRAY: true
```

### Serialização

- `spring.jackson.serialization`: Configura recursos de serialização.
- `INDENT_OUTPUT: true` habilita a formatação de saída com indentação.
- `WRITE_DATES_AS_TIMESTAMPS: false` desabilita a escrita de datas como timestamps.
- `WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS: true` permite escrever datas como nanossegundos.
- `WRITE_DATES_WITH_ZONE_ID: true` permite escrever datas com identificador de fuso horário.
- `WRITE_DURATIONS_AS_TIMESTAMPS: false` desabilita a escrita de durações como timestamps.
- `WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS: true` permite escrever arrays de caracteres como arrays JSON.
- `WRITE_ENUMS_USING_TO_STRING: true` permite escrever valores de enumeração usando o método `toString`.
- `WRITE_ENUMS_USING_INDEX: true` permite escrever valores de enumeração usando o índice.
- `fail-on-empty-beans: false` desabilita a falha em beans vazios.
- `default-property-inclusion: NON_NULL` define a inclusão padrão de propriedades durante a serialização.

```yaml
spring:
  jackson:
    serialization:
      INDENT_OUTPUT: true
      fail-on-empty-beans: false # desabilita a falha em beans vazios
      WRITE_DATES_AS_TIMESTAMPS: true # habilita a escrita de datas como timestamps
```