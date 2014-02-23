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

    it('Does not contain (english) stop / non words', function() {
      assert.deepEqual(["hello", "world"], term.getTerms("Hello but World", skip));
    });
    
  });
  
  describe('countFrequency', function() {
  
    // Get stop words to skip
    var skip = stopword.get('en');
    
    it('Returns list with frequencies', function() {
      assert.deepEqual([{term: "hello", frequency: 1}, {term: "world", frequency: 1}], term.countFrequency(["hello", "world"]));
    });

    it('Returns sorted frequencies', function() {
      assert.deepEqual([{term: "hello", frequency: 2}, {term: "world", frequency: 1}], term.countFrequency(["hello", "world", "hello"]));
    });
    
  });
  
});