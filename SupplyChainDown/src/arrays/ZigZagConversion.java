//package arrays;
//
///**
// * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
// * (you may want to display this pattern in a fixed font for better legibility)
// *
// * P   A   H   N
// * A P L S I I G
// * Y   I   R
// *
// * And then read line by line: "PAHNAPLSIIGYIR"
// *
// * Write the code that will take a string and make this conversion given a number of rows:
// *
// * string convert(string s, int numRows);
// * Example 1:
// *
// * Input: s = "PAYPALISHIRING", numRows = 3
// * Output: "PAHNAPLSIIGYIR"
// * Example 2:
// *
// * Input: s = "PAYPALISHIRING", numRows = 4
// * Output: "PINALSIGYAHRPI"
// * Explanation:
// *
// * P     I    N
// * A   L S  I G
// * Y A   H R
// * P     I
// */
//
//public class ZigZagConversion {
//
//    public String convert(String s, int numRows) {
//        char[] input = s.toCharArray();
//        char[] output = new char[input.length];
//
//        for(int i=0; i<numRows; i++) {
//
//        }
//
//
//
//
//
//
//
//
//
//
//        int setLength = 2*numRows - 2;
//        int numSets = input.length/setLength;
//        for(int rowIndex=0; rowIndex<numRows; rowIndex++){
//            //iterate through each row 0 to numRows - 1
//            for(int setIndex=0; setIndex <= numSets; setIndex++) {
//                //iterate through each set
//                if(rowIndex == 0){
//                    //for first there is only one element per set in the output
//                    output[setIndex] = input[setIndex*setLength];
//                } else if(rowIndex == numRows -1) {
//                    //for first there is only one element per set in the output
//                    output[rowIndex*]
//                } else {
//                    output[numSets*rowIndex + setIndex] = input[rowIndex];
//
//                }
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
