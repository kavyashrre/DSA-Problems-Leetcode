class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length + nums2.length];
        int j = 0;
        int i = 0;
        int k = 0;
        while (i < nums1.length || j < nums2.length) {
            if(i>=nums1.length)
            {
                arr[k]=nums2[j];
                j++;
                k++;
            } else if (j>=nums2.length) {
                arr[k]=nums1[i];
                i++;
                k++;
            }
                
             else if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                k++;
                i++;
            } else if (nums1[i] > nums2[j]) {
                arr[k] = nums2[j];
                k++;
                j++;
            }
            else if (nums1[i] == nums2[j])
            {
                arr[k]=nums1[i];
                arr[k+1]=nums2[j];
                i++;
                j++;k=k+2;
            }
        }
        if((nums1.length + nums2.length)%2!=0)
        {
            double c=arr[(nums1.length + nums2.length)/2];
            return c;
        }
       
         double c=arr[arr.length/2];
         double t=arr[(arr.length/2)-1];
        return (c+t)/2;
        
    }
}