package br.com.juhmaran.address.exceptions.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessages {

    // 400 Bad Request
    METHOD_ARGUMENT_NOT_VALID("Requisição inválida."),

    ILLEGAL_ARGUMENT("Argumento inválido."),

    HTTP_MESSAGE_NOT_READABLE("Mensagem HTTP não legível."),

    MISSING_SERVLET_REQUEST_PARAMETER("Parâmetro de requisição ausente."),

    // 401 Unauthorized
    UNAUTHENTICATED("Usuário não autenticado."),

    // 403 Forbidden
    ACCESS_DENIED("Acesso negado. Usuário não possui permissão."),

    // 404 Not Found
    NO_HANDLER_FOUND("Nenhum manipulador encontrado para a solicitação."),

    // 405 Method Not Allowed
    HTTP_REQUEST_METHOD_NOT_SUPPORTED("Método de solicitação HTTP não suportado."),

    // 406 Not Acceptable
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("Tipo de mídia HTTP não aceitável."),

    // 415 Unsupported Media Type
    HTTP_MEDIA_TYPE_NOT_SUPPORTED("Tipo de mídia HTTP não suportado."),

    // 500 Internal Server Error
    HTTP_MESSAGE_NOT_WRITABLE("Mensagem HTTP não gravável."),

    INTERNAL_ERROR("Erro interno no servidor.");

    private final String message;

}
