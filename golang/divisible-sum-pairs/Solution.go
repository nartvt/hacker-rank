package main

import "fmt"

func main() {
	fmt.Println(divisibleSumPairs(6, 3, []int32{1, 3, 2, 6, 1, 2}))
}

func divisibleSumPairs(n int32, k int32, ar []int32) int32 {
	if int32(len(ar)) != n {
		return 0
	}
	count := int32(0)
	for i, vi := range ar {
		for j := 0; j < len(ar); j++ {
			if i!=j && (vi+ar[j])%k == 0 {
				count++
			}
		}
	}
	return count/2
}
