class Node{
    constructor(valueinput){
        this.value = valueinput;
        this.next = null;
        this.prev = null;
    }
}

class DLL {
    constructor(){
        this.head = null;
        this.tail = null;
    }
    //thursday
    addfront(valueInput){
        let newNode = new Node(valueInput);
        if(!this.head){
          this.head = newNode;
          this.tail = newNode;
        }else{
          newNode.next = this.head;
          this.head.prev = newNode;
          this.head = newNode;
        }

        return this;
  
      }
      
      //thursday
      addback(valueInput){
        let newNode = new Node(valueInput);
        if(!this.head){
          this.head = newNode;
          this.tail = newNode;
        }else{
          this.tail.next = newNode;
          newNode.prev = this.tail;
          this.tail = newNode;
        }
  
  
      }

      isHeadCorrect(){
          console.log(this.head.value)
          console.log(this.head.prev)
          console.log(this.head.next)



      }


    //friday
    removefront(){

    }

    removeBack(){

    }


    reverse(){

    }
}



let dl1 = new DLL();
dl1.addfront(8).addfront(5).addfront(12).addback(99)