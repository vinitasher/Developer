/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notadjacent;

import java.util.Comparator;

/**
 *
 * @author vasher
 */
public class CharacterWithCountComparator implements Comparator<CharacterWithCount> {

    @Override
    public int compare(CharacterWithCount o1, CharacterWithCount o2) {
        return o2.getCount() - o1.getCount();
    }
    
}
