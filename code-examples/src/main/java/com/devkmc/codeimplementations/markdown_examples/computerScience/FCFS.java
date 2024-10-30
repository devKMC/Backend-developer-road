package com.devkmc.codeimplementations.markdown_examples.computerScience;
import java.util.LinkedList;
import java.util.Queue;


// ID와 실행 시간 
class Process {
    String id; 
    int burstTime;

    public Process (String id,int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
    }
}

// Queue 대기줄 느낌으로 여러개의 프로세스가 대기
// FCFS 클래스에 큐라는 공간에 줄을서서 기다림
public class FCFS {
    private Queue<Process> processQueue;

    // 큐를 초기화 
    // 생성자 메서드
    // FCFS()는 FCFS클래스의 생성자이며 processQueue 인스턴스 생성
    public FCFS() {
        processQueue = new LinkedList<>();
    }

    // 메서드
    // 2개의 매개변수를 받아서  메서드가 실행되게되면 id를 반환
    // id , burstTime 의 매개변수를 받아서 새로운 프로세스를 큐에 추가한다
    // 생성자는 클래스를 실행할때 자동으로 호출됨
    public void addProcess(String id, int burstTime) {
        processQueue.add(new Process(id, burstTime));
    }

    // FCFS 스케줄링 알고리즘 실행
    public void schedule() {
        int currentTime = 0; // 현재 시간
        System.out.println("Process ID\tBurst Time\tCompletion Time\tWaiting Time\tTurnaround Time");

        // 대기 중인 프로세스가 하나라도 남아 있으면 큐에서 꺼내서 처리
        while (!processQueue.isEmpty()) { // 프로세스큐가 비어있지 않다면
            Process process = processQueue.poll(); // 가장 먼저 들어온 프로세스를 꺼내는 작업
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
        FCFS scheduler = new FCFS();
        // 프로세스 추가 (ID, 실행 시간)
        scheduler.addProcess("1", 5);
        scheduler.addProcess("2", 3);
        scheduler.addProcess("3", 8);

        // FCFS 스케줄링 실행
        scheduler.schedule();
    }
}