"use strict";

/**
  Word Frequency

  Given a name of a textfile on the users machine, output a list of the 25 most 
  frequently-occurring (non stop) words ordered by decreasing frequency
*/


/**
  Dependencies
*/

var argv     = require("minimist")(process.argv.slice(2));
var fs       = require('fs');

var string   = require("./src/String.js");
var stopword = require('./src/Stopword.js');
var term     = require("./src/Term.js");

/**
  Set input variables using argv command line support
*/

var filename = argv.f || argv.file;
var language = argv.l || argv.lang  || 'en';
var amount   = argv.c || argv.count || 25;

/**
  Check if help command is issued
  (or if no filename is set)
*/

if (!filename || argv.h || argv.help) {
    var help = "Usage node main.js [options]. You can specify options:\n";
    help += "\t-f [filename] / for example input_files/pride_prejudice.txt\n";
    help += "\t-l [language] / Use a comma to split multiple languages.\n";
    help += "\t-c [number]   / Amount of words displayed (default is 25).";

    console.log(help);
    process.exit(0);
}


/**
  Create file reader and count terms
*/
var result    = [];
var skipwords = stopword.get(language); // Get stop words to skip
var reader    = fs.createReadStream(filename);

reader.on('data', function (data) {
    var terms = term.getTerms(data.toString(), skipwords);

    // Concat to get a single list of terms
    result = result.concat(terms);
});

// If file reader reaches the end of the file => print result
reader.on('end', function () {
    var sorted = term.countFrequency(result);
    console.log(term.limit(sorted, amount));
});