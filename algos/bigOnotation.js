function countUpTo(n){
    let total = 0;
    for(let i =1; i<=n; i++){
        total += i
    }
    
    return total
}


// console.log(countUpTo(1));
// console.log(countUpTo(2));
// console.log(countUpTo(3));
// console.log(countUpTo(10000000000));






function countUpTheLoot(n){
    return n*(n+1)/2
}

// console.log(countUpTheLoot(1)) //3 operations
// console.log(countUpTheLoot(2)) //3 operations
// console.log(countUpTheLoot(3)) //3 operations
// console.log(countUpTheLoot(5)) //3 operations

console.log(countUpTheLoot(10000000000))


//nested loop- o(n2)- exponential
const boxes = [1]
function logallpairs(array){
    for(let i =0; i< array.length; i++){
        for(let j= 0; j<array.length; j++){
            console.log(array[i],arr[j])
        }
    }
}


