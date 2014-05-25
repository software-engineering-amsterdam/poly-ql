namespace QL
module Values =

//    type QLValue<'a>(value:'a) = 
//        member this.Value with get() = value
//
//
//    type QLBoolean(value) =
//        inherit QLValue<bool>(value)
//
//    type QLInteger(value) =
//        inherit QLValue<int>(value)
//
//    type QLString(value) =
//        inherit QLValue<string>(value)

    type QLValue =
    | QLBoolean of bool
    | QLString of string
    | QLInteger of int

            
            

