package main

import "fmt"

func main() {

	fmt.Println(decToBinary(125))
}

func decToBinary(n int32) int32{
	count1s:=0
	var arr[]int32
	for n!=0{
		remain:= n%2
		n=n/2
		if remain==1{
			count1s++
		}else{
			if count1s!=0{
				arr = append(arr,int32(count1s))
				count1s=0
			}

		}

	}
	if count1s!=0{
		arr = append(arr,int32(count1s))
		count1s=0
	}
	return findMax(arr)
}
func findMax(arr [] int32) int32{
	max:=arr[0]
	for i:=1;i<len(arr);i++{
		if max < arr[i]{
			max = arr[i]
		}
	}
	return max
}
