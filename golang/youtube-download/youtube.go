package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"net/url"
	"regexp"
)

type MetaData struct {
	Title       string  `meta:"og:title"`
	Description string  `meta:"og:description,description"`
	Type        string  `meta:"og:type"`
	URL         url.URL `meta:"og:url"`
	VideoWidth  int64   `meta:"og:video:width"`
	VideoHeight int64   `meta:"og:video:height"`
}

func SearchForVideoLinks(url string) {

	fmt.Println("Parsing : ", url)

	// Request the HTML page.
	resp, err := http.Get(url)
	if err != nil {
		log.Fatal(err)
	}
	defer resp.Body.Close()
	if resp.StatusCode != 200 {
		log.Fatalf("Unable to get URL with status code error: %d %s", resp.StatusCode, resp.Status)
	}

	htmlData, err := ioutil.ReadAll(resp.Body)

	if err != nil {
		log.Fatal(err)
	}

	videoRegExp := regexp.MustCompile(`<video[^>]+`)
	sourceRegExp := regexp.MustCompile(`<source[^>]+`)

	videoMatchSlice := videoRegExp.FindAllStringSubmatch(string(htmlData), -1)
	sourceMatchSlice := sourceRegExp.FindAllStringSubmatch(string(htmlData), -1)

	for _, item := range videoMatchSlice {
		fmt.Println("Video found : ", item)
		for _, sourceItem := range sourceMatchSlice {
			fmt.Println("Source found : ", sourceItem)
		}
	}

}
func main() {
	//res, _ := http.Get("https://www.youtube.com/watch?v=OXQi-Oug6eU")
	//data := new(MetaData)
	//
	//err := extract.Metabolize(res.Body, data)
	//if err != nil {
	//	panic(err)
	//}
	////
	//fmt.Printf("Title: %s\n", data.Title)
	//fmt.Printf("Description: %s\n", data.Description)
	//fmt.Printf("Type: %s\n", data.Type)
	//fmt.Printf("URL: %s\n", data.URL.String())
	//fmt.Printf("VideoWidth: %d\n", data.VideoWidth)
	//fmt.Printf("VideoHeight: %d\n", data.VideoHeight)
	SearchForVideoLinks("https://www.youtube.com")
}