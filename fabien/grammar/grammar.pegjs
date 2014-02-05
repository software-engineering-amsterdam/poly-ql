{
  function word(str) {
    return str.join("").trim();
  }
}

start = questionnaire

id     = l:[0-9a-zA-Z_\- ]* { return word(l).toLowerCase(); }
type   = l:[a-zA-Z_ ]*      { return word(l); }
label  = l:[a-zA-Z ]*     { return word(l); } 
required = l:.?              { return l == "*"; }

// Question id:input-type:label/question text
question = id:id ":" type:type ":" label:label r:required "\n"?
  { 
    return {
        type:type,
        id:id,
        label:label,
        required:r
    }
  }

questionnaire = question*