package com.urise.webapp.storage;

import com.urise.webapp.exceptions.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    private final Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
        this.storage = storage;
    }

    @Test
    public void saveOverflow() {
        try {
            storage.clear();
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch(StorageException e){
            Assertions.fail("Storage Overflow is not expected");
        }
        Assertions.assertThrows(StorageException.class, () -> storage.save(new Resume()));
    }
}