package main

import "fmt"

func main() {
	fmt.Println(sockMerchant(9, []int32{10, 20, 20, 10, 10, 30, 50, 10, 20}))
}

func sockMerchant(n int32, arr []int32) int32 {
	maps := make(map[int32]int)
	for i := int32(0); i < n; i++ {
		if _, ok := maps[arr[i]]; ok {
			maps[arr[i]]++
		} else {
			maps[arr[i]] = 1
		}
	}
	result := 0
	for _, v := range maps {

		if v >=2 {
			if v == 2 {
				result++
			} else {
				result += v / 2
			}

		}
	}
	return int32(result)
}
