// Test Node file for parsing input
var parser = require("./parser/parser");
var assert = require('assert');


// Do a test
assert.deepEqual( parser.parse("label1 : text : This is my first test question"),
  [
     {
        "type": "text",
        "id": "label1",
        "label": "This is my first test question",
        "required": false
     }
  ]
);

// Check if "*" sets required to true
assert.deepEqual( parser.parse("label1 : text : This is my second test question*"),
  [
     {
        "type": "text",
        "id": "label1",
        "label": "This is my second test question",
        "required": true
     }
  ]
);