package com.codedeving.atendimentosapi.core.usecases;

import jakarta.servlet.http.Part;

public interface AddPhotoUseCase {

    public byte[] execute(Integer id, Part arquivo);
}
