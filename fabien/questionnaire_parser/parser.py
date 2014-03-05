from grammar import *
from util import *


if __name__ == '__main__': 

    try:
        parsed = form.parseFile( options.filename, parseAll=True)
    except IOError:
        #print "File %s not found\n" % options.filename
        raise
        
    
        
    form = parsed[0]
    questions = []

    # Iterate once
    for node in iter(parsed[1:]):

        print node 
        print "\n\n"
        
    #nodes  = iter(root[1:])  # Skip root[0] (i.e the name)
    

    #f = open('form.html','w')
    #f.write(form.render())
    #f.close() 