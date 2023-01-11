
Please Run it before set up database on local

1. Create Database and table using data.sql file

Please find attached screenshot for different EndPoint testing

EndPoint2-1 for  endpoint: 
https://maersk.com/api/bookings/checkAvailable
it will return json 
```
{
 “availableSpace” : 6
}

```

EndPoint2-2, /isAvaible similar with 2-1 but return true or false 
```
{
 “available”: false
}

```

EndPoint3-1 /save , it will save the booking record to database as bookingsRefid as primary key and return it
```
{
 “bookingRef” : “957000002”
}


```

all the endpoint has been write code for catching error