import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        // Uncomment one of the following input arrays as needed:
        // int[] arr = {1, 2, 3};
        int[] arr = {1, 2, 2};

        // For subsets without duplicates:
        // List<List<Integer>> ans = subset(arr);

        // For subsets with duplicates:
        List<List<Integer>> ans = subsetDuplicate(arr);

        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

//    static List<List<Integer>> subset(int[] arr){
//        List<List<Integer>> outer=new ArrayList<>();
//
//        outer.add(new ArrayList<>());
//
//        for(int num: arr){
//            int n=outer.size();
//            for(int i=0;i<n;i++){
//                List<Integer> internal=new ArrayList<>(outer.get(i));
//                internal.add(num);
//                outer.add(internal);
//            }
//        }
//        return outer;

    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>()); // Start with an empty subset

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    static List<List<Integer>> subsetDuplicate(int[] arr) {
        Arrays.sort(arr); // Sort the array to handle duplicates
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>()); // Start with an empty subset

        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = 0;

            // If the current element is the same as the previous one, update the start index
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;

            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
