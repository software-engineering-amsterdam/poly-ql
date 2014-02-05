{
  function word(str) {
    return str.join("").trim();
  }
}

start = questionjo

character = [a-zA-Z_ ]

id     = l:[0-9a-zA-Z_\- ]* { return word(l).toLowerCase(); }
type   = l:[a-zA-Z_ ]*      { return word(l); }
label  = l:[a-zA-Z \n]*     { return word(l); } 

// Question id:input-type:label/question text
question = id:id ":" type:type ":" label:label
  { 
    return {
        type:type,
        id:id,
        label:label
    }
  }

questionjo = question*