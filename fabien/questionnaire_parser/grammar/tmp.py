
def toDict(tokens): 
  tmp = {}

  for t in tokens[0]:
    if t[0] and t[1]:
      tmp[t[0]] = t[1]
    else:
      # Default to true if no value is given
      tmp[t[0]] = True

  return tmp

  
def Question(tokens):

    return { 
        "element"  : "question",
        "id"       : tokens[0].id,
        "type"     : tokens[0].type,
        "question" : tokens[0].ask,
        "settings" : tokens[0].settings,
        "options"  : tokens[0].options
    }


def ExpressionBlock(tokens):
    
    return { 
        "condition" : tokens[0].computation,
        "elements"  : tokens[0][1:]           # rest of the elements
    }
    
def Expression(tokens):

    # Must have an if statement
    element = { 
        "element" : "expression",
        "if"      : tokens[0]._if
    }
    
    if tokens[0]._elif:
        element["elif"] = tokens[0]._elif
    
    if tokens[0]._else:
        element["else"] = tokens[0]._else
    
    return element

# Computation / condition
def Computation(tokens):
    
    for token in tokens[0]:
        print token
        
    return tokens

def Put(tokens):

    return { 
        "element"   : "put",
        "label"     : tokens[0].label,
        "condition" : tokens[0].computation
    }
