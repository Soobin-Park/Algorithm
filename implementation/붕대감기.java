class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        //모든 공격 받고 남은 체력 return
        //캐릭터가 죽는다면 -1 return
        int answer = 0;
        int continousSuccesTime = 0;
        int time = 0;
        int maxHealth = health;

        //bandage = [시전 시간(t), 초당 회복량(x), 추가 회복량(y)]
        //health 체력량
        //attacks = [[공격 시간, 피해량] ...]

        // 1초마다 x 회복 / t초 연속 성공시 y 추가 회복
        // 공격당하면 피해 입고 회복 취소 & 공격 당하는 순간에 회복 x
        // 기술 취소시 즉시 다시 회복시작 but 연속성공시간 초기화
        // 체력 0이 되면 죽음

        int i = 0;
        while(i < attacks.length && health > 0){

            if (time == attacks[i][0]){
                health -= attacks[i][1];
                continousSuccesTime = 0;
                i++;
            }

            else{
                health += bandage[1];
                continousSuccesTime++;

                if (continousSuccesTime == bandage[0]){
                    health += bandage[2];
                    continousSuccesTime = 0;
                }
            }

            if (health > maxHealth)
                health = maxHealth;

            time++;

        }

        if (health <= 0)
            answer = -1;
        else
            answer = health;
        return answer;
    }
}