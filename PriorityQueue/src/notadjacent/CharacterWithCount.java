/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notadjacent;

/**
 *
 * @author vasher
 */
public class CharacterWithCount {

    public CharacterWithCount(Character name, Integer count) {
        this.name = name;
        this.count = count;
    }
    
    Character name;
    Integer count;

    public Character getName() {
        return name;
    }

    public void setName(Character name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    
}
