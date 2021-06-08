function binarySearch(arr, value){

    let start = 0;
    let end = arr.length

    while(start<end){
        //figure out the midpoint
        let midpoint = Math.floor((start+end)/2)

        //check if value to find is == to midpoint
        if(arr[midpoint] == value){
            return true
        }
        //if value we looking for is greater than midpoint, then then narrow it down to look at the right side of the midpoint
        else if(value > arr[midpoint]){
            start = midpoint+1
        }
        else{
            end = midpoint-1
        }
    }

    if(arr[start] == value){
        return true
    }
    else{
        return false
    }


}


console.log(binarySearch([5,8,9,15,17,23,24,34,77], 60)) //false
console.log(binarySearch([5,8,9,15,17,23,24,34,77], 34))//true
