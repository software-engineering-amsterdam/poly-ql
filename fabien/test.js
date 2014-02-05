// Test Node file for parsing input
var parser = require("./parser/parser");
var assert = require('assert');


var out = parser.parse("3+4");

// Do a test
assert.deepEqual( parser.parse("3+4"), {
   "tag": "+",
   "left": 3,
   "right": 4
} );

console.log(out);