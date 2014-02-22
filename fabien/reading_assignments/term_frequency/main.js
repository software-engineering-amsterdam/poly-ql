/**
  Word Frequency

  Given a text file, output a list of the 25 most frequently-occurring non stop, 
  words, ordered by decreasing frequency
*/


/**
  Dependencies
*/

var fs        = require("fs");
var argv      = require("minimist")(process.argv.slice(2));
var stopwords = require('./stop_words/main.js');

/**
  Set input variables
*/

var filename = argv['f'] || argv['file']  || 'input_files/simple.txt';
var language = argv['l'] || argv['lang']  || 'en';
var amount   = argv['c'] || argv['count'] || 25;

// Get stop words to skip
var skipwords = stopwords.get(language);


function textToWords(text) {
  
  return text
    .toLowerCase()                        // From buffer to lowercase string
    .replace(/[\t\r\n\,\.\!\'\"]/g, '')   // Remove non letter characters
    .split(' ');                          // Split to get words from line

}

function getTerms(err, text) {

  // If an error occures while reading the file
  if (err)
    throw err;
  
  var terms = [];
  var words = textToWords(text);

  for (i in words) {
    // Skip empty lines
    if (words[i] == "")
      continue;

    // Only accept non stop words
    if (skipwords.indexOf(words[i]) < 0)
      terms.push(words[i]);
  }

  countFrequency(terms);

}

function countFrequency(terms) {

  var result = [];

  for (i in terms)
    result[terms[i]] = result[terms[i]] ? result[terms[i]]+1 : 1;

  // Show final result
  groupFrequency(result);

}

function groupFrequency(terms) {

  var result = [];

  for (term in terms)
    result.push({term : term, frequency: terms[term]});

  // Sorted terms by frequency
  result = result.sort(sortByFrequency);

  display(result);

}

// Display top Amount (default = 25) occurences
function display(terms) {

  // Splice returns the rest result
  var rest = terms.splice(amount);
  console.log(terms);

}


function sortByFrequency(a, b) { 
  return b.frequency - a.frequency; 
}

// readFile loads the entire file into memory, so it should not be used on
// big files!
fs.readFile(filename, 'utf8', getTerms);

