
/**
  Term Frequency

  Given a text file, output a list of the 25 most frequently-occurring non stop, 
  words, ordered by decreasing frequency
*/


/**
  Dependencies
*/

var argv       = require("minimist")(process.argv.slice(2));
var fileReader = require("fs");
var nlp        = require("natural");

// Set stemmer
nlp.PorterStemmer.attach();

function countFrequency(err, text) {

  // Error occures while reading the file
  if (err)
    throw err;

  var stems =  text; //text.tokenizeAndStem();
  var result = nlp.NGrams.ngrams(stems, 1);

  /*
  var options = {
    score: true,
    stem : true,
    min  : 1,
    ngrams : 1, // Default is [1,2,3]
    limit: 25
  }

  var result = gramophone.extract(text, options);
  */
  console.log(result);

}


var filename = argv['f'] || argv['file'] || 'input.txt';

// readFile loads the entire file into memory, so it should not be used on
// big files!
fileReader.readFile(filename, 'utf8', countFrequency);

