class Node{
    constructor(valueinput){
        this.value = valueinput;
        this.next = null;
    }
}


class SLL{
    constructor(){
        this.head = null;
    }

    addToBack(valueinput){
        let newnode = new Node(valueinput);
        if(this.head == null){
            this.head = newnode;
        }else{
            let runner = this.head;
            while(runner.next != null){
                runner = runner.next
            }
            runner.next = newnode;

        }
    }

    display(){
        let runner = this.head;
        while(runner){
            console.log(runner.value + " -->");
            runner = runner.next;
        }
    }

    reverseList(){
        let arr= [];
        let runner= this.head;
        if(this.head ==null){
            return "List does not have values"
        }
        while(runner!= null){
            arr.unshift(runner.value)
            runner = runner.next
        }
        runner = this.head
        for(let i=0; i<arr.length; i++){
            this.addToBack(arr[i]);
            this.removeFromFront();
        }
        return this;
    }

    reverse2(){
        if(!this.head){
          return "List is empty!"
        }
        let prev = null;
        let cur = this.head;
        let next = cur.next;
  
        while(next){
          cur.next = prev;
          prev = cur;
          cur = next;
          next = next.next;
        }
        cur.next = prev;
        this.head = cur; 
      }
}



let sll1 = new SLL();
sll1.addToBack(5);
sll1.addToBack(12);
sll1.addToBack(3);
sll1.addToBack(37);
sll1.addToBack(2);


sll1.display()
sll1.reverse2()
console.log("***********")
sll1.display()


