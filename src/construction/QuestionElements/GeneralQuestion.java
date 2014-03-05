/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package construction.QuestionElements;

/**
 *
 * @author svene_000
 */
public interface GeneralQuestion extends Visitable {
    public void render();
    public String toString();
    public String toString(int depth);
    public int getLine();
}
