
function balancepoint(arr){
    let total = 0;
    let leftsum = 0;
    //first loop through to find total sum
    for(let i = 0; i < arr.length; i++){
        total+= arr[i]
    }

    //go through array again, and at each index (each iteration), add to left sum, then compare leftsum with total-leftsum, and if those ar  equal return true
    for(let i = 0; i< arr.length; i++){
       leftsum+= arr[i]
       //compare leftsum with total-leftsum, and if those ar  equal return true
       if(leftsum == (total-leftsum)){
           return true
       }
    }
    return false


}


console.log(balancepoint([1,2,3,4,10])) //true   
console.log(balancepoint([4,7,1,3])) //false



// total = 20

// leftsum = 10


// remaining(total-leftsum) -> 10