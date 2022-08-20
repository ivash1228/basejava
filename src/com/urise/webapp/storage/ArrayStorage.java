package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int countResume = 0;

    public void save(Resume r) {
        if (countResume > storage.length) {
            System.out.println("Storage is full");
        } else if (exist(r.getUuid())) {
            System.out.printf("Resume %s already exists\n", r.getUuid());
        } else {
            storage[size()] = r;
            countResume++;
        }
    }

    public Resume get(String uuid) {
        if (exist(uuid)) {
            for (int i = 0; i < countResume; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    return storage[i];
                }
            }

        }
        System.out.printf("Resume %s doesn't exist\n", uuid);
        return null;
    }

    public void update(Resume resume) {
        if (!exist(resume.getUuid())) {
            System.out.println("Resume doesn't exists");
        } else {
            for (int i = 0; i < countResume; i++) {
                if (storage[i].getUuid().equals(resume.getUuid())) {
                    storage[i] = resume;
                    System.out.println("Resume updated");
                }
            }
        }
    }

    public void delete(String uuid) {
        if (exist(uuid)) {
            int index = -1;
            int size = countResume;
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    index = i;
                }
            }
            if (index >= 0) {
                System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
                storage[size - 1] = null;
                countResume--;
            }
        }
    }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    public void clear() {
        Arrays.fill(storage, null);
        countResume = 0;
    }

    public int size() {
        return countResume;
    }

    private boolean exist(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (uuid.equals(storage[i].getUuid())) return true;
        }
        return false;
    }
}
