/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construction.Types;

/**
 *
 * @author svene_000
 */
public class ErrorType extends AbstractIType {

    boolean value;
    int line;
    
    public ErrorType(int line) {
        this.line = line;
    }

    public ErrorType()
    {
        
    }
    
    public void setValue() {
    }

    public String toString() {
        return "Undefined";
    }
    
    public boolean isCompatible(IType iType)
    {
        if(iType.isErrorCompatible()) return true;
        return false;
    }
    
    public boolean isErrorCompatible()
    {
        return true;
    }
    
}
