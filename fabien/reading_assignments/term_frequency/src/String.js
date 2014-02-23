"use strict";

/**
  Custom string functions to help with term extraction
*/

String.prototype.sanitizeSpacing = function () {
    return this
        .replace(/[\t\r\n\-_]/g, ' ')  // Newline / tab to single space
        .replace(/  +/g, ' ')          // Multiple 'spaces' to single 
        .trim();                       // Trim (spaces from new lines etc)
};


// Returns list of only lowercase words (thus no punctuation)
String.prototype.toWords = function () {
    return this
        .toLowerCase()
        .replace(/\'s|s\'/g, '')                          // Remove 's (Elizabeth's == Elizabeth)
        .replace(/[\\\/\:\;\,\.\?\!\'\"\(\)\[\]\{\}\+\=]/g, '') // Remove non letter characters
        .split(' ');                                      // Split to get words from line
};