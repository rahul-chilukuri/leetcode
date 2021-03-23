# String
* Palindrome
* Reverse recursively 
* Anagram 
    * Check if both strings are equal size
    * Iterate each character in one string and remove it from the other. At the end the other string should be empty. Can be done inplace or with buffer
    * Arrays.sort both strings and see if the both are same
    * Put each occurence of the first string in char map(256). Iterate second string and decrement each occurence of the character in the string. At the end, character map array should have all zeroes.
    * character maps are useful for finding out duplicates.
* Non repeating character
    * Create a table to store counts of each character
    * Finally pick the first non repeating character
