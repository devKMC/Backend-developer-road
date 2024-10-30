package com.devkmc.codeimplementations.markdown_examples.computerScience;

import java.util.LinkedList;
import java.util.Queue;

// ID와 실행 시간 
class Process {
    String id; 
    int burstTime;

    public Process(String id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
    }
}

// RR 스케줄링 클래스
public class RR {
    private Queue<Process> processQueue;
    private int timeQuantum;

    // 큐 초기화
    public RR(int timeQuantum) {
        this.processQueue = new LinkedList<>();
        this.timeQuantum = timeQuantum;
    }

    // 프로세스 추가
    public void addProcess(String id, int burstTime) {
        processQueue.add(new Process(id, burstTime));
    }

    // RR 스케줄링 알고리즘 실행
    public void schedule() {
        int currentTime = 0; // 현재 시간
        System.out.println("Process ID\tBurst Time\tCompletion Time\tWaiting Time\tTurnaround Time");

        while (!processQueue.isEmpty()) {
            Process process = processQueue.poll(); // 큐에서 프로세스 가져오기
            int timeToExecute = Math.min(process.burstTime, timeQuantum); // 실행할 시간
            currentTime += timeToExecute; // 현재 시간 업데이트
            
            // 실행 후 남은 시간 계산
            process.burstTime -= timeToExecute;

            // 프로세스가 완료되었는지 확인
            if (process.burstTime == 0) {
                int completionTime = currentTime; // 완료 시간
                int waitingTime = currentTime - timeToExecute; // 대기 시간
                int turnaroundTime = completionTime; // 반환 시간

                // 결과 출력
                System.out.printf("%s\t\t%d\t\t%d\t\t%d\t\t%d%n",
                        process.id, timeToExecute, completionTime, waitingTime, turnaroundTime);
            } else {
                // 프로세스가 완료되지 않으면 큐에 다시 추가
                processQueue.add(process);
            }
        }
    }

    public static void main(String[] args) {
        RR scheduler = new RR(3); // 타임 쿼텀 설정
        // 프로세스 추가 (ID, 실행 시간)
        scheduler.addProcess("1", 10);
        scheduler.addProcess("2", 5);
        scheduler.addProcess("3", 8);

        // RR 스케줄링 실행
        scheduler.schedule();
    }
}
