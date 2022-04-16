package com.downvoteit.javaalgorithms.problems.medium.topologicalsort;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    return new V1().canFinish(numCourses, prerequisites);
  }

  static class V1 extends CourseSchedule {
    // vertices and edges
    // if a cycle is found => false
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      return false;
    }
  }
}
