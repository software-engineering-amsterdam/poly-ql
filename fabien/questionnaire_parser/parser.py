from grammar import *
from util import *

if __name__ == '__main__': 

    try:
        parsed = form.parseFile( options.filename, parseAll=True)
        #print parsed.dump()
    except IOError:
        #print "File %s not found\n" % options.filename
        raise
    
    
    for node in parsed[1:]:
        
        print node.asDict()
        print node.condition[0]
        print node.condition[1]
        print node.condition[2]
    
    #for node in parsed:
    #    print node.getName()