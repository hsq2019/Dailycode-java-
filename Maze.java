package datastructure.recursive;

public class Maze {
    public static void main(String[] args) {
        //使用二维数组来表示迷宫
        //上下
        int[][] map=new int[8][7];
         //使用1表示墙
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        //左右
        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        //地图的情况
        System.out.println("原始地图");
        for(int[] arr:map){
            for(int x:arr){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        setWay(map,1,1);
        System.out.println("找到路");
        for(int[] arr:map){
            for(int x:arr){
                System.out.print(x+" ");
            }
            System.out.println();
        }




    }
    //使用递归给小球找路
    //i，j表示从地图的哪个地图开始出发。（1，1）
    //如果小球到map[6][5]这个位置，那么通路找到
    //当map[i][j]是0，表示没走过，如果是1那么就是墙，如果是2表示通路可以走，如果是3以及走过，但走不通
     //在走迷宫时需要确定策略，优先走下，右，上，左 。如果走不通，那么回溯
            /**
             *
             * @param map 地图
             * @param i 哪个位置开始找
             * @param j
             * @return 找到返回真，没找到返回假
             */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else {
            if(map[i][j]==0){
                map[i][j]=2;
                if(setWay(map,i+1,j)){
                    //向下走
                    return true;
                }else if(setWay(map,i,j+1)){//向右走
                    return true;
                }else if(setWay(map,i-1,j-1)){//向上走
                    return true;
                }else if(setWay(map,i-1,j)){//向左走
                    return true;
                }else {//说明走不通，是死路
                    map[i][j]=3;
                    return false;
                }
            }else {//map[i][j]可以是1，2，3。
                return false;
            }
        }
    }
}
