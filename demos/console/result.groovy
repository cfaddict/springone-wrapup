// given an array of maps
def result = [
    [Date: '10/29', HOST2:5, HOST3:5, HOST1:5], 
    [Date: '10/29', COMPLETED:5], 
    [Date: '10/30', HOST2:6, HOST3:6, HOST1:6], 
    [Date: '10/30', COMPLETED:6], 
    [Date: '10/31', HOST2:7, HOST3:7, HOST1:7], 
    [Date: '10/31', COMPLETED:7]
]

// produce a result that looks like this (group by date)
// [Date:10/29, HOST2:5, HOST3:5, HOST1:5, COMPLETED:5]

result.groupBy { it.Date }.collect { key,value -> value.collectEntries() }.each {
    println it
}