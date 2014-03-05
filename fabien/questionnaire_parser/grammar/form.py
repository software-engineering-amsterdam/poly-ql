from util import *

class Form():
            
    def render(self):
        html = []
        
        for node in self.nodes:
            html.append(node.asField())
            
        return "\n".join(html)

class Question():

    def __init__(self, id=None, ask="", type="string", settings=[], options=[]):
        self.id   = id
        self.type = type
        self.ask  = ask
        
        self.settings = settings
        self.options  = options
        
        
    def __repr__(self):
        return "question : {\n\t'id'\t: '%s',\n\t'type'\t: '%s'\n}" % (self.id, self.type)
                
    
    # Return HTML representation of the field
    def asField(self):
        if self._type == "string":
            return self.inputField()

        if self._type == "integer":
            return self.inputField()
            
            
    def inputField(self):
        return "<div><label>%s?</label><input type='text' name='%s'></div>" % (self._ask, self._id)

class Put():

    def __init__(self, item):
        self.item = item
        
        self.answer      = item.find('answer').text    
        self.computation = Computation(item.find('computation'))



    def asField(self):
        return ""
        
# Expression block 
# - if 
# - else if*
# - else
class Expression():
    
    def __init__(self, item):
        self.item = item

    
    def asField(self):
        return "---------------"

class Computation():

    def __init__(self, item):

        for child in item:
            
            if child.tag == "operator":
                self.operator = child.text

        
        self.left  = self.parseItem(item[0])
        self.right = self.parseItem(item[2])


        #if operator == '*':
        #    self = Multiplication(item[0], item[2])

 
    def parseItem(self, item):
        # Sub expression
        # TODO check if this works
        for child in item:
            if child.tag == "computation":
                return Computation(item[0])
            
            elif child.tag == "ITEM":
                return Literal(item[0].text)



# TODO Fix something question_id ? 
class Literal():
    
    def __init__(self, value):
        self.value = int(value)
        
    def compute(self):
        return self.value
