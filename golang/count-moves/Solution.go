package main

import (
	"fmt"
	"strings"
	"time"
)

func main() {
	var numbers []int32
	numbers = append(numbers, 5)
	numbers = append(numbers, 6)
	numbers = append(numbers, 8)
	numbers = append(numbers, 8)
	numbers = append(numbers, 5)
	numbers = append(numbers, 100)
	numbers = append(numbers, 101)
	numbers = append(numbers, 1)
	numbers = append(numbers, 50)
	numbers = append(numbers, 2)
	before:=time.Now()
	fmt.Println(countMoves(numbers))
	after:=time.Now()
	fmt.Printf("\nCalculate time: %d", after.UnixNano() - before.UnixNano())
}
func getMaxIndex(numbers []int32) int {
	iMax := 0
	max := numbers[0]
	for i, num := range numbers {
		if num > max {
			max = num
			iMax = i
		}
	}
	return iMax
}

var step int64 = 0

func equalsArr(numbers []int32) bool {

	flag := numbers[0]

	for _, num := range numbers {
		if num != numbers[0] {
			flag = num
			break
		}
	}
	if flag == numbers[0] {
		return true
	}
	return false
}
func countMoves(numbers []int32) int64 {
	if len(numbers) == 0 {
		return 0
	}
	if equalsArr(numbers) {
		return step
	}
	for !equalsArr(numbers) {
		iMax := getMaxIndex(numbers)
		for i, num := range numbers {
			if i != iMax {
				numbers[i] = num + 1
			}
		}
		step++
	}
	return step
}

func getUniqueCharacter(s string) int32 {
	arr := strings.Split(s, "")
	maps := make(map[string]int)
	indexs := make(map[string]int)
	for i := 0; i < len(arr); i++ {
		v, ok := maps[arr[i]]
		if !ok {
			maps[arr[i]] = 1
		} else {
			v += 1
			maps[arr[i]] = v
		}
		indexs[arr[i]] = i + 1
	}
	var uniques []string
	for k, v := range maps {
		if v == 1 {
			uniques = append(uniques, k)
		}
	}
	fmt.Println(uniques)
	for _, i := range uniques {
		v, ok := indexs[i]
		if ok {
			return int32(v)

		}
	}
	return int32(-1)
}