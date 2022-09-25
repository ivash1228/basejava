package com.urise.webapp.storage;

import com.urise.webapp.exceptions.ExistStorageException;
import com.urise.webapp.exceptions.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractArrayStorageTest {
    public Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME1 = new Resume(UUID_1);
    private static final Resume RESUME2 = new Resume(UUID_2);
    private static final Resume RESUME3 = new Resume(UUID_3);
    private static final Resume RESUME4 = new Resume(UUID_4);

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    void save() {
        int qtyBeforeSave = storage.size();
        storage.save(RESUME4);
        assertTrue(qtyBeforeSave + 1 == storage.size(), "Quantity is incorrect");
        assertEquals(RESUME4, storage.get("uuid4"));
    }

    @Test
    void get() {
        assertEquals(RESUME3, storage.get("uuid3"));
    }

    @Test
    void update() {
        int qtyBeforeUpdate = storage.size();
        storage.update(RESUME3);
        assertEquals(qtyBeforeUpdate, storage.size());
    }

    @Test
    void delete() {
        int qtyBeforeDelete = storage.size();
        storage.delete("uuid3");
        assertTrue( qtyBeforeDelete - 1 == storage.size());
    }

    @Test
    void getAll() {
        Resume[] storageResumes = storage.getAll();
        assertEquals(storageResumes.length, storage.size());
    }

    @Test
    void size() {
        assertEquals(3, storage.size(), "Size is incorrect");
    }

    @Test
    void clear() {
        storage.clear();
        assertEquals(0, storage.size(), "Clearing not working");
    }

    @Test
    void doesExist() {
        assertThrows(ExistStorageException.class, () -> {
            storage.save(RESUME1);
        });
    }

    @Test
    public void doesNotExist() {
        assertThrows(NotExistStorageException.class, () -> {
            storage.get("dummy");
        });
    }

    @Test
    public void updateAlreadyExist() {
        assertThrows(ExistStorageException.class, () -> {
            storage.update(RESUME1);
        });
    }
}