class Node{
    constructor(value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}


class BST{
    constructor(){
        this.root = null;
    }

    add(value){
        //create a node
        let newNode = new Node(value)
        if(this.root == null){
            this.root = newNode;
        }else{
            let runner = this.root;
            while(runner!= null){
                if(value > runner.value){
                    if(runner.right == null){
                        runner.right = newNode;
                        break
                    }else{
                        runner = runner.right
                    }
                }else if(value < runner.value){
                    if(runner.left == null){
                        runner.left = newNode;
                        break
                    }else{
                        runner = runner.left
                    }
                }else{
                    console.log("no duplicates allowed in a BST")
                    return this;
                }
            }
        }
        return this;
    }


    findMin(){

    }

    findMax(){

    }

    printTree(node){
        console.log("Current node = ", node.value);
        if(node.left!=null){
            console.log("left node of", node.value, "= " + node.left.value)
            this.printTree(node.left)
        }
        if(node.right != null){
            console.log("Right node of", node.value, " = " + node.right.value)
            this.printTree(node.right);
        }
    }

    contains(value){
        if(this.root== null){
            console.log("This tree is empty, it doesn't contain anything")
            return false
        }else{
            let current = this.root
            while(current!= null){
                //if the value is in the current node
                if(value== current.value){
                    return true
                }else if (value > current.value){
                    current = current.right;
                }else{
                    current = current.left;
                }
            }

            return false


        }
        

    }

    size(node){
        if(node ==null){
            console.log("no size");
            return false
        }else{
            return (this.size(node.left) + 1 + this.size(node.right))
        }
    }
}



let bst1 = new BST()
bst1.add(12).add(15).add(10).add(11)
console.log(bst1.contains(23)) //return false
console.log(bst1.contains(12)) //return true
console.log(bst1.size(bst1.root)) //4
