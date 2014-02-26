from util import *

class Form():

    nodes     = []
    questions = [] # List of all questions in the form
    
    def __init__(self, root):
        self.name = root[0].text
        
        # Skip root[0] (i.e the name)
        for prev, item, next in neighborhood(root[1:]):
            node = Node(item, prev, next)
            
            self.nodes.append(node)
            self.questions += node.questions
            print item.tag
            print len(self.nodes)
            

    # Checks all expression 
    def hasUndefinedQuestions(self):
        return False
        
    # Validate if the form is possible
    def validate(self):
        pass
        
    def printNodes(self):
        for node in self.nodes:
            print node.type

    def printQuestions(self):
        for question in self.questions: 
            print question.ask + "?"

class Node():

    # List of questions under this node
    questions = []
    
    def __init__(self, item, prev=None, next=None):
        self.type = item.tag
        self.item = item
        
        self.prev = prev
        self.next = next
        
        # Single question, as the node is a question ?
        if self.type == "question":
            self.questions = [Question(item)]
            
        
class Question():

    def __init__(self, item):
        self.ask = item.find('ask').text         # the question
        self.id  = item.find('id').text
        
        # TODO are shortcuts needed?
        # shortcut of settings.required
        self.required = True

# Expression block 
# - if 
# - else if*
# - else
class Expression():
    
    def __init__(self):
        pass
    