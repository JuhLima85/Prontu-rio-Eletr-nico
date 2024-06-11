package com.codedeving.atendimentosapi.core.usecases.paciente;

import jakarta.servlet.http.Part;

public interface AddPhotoUseCase {
     byte[] execute(Integer id, Part arquivo);
}
