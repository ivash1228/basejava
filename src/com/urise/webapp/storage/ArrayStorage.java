package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int countResume = 0;

    public void save(Resume resume) {
        if (countResume >= storage.length) {
            System.out.println("Storage is full");
        }
        int index = getSearchKey(resume.getUuid());
        if (index == -1) {
            System.out.printf("Resume %s already exists\n", resume.getUuid());
        } else {
            storage[countResume] = resume;
            countResume++;
        }
    }

    public Resume get(String uuid) {
        int index = getSearchKey(uuid);
        if (index == -1) {
            System.out.printf("Resume %s doesn't exist\n", uuid);
            return null;
            }
        return storage[index];
        }

    public void update(Resume resume) {
        int index = getSearchKey(resume.getUuid());
        if (index == -1) {
            System.out.println("Resume doesn't exists");
        } else {
            storage[index] = resume;
            System.out.println("Resume updated");
        }
    }

    public void delete(String uuid) {
        int index = getSearchKey(uuid);
        if (index >= 0) {
            storage[index] = storage[countResume];
            storage[countResume] = null;
            countResume--;
        }
    }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    public void clear() {
        Arrays.fill(storage, null);
        countResume = 0;
    }

    public int size() {
        return countResume;
    }

    private int getSearchKey(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (uuid.equals(storage[i].getUuid())) return i;
        }
        return -1;
    }
}
