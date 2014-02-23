"use strict";

/**
  File containing useful functions for term extraction
*/

// Transform a string to a list of (non stop) words, using skipwords for skipping
exports.getTerms = function (text, skipwords) {
    return text
        .sanitizeSpacing()
        .toWords()
        .filter(function(elem) {
            return skipwords.indexOf(elem) < 0;
        });
};


// Count the frequency of a certain item in a list 
// Then returns a sorted list of "frequency term objects"
//
// ["hello", "hello", "world"] becomes: 
//
// [
//    {term : "hello", frequency: 2},
//    {term : "world", frequency: 1}
// ]
exports.countFrequency = function (terms) {
    var i,
        result = [];
   
    // Using http://stackoverflow.com/a/21626233/951517
    var frequencies = terms.reduce(function(m, e) {
        // TODO remove if expression?
        m[e] = (+m[e] || 0) + 1;
        return m;
    }, []);
    
    // TODO remove for
    for (i in frequencies) {
        result.push({term : i, frequency: frequencies[i]});
    }

    // Sorted terms by frequency
    return result.sort(this.sortByFrequency);
};

// Javascript numeric comparison for sorting a list
exports.sortByFrequency = function (a, b) {
    return b.frequency - a.frequency; 
};

// Limit a list of terms to certain length amount
exports.limit = function (terms, amount) {
    // Splice returns the rest result
    terms.splice(amount);
    return terms; 
};