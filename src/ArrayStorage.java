import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;
    
    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                Arrays.fill(storage, i, i + 1, null);
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i])) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i])) {
                storage[i] = storage[i - 1];
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                return Arrays.copyOfRange(storage, i,  i + 1);
            }
        }
        return null;
    }

    int size() {
        for (int i = 0; i < storage.length; i++) {
            if (storage.length - 1 == i) {
                size++;
            }
        }
        return size;
    }
}
