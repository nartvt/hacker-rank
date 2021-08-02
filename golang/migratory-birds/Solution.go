package main

import "fmt"

func main() {

	fmt.Println(migratoryBirds([]int32{1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4}))
}

func migratoryBirds(arr []int32) int32 {
	if len(arr) <1{
		return 0
	}
	if len(arr) == 1{
		return 1
	}
	maps:=make(map[int32]int32)
	for _,val:=range arr{
		_,ok:=maps[val]
		if ok{
			maps[val]++
		}else{
			maps[val] = 1
		}
	}

	lowId:=int32(0)
	low:=int32(0)

	highId:=int32(0)
	high:=int32(0)
	for k,v:=range maps{
		if high < v {
			highId = k
			high = v
		}
		if high==v && lowId!=highId{
			lowId = k
			low = v
		}
	}
	if low == high {
		return lowId
	}
	return highId
}
