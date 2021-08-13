package main

import (
	"fmt"
	"sort"
)

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	arr:=append(nums1,nums2...)
	sort.Ints(arr)
	length:=len(arr)
	if length%2==0{
		a:=arr[length/2-1]
		b:=arr[length/2]
		return float64(a+b)/2
	}else{
		c:=arr[(length+1)/2-1]
		return float64(c)
	}
}
func main() {
	nums1:=[]int{1,3,9}
	nums2:=[]int{2}
	fmt.Printf("%f",findMedianSortedArrays(nums1,nums2))
}