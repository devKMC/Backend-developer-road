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

// PS 스케줄링 클래스
public class PS {   
    private List<Process> processList;
    // 리스트 초기화
    public PS() {
        processList = new ArrayList<>();
    }

    // 프로세스 추가
    public void addProcess(String id, int burstTime) {
        processList.add(new Process(id, burstTime));
    }

    // PS 스케줄링 알고리즘 실행
    public void schedule() {
        int currentTime = 0; // 현재 시간
        System.out.println("Process ID\tBurst Time\tCompletion Time\tWaiting Time\tTurnaround Time");

        // 프로세스 실행 시간 기준으로 정렬
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

        // 클래스이름 / 변수 = 객체생성();
        // PS 클래스의 새로운 객체를 만들어서 그 객체를 scheduler라는 변수에 저장한다.
        PS scheduler = new PS();
        // 프로세스 추가 (ID, 실행 시간)
        scheduler.addProcess("1", 8);
        scheduler.addProcess("2", 4);
        scheduler.addProcess("3", 9);
        scheduler.addProcess("4", 5);

        // PS 스케줄링 실행
        scheduler.schedule();
    }
}
