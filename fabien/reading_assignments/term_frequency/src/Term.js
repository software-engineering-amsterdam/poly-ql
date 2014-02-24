"use strict";

/**
  File containing useful functions for term extraction
*/

// Transform a string to a list of (non stop) words, using skipwords for skipping
exports.getTerms = function (text, skipwords) {
    var i,
        terms = [],
        words = text.sanitizeSpacing().toWords();

    for (i in words) {
        // Skip empty lines and words in skipwords list (stop words etc.)
        if (words[i] === "" || skipwords.indexOf(words[i]) > 0) {
            continue;
        }

        terms.push(words[i]);
    }

    return terms;  
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
        result      = [],
        frequencies = [];
        
    if (terms === "[]") {
        return result;
    }

    // Count the term frequencies
    for (i in terms) {
        if (frequencies[terms[i]]) {
            frequencies[terms[i]]++;
            continue;
        }

        frequencies[terms[i]] = 1;
    }

    // Create a sortable list 
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