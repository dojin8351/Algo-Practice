package test.월말대비;

import java.util.*;

public class No2382_미생물격리 {
    // 상, 하, 좌, 우
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int test = 1; test <= testCase; test++) {
            int N = sc.nextInt(); // 셀 개수
            int M = sc.nextInt(); // 격리 시간
            int K = sc.nextInt(); // 초기 군집 수

            // 미생물을 담는 리스트
            List<Microorganisms> microorganismList = new ArrayList<>();

            // 초기 군집 정보 입력
            for (int i = 0; i < K; i++) {
                int y = sc.nextInt(); //x좌표
                int x = sc.nextInt(); //y좌표
                int cnt = sc.nextInt(); //미생물 수
                int dir = sc.nextInt() - 1; // 위의 배열의 index를 맞추어 주기위해 입력받을때 -1처리
                microorganismList.add(new Microorganisms(y, x, cnt, dir)); // 미생물 생성후 리스트 추가
            }

            // M시간 동안 미생물 이동 및 병합 실행
            for (int t = 0; t < M; t++) {
                // 미생물 이동
                Map<String, List<Microorganisms>> cellMap = new HashMap<>();

                for (Microorganisms micro : microorganismList) {
                    // 미생물이 지니고 있는 dir값을 받아와 방향으로 나아간다.
                    int nextY = micro.y + dirY[micro.dir];
                    int nextX = micro.x + dirX[micro.dir];

                    // 약품 셀에 도달한 경우 처리
                    if (nextY == 0 || nextX == 0 || nextY == N - 1 || nextX == N - 1) {
                        micro.cnt /= 2; // 미생물 감소
                        if (micro.cnt == 0) continue; // 군집이 사라진 경우
                        micro.dir = changeDir(micro.dir); // 방향 전환
                    }

                    // 이동 완료된 좌표 갱신
                    micro.y = nextY;
                    micro.x = nextX;

                    // 현재 좌표를 Map의 키로 활용하여 같은 위치 군집을 묶음
                    String key = nextY + "," + nextX;
                    // 리스트에 add를 해주기위해 NullpointException을 방지하기위해 키값에 리스트 초기화 처리해준다.
                    cellMap.putIfAbsent(key, new ArrayList<>());
                    cellMap.get(key).add(micro);
                }

                // 같은 셀에 모인 군집 병합
                // 중첩되는 애들을 처리해주기위해 새로운 리스트를 만들고 이곳에 담아준다.
                microorganismList = new ArrayList<>();
                for (String key : cellMap.keySet()) {
                    List<Microorganisms> cellMicroList = cellMap.get(key);

                    if (cellMicroList.size() == 1) {
                        // 하나의 군집만 있는 경우 병합 없이 그대로 유지
                        microorganismList.add(cellMicroList.get(0));
                    } else {
                        // 두 개 이상의 군집 병합 처리
                        int totalCnt = 0;
                        int maxCnt = 0;
                        int newDir = 0;
                        int y = 0;
                        int x = 0;
                        // 위에서 키값에 할당되어있는 리스트를 cellMicroList에 담아줬으므로
                        // 순회하면서 값을 비교한다.
                        for (Microorganisms micro : cellMicroList) {
                            totalCnt += micro.cnt; // 개수는 계속 누적이 되어야 한다.
                            if (micro.cnt > maxCnt) {
                                maxCnt = micro.cnt;
                                newDir = micro.dir; // 가장 큰 군집의 방향 사용
                                y = micro.y;
                                x = micro.x;
                            }
                        }

                        // 병합된 군집 추가
                        microorganismList.add(new Microorganisms(y, x, totalCnt, newDir));
                    }
                }
            }

            //남은 미생물 수 계산
            int resultCnt = 0;
            for (Microorganisms micro : microorganismList) {
                resultCnt += micro.cnt;
            }

            System.out.println("#" + test + " " + resultCnt);
        }
    }

    // 미생물 군집 클래스
    static class Microorganisms {
        int y;
        int x;
        int cnt;
        int dir;

        public Microorganisms(int y, int x, int cnt, int dir) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    // 방향 전환 메서드
    static int changeDir(int dir) {
        if (dir == 0) {
            return 1; // 상 -> 하
        }
        if (dir == 1){
            return 0; // 하 -> 상
        }
        if (dir == 2) {
            return 3; // 좌 -> 우
        }
        if (dir == 3){
            return 2; // 우 -> 좌
        }
        return -1;
    }
}