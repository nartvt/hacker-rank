package main

import "fmt"

func main() {

	fmt.Println(findMedianSortedArrays([]int{1, 3}, []int{2}))
}
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	var arr []int
	if len(nums1) == 0 && len(nums2) == 0 {
		return 0.0
	}
	if len(nums1) == 0 && len(nums2) != 0 {
		arr = nums2
	}
	if len(nums1) != 0 && len(nums2) == 0 {
		arr = nums1
	}
	if len(nums1) != 0 && len(nums2) != 0 {
		arr = append(nums1, nums2...)
		arr = mergeSort(arr)
	}

	length := len(arr)
	if length%2 == 0 {
		a := arr[length/2-1]
		b := arr[length/2]
		return float64(a+b) / 2
	} else {
		return float64(arr[(length+1)/2-1])
	}
}

func mergeSort(items []int) []int {
	if len(items) < 2 {
		return items
	}
	first := mergeSort(items[:len(items)/2])
	second := mergeSort(items[len(items)/2:])
	return merge(first, second)
}

func merge(a []int, b []int) []int {
	final := []int{}
	i := 0
	j := 0
	for i < len(a) && j < len(b) {
		if a[i] < b[j] {
			final = append(final, a[i])
			i++
		} else {
			final = append(final, b[j])
			j++
		}
	}
	for ; i < len(a); i++ {
		final = append(final, a[i])
	}
	for ; j < len(b); j++ {
		final = append(final, b[j])
	}
	return final
}
