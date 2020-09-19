/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int lastIndex = -1;
    Resume[] storage = new Resume[10000];

    void clear() {
        lastIndex = -1;
    }

    void save(Resume r) {
        lastIndex++;
        storage[lastIndex] = r;
    }

    private int getResumeIndex(String uuid){
        for (int i = 0; i <= lastIndex; i++){
            Resume r = storage[i];
            if (uuid.equals(r.uuid)){
                return i;
            }
        }
        return -1;
    }

    Resume get(String uuid) {
        int resumeIndex = getResumeIndex(uuid);
        if (resumeIndex == -1) {
            return null;
        }
        return storage[resumeIndex];
    }

    void delete(String uuid) {
        int resumeIndex = getResumeIndex(uuid);
        if (resumeIndex == -1) {
            return;
        }
        for (int i = resumeIndex+1; i <= lastIndex; i++) {
            storage[resumeIndex] = storage[resumeIndex+1];
        }
        lastIndex--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[lastIndex+1];
        if (lastIndex >= 0) System.arraycopy(storage, 0, result,0,lastIndex+1);
        return result;
    }

    int size() {
        return lastIndex+1;
    }
}
