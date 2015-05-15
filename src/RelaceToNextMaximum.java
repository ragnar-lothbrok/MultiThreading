// array is {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2,
// -1}.
public class RelaceToNextMaximum {

    public static void main(String[] args) {
        int[] input = { 16, 17, 4, 3, 5, 2 };
        RelaceToNextMaximum obj = new RelaceToNextMaximum();
        obj.replaceArrayElements(input);
        ;

    }

    public void replaceArrayElements(int[] input) {
        display(input);
        int maximumValue = input[input.length - 1];
        for (int i = input.length - 2; i >= 0; i--) {
            if (maximumValue < input[i]) {
                maximumValue = input[i];
            }
            input[i] = maximumValue;
        }
        display(input);
    }

    public void display(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + "\t");
        }
        System.out.println();
    }

}
