/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int lastIndex = -1;
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i <= lastIndex; i++){
            storage[i] = null;
        }
        lastIndex = -1;
    }

    void save(Resume r) {
        lastIndex++;
        storage[lastIndex] = r;
    }

    Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            return null;
        }
        return storage[index];
    }

    void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            return;
        }
        for (int i = index + 1; i <= lastIndex; i++) {
            storage[i - 1] = storage[i];
        }
        lastIndex--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[lastIndex + 1];
        for (int i = 0; i <= lastIndex; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return lastIndex + 1;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i <= lastIndex; i++) {
            Resume r = storage[i];
            if (uuid.equals(r.uuid)) {
                return i;
            }
        }
        return -1;
    }
}
