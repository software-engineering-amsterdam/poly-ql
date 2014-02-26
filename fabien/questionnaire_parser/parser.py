from grammar import *

# command line parsing
from util import *

import xml.etree.ElementTree as ET

    
if __name__ == '__main__': 

    try:
        xml = form.parseFile( options.filename ).asXML()
        print xml
        
    except IOError:
        #print "File %s not found\n" % options.filename
        raise
        
    
    form = Form(ET.fromstring(xml))
    
    form.printQuestions()
        
    '''
        
    for child in root:
        node = Node(child.tag)
        
        form.addNode(node)
        
        if child.tag == "question":
            question = Question( child )
            
        if child.tag == "expression":
    '''         
        