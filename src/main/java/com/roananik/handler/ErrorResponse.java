package com.roananik.handler;

import lombok.Builder;

@Builder
public record ErrorResponse (Integer status, String message) {
}
