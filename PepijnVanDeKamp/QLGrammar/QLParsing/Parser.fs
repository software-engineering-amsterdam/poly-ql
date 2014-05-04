namespace QL
module Parsing =
 
    open System  
    open System.Collections.Generic 
    open QL.Grammar

    [<AbstractClass>] 
    type Message(Message:string,Position:Position) =
         member this.Message with get() = Message
         member this.Position with get() = Position

    type ParserMessage(Message:string,Position:Position) =
        inherit Message(Message,Position)
        override this.ToString() = String.Format("PARSE ERROR: {0} - Line: {1} Column: {2}",Message,Position.LineStart,Position.ColumnStart)


    type ParseResult(Form,Messages:List<Message>) =
        member this.Messages with get() = Messages
        member this.ParseTree with get() = Form


    type Parser() =
        member this.Parse source =
            let lexbuf = Lexing.LexBuffer<_>.FromString source
            let messages = new List<Message>()
            try
                let form = QlParser.start QlLexer.tokenize lexbuf   
                new ParseResult(Some form,messages)
            with | exc -> messages.Add(new ParserMessage(exc.Message,Position(lexbuf.StartPos,lexbuf.EndPos)))
                          new ParseResult(None,messages)
                          
