package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractArrayStorageTest {
    public Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    void save() throws Exception{
        int qtyBeforeSave = storage.size();
        storage.save(new Resume("uuid4"));
        assertTrue(qtyBeforeSave + 1 == storage.size(), "Quantity is incorrect");
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        int qtyBeforeDelete = storage.size();
        storage.delete("uuid3");
        assertTrue( qtyBeforeDelete - 1 == storage.size());
    }

    @Test
    void getAll() {
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
}