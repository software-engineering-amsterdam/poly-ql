"use strict";

/**
  Dependencies
*/

var assert   = require("assert");
var string   = require("../src/String.js");
var stopword = require('../src/Stopword.js');
var term     = require("../src/Term.js");

/**
  Tests
*/


// Test string
describe('Custom String helper functions', function() {

  describe('sanitizeSpacing', function() {
  
    it('Should handle multiple spaces and newlines', function(){
      assert.equal("Hello World!", "Hello   \nWorld!".sanitizeSpacing());
    });
    
  });

  describe('toWords', function() {
  
    it('Should return a lowercase text', function() {
      assert.equal("hello", "Hello".toWords());
    });

    it('Should remove punctuation', function() {
      assert.equal("hello", "Hello\'\":;,.!?".toWords());
    });
    
    // Compare lists with deepEqual
    it('Creates a list of words', function() {
      assert.deepEqual(["hello", "world"], "Hello World!".toWords());
    });
    
  });
  
});

// Test term functions
describe('Custom Term helper functions', function() {


  describe('getTerms', function() {
  
    // Get stop words to skip
    var skip = stopword.get('en');
    
    it('Creates a list of words', function() {
      assert.deepEqual(["hello", "world"], term.getTerms("Hello World!", skip));
    });

    // Stop-words are not counted in the distribution
    it('Does not contain (english) stop / non words', function() {
      assert.deepEqual(["hello", "world"], term.getTerms("Hello but World", skip));
    });
    
  });
  
  describe('countFrequency', function() {
  
    it('Returns list with frequencies', function() {
      assert.deepEqual([{term: "hello", frequency: 1}, {term: "world", frequency: 1}], term.countFrequency(["hello", "world"]));
    });

    // Multiple occurrences of same word in different capitalizations are 
    // counted as occurences of the same single word.
    // (Combination of functionality in this style)
    it('Returns list with frequencies', function() {
      // Get stop words to skip
      var skip  = stopword.get('en');
      var terms = term.getTerms("Hello hEllo HELLO hello", skip);
      
      assert.deepEqual([{term: "hello", frequency: 4}], term.countFrequency(terms));
    });

    // The words are printed by decreasing order
    it('Returns sorted frequencies', function() {
      assert.deepEqual([{term: "hello", frequency: 2}, {term: "world", frequency: 1}], term.countFrequency(["hello", "world", "hello"]));
    });
    
  });

  describe('limit', function() {
     
    var frequencies = [
        {term: "hello",     frequency: 3}, 
        {term: "world",     frequency: 2},
        {term: "mr",        frequency: 1},
        {term: "elizabeth", frequency: 1},
        {term: "up",        frequency: 1}
    ];
    
    // The program only prints out the top N words
    it('The program prints all words if shorter than top N', function() {
      assert.equal(5, term.limit(frequencies, 25).length);
    });
    
    // The program only prints out the top N words
    it('The program only prints out the top N words', function() {
      assert.equal(3, term.limit(frequencies, 3).length);
    });
  });
});