package Solution;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map =new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
             if(!map.containsKey(prerequisites[i][0])){
               List<Integer> arr =new ArrayList<>();
               arr.add(prerequisites[i][1]);
               map.put(prerequisites[i][0], arr);
             }else{
                List<Integer> arr= map.get(prerequisites[i][0]);
                arr.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], arr);
             }
        }
        System.out.println(map);
        return true;
        
    }


    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        // Step 2: Initialize the queue with nodes having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // Step 3: Process the courses
        int processedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            processedCourses++;
            
            for (int dependentCourse : graph.get(course)) {
                inDegree[dependentCourse]--;
                if (inDegree[dependentCourse] == 0) {
                    queue.add(dependentCourse);
                }
            }
        }
        
        // Step 4: Check if all courses were processed
        return processedCourses == numCourses;
    }
}
