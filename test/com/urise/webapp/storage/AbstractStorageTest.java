package com.urise.webapp.storage;

import com.urise.webapp.exceptions.ExistStorageException;
import com.urise.webapp.exceptions.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbstractStorageTest {

    public final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME1 = new Resume(UUID_1, UUID_1);
    private static final Resume RESUME2 = new Resume(UUID_2, UUID_2);
    private static final Resume RESUME3 = new Resume(UUID_3, UUID_3);

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    public void save() {
        assertSize(3);
        assertGet(RESUME3);
    }

    @Test
    public void get() {
        assertGet(RESUME3);
    }

    @Test
    public void update() {
        Resume resume4 = RESUME3;
        storage.update(resume4);
        assertTrue(RESUME3.equals(resume4));
        assertSize(3);
    }

    @Test//(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(RESUME3.getUuid());
        assertSize(2);
        assertThrows(NotExistStorageException.class, () -> {
            storage.get(RESUME3.getUuid());
        });
    }

    @Test
    public void getAll() {
        List<Resume> expected = storage.getAllSorted();
        assertSize(expected.size());
    }

    @Test
    public void size() {
        assertEquals(3, storage.size(), "Size is incorrect");
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
        List<Resume> emptyStorage = storage.getAllSorted();
        assertEquals(emptyStorage.size(), storage.size());
    }

    @Test
    public void saveExist() {
        assertThrows(ExistStorageException.class, () -> {
            storage.save(RESUME1);
        });
    }

    @Test
    public void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> {
            storage.get("dummy");
        });
    }

    @Test
    public void updateExist() {
        assertThrows(NotExistStorageException.class, () -> {
            storage.update(new Resume("dummy", "dummy"));
        });
    }

    @Test
    public void deleteNotExist() {
        assertThrows(NotExistStorageException.class, () -> {
            storage.delete("uuid5");
        });
    }

    public void assertSize(int expectedSize) {
        assertTrue(expectedSize == storage.size(), "Size is incorrect");
    }

    public void assertGet(Resume resume) {
        Resume storageResume = storage.get(resume.getUuid());
        assertTrue(resume.equals(storageResume));
    }

}
