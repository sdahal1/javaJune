class TrieNode{
    constructor(letter){
        this.letter = letter;
        this.children = {};
        this.isWord = false
    }
}

class TrieSet{
    constructor(){
        this.root = new TrieNode("")
    }
    add(str){
        //create a runner that allows us to navigate ourselves down this trie
        let runner = this.root;
        //loop through every character in the string
        for(let i = 0; i<str.length; i++){
            // console.log(str[i])
            //if the children of the current node we are on does not contain a key for the letter we want to reference, then we need to create a new node that contains that letter and assign that node to this particular nodes children
            if(!runner.children.hasOwnProperty(str[i])){
                runner.children[str[i]] = new TrieNode(str[i]);
            }
            //move runner to the node for that new letter that got inserted
            runner = runner.children[str[i]]
        }
        //at this point, we have runner at the node that represents the end of a word/term 
        runner.isWord = true

    }

    printAllWords(root = this.root, str=""){
        //base case
        if(root.isWord){
            console.log(str)
        }

        //forward progress--> recurse through each child node, while passing a string that we build along the way
        for(const key in root.children){
            this.printAllWords(root.children[key], str+key )
        }
    }

    contains(str){
        let runner = this.root;
        for(let i = 0; i< str.length && runner != null; ++i){
            if(runner.children[str[i]] == null) return false;
            runner = runner.children[str[i]]
            console.log("RUNNER IS NOW THIS--->", runner)
        }
        if(runner.letter = str[str.length-1] && runner.isWord){
            return true;
        }else{
            return false;
        }
    }

    autocomplete(str){
        const helperFunc = (root, newStr, arr) => {
            if(root.isWord){
                arr.push(newStr);
            }
            for(const key in root.children){
                arr = helperFunc(root.children[key], newStr + key, arr);
            }
            return arr;
        }
        let runner = this.root;
        for(let i = 0; i < str.length; ++i){
            if(!runner.children.hasOwnProperty(str[i])) return [];
            runner = runner.children[str[i]];
        }
        return helperFunc(runner, str, []);
    }


    
}



let words = new TrieSet();
words.add("apple")
words.add("app")
words.add("ape")
words.add("application")
words.add("ale")
words.add("dog")
words.add("do")


words.printAllWords()

console.log(words.autocomplete("ap")) //["apple", "app", "ape", "application"]
console.log(words.autocomplete("d")) //["dog", "do"]




