package main

import (
	"fmt"
)

func pageCount(n int32, p int32) int32 {
	if n == 1 {
		return 0
	}
	var arrResult [][]int32
	arrResult = append(arrResult, []int32{1})
	for i := int32(2); i <= n; i++ {
		if i%2 == 0 {
			var temp []int32
			temp = append(temp, i)
			if i < n {
				temp = append(temp, i+1)
			}

			arrResult = append(arrResult, temp)
		}
	}

	begin := 0
	end := 0
	for i := 0; i < len(arrResult); i++ {
		fromBegin := arrResult[i]
		for j := 0; j < len(fromBegin); j++ {
			if p == fromBegin[j] {
				begin = i
				break
			}
		}
		fromLast := arrResult[len(arrResult)-i-1]
		for j := 0; j < len(fromLast); j++ {
			if p == fromLast[j] {
				end = i
				break
			}
		}
	}
	if begin > end {
		return int32(end)
	}
	return int32(begin)
}

func main() {
	fmt.Println(pageCount(6, 2))
}
