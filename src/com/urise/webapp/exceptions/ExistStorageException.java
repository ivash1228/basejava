package com.urise.webapp.exceptions;

public class ExistStorageException extends StorageException{

    public ExistStorageException(String uuid) {
        super("Resume " + uuid + " already exists.", uuid);
    }
}
