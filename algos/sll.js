class Node{
    constructor(valueinput){
        this.value = valueinput;
        this.next = null;

        //here is a new attribute, this.child
        this.child = null;
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

    addToFront(val){
        let newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
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


      //populates each node with a random amount of children from 0 to 4
    populateChildren(){

        let runner = this.head;

        while(runner !== null){
            let numChildren = Math.floor(Math.random() * 5);
            if(numChildren !== 0){
                let childList = new SLL();
                for(let i = 0; i < numChildren; ++i){
                    childList.addToFront(Math.floor(Math.random() * 50));
                }
                runner.child = childList;
            }
            runner = runner.next;
        }
    }

    printMeWithChildren(){
        let returnStr = '';
        let runner = this.head;
        while(runner != null){
            returnStr += `${runner.value}`;
            if(runner.child){
                returnStr += "(";
                let runner2 = runner.child.head;
                while(runner2 !== null){
                    returnStr += `${runner2.value} ->`;
                    runner2 = runner2.next;
                }
                returnStr += ")";
            }
            returnStr += " -> ";
            runner = runner.next;
        }
        console.log(returnStr);
        return returnStr;
    }


    flattenChildren(){
        let runner = this.head;
        while (runner!= null){
            //if the node we currently are on (runner) does not have a child, then skip it
            if(runner.child == null){
                runner = runner.next;
                continue;
            }
            //if the node has children, then iterate through the child list to the last node
            let childRunner = runner.child.head
            while(childRunner.next != null){
                childRunner = childRunner.next;
            }
            //at this point, i have the a pointer pointing to the last node in the child sll, and I can point that nodes .next to point to the runner.next
            childRunner.next = runner.next;
            runner.next = runner.child.head;
            // runner.child = null;
            runner = runner.next;
        }

    }


}



let sll1 = new SLL();
sll1.addToFront(5);
sll1.addToFront(15);
sll1.addToFront(2);
sll1.addToFront(23);

sll1.populateChildren();
sll1.printMeWithChildren();
sll1.flattenChildren();
sll1.display();
sll1.printMeWithChildren();





