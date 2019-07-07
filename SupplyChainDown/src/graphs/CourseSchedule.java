package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courses = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            courses.put(i, new HashSet<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int targetCourse = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            courses.get(targetCourse).add(prerequisite);
        }

        for(int i=0; i<numCourses; i++) {
            if (courses.get(i).size() == 0) {
                continue;
            }
            Set<Integer> prerequisite = courses.get(i);
            Set<Integer> visited = new HashSet<>();
            if(!canFinishRecursive(courses, prerequisite, i, visited)){
                return false;
            }
        }
        return true;
    }

    public boolean canFinishRecursive(Map<Integer, Set<Integer>> courses, Set<Integer> prerequisite, int start, Set<Integer> visited){
        //iterate for each prerequisite
        for(Integer p: prerequisite){
            if(visited.contains(p)){
                continue;
            }
            visited.add(p);
            //if you detect a circular dependency then return false since course can never be completed
            if(p.intValue() == start){
                return false;
            }
            if(courses.get(p).size() == 0){
                continue;
            }
            if(!canFinishRecursive(courses,courses.get(p), start, visited)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule instance = new CourseSchedule();
        int[][] pre = {{0,1},{3,1},{1,3},{3,2}};
        System.out.println(instance.canFinish(4, pre));
    }
}
