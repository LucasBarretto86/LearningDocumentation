# JAVASCRIPT CHALLENGE

## CHALLENGE 1
In this kata you are required to, given a string, replace every letter with its position in the alphabet.

If anything in the text isn't a letter, ignore it and don't return it.

"a" = 1, "b" = 2, etc.

### ANSWER / MY ANSWER
~~~
function alphabetPosition(text) {
  const alphabet = ["","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
  let matches = text.toLowerCase().match(/[a-z]/g)
  
  if (matches == ) return ""

  return matches.map((letter) => alphabet.indexOf(letter)).join(" ")
}
~~~

### BETTER ANSWER
~~~
function alphabetPosition(text) {
  return text.match(/[a-zA-Z]/g).map( (el) => el.toLowerCase().charCodeAt() - 96 ).join(' ');
}
~~~

## CHALLENGE 2
In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have function with one side of the DNA (string, except for Haskell); you need to get the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).

~~~
DNAStrand ("ATTGC") // return "TAACG"

DNAStrand ("GTAT") // return "CATA" 
~~~

### ANSWER / MY ANSWER
~~~
function DNAStrand(dna){
  const sequencer = {
    A: 'T',
    T: 'A',
    G: 'C',
    C: 'G'
  }
  
  let DNASequenced = dna.split("").map((piece) => sequencer[piece]).join("")
  
  return DNASequenced
}
~~~

## CHALLENGE 3
Give an perfect square number return the next perfect square root or return -1 if initial param isn't a perfect square root 

### BETTER ANSWER
~~~
function findNextSquare(sq) {
  return Math.sqrt(sq) % 1 ? -1 : Math.pow(Math.sqrt(sq)+1, 2);
}
~~~

## CHALLENGE 4
Take 2 strings s1 and s2 including only letters from ato z. Return a new sorted string, the longest possible, containing distinct letters - each taken only once - coming from s1 or s2.

Examples:
a = "xyaabbbccccdefww"
b = "xxxxyyyyabklmopq"
longest(a, b) -> "abcdefklmopqwxy"

a = "abcdefghijklmnopqrstuvwxyz"
longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"

### MY ANSWER
~~~
Array.from(new Set((a + b).match(/\w/g).sort())).join("")
~~~

### BETTER ANSWER
~~~
[... new Set(a + b)].sort().join("")
~~~ 

## CHALLENGE 5 
In this kata you will create a function that takes a list of non-negative integers and strings and returns a new list with the strings filtered out.

Example
filter_list([1,2,'a','b']) == [1,2]
filter_list([1,'a','b',0,15]) == [1,0,15]
filter_list([1,2,'aasf','1','123',123]) == [1,2,123]

### MY ANSWER
~~~
function filter_list(l) {
  return l.filter(a => (typeof(a) == "number"))
}
~~~

### BETTER ANSWER
~~~
function filter_list(l) {
  return l.filter(e => Number.isInteger(e));
}
~~~

## CHALLENGE 6
~~~   
~~~


## JOB CHALLENGE  
Have the function ArrayChallenge(arr) take the array of integers stored in arr and return the minimum number of integers needed to make the contents of arr consecutive from the lowest number to the highest number. For example: If arr contains [4, 8, 6] then the output should be 2 because two numbers need to be added to the array (5 and 7) to make it a consecutive array of numbers from 4 to 8. Negative numbers may be entered as parameters and no array will have less than 2 elements.

Examples
Input: [5,10,15]
Output: 8

Input: [-2,10,4]
Output: 10

## MY ANSWER
~~~
function ArrayChallenge(arr){
  let [min, max] = minMax(arr)
  let newArr = []
  
  for(min; min <= max; min++ ) newArr.push(min);

  return newArr.length - arr.length
}

function minMax(arr) {
  if (arr.some(el => el < 0)) {
    arr = arr.sort((a, b) => a - b)
  } else {
    arr = arr.sort(a => a)
  }

  return [arr[0], arr[arr.length-1]]
}
~~~

## JOB CHALLENGE 2
input
["X:-1", "Y:4", "A:2", "X:2", "Y:2", "X:1", "Z:0"]

Output
["X:2", "Y:6", "A:2"]

## MY ANSWER
~~~
~~~

## JOB CHALLENGE 3
Get the second higher number from an array

input
[5, 7, 3, 10, 9, 8, 6, 1]

Output
9

input
[3, 2, 8, 1, 9, 7, 6, 1]

Output
8


## MY ANSWER
~~~
const secondGreater = () => (arr){ arr.sort()[arr.length - 2]}
~~~

## THOUGHTS
I think that the easiest way to discover it followe a data structure would be 'breaking' the arry in two, reach the highest value from the first chunk and then the highest from the second chunk then compare the highest value between the two, by doing that we have a data structure twice as fast.

Example:
[5, 7, 3, 10, 9, 8, 6, 1]

first_chunk  = [5, 7, 3, 10]
second_chunk = [9, 8, 6, 1]

highest from the first chunk is 10
highest from the second chunk is 9

so the second highest is 9

~~~

~~~

