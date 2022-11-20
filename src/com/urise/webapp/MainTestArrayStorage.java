package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.ListStorage;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final Storage ARRAY_STORAGE = new ArrayStorage();
    static final Storage ARRAY_STORAGE_SORT = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r3 = new Resume();
        r3.setUuid("uuid3");
        Resume r4 = new Resume();
        r4.setUuid("uuid4");
        Resume r5 = new Resume();
        r5.setUuid("uuid5");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE_SORT.save(r3);
        ARRAY_STORAGE_SORT.save(r4);
        ARRAY_STORAGE_SORT.save(r2);
        ARRAY_STORAGE_SORT.save(r5);
        ARRAY_STORAGE_SORT.save(r1);


        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        ARRAY_STORAGE.update(r1);

        printAll(ARRAY_STORAGE);
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll(ARRAY_STORAGE);
        ARRAY_STORAGE.clear();
        printAll(ARRAY_STORAGE);

        System.out.println("Size: " + ARRAY_STORAGE.size());


        System.out.println("Get r1: " + ARRAY_STORAGE_SORT.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE_SORT.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE_SORT.get("dummy"));

        ARRAY_STORAGE_SORT.update(r1);

        printAll(ARRAY_STORAGE_SORT);
        ARRAY_STORAGE_SORT.delete(r1.getUuid());
        printAll(ARRAY_STORAGE_SORT);
        ARRAY_STORAGE_SORT.clear();
        printAll(ARRAY_STORAGE_SORT);

        System.out.println("Size: " + ARRAY_STORAGE_SORT.size());
    }

    static void printAll(Storage storage) {
        System.out.println("\nGet All");
        for (Resume r : storage.getAll()) {
            System.out.println(r);
        }
    }
}

