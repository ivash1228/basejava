package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

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

    protected int getSearchKey(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

}
