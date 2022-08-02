class Solution {
    void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    int partition(int arr[], int low, int high){
        int randomIndex = low + (int)(Math.random() * (high - low + 1));
        swap(arr, randomIndex, high);
        
        int pivot = arr[high], i = low-1;
        
        for (int j = low; j < high; j++){
            if (arr[j] < pivot){
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, high);
        return i;
    }
    int kthSmallest(int[] arr, int low, int high, int k){
        while (true){
            
            int index = partition(arr, low, high);
            if (index == k)
                return arr[k];
            if (index < k)
                low = index+1;
            else
                high = index-1;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int arr[] = new int[m*n];
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                arr[i*n+j] = matrix[i][j];
            }
        }
        
        return kthSmallest(arr, 0, m*n-1, k-1); 
    }
}