
class Form:
  questions = []
  #settings  = {}

  def __init__(self):
    self.element = "form"
    
    
  def __repr__(self):
        return json.dumps(self, default=lambda o: o.__dict__, sort_keys=True, indent=2)

    
def toForm(tokens):
  form = Form()
  form.name = tokens[0]
  form.questions = tokens[1:]
  
  print form
  
  '''form = {
    "element"   : "form",
    "name"      : tokens[0],
    "questions" : tokens[1:]
  }'''
  
  return tokens # form

def toExpr(tokens):
  print tokens
  
  return tokens

def toQuestion(tokens):
  question = { 
    "element"  : "question",
    "question" : tokens[0].question,
    "settings" : tokens[0].settings
  }

  # Check if question type and ID are set for reference
  if tokens[0].type:
    question["type"] = tokens[0].type[0]
    question["id"]   = tokens[0].type[1]
  else:
    question["type"] = "string"
    question["id"]   = False
      
  return question

  def toDict(tokens):
  tmp = {}

  for t in tokens[0]:
    if t[0] and t[1]:
      tmp[t[0]] = t[1]
    else:
      # Default to true if no value is given
      tmp[t[0]] = True

  return tmp
