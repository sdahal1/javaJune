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
        return this;
  
  
      }

      isHeadCorrect(){
          console.log(this.head.value)
          console.log(this.head.prev)
          console.log(this.head.next)



      }

    printValuesForward(){
        let runner = this.head;
        let result = ""
        while(runner != null){
            result += `${runner.value}->`;

            runner = runner.next;
        }
        console.log(result);
        return this;
    }

    printValuesBackward(){
        let runner = this.tail;
        let result = ""
        while(runner != null){
            result += `${runner.value}->`;
            runner = runner.prev;
        }
        console.log(result);
        return this;
    }


    //friday
    removefront(){

    }

    removeBack(){

    }


    reverse(){
      let runner = this.head;
      let backward = this.tail;
      while(runner!=backward && runner.prev !=backward){
        let temp = runner.value
        runner.value = backward.value
        backward.value= temp
        runner = runner.next
        backward = backward.prev
      }
      return this

    }


    recurseReverse(runner = this.head){
      if(runner === null){
          [this.head, this.tail] = [this.tail, this.head];
          return this;
      }
      [runner.prev, runner.next] = [runner.next, runner.prev];
      return this.recurseReverse(runner.prev);
  }
}



let dl1 = new DLL();
dl1.addfront(8).addfront(5).addfront(12).addback(99).printValuesForward().reverse().printValuesForward().printValuesBackward()