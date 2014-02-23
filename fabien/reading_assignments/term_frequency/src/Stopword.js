"use strict";

/**
  Allow stop word files to be included, with additional character / number
  support (i.e a single letter is seen as a stopword)
*/

/**
  Default stop words (single characters)
*/

var letters = "abcdefghijklmnopqrstuvwxyz";
var numbers = "0123456789";
var symbols = "@#$%^&(){}[]|?";
var combined = (letters + numbers + symbols).split("");

// Include a language stopword file
function include (lang) {
    // Check if language file is available
    try {
        var tmp = require('./stopword_files/' + lang + '.js')[lang];
        return tmp;
    }
    catch(err) {
        throw err;
    }
}

// Retrieve language(s) stopwords
exports.get = function (language) {
    var i,
        result = [],
        lang   = language instanceof Array ? language : [language];

    // Get the stop words from given language
    for (i in lang) {
        result = result.concat(include(lang[i]));
    }
    
    // Concat the language file with defaults  
    return result.concat(combined); 
};