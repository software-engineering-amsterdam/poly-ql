/**
  Languages
*/
var lang = [
  'en', 
  'nl'
];


/**
  Default stop words (single characters)
*/
var letters = "abcdefghijklmnopqrstuvwxyz";
var numbers = "0123456789";
var symbols = "@#$%^&(){}[]|?";
var combined = (letters + numbers + symbols).split("");


// Include a language stopword file
function include(lang) {
  // Check if language file is available
  try {
    var tmp = require('./' + lang + '.js')[lang];
    return tmp;
  }
  catch(err) {
    throw err;
  }

}

// Retrieve language(s) stopwords
exports.get = function(language) {

  var result = [];
  var lang   = language instanceof Array ? language : [language];

  // Get the stop words from given language
  for (i in lang)
    result = result.concat(include(lang[i]));

  // Concat the language file with defaults  
  return result.concat(combined); 

};

