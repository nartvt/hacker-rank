package main

import "fmt"

func main() {
	var a []int32
	var b []int32
	a = append(a, 2, 4)
	b = append(b, 16, 32, 96)
	fmt.Println(getTotalX(a, b))
}

func getTotalX(a []int32, b []int32) int32 {
	maxA := getMax(a)
	minB := getMin(b)

	var result []int32
	for i := maxA; i <= minB; i++ {
		if getCommonMulti(i, a) != -1 && getCommonDiv(i, b) != -1 {
			result = append(result, i)
		}
	}
	if len(result) == 0 {
		return 0
	}
	return int32(len(result))

}

func getCommonDiv(number int32, a []int32) int32 {
	isFound := true
	for j := 0; j < len(a); j++ {
		if a[j]%number != 0 {
			isFound = false
			break
		}
	}
	if isFound {
		return number
	}
	return -1
}
func getMax(a []int32) int32 {
	max := a[0]
	for _, va := range a {
		if max < va {
			max = va
		}
	}
	return max
}
func getMin(a []int32) int32 {
	min := a[0]
	for _, va := range a {
		if min > va {
			min = va
		}
	}
	return min
}
func getCommonMulti(number int32, a []int32) int32 {
	isFound := true
	for j := 0; j < len(a); j++ {
		if number%a[j] != 0 {
			isFound = false
			break
		}
	}
	if isFound {
		return number
	}
	return -1
}
