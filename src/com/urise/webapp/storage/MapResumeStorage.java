package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

public class MapResumeStorage extends AbstractStorage{


    @Override
    protected boolean isExist(String uuid) {
        return false;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {

    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {

    }

    @Override
    protected void doDelete(Object searchKey) {

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
