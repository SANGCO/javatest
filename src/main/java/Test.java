import java.io.*;

public class Test {

    /**
     * 단일창구 대기행렬 시뮬레이션
     * tpump : 고객에 대한 봉사시간(단위 : 분)
     * queue : 줄에서 기다리고 있는 사람(차량) 수, 대기행렬의 길이
     * prarr : 고객이 1분내에 도착할 확률
     * arrive : 0 = 고객이 도착하지 않은 경우
     *          1 = 고객이 도착한 경우
     * time : 시뮬레이션의 현재시간(단위 : 분)
     * tstep : 시뮬레이션 진행 단위시간
     * tlimit : 총 시뮬레이션 수행시간
     * toarr : 도착한 총 고객수
     * totque : 대기행렬 queue의 전체 합(=전체 고객의 총 대기시간0
     * aveque : 대기행렬 queue의 평균길이
     * seed : 난수의 초기값
     */

    static class SingleQueueing {
        final static int SEED=363723;
        public int n, seed, p;
        public float up, mean;
        public String StrTime = new String();

        public SingleQueueing(){
            mean = 4;
            seed = SEED;
            n = SEED;
        }

        public int random(int np, float u){
            np = np * 843314861 + 453816693;
            if(np < 0){
                np = np + 2147483647;
                np = np + 1;
            }
            up = (float)(np * 0.4656612e-9);
            return np;
        }

        public int poissn(int np, int pp){
            float b, prod;

            pp = 0;
            b = (float)(Math.exp(-mean));

            prod = 1;
            n = random(np, up);
            prod = prod * up;

            while(prod >= b){
                n = random(n, up);
                prod = prod * up;
                ++pp;
            }
            return pp;
        }

        public void ConvDataToString(int time){
            int i, len;

            StrTime = "";
            StrTime = StrTime.valueOf(time);
            len = StrTime.length();
            if(len < 3)
                for(i = 0; i < (3-len); i++)
                    StrTime = "0" + StrTime;
        }

        public void ComputeQueueing(){
            int queue = 0, totque = 0, time=0, totarr=0, arrive, tstep = 1;
            double prarr=1.0/4.0, tpump=0.0, tlimit=100, aveque=0, avetime=0;
            System.out.println("SIMULATION FOR A QUEUEING SYSTEM");
            System.out.println("=================================");
            System.out.println("THE TIME STEP           = " + tstep);
            System.out.println("THE TIME LIMIT          = " + tlimit);
            System.out.println("THE ARRIVAL PROBABILITY = " + prarr);
            System.out.println("THE POISSON MEAN        = " + (int)mean);
            System.out.println("THE SEED                = " + seed);
            System.out.println("=================================");
            System.out.println("TIME    ARRIVAL    QUEUE    TPUMP");
            System.out.println("---------------------------------");

            while(time < tlimit) {
                time = time + tstep;
                arrive = 0;
                seed = random(seed, up);

                if(up < prarr*tstep) {
                    arrive = 1;
                    queue = queue + arrive;
                    totarr = totarr + 1;
                }
                if(tpump > 0.0) {
                    tpump = tpump-tstep;
                    if(tpump < 0)
                        tpump = 0;
                }
                if(tpump==0 && queue!=0) {
                    queue = queue - 1;
                    p = poissn(n, p);
                    tpump = p;
                }
                totque = totque + queue;
                ConvDataToString(time);
                System.out.println(" " + StrTime + "      " + arrive + "          " + queue + "        " + (int)tpump);
            }
            aveque = totque / (tlimit*tstep);

            System.out.println("---------------------------------");
            System.out.println("MEAN QUEUE LENGTH  = " + aveque);
            System.out.println("THE TOTAL ARRIVALS = " + totarr);

        }
    }

    public static class EX1_6 {
        public static void main(String[] args){
            SingleQueueing g = new SingleQueueing();
            g.ComputeQueueing();
        }
    }

}
