package com.urise.webapp.storage;

import com.urise.webapp.exceptions.ExistStorageException;
import com.urise.webapp.exceptions.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;

public class ListStorage extends AbstractStorage {

    protected final ArrayList<Resume> storage = new ArrayList<>();

    @Override
    public void save(Resume resume) {
        if (storage.contains(resume)) {
            throw new ExistStorageException(resume.getUuid());
        }
        storage.add(resume);
    }

    @Override
    public Resume get(String uuid) {
        int index = storage.indexOf(new Resume(uuid));
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage.get(index);
    }

    @Override
    public void update(Resume resume) {
        if (!storage.contains(resume)) {
            throw new NotExistStorageException(resume.getUuid());
        }
        storage.set(storage.indexOf(resume), resume);
    }

    @Override
    public void delete(String uuid) {
        if (!storage.contains(new Resume(uuid))) {
            throw new NotExistStorageException(uuid);
        }
        storage.remove(new Resume(uuid));
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

}
