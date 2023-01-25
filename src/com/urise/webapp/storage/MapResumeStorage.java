package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

import static java.util.Objects.*;

public class MapResumeStorage extends AbstractStorage<Resume>{

    protected final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExist(Resume searchKey) {
        return !isNull(searchKey);
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return storage.get(uuid);//can be null
    }

    @Override
    protected Resume doGet(Resume searchKey) {
        return searchKey;
    }

    @Override
    protected void doSave(Resume resume, Resume searchKey) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doUpdate(Resume resume, Resume searchKey) {
        storage.put(searchKey.getUuid(), resume);
    }

    @Override
    protected void doDelete(Resume searchKey) {
        storage.remove(searchKey.getUuid());
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
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
