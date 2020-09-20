public class Inventory {
    private Object resource[][] = {{"water", 0},
                                    {"food",0},
                                    {"wood",0},
                                    {"stone",0},
                                    {"stoneSword",0},
                                    {"stoneAxe",0},
                                    {"stonePickAx",0},
                                    {"meet",0},
                                    {"fruits",0}
                                    };
    //counts

    Inventory(int water, int food, int wood, int stone, int stoneSword, int stoneAxe, int stonePickAx) {
        setStone(stone);
        setFood(food);
        setStoneAxe(stoneAxe);
        setStonePickAx(stonePickAx);
        setStoneSword(stoneSword);
        setWood(wood);
        setWater(water);
    }
    //getter & setter

    public Object[][] getResource() {
        return resource;
    }

    public void setWater(int water){
        resource[0][1] = water;
    }
    public void setFood(int food){
        resource[1][1] = food;
    }
    public void setWood(int wood){
        resource[2][1] = wood;
    }
    public void setStone(int stone){
        resource[3][1] = stone;
    }
    public void setStoneSword(int stoneSword){
        resource[4][1] = stoneSword;
    }
    public void setStoneAxe(int stoneAxe){
        resource[5][1] = stoneAxe;
    }
    public void setStonePickAx(int stonePickAx){
        resource[6][1] = stonePickAx;
    }

    //item 번호와 갯수를 받아서 그에 해당하는 아이템 갯수 수정
    public void setResource(int mount, int itemNumber){
        resource[itemNumber][1] = mount;
    }
}
