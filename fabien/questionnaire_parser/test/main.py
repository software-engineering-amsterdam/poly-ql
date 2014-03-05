import unittest

# Unit testing
class ParserTestCase(unittest.TestCase):

    def assertMatch(self, parser, input):
        parser.parseString(input, parseAll=True)

    def assertNoMatch(self, parser, input):
        try:
            parser.parseString(input, parseAll=True)
        except ParseException:
            pass
        else:
            raise ValueError('match should fail', input)

    def test_single_word(self):
        self.assertMatch(word, 'hello')
        self.assertMatch(variable, 'hello')
        self.assertMatch(keyword, 'required')
        
        self.assertNoMatch(word, 'hello world')
        self.assertNoMatch(variable, 'hello world')
        self.assertNoMatch(keyword, 'world')

    def test_type(self):
        self.assertMatch(type, "boolean")
        
        # TODO should maybe accept this
        self.assertNoMatch(type, "bool")
    
    def test_key_value(self):
        self.assertMatch(key_value, "required \"true\"")
        self.assertMatch(key_value, "value \"12.00\"")
    
    def test_settings(self):
        self.assertMatch(settings, "required \"true\"\n value \"12.00\"")
    
    def test_sentence(self):
        self.assertMatch(sentence, 'hello')
        self.assertMatch(sentence, 'hello world')
        self.assertMatch(sentence, 'hello world!')
    
    def test_string(self):
        self.assertMatch(string, '"hello"')
        self.assertMatch(string, '"hello `world`!"')
        
        self.assertNoMatch(string, '\'hello\'')
        self.assertNoMatch(string, '"hello')
        self.assertNoMatch(string, 'hello')

    # TODO : Test associativity
    def test_put(self):
        self.assertMatch(put, "put \"Your answer was\" () ")
        self.assertMatch(put, "put \"Your answer was\" (foo * 3)")
        self.assertMatch(put, "put \"Your answer was\" (foo * 3 * 3)")
        self.assertMatch(put, "put \"Your answer was\" (foo * (3 + bar))")
        self.assertMatch(put, "put (foo * 3)")
   
        
    def test_expression(self):
        self.assertMatch(condition, "()")
        self.assertMatch(condition, "(hello)")
   
        self.assertNoMatch(condition, "(hello)(world)")
   
    def test_negation(self):
        self.assertMatch(condition, "(!hello)")
        
    def test_nested_expression(self):
        self.assertMatch(condition, "(())")
        self.assertMatch(condition, "( (hello) )")
        self.assertMatch(condition, "( hello and world )")
        self.assertMatch(condition, "( hello and !world )")
        self.assertMatch(condition, "( hello and not world )")
        self.assertMatch(condition, "( hello and (hello or world) )")
        self.assertMatch(condition, "( !(hello or world) and hello )")
   
        self.assertNoMatch(condition, "( (hello or world) hello )")

    def test_operators_in_expression(self):
        self.assertMatch(condition, "( hello > world )")

    def test_if(self):
        self.assertMatch(_if, 'if (hello) { }')
        
        self.assertNoMatch(_if, 'if (hello)')
        self.assertNoMatch(_if, 'else if (hello)')
        
    def test_else_if(self):
        self.assertMatch(_elif, 'else if (hello) { }')
        
    def test_else(self):
        self.assertMatch(_else, 'else { }')
        
        self.assertNoMatch(_else, 'else (hello) { }')
        self.assertNoMatch(_else, 'else if (hello) { }')
    
    def test_condition(self):
        self.assertMatch(expression, 'if (hello) { }')
        self.assertMatch(expression, 'if (hello) { }\n else if (foo) { } ')
        self.assertMatch(expression, 'if (hello) { }\n else if (foo) { }\n else {} ')
        
    def test_question(self):
        self.assertMatch(question, 'How old are you?')
        self.assertMatch(question, 'How old are you?')
        
        self.assertNoMatch(question, 'How old are you')
    
    def test_form(self):
        self.assertMatch(form, 'form test { }')
        self.assertMatch(form, 'form test { hello? boolean world }')