{
  function word(str) {
    return str.join("").trim();
  }
}

start = questionnaire

id     = l:[0-9a-zA-Z_\- ]* { return word(l).toLowerCase(); }
type   = l:[a-zA-Z_ ]*      { return word(l); }
label  = l:[a-zA-Z\$\#\% ]*  { return word(l); } 
required = l:.?              { return l == "*"; }

option = "\n"* b:block l:label "\n"? {return {key: b, value:l}; } 


block = "[" l:label "]" { return l; }


// Question id:input-type:label/question text
question = id:id ":" type:type ":" label:label r:required? o:option* "\n"*
  { 
    return {
        type:type,
        id:id,
        label:label,
        required:r,
        options:o
    }
  }

questionnaire = question*