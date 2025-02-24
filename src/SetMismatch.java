public class SetMismatch {
    public static void main(String[] args) {
        SetMismatch sm = new SetMismatch();
        int[] arr = {1, 2, 2, 4};  // Example input array
        int[] result = sm.findErrorNums(arr);
        System.out.println("Duplicate: " + result[0] + ", Missing: " + result[1]);

    }
    public int[] findErrorNums(int[] arr){
        int i=0;
        while(i< arr.length){
            int correct=arr[i]-1;
            if(arr[i]< arr.length && arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
        //search for first missing number
        for(int index=0;index< arr.length;index++) {
            if (arr[index] != index + 1) {
                return new int[]{arr[index], index + 1};
            }
        }
            return new int[] {-1,-1};
        }
        static void swap(int[] arr,int first,int second){
            int temp=arr[first];
            arr[first]=arr[second];
            arr[second]=temp;

    }

}
