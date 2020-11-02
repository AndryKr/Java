public class Task1 {

    public static <T> T[] arrToList(T[] arr, int index1, int index2) {
        T variable  = arr[index1];
        arr[index1] = arr [index2];
        arr [index2] = variable;
        return arr;
    }
}
