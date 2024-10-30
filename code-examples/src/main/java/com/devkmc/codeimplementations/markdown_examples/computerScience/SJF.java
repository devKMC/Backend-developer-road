package com.devkmc.codeimplementations.markdown_examples.computerScience;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// ID와 실행 시간 
class Process {
    String id; 
    int burstTime;

    public Process(String id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
    }
}

// SJF 스케줄링 클래스
public class SJF {
    private List<Process> processList;

    // 리스트 초기화
    public SJF() {
        processList = new ArrayList<>();
    }

    // 프로세스 추가
    public void addProcess(String id, int burstTime) {
        processList.add(new Process(id, burstTime));
    }

    // SJF 스케줄링 알고리즘 실행
    public void schedule() {
        int currentTime = 0; // 현재 시간
        System.out.println("Process ID\tBurst Time\tCompletion Time\tWaiting Time\tTurnaround Time");

        // 프로세스를 실행 시간 기준으로 정렬
        processList.sort(Comparator.comparingInt(process -> process.burstTime));

        // 모든 프로세스를 처리
        for (Process process : processList) {
            int completionTime = currentTime + process.burstTime; // 완료 시간
            int waitingTime = currentTime; // 대기 시간
            int turnaroundTime = completionTime; // 반환 시간

            // 결과 출력
            System.out.printf("%s\t\t%d\t\t%d\t\t%d\t\t%d%n",
                    process.id, process.burstTime, completionTime, waitingTime, turnaroundTime);

            currentTime += process.burstTime; // 현재 시간 업데이트
        }
    }

    public static void main(String[] args) {
        SJF scheduler = new SJF();
        // 프로세스 추가 (ID, 실행 시간)
        scheduler.addProcess("1", 8);
        scheduler.addProcess("2", 4);
        scheduler.addProcess("3", 9);
        scheduler.addProcess("4", 5);

        // SJF 스케줄링 실행
        scheduler.schedule();
    }
}
