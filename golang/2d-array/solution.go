package main

import "fmt"

func main() {
	arrays := initArrs()
	fmt.Println("Max: ",calculate(arrays))
}

func calculate(arrays [6][6]int32) int32 {

	var values []int32
	for i, arr := range arrays {
		for j, _ := range arr {
			if j+2 <= 5 && i+2 <= 5 {
				value := arr[j] + arr[j+1] + arr[j+2] + arrays[i+1][j+1] + arrays[i+2][j] + arrays[i+2][j+1] + arrays[i+2][j+2]
				values = append(values, value)
				fmt.Printf("----value: %d------\n", value)
				fmt.Printf("%d %d %d\n", arr[j], arr[j+1], arr[j+2])
				fmt.Printf("  %d  \n", arrays[i+1][j+1])
				fmt.Printf("%d %d %d\n", arrays[i+2][j], arrays[i+2][j+1], arrays[i+2][j+2])
			}

		}
	}
	return findMax(values)
}
func findMax(arr []int32) int32 {
	max := arr[0]
	for _, value := range arr {
		if value > max {
			max = value
		}
	}
	return max
}
func initArrs() [6][6]int32 {
	var arrs [6][6]int32
	arrs[0][0] = 1
	arrs[0][1] = 1
	arrs[0][2] = 1
	arrs[0][3] = 0
	arrs[0][4] = 0
	arrs[0][5] = 0

	arrs[1][0] = 0
	arrs[1][1] = 1
	arrs[1][2] = 0
	arrs[1][3] = 0
	arrs[1][4] = 0
	arrs[1][5] = 0

	arrs[2][0] = 1
	arrs[2][1] = 1
	arrs[2][2] = 1
	arrs[2][3] = 0
	arrs[2][4] = 0
	arrs[2][5] = 0

	arrs[3][0] = 0
	arrs[3][1] = 0
	arrs[3][2] = 2
	arrs[3][3] = 4
	arrs[3][4] = 4
	arrs[3][5] = 0

	arrs[4][0] = 0
	arrs[4][1] = 0
	arrs[4][2] = 0
	arrs[4][3] = 2
	arrs[4][4] = 0
	arrs[4][5] = 0

	arrs[5][0] = 0
	arrs[5][1] = 0
	arrs[5][2] = 1
	arrs[5][3] = 2
	arrs[5][4] = 4
	arrs[5][5] = 0
	return arrs
}
