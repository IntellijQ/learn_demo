package com.learn.dataStructure.D8Algorithm.A3GreedyAlgorithm;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yds
 * @title: RoomDistribution
 * @description: 教室调度问题
 * 整体思路按照：
 * 1.活动时间结束最早的进行选择
 * 2.下一个活动开始时间要 晚于 上一个结束时间
 * @date 2020/11/30 15:15
 */
public class RoomDistribution {
    public static void main(String[] args) {
        List<Project> allProjects = inintProjects();

        greedyDistribution(allProjects);

    }

    private static void greedyDistribution(List<Project> allProjects) {
        List<Project> markList = new ArrayList<>();
        //排序 按照结束时间升序
        Collections.sort(allProjects);
        // 因为已经按照结束时间升序，所以第一个是最早结束的活动
        Project currentSelectedProject = allProjects.get(0);
        markList.add(currentSelectedProject);

        // 从第1个下标开始
        int checkIndex = 1;
        while (checkIndex < allProjects.size()){
            Project project = allProjects.get(checkIndex);
            if(project.getBeginTime() >= currentSelectedProject.getEndTime()){
                markList.add(project);
                currentSelectedProject = project;
            }
            checkIndex++;
        }

        System.out.println(markList);

    }

    private static List<Project> inintProjects() {
        List<Project> allProjects = new ArrayList<>();
        Project project = new Project();
        project.setName("美术");
        project.setBeginTime(3);
        project.setEndTime(5);
        allProjects.add(project);

        project = new Project();
        project.setName("化学");
        project.setBeginTime(5);
        project.setEndTime(9);
        allProjects.add(project);

        project = new Project();
        project.setName("英语");
        project.setBeginTime(5);
        project.setEndTime(7);
        allProjects.add(project);

        project = new Project();
        project.setName("音乐");
        project.setBeginTime(0);
        project.setEndTime(6);
        allProjects.add(project);

        project = new Project();
        project.setName("政治");
        project.setBeginTime(12);
        project.setEndTime(14);
        allProjects.add(project);

        project = new Project();
        project.setName("数学");
        project.setBeginTime(1);
        project.setEndTime(4);
        allProjects.add(project);

        project = new Project();
        project.setName("生物");
        project.setBeginTime(8);
        project.setEndTime(11);
        allProjects.add(project);

        project = new Project();
        project.setName("地理");
        project.setBeginTime(3);
        project.setEndTime(8);
        allProjects.add(project);

        project = new Project();
        project.setName("物理");
        project.setBeginTime(6);
        project.setEndTime(10);
        allProjects.add(project);

        project = new Project();
        project.setName("语文");
        project.setBeginTime(2);
        project.setEndTime(13);
        allProjects.add(project);

        project = new Project();
        project.setName("历史");
        project.setBeginTime(8);
        project.setEndTime(12);
        allProjects.add(project);

        return allProjects;
    }


    @Data
    public static class Project implements Comparable<Project> {
        private String name;
        private int beginTime;
        private int endTime;


        @Override
        public int compareTo(Project o) {
            return this.getEndTime() - o.getEndTime();
        }
    }
}
