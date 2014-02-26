from optparse import OptionParser

parser = OptionParser()
parser.add_option("-f", "--file", dest="filename", default="forms/simple.txt",
                  help="Form location, for example: forms/simple.txt", metavar="FORM")

(options, args) = parser.parse_args()