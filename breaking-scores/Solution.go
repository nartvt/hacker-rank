package breaking_scores

func breakingRecords(scores []int32) []int32 {
	// Write your code here
	l :=scores[0]
	h :=scores[0]
	var result [] int32
	result = append(result,0,0)
	for i:=1;i<len(scores);i++{
		if l>scores[i] {
			l=scores[i]
			result[1]++
		}
		if h<scores[i]{
			h=scores[i]
			result[0]++
		}
	}
	return result
}
