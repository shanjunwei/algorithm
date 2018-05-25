package Feibonacci;

public class Feibonacci {

    public int JumpFloorII(int target) {
        if(target<1) return  0;

        else  return  1<<target;
    }
}
