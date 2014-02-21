Term Frequency
==============

Given a text file, output a list of the 25 most frequently-occurring non stop, 
words, ordered by decreasing frequency


## Language of choice

I have decided to write a solution for term frequency problem in javascript (using node JS). First I looked into `gramophone` and `natural` libraries. They provide decent NLP support, however "terms" in the libraries where defined using n-grams. Thus term frequencies would not be a single word. Another problem was multiple language support, which is lacking in most libraries and I only encountered later on.

## Style

I started using code similar to "code golf". Including a few libraries that almost got the solution in a couple of lines. Then I figured the assignment did not actually meant "terms" but just word frequencies. So I switched to a more "Candy Factory" approach as javascript is asynchrounous.


## Conclusion

Now that I have seen other programming styles, I would consider the data stream as an option for bigger files. Currently I use a blocking function to read the entire file at once. This is because most node streams had memory leaking problems. With more time this seems as a reasonable improvement, but it should be implemented more readable than the exercise style.
