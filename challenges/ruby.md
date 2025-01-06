# Ruby Challenges

## Challenge #1

<!-- https://www.codewars.com/kata/515de9ae9dcfc28eb6000001/train/ruby -->

Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of characters then it should replace the missing second character of the final pair with an underscore ('_').

**Examples:**

```mono
'abc' =>  ['ab', 'c_']
'abcdef' => ['ab', 'cd', 'ef']
```

**Test:**

```rb
describe "Split Strings" do
  it "Basic tests" do
    expect(solution("abcef")).to eq(["ab", "cd", "ef"])
    expect(solution("abcdefg")).to eq(["ab", "cd", "ef", "g_"])
    expect(solution("")).to eq([])
  end
end
```

**My solution:**

```rb
def solution(str)
   letters = str.chars
  
   if letters.length.odd?
    solution((letters + ["_"]).join)
   else
     letters.each_slice(2).map {|pair| "%s%s" % pair}
   end
end
```

**Clever Solution:**

```rb
def solution(str)
  str << "_" if str.length.odd?
  
  arr = str.scan(/../)
end
```

---

## Challenge #2

<!-- https://www.codewars.com/kata/530e15517bc88ac656000716/train/ruby -->

ROT13 is a simple letter substitution cipher that replaces a letter with the letter 13 letters after it in the alphabet. ROT13 is an example of the Caesar cipher.

Create a function that takes a string and returns the string ciphered with Rot13. If there are numbers or special characters included in the string, they should be returned as they are. Only letters from the latin/english alphabet should be shifted, like in the original Rot13 "implementation".

**Test:**

```rb
describe "Rot13" do
  it "test" do
    Test.expect("grfg" == rot13("test"), "Input: test , Expected Output: grfg , Actual Output: " + rot13("test"))
  end    
  it "Test" do
    Test.expect("Grfg" == rot13("Test"), "Input: Test , Expected Output: Grfg , Actual Output: " + rot13("Test"))
  end
end
```

**My Solution:**

```rb
def rot13(string)
  letters = string.chars
  
  letters.map do |letter|
    return letter unless 
    
    rot13 = if /[A-Za-z]/.match?(letter)
      salt = "abcdefghijklmnopqrstuvwxyz"
      salt.upcase! if /[A-Z]/.match?(letter)
    
      salt_array = salt.chars
    
      position = salt_array.index(letter)
      rot13 = salt_array.rotate(position).at(13)
    else
      letter
    end
  
    rot13
  end.join
end

```

**Clever Solution:**

```rb
def rot13(string)
  string.tr("A-Za-z", "N-ZA-Mn-za-m")
end
```

**Most Readable:**

```rb
def rot13(string)
  alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
  cipher = "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM"

  string.tr(alphabet, cipher)
end
```

---

## Challenge 3

<!-- https://www.codewars.com/kata/54b724efac3d5402db00065e/train/ruby -->

In this kata you have to write a simple Morse code decoder. While the Morse code is now mostly superseded by voice and digital data communication channels, it still has its use in some applications around the world.
The Morse code encodes every character as a sequence of "dots" and "dashes". For example, the letter A is coded as `·−`, letter Q is coded as `−−·−`, and digit 1 is coded as `·−−−−`. The Morse code is case-insensitive, traditionally capital letters are used. When the message is written in Morse code, a single space is used to separate the character codes and 3 spaces are used to separate words. For example, the message HEY JUDE in Morse code is `···· · −·−−   ·−−− ··− −·· ·`.

> NOTE: Extra spaces before or after the code have no meaning and should be ignored.

In addition to letters, digits and some punctuation, there are some special service codes, the most notorious of those is the international distress signal SOS (that was first issued by Titanic), that is coded as ···−−−···. These special codes are treated as single special characters, and usually are transmitted as separate words.

Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.

**Example:**

```rb
decodeMorse('.... . -.--   .--- ..- -.. .')

#  should return "HEY JUDE"
```

> NOTE: For coding purposes you have to use ASCII characters . and -, not Unicode characters.

The Morse code table is preloaded for you as a dictionary, feel free to use it:

```mono
Coffeescript/C++/Go/JavaScript/Julia/PHP/Python/Ruby/TypeScript: MORSE_CODE['.--']
C#: MorseCode.Get(".--") (returns string)
F#: MorseCode.get ".--" (returns string)
Elixir: @morse_codes variable (from use MorseCode.Constants). Ignore the unused variable warning for morse_codes because it's no longer used and kept only for old solutions.
Elm: MorseCodes.get : Dict String String
Haskell: morseCodes ! ".--" (Codes are in a Map String String)
Java: MorseCode.get(".--")
Kotlin: MorseCode[".--"] ?: "" or MorseCode.getOrDefault(".--", "")
Racket: morse-code (a hash table)
Rust: MORSE_CODE
Scala: morseCodes(".--")
Swift: MorseCode[".--"] ?? "" or MorseCode[".--", default: ""]
C: provides parallel arrays, i.e. morse[2] == "-.-" for ascii[2] == "C"
NASM: a table of pointers to the morsecodes, and a corresponding list of ascii symbols
```

All the test strings would contain valid Morse code, so you may skip checking for errors and exceptions. In C#, tests will fail if the solution code throws an exception, please keep that in mind. This is mostly because otherwise the engine would simply ignore the tests, resulting in a "valid" solution.

Good luck!

After you complete this kata, you may try yourself at Decode the Morse code, advanced.

**Tests:**

```rb
describe("Example from description") do
  Test.assert_equals(decodeMorse('.... . -.--   .--- ..- -.. .'), 'HEY JUDE')
end

describe("Your own tests") do
  it "Test logger" do
    Test.assert_equals(decodeMorse("...."), 'H')
  end
  
  it "accepts SOS special code" do
    Test.assert_equals(decodeMorse("...---..."), 'SOS')
  end
end
```

**My Solution:**

```rb
def decodeMorse(morseCode)
 morseCode.scan(/[.-]+|\s{3}/).map {|chunk| chunk.match?(/\s{3}/) ? " " : MORSE_CODE[chunk]}.join.strip
end
```

**Clever solution:**

```rb
def decodeMorse(morseCode)
  morseCode
    .strip
    .scan(/[.-]+|\s{3}/)
    .map { |code| code.match?(/\s{3}/) ? " " : MORSE_CODE[code] }
    .join
end
```

**Most readable solution:**

```rb
def decodeMorse(morseCode)
  morseCode.strip
  .gsub(/[.-]+/) { |code| MORSE_CODE[code] }
  .gsub(/\s+/) { |blank| blank.length >= 3 ? " ": ""}
end
```

---

## Challenge 4

Given a string of words, you need to find the highest scoring word.

Each letter of a word scores points according to its position in the alphabet: `a = 1, b = 2, c = 3` etc.

For example, the score of `abad` is `8 (1 + 2 + 1 + 4)`.

You need to return the highest scoring word as a string.

If two words score the same, return the word that appears earliest in the original string.

All letters will be lowercase and all inputs will be valid.

**Tests:**

```rb
describe "Basic Tests" do
  it "should pass basic tests" do
    Test.assert_equals(high('man i need a taxi up to ubud'), 'taxi')
    Test.assert_equals(high('what time are we climbing up the volcano'), 'volcano')
    Test.assert_equals(high('take me to semynak'), 'semynak')
    Test.assert_equals(high('aa b'), 'aa')
    Test.assert_equals(high('b aa'), 'b')
    Test.assert_equals(high('bb d'), 'bb')
    Test.assert_equals(high('d bb'), 'd') 
    Test.assert_equals(high('aaa b'), 'aaa')
  end
end
```

**My Solution:**

```rb
ALPHABET = ('a'..'z').to_a

def high(x)
  keywords = x.downcase.split(" ")
  
  results = Hash.new()
  
  keywords.each do |keyword|
    results[keyword] = keyword.chars.sum { |letter| ALPHABET.index(letter) + 1}
  end

 results.max_by { |key, value| value }[0]
end
```

**Clever solution:**

```rb
def high(x)
  x.split.max_by { |w| score_word(w) }
end

def score_word(word)
  word.chars.reduce(0) { |sum, char| sum + (char.ord - 96) }
end
```

> `(char.ord - 96)` mean the ASCII code of char, where `- 96` is a offset because alphabet in ASCII starts with code 97

**Most readable solution:**

```rb
def high(x)
  x.split.max_by { |word| score_word(word) }
end

def score_word(word)
  ascii_code_offset = 96

  word.chars.reduce(0) { |sum, char| sum + score_char(char) }
end

def score_char(char)
  char_ascii_code = char.ord
  ascii_alphabet_offset = 96

  char_ascii_code - ascii_alphabet_offset
end
```

---

## Challenge 5

Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!

All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.

What is considered Valid?
A string of braces is considered valid if all braces are matched with the correct brace.

**Example:**

```sh
"(){}[]"   =>  True
"([{}])"   =>  True
"(}"       =>  False
"[(])"     =>  False
"[({})](]" =>  False
```

**Tests:**

```rb
describe 'tests' do
    def do_test(input, expected)
    # previous method name was in camelCase
        actual = method(defined?(valid_braces) ? :valid_braces : :validBraces).call(input.dup)
        message = "expected #{expected} but got #{actual} for input #{input.inspect}"
        expect(actual).to be(expected), message
    end

    it 'sample tests' do
        do_test( "()" , true)
        do_test( "[]" , true)
        do_test( "(}" , false)
        do_test( "(((({{" , false)
    end
end
```

**My Solution:**

```rb
VALID_BRACES = [81, 184, 248]

def valid_braces(braces) 
  ordered_chars = braces.chars.map { |char| char.ord}.sort
  ordered_chars.each_slice(2).all? {|a, b| VALID_BRACES.include?(a + b)}
end  
```

**Clever solution:**

```rb
```

**Most readable solution:**

```rb
```

---

## Challenge 7

The challenge is to make a array of strings with pattern `key:value`, to return a ordered string of unique keys and summed values

**Tests:**

```rb
it 'sample tests' do
  do_test(my_method(["B:-1", "A:1", "B:3", "A:5"])) , "A:6,B:2")
  do_test(my_method(["B:-1", "C:3" "A:1", "B:2", "A:-3", "C:2"])) , "A:-2,B:1,C:5")
end
```

**My Solution:**

```rb
def my_method(str_array)
  split_result = str_array.map {|str| str.split(":")}
  hashes = {}
  split_result.each {|key, value| hashes.merge!({key => value})}

  hashes.sort.map {|hash| "%s:%d" % hash}.join(",")
end
```

**Clever solution:**

```rb
```

**Most readable solution:**

```rb
```

---

---

## Challenge ?

**Tests:**

```rb
```

**My Solution:**

```rb
```

**Clever solution:**

```rb
```

**Most readable solution:**

```rb
```

---
