# iTunesSearch
This application work for to search adudio and video content i.e movies, music, podcast, audio book and short films and TV shows

To search video and audio content and return only the first two items.

To search only music videos.

To serarch for all audio and video content and return only the results from the country iTunes store as per the data.

To run test cases run below command
gradle clean build

add:
POST: http://localhost:8080/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/apple_ref/doc/uid
Request: {
    "id": 1,
    "uid": "TP40017632-CH3-SW1",
    "productId": "TP40017632-CH3-SW1",
    "productDes": "IPhone Supported",
    "productType": "Video",
    "productRef": "Apple Store"
}
getAll:
GET: http://localhost:8080/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/all
{
    "resultCount": 3,
    "appleTunes": [
        {
            "id": 1,
            "uid": "TP40017632-CH3-SW1",
            "productId": "TP40017632-CH3-SW1",
            "productDes": "IPhone Supported",
            "productType": "Video",
            "productRef": "Apple Store"
        },
        {
            "id": 2,
            "uid": "TP40017632-CH3-SW1",
            "productId": "TP40017632-CH3-SW1",
            "productDes": "IPhone Supported",
            "productType": "Audio",
            "productRef": "Apple Store"
        },
        {
            "id": 3,
            "uid": "TP40017632-CH3-SW1",
            "productId": "TP40017632-CH3-SW1",
            "productDes": "IPhone Supported",
            "productType": "Video",
            "productRef": "Apple Store"
        }
    ]
}

getAll by term and limit
GET: http://localhost:8080/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/all?term=Video&limit=2
{
    "resultCount": 2,
    "appleTunes": [
        {
            "id": 1,
            "uid": "TP40017632-CH3-SW1",
            "productId": "TP40017632-CH3-SW1",
            "productDes": "IPhone Supported",
            "productType": "Video",
            "productRef": "Apple Store"
        },
        {
            "id": 3,
            "uid": "TP40017632-CH3-SW1",
            "productId": "TP40017632-CH3-SW1",
            "productDes": "IPhone Supported",
            "productType": "Video",
            "productRef": "Apple Store"
        }
    ]
}
