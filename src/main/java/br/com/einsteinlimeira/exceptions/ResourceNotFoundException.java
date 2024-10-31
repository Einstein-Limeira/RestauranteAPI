package br.com.einsteinlimeira.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mensagem, Integer id) {
        super(String.format("ERRO! %s com o ID: %d não foi encontrado!", mensagem, id));
    }
}