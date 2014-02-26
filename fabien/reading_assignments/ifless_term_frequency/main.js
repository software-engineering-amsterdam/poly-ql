"use strict";

/**
  Word Frequency

  Given a name of a textfile on the users machine, output a list of the 25 most 
  frequently-occurring (non stop) words ordered by decreasing frequency without
  using if/else/loop statements
*/


/**
  Dependencies
*/

var fs       = require('fs');

var string   = require("./src/String.js");
var stopword = require('./src/Stopword.js');
var term     = require("./src/Term.js");

/**
  Set input variable constants
*/

var filename = "input_files/pride-prejudice.txt";
var language = "en";
var amount   = 25;

/**
  Create file reader and count terms
*/

var result    = [];
var skipwords = stopword.get(language);         // Get stop words to skip
var reader    = fs.createReadStream(filename);

reader.on('data', function (data) {
    var line  = data.toString(),
        terms = term.getTerms(line, skipwords);

    // Concat to get a single list of terms
    result = result.concat(terms);
});

// If file reader reaches the end of the file => print result
reader.on('end', function () {
    var sorted  = term.countFrequency(result),
        limited = term.limit(sorted, amount);
    
    console.log(limited);
});