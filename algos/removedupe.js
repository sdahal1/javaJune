//challenge: remove duplicates from the original array without creating a new one (doing it in place)
//HINT: research the javascript array .splice() method

function removeDupes(arr){
    var obj = {}
    for(let i = 0; i< arr.length; i++){
        console.log(arr[i])
        console.log(obj[arr[i]])
        if(!obj[arr[i]]){
            obj[arr[i]] = 1
        }else{
            //here is where we handle the duplicate
            console.log("I IS CURRENTLY:", i)
            arr.splice(i,1)
            i--
        }
    }
    return arr
}


console.log(removeDupes([4,7,8,8,4,2,3])) //[4,7,8,2,3]

// {
//   4:1,
//   7:1,
//   8:1
// }

// [4,7,8, 4,2,3]


