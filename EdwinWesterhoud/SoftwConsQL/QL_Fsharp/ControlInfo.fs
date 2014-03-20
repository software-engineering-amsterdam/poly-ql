module ControlInfo

open System.Collections.Generic
open QL_Csharp
open QL_Csharp.PrimitiveControls

type ControlInfo() = 
    let controlsMap = new Dictionary<string, StatementControl>()

    member this.AddControl(id, control) = controlsMap.Add(id, control)
    member this.GetControl(id) = controlsMap.[id]