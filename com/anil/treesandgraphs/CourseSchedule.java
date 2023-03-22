package com.anil.treesandgraphs;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int[][] dependencies = {{1,4},{2,4},{3,1},{3,2},{4,1}};
        boolean canFinish = cs.canFinish(5,dependencies);
        System.out.println(canFinish);
    }
    Set<Integer> isCircular = new HashSet<>();
    public boolean canFinish(int numCourses,int[][] preRequisites){
        ArrayList[] courseList = new ArrayList[numCourses];
        for(int i = 0; i < preRequisites.length; i++){
            int[] edge = preRequisites[i];
            int c = edge[0];
            int d = edge[1];
            if(courseList[c] == null){
                courseList[c] = new ArrayList<Integer>();
            }
            courseList[c].add(d);
        }
//        for(int i = 0; i < courseList.length; i++){
//            System.out.println(i+" - "+courseList[i]);
//        }

        for(int i = 0; i < courseList.length; i++){
            Set<Integer> completed = new HashSet<>();
            if(!isCircular.contains(i)) {
                boolean result = studyCourses(i,courseList,completed);
                if(!result) return result;
                isCircular.add(i);
            }
        }
        return true;
    }

    public boolean studyCourses(int course,ArrayList[] courseList,Set<Integer> completed){
        if(completed.contains(course)) return false;
        completed.add(course);
        ArrayList<Integer> dependencies = courseList[course];
        if(dependencies!=null){
            for(int i = 0; i < dependencies.size(); i++){
                if(!isCircular.contains(dependencies.get(i))) {
                    boolean result = studyCourses(dependencies.get(i), courseList, completed);
                    if (!result) return result;
                    isCircular.add(dependencies.get(i));
                }
            }
        }
        completed.remove(course);
        return true;
    }
}
