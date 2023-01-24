package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    }

    @Override
    protected void doSave(Resume resume, Resume searchKey) {
    }

    @Override
    protected void doUpdate(Resume resume, Resume searchKey) {
    }

    @Override
    protected void doDelete(Resume searchKey) {

    }

    @Override
    protected List<Resume> doCopyAll() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
}
