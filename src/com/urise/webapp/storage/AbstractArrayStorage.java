package com.urise.webapp.storage;

import com.urise.webapp.exceptions.ExistStorageException;
import com.urise.webapp.exceptions.NotExistStorageException;
import com.urise.webapp.exceptions.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResume = 0;

    public final void save(Resume resume) {
        int index = getSearchKey(resume.getUuid());
        if (countResume >= STORAGE_LIMIT) {
            throw new StorageException("Storage is full.", resume.getUuid());
        } else if (index > -1) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            saveResume(resume, index);
            countResume++;
        }
    }

    public final Resume get(String uuid) {
        int index = getSearchKey(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public final void update(Resume resume) {
        int index = getSearchKey(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
            System.out.println("Resume updated");
        }
    }

    public final void delete(String uuid) {
        int index = getSearchKey(uuid);
        if (index >= 0) {
            deleteResume(index);
            storage[countResume] = null;
            countResume--;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
    }

    public int size() {
        return countResume;
    }

    protected abstract int getSearchKey(String uuid);

    protected abstract void saveResume(Resume resume, int index);

    protected abstract void deleteResume(int index);
}
