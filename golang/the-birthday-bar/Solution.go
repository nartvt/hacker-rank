package main

import "fmt"

func main() {
	fmt.Println(birthday([]int32{4, 1, 4, 3, 3, 5, 1, 2, 4, 2, 5, 1, 5, 1, 4, 1, 3, 1, 5, 2, 2, 2, 1, 1,
		3, 2, 5, 3, 1, 5, 4, 5, 2, 2, 1, 1, 2, 2, 4, 5, 4, 1, 5, 2, 1, 1, 2, 2, 1, 3, 2, 4, 4, 1,
		3, 2, 2, 3, 1, 5, 4, 4, 1, 4, 2, 1, 2, 1, 5, 1, 3, 3, 4, 2, 1, 5, 5, 4, 2, 2, 3, 3, 4, 3, 1, 2, 1, 2, 4, 3}, 16, 7))

	fmt.Println(birthday([]int32{1, 2, 1, 3, 2}, 3, 2))
	fmt.Println(birthday([]int32{1, 1, 1, 1, 1, 1}, 3, 2))
	fmt.Println(birthday([]int32{4}, 4, 1))
}

func dateValid(m int32, d int32) bool {
	if m <= 0 || m > 12 || d <= 0 {
		return false
	}
	switch m {
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
		if d > 31 {
			return false
		}
	case 4:
	case 6:
	case 9:
	case 11:
		if d > 30 {
			return false
		}
	case 2:
		if d > 29 {
			return false
		}
	}
	return true
}

func birthday(s []int32, d int32, m int32) int32 {
	if int32(len(s)) < m {
		return 0
	}
	if sum(s) < d {
		return 0
	}
	if int32(len(s)) == m && s[0] == d {
		return 1
	}
	if !dateValid(m, d) {
		return 0
	}
	count := 0
	for i, _ := range s {
		if int32(i)+m <= int32(len(s)) && sum(s[i:m+int32(i)]) == d {
			count++
		}
	}
	return int32(count)
}
func sum(arr []int32) int32 {
	//fmt.Println(arr)
	count := int32(0)
	for _, v := range arr {
		count += v
	}
	return count
}
