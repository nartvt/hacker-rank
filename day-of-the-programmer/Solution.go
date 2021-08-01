package main

import "fmt"

var mapMonths map[int32]int32

const programDate = 256
const transitionJuliaToGregorianYear = 1918

func init() {
	mapMonths = make(map[int32]int32)
	gregorianCalendar()
}
func gregorianCalendar() {
	mapMonths[1] = 31
	mapMonths[3] = 31
	mapMonths[4] = 30
	mapMonths[5] = 31
	mapMonths[6] = 30
	mapMonths[7] = 31
	mapMonths[8] = 31
	mapMonths[9] = 30
	mapMonths[10] = 31
	mapMonths[11] = 30
	mapMonths[12] = 31
}
func juliaCalendar() {
	mapMonths[1] = 31
	mapMonths[3] = 31
	mapMonths[4] = 30
	mapMonths[5] = 31
	mapMonths[6] = 30
	mapMonths[7] = 31
	mapMonths[8] = 30
	mapMonths[9] = 31
	mapMonths[10] = 30
	mapMonths[11] = 31
	mapMonths[12] = 30
}
func leapYearGregorian(year int32) bool {
	if year < 4 {
		return false
	}
	if year%400 == 0 || year%4 == 0 && year%100 != 0 {
		return true
	}
	return false
}
func leapYearJulian(year int32) bool {
	if year < 4 {
		return false
	}
	if year%4 == 0 {
		return true
	}
	return false
}

func dayOfProgram(year int32) string {

	// julian date
	if year >= 1700 && year <= 1917 {
		juliaCalendar()
		if leapYearJulian(year) {
			mapMonths[2] = 30
		} else {
			mapMonths[2] = 29
		}
	}
	if year >= 1919 {
		if leapYearGregorian(year) {
			mapMonths[2] = 29
		} else {
			mapMonths[2] = 28
		}
	}
	findDate := int32(0)
	result := ""
	for k := int32(1); k < int32(len(mapMonths)); k++ {
		v := mapMonths[k]
		if k <= 8 {
			if year == transitionJuliaToGregorianYear {
				/*
					From 1700 to 1917, Russia's official calendar was the Julian calendar; since 1919 they used the Gregorian calendar system.
					The transition from the Julian to Gregorian calendar system occurred in 1918, when the next day after January 31st was February 14th.
					This means that in 1918, February 14th was the 32nd day of the year in Russia.
				*/
				if k == 1 {
					if leapYearGregorian(year) {
						findDate += v + 1 + 15
					} else {
						findDate += v + 1 + 14
					}

				} else if k > 2 { // ignore month = 2 at 1918 years
					findDate += v
				}
			} else {
				findDate += v
			}
		} else {
			for i := int32(1); i <= v; i++ {
				findDate++
				if findDate == programDate {
					if k < 10 {
						result = fmt.Sprintf("%d.0%d", i, k)
					} else {
						result = fmt.Sprintf("%d.%d", i, k)
					}
					break
				}
			}
			if findDate == programDate {
				break
			}
		}
	}
	return result
}
func dayOfProgrammer2(year int32) string {
	if year == 1918 {
		return fmt.Sprintf("26.09.%d", year)
	}
	if year <= 1917 && leapYearJulian(year) || year > 1918 && leapYearGregorian(year) {
		return fmt.Sprintf("12.09.%d", year)
	} else {
		return fmt.Sprintf("13.09.%d", year)
	}
}
func dayOfProgrammer(year int32) string {
	return fmt.Sprintf("%s.%d", dayOfProgram(year), year)
}

func main() {
	fmt.Println(dayOfProgrammer2(1800))
	fmt.Println(dayOfProgrammer(1800))
}
