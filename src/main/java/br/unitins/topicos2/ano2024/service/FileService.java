package br.unitins.topicos2.ano2024.service;

import java.io.File;

public interface FileService {

    void salvar(Long id, String nomeImagem, byte[] imagem);

    File download(String nomeArquivo);
    
}
