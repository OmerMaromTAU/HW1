import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char dir) {
        if (array.length <= 1 || move == 0 || (dir != 'R' && dir != 'L')) {
            return array;
        }

        if (move < 0) {
            dir = dir == 'R' ? 'L' : 'R';
            move = -move;
        }

        move %= array.length;

        // The number of values that only need to advance `move` positions
        // (and don't need to wrap around)
        int unwrappedLength = array.length - move;

        if (dir == 'R') {
            int[] wrapped = Arrays.copyOfRange(array, unwrappedLength, array.length);
            System.arraycopy(array, 0, array, move, unwrappedLength);
            System.arraycopy(wrapped, 0, array, 0, move);
        } else {
            int[] wrapped = Arrays.copyOfRange(array, 0, move);
            System.arraycopy(array, move, array, 0, unwrappedLength);
            System.arraycopy(wrapped, 0, array, unwrappedLength, move);
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 0, 8, 9, 5, 6 }, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] {}, 3, 'R'))); // []
    }
}